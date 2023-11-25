package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Alquiler;
import entities.Persona;
//import entities.Persona;
//import entities.TipoVehiculo;
import entities.Vehiculo;
import logic.AlquilerLogic;
import logic.PersonaLogic;
//import logic.PersonaLogic;
//import logic.TipoVehiculoLogic;
import logic.VehiculoLogic;

/**
 * Servlet implementation class ServletAlquilerAdmin
 */
@WebServlet("/ServletAlquilerAdmin")
public class ServletAlquilerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlquilerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    int idVehicElegido;//probando
    String principalvehsxtipo="principalvehsxtipo.jsp";
    //String add="altaalqadmin.jsp";
    String alquileradmin="alquileradmin.jsp";
    String edit="editaralqadmin.jsp";
    
    //Aca busca vehiculos disponibles
    String principalvehicxtipo="principalvehicxtipo.jsp";
    
    String principalalquileresxclte="principalalquileresxclte.jsp";
    String editaralquileradmin="editaralquileradmin.jsp";
    String principal="principal.jsp";
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession miSesion = request.getSession();
		
		String acceso="";
		String action=request.getParameter("accion");
		
		if (action.equalsIgnoreCase("principalvehsxtipo")) {
		acceso=principalvehsxtipo;
		}
		else if (action.equalsIgnoreCase("BuscarVehi")) {
			int idTipoVehiculo = Integer.parseInt(request.getParameter("txtidtipovehiculo"));
			//el idTipoVehiculo es seteado 
			request.setAttribute("idTipoVehiculo", idTipoVehiculo); //esta linea seria reemplazada por la de abajo
			miSesion.setAttribute("idTVSesion", idTipoVehiculo);
			acceso=principalvehicxtipo;
		}
		else if (action.equalsIgnoreCase("vehicelegido")) {
			int id = Integer.parseInt(request.getParameter("id"));//viene de la tabla vehiculo
			idVehicElegido = id;
			VehiculoLogic vlogic = new VehiculoLogic();
			Vehiculo vehic = vlogic.getById(id);
			int idVehic = vehic.getIdVehiculo();
			//ahora tendria que enviar idVehic del vehic a alquileradmin no lo de abajo
			//indicado porque tira error nullexception haciendo la busqueda
			//en alquileradmin porque le falta el id
			//request.setAttribute("idVehic", idVehic);
			miSesion.setAttribute("idVehic", idVehic);
			
			//esa variable es enviada al input de vehiculo en alquileradmin
			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("personaelegida")) {
			int idPer = Integer.parseInt(request.getParameter("id"));//viene de la tabla persona
			//request.setAttribute("idPer", idPer);
			//request.getSession().setAttribute("personaElegida",idPer); //TODO session guia del profe
			miSesion.setAttribute("idPer", idPer);			
			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("clienteelegido")) {
			int idPers = Integer.parseInt(request.getParameter("id"));//viene de la tabla alquileres y clientes, y va a alquileresxcllte
			request.setAttribute("idPers", idPers);
			acceso=principalalquileresxclte;						
		} 
		else if (action.equalsIgnoreCase("CalculaImporte")) {
			VehiculoLogic vlogic = new VehiculoLogic();
			Vehiculo vehic = vlogic.getById(idVehicElegido);
			double precio = vehic.getPrecio();
					
			String fecInit = request.getParameter("fecInic");
			String fecFin = request.getParameter("fecFin");
			
			request.setAttribute("fecInit", fecInit);
			request.setAttribute("fecFin", fecFin);
			
			LocalDate fechaInic = LocalDate.parse(fecInit);
			LocalDate fechaFin = LocalDate.parse(fecFin);
			
			long cantDias = ChronoUnit.DAYS.between(fechaInic, fechaFin);

			Double importeTotal = cantDias*precio/730;
			
			request.setAttribute("importeTotal", importeTotal);
			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("Cancelar")) {
			miSesion.invalidate();
			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("Aceptar")) {
			Alquiler alq = new Alquiler();
			AlquilerLogic alqLog = new AlquilerLogic();
			
			//Persona pers;
			Persona pers = new Persona();
			PersonaLogic pl = new PersonaLogic();
			int idPers = Integer.parseInt(request.getParameter("idPers"));			
			pers = pl.getById(idPers);
			
			//Vehiculo vehic;
			Vehiculo vehic = new Vehiculo();
			VehiculoLogic vl = new VehiculoLogic();
			int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
			vehic = vl.getById(idVehiculo);
			vehic.setEstado(false);
			vl.update(vehic);
			
			String senia = request.getParameter("senia");
			String fecInic = request.getParameter("fecInic");
			String fecFin = request.getParameter("fecFin");
			String importe = request.getParameter("importe");
			
			//vehic.getKilometraje();
			String kminic = request.getParameter("kminic");
			
			String kmfin = request.getParameter("kmfin");
			String fecentrega = request.getParameter("fecentrega");
			String feccancel = request.getParameter("feccancel");
			String recyobs = request.getParameter("recyobs");
			String estado = request.getParameter("txtestado");
			alq.setPersona(pers);
			alq.getPersona().setId(idPers);
			
			alq.setVehiculo(vehic);
			alq.getVehiculo().setIdVehiculo(idVehiculo);

			if (fecInic=="") {
				alq.setFechaFin(LocalDate.now());
			} else {
				alq.setFechaInic(LocalDate.parse(fecInic));
			}
			
			if (fecFin=="") {
				alq.setFechaFin(LocalDate.now().plusDays(1));
			}
			else {
				alq.setFechaFin(LocalDate.parse(fecFin));
			}
			
			if (senia=="") {				
				alq.setSenia(0.0);
			}
			else {
				alq.setSenia(Double.parseDouble(senia));
			}
			
			if (importe=="") {
				alq.setImporte(0.0);
			} else {
				alq.setImporte(Double.parseDouble(importe));
			}
			
			if (kminic=="") {
				alq.setKmInic(0.0);
			} else {
				alq.setKmInic(Double.parseDouble(kminic));
			}
			
			if (kmfin=="") {
				alq.setKmFin(0.0);
			} else {
				alq.setKmFin(Double.parseDouble(kmfin));
			}
			
			/*
			 * if(fecentrega!=null || fecentrega!="") {
			 * alq.setFechaEntrega(LocalDate.parse(fecentrega));
			 * } 
			 */
			
			//a modificar para probar en caso de null
//			if (fecentrega=="") {
//				alq.setFechaEntrega(LocalDate.now());//alq.setFechaFin(LocalDate.now());
//				
//			} else {
//				alq.setFechaEntrega(LocalDate.parse(fecentrega));
//			}
			
			if (!(fecentrega=="")) {
				//alq.setFechaEntrega(LocalDate.parse(fecentrega));	no corresponde por ser alta alquiler
				//System.out.println();
			}
			
//			if (feccancel=="") {
//				alq.setFechaCancel(LocalDate.now());
//			} else {
//				alq.setFechaCancel(LocalDate.parse(feccancel));
//			}
			
			if (!(feccancel=="")) {
				//alq.setFechaCancel(LocalDate.parse(feccancel)); no corresponde por ser alta alquiler 
				//System.out.println();
			}
			
			if (recyobs=="") {
				alq.setReclamoyObs("");
			} else {
				alq.setReclamoyObs(recyobs);
			}
			
			if (estado=="") {
				alq.setEstado("");
			} else {
				alq.setEstado(estado);
			}
			//alq.setSenia(Double.parseDouble(senia));
			//alq.setFechaInic(LocalDate.parse(fecInic));
//			alq.setFechaFin(LocalDate.parse(fecFin));
//			alq.setImporte(Double.parseDouble(importe));
//			alq.setKmInic(Double.parseDouble(kminic));			
//			alq.setKmFin(Double.parseDouble(kmfin));
//			alq.setFechaEntrega(LocalDate.parse(fecentrega));
//			alq.setFechaCancel(LocalDate.parse(feccancel));
//			alq.setReclamoyObs(recyobs);
//			alq.setEstado(estado);//			
			alqLog.add(alq);
			miSesion.invalidate();
			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("alquilerelegido")) {
			int idAlq = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("idAlq", idAlq);
			acceso=editaralquileradmin;			
		}
		else if (action.equalsIgnoreCase("Actualizar")) {
			Alquiler alq = new Alquiler();
			AlquilerLogic alqLog = new AlquilerLogic();
			
			String idPer = request.getParameter("idPers");
			
			String id = request.getParameter("idAlq");
			String Kmfin = request.getParameter("Kmfin");		
			String fecentrega = request.getParameter("fecentrega");
			String feccancel = request.getParameter("feccancel");
			String recyobs = request.getParameter("recyobs");
//			String estado = request.getParameter("txtestado");
			String estado;

			if (id=="") {
				alq.setId(0);
			} else {
				alq.setId(Integer.parseInt(id));
			}
			if (Kmfin=="") {
				alq.setKmFin(0.0);
			} else {
				alq.setKmFin(Double.parseDouble(Kmfin)); 
			}
			
//			if (fecentrega=="") {
//				alq.setFechaEntrega(LocalDate.now());
//			} else {
//				alq.setFechaEntrega(LocalDate.parse(fecentrega));
//			}
			if (fecentrega!="") {
				alq.setFechaEntrega(LocalDate.parse(fecentrega));
				estado="Finalizado";
				alq.setEstado(estado);
			}
			
//			if (feccancel=="") {
//				alq.setFechaCancel(LocalDate.now());
//			} else {
//				alq.setFechaCancel(LocalDate.parse(feccancel));
//			}
			if (feccancel!="") {
				alq.setFechaEntrega(LocalDate.parse(feccancel));
				estado="Cancelado";
				alq.setEstado(estado);
			}
			
			if ((fecentrega!="")|| (feccancel!="")) {
				VehiculoLogic vl = new VehiculoLogic();
				Vehiculo vehic = new Vehiculo();				
				int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
				vehic = vl.getById(idVehiculo);
				vehic.setEstado(true);
				vl.update(vehic);
			}
			
			if (recyobs=="") {
				alq.setReclamoyObs("");
			} else {
				alq.setReclamoyObs(recyobs);
			}
			
//			if (estado=="") {
//				alq.setEstado("");
//			} else {
//				alq.setEstado(estado);
//			}
			//String idPersona = request.getParameter("idPers");
			//System.out.println(idPersona);
			//System.out.println();
			alqLog.update(alq);
			int idPersona = Integer.parseInt(idPer);//me esta devolviendo el idAlquiler
//			System.out.println(idPersona);
			request.setAttribute("idPers", idPersona);
			acceso=principalalquileresxclte;
			//acceso=principal;
		}
				
		RequestDispatcher vista=request.getRequestDispatcher(acceso);
		//request.getRequestDispatcher(acceso).forward(request, response);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
