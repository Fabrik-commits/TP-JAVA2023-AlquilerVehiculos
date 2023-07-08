package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.TipoVehiculo;

public class TipoVehiculoData {
	
	public LinkedList<TipoVehiculo> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<TipoVehiculo> tiposVehiculo= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from tiposvehiculo");
			if(rs!=null) {
				while(rs.next()) {
					TipoVehiculo tv=new TipoVehiculo();
					tv.setId(rs.getInt("id"));
					tv.setDescripcion(rs.getString("descripcion"));
					tv.setCosto(rs.getDouble("costo"));
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
	
	

}
