package data;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
//import java.sql.Date;
import java.time.ZoneId;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Date;
//import java.sql.Timestamp;

import entities.Alquiler;
import entities.Persona;

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
			
			String fec_entrega = alq.getFechaFin().toString();
			stmt.setDate(9, java.sql.Date.valueOf(fec_entrega));
			
			String fec_cancelacion = alq.getFechaFin().toString();
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
	
	public LinkedList<Alquiler> getAllByALquileresxClte(int id) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Alquiler> alquileres = new LinkedList<>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select alquiler.id, alquiler.id_persona, "
					+ "alquiler.id_vehiculo, alquiler.fec_inic, alquiler.fec_fin, alquiler.fec_entrega, alquiler.kms_inic, "
					+ "alquiler.kms_fin, alquiler.importe, alquiler.fec_cancelacion, alquiler.senia, alquiler.reclamo_obs, alquiler.estado "
					+ "from alquiler inner join vehiculo on alquiler.id_vehiculo=vehiculo.id where persona.id_rol=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
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
		
		return alquileres;
	}

}
