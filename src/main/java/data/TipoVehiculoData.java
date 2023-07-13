package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Rol;
import entities.TipoVehiculo;

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
	
	
	public TipoVehiculo getById(int id) {    // Rol rolToSearch
		TipoVehiculo tipov=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from tipovehiculo where id=?"
					);
			stmt.setInt(1, id);  // rolToSearch.getId()
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				tipov=new TipoVehiculo();
				tipov.setId(rs.getInt("id"));
				tipov.setDescripcion(rs.getString("descripcion"));
				tipov.setCosto(rs.getDouble("costo"));
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
							"update tipovehiculo set descripcion=?, costo=? where id=?");
			stmt.setString(1, tv.getDescripcion());
			stmt.setDouble(2, tv.getCosto());
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
	
	

}
