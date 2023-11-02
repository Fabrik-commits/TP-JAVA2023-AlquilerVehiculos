package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.TipoVehiculo;
import entities.Vehiculo;

public class VehiculoData {
	
	public LinkedList<Vehiculo> getAll(){
		
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Vehiculo> listveh = new LinkedList<Vehiculo>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select vehiculo.id, vehiculo.marcaymodelo, "
					+ "vehiculo.anio, vehiculo.kilometraje, vehiculo.pasajeros, "
					+ "vehiculo.color, vehiculo.estado, vehiculo.precio, "
					+ "vehiculo.matricula, vehiculo.capacidadmaxima, tipovehiculo.id, "
					+ "tipovehiculo.descripcion from vehiculo inner join tipovehiculo on vehiculo.idtipovehiculo=tipovehiculo.id");
			if (rs!=null) {
				while (rs.next()) {
					Vehiculo veh = new Vehiculo();					
					veh.setTipoVehiculo(new TipoVehiculo());
					veh.setIdVehiculo(rs.getInt("id"));
					veh.setMarcayModelo(rs.getString("marcaymodelo"));
					veh.setAnio(rs.getInt("anio"));
					veh.setKilometraje(rs.getDouble("kilometraje"));
					veh.setPasajeros(rs.getInt("pasajeros"));
					veh.setColor(rs.getString("color"));
			    	veh.setEstado(rs.getBoolean("estado"));
					veh.setPrecio(rs.getDouble("precio"));
					veh.setMatricula(rs.getString("matricula"));										
					veh.setCapacidadMaxima(rs.getDouble("capacidadmaxima"));					
					
					veh.getTipoVehiculo().setId(rs.getInt("id"));
					veh.getTipoVehiculo().setDescripcion(rs.getString("descripcion"));
					
//					TipoVehiculo tveh = new TipoVehiculo();
//					tveh.setDescripcion(rs.getString("descripcion"));
					
					listveh.add(veh);
				}
//				System.out.println(listveh);
//				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listveh;
	}
	
//	public LinkedList<Vehiculo> getAllVehicTipo() {
//		
//		LinkedList<Vehiculo> listveh = new LinkedList<Vehiculo>();
//		return listveh;
//		
//	}
	

	
	public Vehiculo getById(int id) {
		Vehiculo vehic=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select vehiculo.id, vehiculo.marcaymodelo, "
							+ "vehiculo.anio, vehiculo.kilometraje, vehiculo.pasajeros, "
							+ "vehiculo.color, vehiculo.estado, vehiculo.precio, "
							+ "vehiculo.matricula, vehiculo.capacidadmaxima, tipovehiculo.id, "
							+ "tipovehiculo.descripcion from vehiculo inner join tipovehiculo on vehiculo.idtipovehiculo=tipovehiculo.id where vehiculo.id=?"
					);
			stmt.setInt(1, id);  
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				vehic=new Vehiculo();
				vehic.setTipoVehiculo(new TipoVehiculo());
				vehic.setIdVehiculo(rs.getInt("id"));
				vehic.setMarcayModelo(rs.getString("marcaymodelo"));
				vehic.setAnio(rs.getInt("anio"));
				vehic.setKilometraje(rs.getDouble("kilometraje"));
				vehic.setPasajeros(rs.getInt("pasajeros"));
				vehic.setColor(rs.getString("color"));
				vehic.setEstado(rs.getBoolean("estado"));
				vehic.setPrecio(rs.getDouble("precio"));
				vehic.setMatricula(rs.getString("matricula"));
				vehic.setCapacidadMaxima(rs.getDouble("capacidadmaxima"));
								
				vehic.getTipoVehiculo().setId(rs.getInt("tipovehiculo.id"));
				vehic.getTipoVehiculo().setDescripcion(rs.getString("descripcion"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vehic;
		
	}
	
	public Vehiculo update(Vehiculo vehic) {
		//TipoVehiculo tipovehic = new TipoVehiculo();
		PreparedStatement stmt=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update vehiculo set vehiculo.marcaymodelo=?,"
							+ " vehiculo.anio=?, vehiculo.kilometraje=?, "
							+ "vehiculo.pasajeros=?, vehiculo.color=?, "
							+ "vehiculo.estado=?, vehiculo.precio=?, "
							+ "vehiculo.matricula=?, vehiculo.capacidadmaxima=?, "
							+ "vehiculo.idtipovehiculo=? where vehiculo.id=?");
									
			stmt.setString(1, vehic.getMarcayModelo());
			stmt.setInt(2, vehic.getAnio());
			//stmt.setInt(3, vehic.getIdVehiculo());
			stmt.setDouble(3, vehic.getKilometraje());
			stmt.setInt(4, vehic.getPasajeros());
			stmt.setString(5, vehic.getColor());
			stmt.setBoolean(6, vehic.isEstado());
			stmt.setDouble(7, vehic.getPrecio());
			stmt.setString(8, vehic.getMatricula());
			stmt.setDouble(9, vehic.getCapacidadMaxima());
			
			stmt.setInt(10, vehic.getTipoVehiculo().getId());

			
			stmt.setInt(11, vehic.getIdVehiculo());
			
//			System.out.println(stmt.executeUpdate());
//			System.out.println(vehic.getIdVehiculo());
//			System.out.println(vehic.getTipoVehiculo().getId());
//			System.out.println();
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return vehic;
	}

public void add(Vehiculo vehic) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into vehiculo(marcaymodelo, anio, kilometraje, pasajeros, color, estado, precio, matricula, capacidadmaxima, idtipovehiculo) values(?,?,?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, vehic.getMarcayModelo());
			stmt.setDouble(2, vehic.getAnio());
			stmt.setDouble(3, vehic.getKilometraje());
			stmt.setDouble(4, vehic.getPasajeros());
			stmt.setString(5, vehic.getColor());
			stmt.setBoolean(6, vehic.isEstado());
			stmt.setDouble(7, vehic.getPrecio());
			stmt.setString(8, vehic.getMatricula());
			stmt.setDouble(9, vehic.getCapacidadMaxima());
			stmt.setInt(10, vehic.getTipoVehiculo().getId());
						
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                vehic.setIdVehiculo(keyResultSet.getInt(1));
            }
                       
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }


public void remove(int id) {
	PreparedStatement stmt= null;
	try {
		stmt=DbConnector.getInstancia().getConn().
				prepareStatement(
						"delete from vehiculo where id=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
	} catch (SQLException e) {
        e.printStackTrace();
	} finally {
        try {
            if(stmt!=null)stmt.close();
            DbConnector.getInstancia().releaseConn();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
}
	
}
