package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Alquiler;
import entities.Persona;
import entities.Vehiculo;
import logic.AlquilerLogic;
import logic.PersonaLogic;
import logic.VehiculoLogic;

/**
 * Servlet implementation class ServletAlquilerUsuario
 */
@WebServlet("/ServletAlquilerUsuario")
public class ServletAlquilerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlquilerUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    String login="loginvista.jsp";
    String principalvehsxtipo="principalvehsxtipo.jsp";
    String alquilerusuario="alquilerusuario.jsp";
    String datosalquilerusuario="datosalquilerusuario.jsp";
    String principalalquileresxclteUsur="principalalquileresxclteUsur.jsp";
    
    //Aca busca vehiculos disponibles
    String principalvehicxtipo="principalvehicxtipo.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession miSesion = request.getSession();
		
		String acceso="";
		String action=request.getParameter("accion");
		
		if (action==null) {
			acceso=login;
		}
		else if (action.equalsIgnoreCase("BuscarVehi")) {
			if (request.getParameter("txtidtipovehiculo")=="") {
				acceso=alquilerusuario;
				RequestDispatcher vista=request.getRequestDispatcher(acceso);
				vista.forward(request, response);
			}
			int idTipoVehiculo = Integer.parseInt(request.getParameter("txtidtipovehiculo"));
			request.setAttribute("idTipoVehiculo", idTipoVehiculo);
			miSesion.setAttribute("idTVSesion", idTipoVehiculo);
			acceso=principalvehicxtipo;
		}
		else if (action.equalsIgnoreCase("alquilerelegido")) {
			int idAlq = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("idAlq", idAlq);
			acceso=datosalquilerusuario;
		}
		else if (action.equalsIgnoreCase("CalculaImporte")) {
			Integer idVehiculo = (Integer)miSesion.getAttribute("idVehic");
			VehiculoLogic vlogic = new VehiculoLogic();
			Vehiculo vehic = vlogic.getById(idVehiculo);
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
			acceso=alquilerusuario;
		}
		else if (action.equalsIgnoreCase("Aceptado")) {
			acceso=principalalquileresxclteUsur;
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
			
			alqLog.add(alq);

			miSesion.removeAttribute("idTVSesion");
			miSesion.removeAttribute("idVehic");
			acceso=alquilerusuario;
		}
		else if (action.equalsIgnoreCase("Cancelar")) {
			miSesion.removeAttribute("idTVSesion");
			miSesion.removeAttribute("idVehic");
			acceso=alquilerusuario;
		}		
		RequestDispatcher vista=request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
