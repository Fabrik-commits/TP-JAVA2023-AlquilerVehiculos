package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

//import entities.Documento;
//import entities.Documento;
import entities.Persona;
import entities.Vehiculo;

public class PersonaData {
	
	public LinkedList<Persona> getAll(){
		RolData dr = new RolData();
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Persona> pers = new LinkedList<Persona>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id,nombre,apellido,dni,direccion,email,telefono,password from persona");
			//intencionalmente no se recupera la password
//select persona.id, persona.nombre, persona.apellido, persona.dni, persona.direccion, persona.telefono, email.estado, persona.password, tipovehiculo.id, tipovehiculo.descripcion from persona inner join rol on persona.id_persona=rol.id_rol			
			if(rs!=null) {
				while(rs.next()) {
					Persona p=new Persona();
					//p.setDocumento(new Documento());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					
					p.setDireccion(rs.getString("direccion"));
					
					//p.getDocumento().setTipo(rs.getString("tipo_doc"));
					//p.getDocumento().setNro(rs.getString("nro_doc"));
					p.setEmail(rs.getString("email"));
					p.setTel(rs.getString("telefono"));
					p.setPassword(rs.getString("password"));
					//p.setHabilitado(rs.getBoolean("habilitado"));
					
					dr.setRoles(p);
					
					pers.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pers;
	}
	
	public Persona getById(int id) {
		RolData dr = new RolData();
		Persona pers=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from persona where id=?"
					);
			stmt.setInt(1, id);  // rolToSearch.getId()
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				pers=new Persona();
				pers.setId(rs.getInt("id"));
				pers.setNombre(rs.getString("nombre"));
				pers.setApellido(rs.getString("apellido"));
				pers.setDireccion(rs.getString("direccion"));
				pers.setDni(rs.getString("dni"));
				pers.setTel(rs.getString("telefono"));
				pers.setEmail(rs.getString("email"));
				pers.setPassword(rs.getString("password"));
				//vehic.setMatricula(rs.getString("matricula"));
				//vehic.setCapacidadMaxima(rs.getDouble("capacidadmaxima"));
				
				dr.setRoles(pers);
				
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
		
		return pers;
		
	}

	
//	public LinkedList<Persona> getDatosPersonas(){
//		RolData dr = new RolData();
//		Statement stmt = null;
//		ResultSet rs = null;
//		LinkedList<Persona> pers = new LinkedList<Persona>();
//		
//		try {
//			stmt= DbConnector.getInstancia().getConn().createStatement();
//			rs= stmt.executeQuery("select id,nombre,apellido,dni,direccion,email,tel, password from persona");
//			//intencionalmente no se recupera la password
//			if(rs!=null) {
//				while(rs.next()) {
//					Persona p=new Persona();
//					//p.setDocumento(new Documento());
//					p.setId(rs.getInt("id"));
//					p.setNombre(rs.getString("nombre"));
//					p.setApellido(rs.getString("apellido"));
//					p.setDni(rs.getString("dni"));
//					
//					p.setDireccion(rs.getString("direccion"));
//					
//					//p.getDocumento().setTipo(rs.getString("tipo_doc"));
//					//p.getDocumento().setNro(rs.getString("nro_doc"));
//					p.setEmail(rs.getString("email"));
//					p.setTel(rs.getString("tel"));
//					p.setPassword(rs.getString("password"));
//					//p.setHabilitado(rs.getBoolean("habilitado"));
//					
//					dr.setRoles(p);
//					
//					pers.add(p);
//				}
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return pers;
//	}
		
	public Persona getByUser(Persona per) {
		//RolData rd=new RolData();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,dni,direccion,email,telefono from persona where email=? and password=?"
					);
			stmt.setString(1, per.getEmail());
			stmt.setString(2, per.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				//p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				
				p.setDireccion(rs.getString("direccion"));
				
				//p.getDocumento().setTipo(rs.getString("tipo_doc"));
				//p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("telefono"));
				//p.setHabilitado(rs.getBoolean("habilitado"));
				//
				//rd.setRoles(p);
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
		
		return p;
	}
				
	//public Persona getByDocumento(Persona per) falta
	
	
	
	
	
	
	
	
	public LinkedList<Persona> getAllByApellido(Persona per){
		RolData dr=new RolData();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> pers= new LinkedList<>();
		
		try {			
			
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,nroDni,email,tel,habilitado from persona where apellido=?"
					);
			//intencionalmente no se recupera la password
			stmt.setString(1, per.getApellido());
			rs=stmt.executeQuery();
									
			if(rs!=null) {
				while(rs.next()) {
					p=new Persona();
					//p.setDocumento(new Documento());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					//p.getDocumento().setTipo(rs.getString("tipo_doc"));
					//p.getDocumento().setNro(rs.getString("nro_doc"));
					p.setEmail(rs.getString("email"));
					p.setTel(rs.getString("tel"));
					
					//p.setHabilitado(rs.getBoolean("habilitado"));
					
					dr.setRoles(p);
					
					pers.add(p);
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
		
		
		return pers;
	}
	
	public void add(Persona p) {
		RolData rd=new RolData();
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into persona(nombre, apellido, dni, direccion, email, password, telefono) values(?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getDni());
			stmt.setString(4, p.getDireccion());
			//stmt.setString(3, p.getDocumento().getTipo());
			//stmt.setString(4, p.getDocumento().getNro());
			stmt.setString(5, p.getEmail());
			stmt.setString(6, p.getPassword());
			stmt.setString(7, p.getTel());
			//stmt.setBoolean(7, p.isHabilitado());
						
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
            }
            
            rd.updateRoles(p);
			
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
	
	
	public void update(Persona p) {
		RolData dr=new RolData();
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update persona set nombre=?, apellido=?, email=?, password=?, telefono=?, direccion=? where dni=?");
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());			
			stmt.setString(3, p.getEmail());
			stmt.setString(4, p.getPassword());
			stmt.setString(5, p.getTel());
			stmt.setString(6, p.getDireccion());
			//stmt.setBoolean(6, p.isHabilitado());
			stmt.setString(7, p.getDni());
			//stmt.setString(7, p.getDocumento().getTipo());
			//stmt.setString(8, p.getDocumento().getNro());
			stmt.executeUpdate();
			
			dr.updateRoles(p);
						
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
	
	
	public void remove(Persona per) {
		RolData dr=new RolData();
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from persona where id=?");
			stmt.setInt(1, per.getId());
			//stmt.setString(1, per.getDocumento().getTipo());
			//stmt.setString(2, per.getDocumento().getNro());
						
			dr.removeRoles(per);
			
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
