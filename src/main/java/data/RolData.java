package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Persona;
import entities.Rol;

public class RolData {
	
	public LinkedList<Rol> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Rol> roles= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from rol");
			if(rs!=null) {
				while(rs.next()) {
					Rol r=new Rol();
					r.setId(rs.getInt("id"));
					r.setDescripcion(rs.getString("descripcion"));
					roles.add(r);
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
		
		
		return roles;
	}
	
	public Rol getByDesc(Rol rolToSearch) {
		Rol r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from rol where descripcion=?"
					);
			stmt.setString(1, rolToSearch.getDescripcion());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				r=new Rol();
				r.setId(rs.getInt("id"));
				r.setDescripcion(rs.getString("descripcion"));
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
		
		return r;
	}
	
	public void setRoles(Persona per) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select rol.* "
					+ "from rol "
					+ "inner join rol_persona "
					+ "on rol.id=rol_persona.id_rol "
					+ "where id_persona=?"
					);
			stmt.setInt(1, per.getId());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Rol r=new Rol();
					r.setId(rs.getInt("id"));
					r.setDescripcion(rs.getString("descripcion"));
					per.addRol(r);;
				}
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
	}
	
	public void updateRoles(Persona per) {
		PreparedStatement stmt=null;
		try {
			
			this.removeRoles(per);
						
			for (Integer clave:per.roles.keySet()) {
				stmt=DbConnector.getInstancia().getConn().prepareStatement(					
				"insert into rol_persona(id_persona, id_rol) values(?,?)");
				stmt.setInt(1, per.getId());
				stmt.setInt(2, clave);				 
				stmt.executeUpdate();
		
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void removeRoles(Persona per) {
		PreparedStatement stmt=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"delete from rol_persona where id_persona=?"
					);
			stmt.setInt(1, per.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

}
