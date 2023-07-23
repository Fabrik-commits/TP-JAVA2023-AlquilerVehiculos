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
			rs = stmt.executeQuery("select vehiculo.id, vehiculo.marcaymodelo, vehiculo.anio, vehiculo.kilometraje, vehiculo.pasajeros, vehiculo.color, vehiculo.estado, vehiculo.precioxkm, vehiculo.matricula, vehiculo.capacidadmaxima, tipovehiculo.descripcion from vehiculo inner join tipovehiculo on vehiculo.idtipovehiculo=tipovehiculo.id");
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
					veh.setPrecioporKm(rs.getDouble("precioxkm"));
					veh.setMatricula(rs.getString("matricula"));										
					veh.setCapacidadMaxima(rs.getDouble("capacidadmaxima"));					
					
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
	
	public Vehiculo getById(int id) {
		Vehiculo vehic=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from vehiculo where id=?"
					);
			stmt.setInt(1, id);  // rolToSearch.getId()
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				vehic=new Vehiculo();
				vehic.setIdVehiculo(rs.getInt("id"));
				vehic.setMarcayModelo(rs.getString("marcaymodelo"));
				vehic.setAnio(rs.getInt("anio"));
				vehic.setKilometraje(rs.getDouble("kilometraje"));
				vehic.setPasajeros(rs.getInt("pasajeros"));
				vehic.setColor(rs.getString("color"));
				vehic.setEstado(rs.getBoolean("estado"));
				vehic.setPrecioporKm(rs.getDouble("precioxkm"));
				vehic.setMatricula(rs.getString("matricula"));
				vehic.setCapacidadMaxima(rs.getDouble("capacidadmaxima"));
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

	
	
}
