package data;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
import java.util.LinkedList;
import java.time.LocalDate;
//import java.sql.Date;
//import java.time.ZoneId;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
//import java.sql.Timestamp;

import entities.Alquiler;
import entities.Persona;
import entities.TipoVehiculo;
import entities.Vehiculo;

public class AlquilerData {
	
	public void add(Alquiler alq) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into alquiler(id_persona, id_vehiculo, fec_inic, fec_fin, senia, importe, kms_inic, kms_fin, fec_entrega, fec_cancelacion, reclamo_obs, estado) values(?,?,?,?,?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, alq.getPersona().getId());
			stmt.setInt(2, alq.getVehiculo().getIdVehiculo());

			String fechainic = alq.getFechaInic().toString();
			stmt.setDate(3, java.sql.Date.valueOf(fechainic));
			
			String fechafin = alq.getFechaFin().toString();
			stmt.setDate(4, java.sql.Date.valueOf(fechafin));
						
			stmt.setDouble(5, alq.getSenia());
			stmt.setDouble(6, alq.getImporte());
			stmt.setDouble(7, alq.getKmInic());
			stmt.setDouble(8, alq.getKmFin());
			
			String fec_entrega = alq.getFechaEntrega().toString();
			stmt.setDate(9, java.sql.Date.valueOf(fec_entrega));
			
			String fec_cancelacion = alq.getFechaCancel().toString();
			stmt.setDate(10, java.sql.Date.valueOf(fec_cancelacion));
			
			stmt.setString(11, alq.getReclamoyObs());
			stmt.setString(12, alq.getEstado());
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				alq.setId(keyResultSet.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public Alquiler update(Alquiler alq) {
		PreparedStatement stmt = null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement("update alquiler set kms_fin=?, fec_entrega=?, fec_cancelacion=?, reclamo_obs=?, estado=? where id=?");
			stmt.setDouble(1, alq.getKmFin());

//			stmt.setDate(2, alq.getFechaEntrega());
			String fec_entrega = alq.getFechaEntrega().toString();
			stmt.setDate(2, java.sql.Date.valueOf(fec_entrega));
						
//			stmt.setDate(3, alq.getFechaCancel());
			String fec_cancelacion = alq.getFechaCancel().toString();
			stmt.setDate(3, java.sql.Date.valueOf(fec_cancelacion));
			
			stmt.setString(4, alq.getReclamoyObs());
			stmt.setString(5, alq.getEstado());
			stmt.setInt(6, alq.getId());

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
		return alq;
	}
	
	public LinkedList<Alquiler> getAllByALquileresxClte(int id) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Alquiler> alquileresxClte = new LinkedList<>();
		
		try {//cargar AlquileresXClte.jsp
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select alquiler.id, alquiler.fec_inic, tipovehiculo.descripcion, vehiculo.marcaymodelo, vehiculo.color from alquiler inner join vehiculo on alquiler.id_vehiculo=vehiculo.id inner join tipovehiculo on vehiculo.idtipovehiculo=tipovehiculo.id inner join persona on alquiler.id_persona=persona.id where persona.id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs!=null) {
				while (rs.next()) {
					Alquiler alq = new Alquiler();
					alq.setId(rs.getInt("id"));
					
					String fec_inic = rs.getDate("fec_inic").toString();
					LocalDate fecha_inicial = LocalDate.parse(fec_inic);					
					alq.setFechaInic(fecha_inicial);
					
					alq.setVehiculo(new Vehiculo());
					alq.getVehiculo().setMarcayModelo(rs.getString("marcaymodelo"));
					alq.getVehiculo().setColor(rs.getString("color"));
										
					alq.getVehiculo().setTipoVehiculo(new TipoVehiculo());
					alq.getVehiculo().getTipoVehiculo().setDescripcion(rs.getString("descripcion"));
					
					alquileresxClte.add(alq);
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
		
		return alquileresxClte;
	}
	
	public Alquiler getById(int id) {
		Alquiler alq = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select alquiler.id, alquiler.id_persona, alquiler.id_vehiculo, alquiler.fec_inic, alquiler.fec_fin, alquiler.fec_entrega, alquiler.kms_inic, alquiler.kms_fin, alquiler.importe, alquiler.fec_cancelacion, alquiler.senia, alquiler.reclamo_obs, alquiler.estado from alquiler where id=?"
					);
			stmt.setInt(1, id);  
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				alq=new Alquiler();
				alq.setId(rs.getInt("id"));
				
				alq.setPersona(new Persona());
				alq.getPersona().setId(rs.getInt("id_persona"));
				
				alq.setVehiculo(new Vehiculo());
				alq.getVehiculo().setIdVehiculo(rs.getInt("id_vehiculo"));
				
				String fec_inic = rs.getDate("fec_inic").toString();
				LocalDate fecha_inicial = LocalDate.parse(fec_inic);					
				alq.setFechaInic(fecha_inicial);
				
				if (rs.getDate("fec_fin").toString()!=null) {
					String fec_fin = rs.getDate("fec_fin").toString();
					LocalDate fecha_final = LocalDate.parse(fec_fin);
					alq.setFechaFin(fecha_final);
				}
				
				if ((rs.getDate("fec_entrega").toString())!=null) {
					String fec_entrega = rs.getDate("fec_entrega").toString();
					LocalDate fecha_entrega = LocalDate.parse(fec_entrega);					
					alq.setFechaEntrega(fecha_entrega);
				}
				
				alq.setKmInic(rs.getDouble("kms_inic"));
				alq.setKmFin(rs.getDouble("kms_fin"));//aca estaba el error
				alq.setImporte(rs.getDouble("importe"));
				
				if ((rs.getDate("fec_cancelacion").toString())!=null) {
					String fec_cancelacion = rs.getDate("fec_cancelacion").toString();
					LocalDate fecha_cancelacion = LocalDate.parse(fec_cancelacion);					
					alq.setFechaCancel(fecha_cancelacion);
				}
				
				alq.setSenia(rs.getDouble("senia"));
				alq.setReclamoyObs(rs.getString("reclamo_obs"));
				alq.setEstado(rs.getString("estado"));
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
		return alq;
	}

}
