package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

//import entities.Persona;
//import entities.Rol;
import entities.TipoVehiculo;
import entities.Vehiculo;

public class TipoVehiculoData {
	
	public LinkedList<TipoVehiculo> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<TipoVehiculo> tiposVehiculo= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from tipovehiculo");
			if(rs!=null) {
				while(rs.next()) {
					TipoVehiculo tv=new TipoVehiculo();
					tv.setId(rs.getInt("id"));
					tv.setDescripcion(rs.getString("descripcion"));
					//tv.setCosto(rs.getDouble("costo"));
					tiposVehiculo.add(tv);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return tiposVehiculo;
	}
	
	public LinkedList<Vehiculo> getAllVehiculosporTipo(int id){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Vehiculo> vehiculosporTipo= new LinkedList<>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select vehiculo.id, vehiculo.marcaymodelo, vehiculo.anio, vehiculo.kilometraje, vehiculo.pasajeros, vehiculo.color, vehiculo.estado, vehiculo.precio, vehiculo.matricula, vehiculo.capacidadmaxima, tipovehiculo.id, tipovehiculo.descripcion from vehiculo inner join tipovehiculo on vehiculo.idtipovehiculo=tipovehiculo.id where tipovehiculo.id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
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
					
					vehiculosporTipo.add(veh);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vehiculosporTipo;
	}
	
	///
	public LinkedList<Vehiculo> getAllVehiculosDispPorTipo(int id){
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Vehiculo> vehiculosporTipo= new LinkedList<>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select vehiculo.id, vehiculo.marcaymodelo, vehiculo.anio, vehiculo.kilometraje, vehiculo.pasajeros, vehiculo.color, vehiculo.estado, vehiculo.precio, vehiculo.matricula, vehiculo.capacidadmaxima, tipovehiculo.id, tipovehiculo.descripcion from vehiculo inner join tipovehiculo on vehiculo.idtipovehiculo=tipovehiculo.id where tipovehiculo.id=? AND vehiculo.estado=1");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
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
					
					vehiculosporTipo.add(veh);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vehiculosporTipo;
	}
	
	
	
	
	
	public TipoVehiculo getById(int id) {    
		TipoVehiculo tipov=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from tipovehiculo where id=?"
					);
			stmt.setInt(1, id);  
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				tipov=new TipoVehiculo();
				tipov.setId(rs.getInt("id"));
				tipov.setDescripcion(rs.getString("descripcion"));
				//tipov.setCosto(rs.getDouble("costo"));
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
		
		return tipov;
	}
	
	
	public TipoVehiculo update(TipoVehiculo tv) {
		PreparedStatement stmt=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update tipovehiculo set descripcion=? where id=?");
			stmt.setString(1, tv.getDescripcion());
			//stmt.setDouble(2, tv.getCosto());
			stmt.setInt(3, tv.getId());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return tv;
		
	}
	
	public void add(TipoVehiculo tipov) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into tipovehiculo(descripcion) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, tipov.getDescripcion());
			//stmt.setDouble(2, tipov.getCosto());			
						
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                tipov.setId(keyResultSet.getInt(1));
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
							"delete from tipovehiculo where id=?");
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
	
	public TipoVehiculo getTipodelVehic(int id) {
		TipoVehiculo tipov=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select tipovehiculo.id, tipovehiculo.descripcion, tipovehiculo.costo from vehiculo inner join tipovehiculo on vehiculo.idtipovehiculo=tipovehiculo.id where vehiculo.id=?"
					);
			stmt.setInt(1, id);  // rolToSearch.getId()
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				tipov=new TipoVehiculo();
				tipov.setId(rs.getInt("id"));
				tipov.setDescripcion(rs.getString("descripcion"));
				//tipov.setCosto(rs.getDouble("costo"));
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
		
		return tipov;
	}

}
