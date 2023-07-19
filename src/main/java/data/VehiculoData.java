package data;

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
			rs = stmt.executeQuery("select marcaymodelo, anio, kilometraje, pasajeros, color, estado, precioxkm, matricula, capacidadmax, descripcion from vehiculo inner join tipovehiculo where vehiculo.id=tipovehiculo.id");
			if (rs!=null) {
				while (rs.next()) {
					Vehiculo veh = new Vehiculo();
					veh.setTipoVehiculo(new TipoVehiculo());
					veh.setMarcayModelo(rs.getString("marcaymodelo"));
					veh.setAnio(rs.getInt("anio"));
					veh.setKilometraje(rs.getDouble("kilometraje"));
					veh.setPasajeros(rs.getInt("pasajeros"));
					veh.setColor(rs.getString("color"));
			    	veh.setEstado(rs.getBoolean("estado"));
					veh.setPrecioporKm(rs.getDouble("precioxkm"));
					veh.setMatricula(rs.getString("matricula"));										
					veh.setCapacidadMax(rs.getDouble("capacidadmax"));
					
					veh.getTipoVehiculo().setDescripcion(rs.getString("descripcion"));
					
//					TipoVehiculo tveh = new TipoVehiculo();
//					tveh.setDescripcion(rs.getString("descripcion"));
					
					listveh.add(veh);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listveh;
	}

}
