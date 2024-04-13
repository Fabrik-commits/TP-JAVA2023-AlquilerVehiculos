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
import util.Valida;

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
    //String principalvehsxtipo="principalvehsxtipo.jsp";
    //String add="altaalqadmin.jsp";
    String alquileradmin="alquileradmin.jsp";
    String edit="editaralqadmin.jsp";
    String login="loginvista.jsp";
    
    //Aca busca vehiculos disponibles
    String principalvehicxtipo="principalvehicxtipo.jsp";
    
    String principalalquileresxclte="principalalquileresxclte.jsp";
    String editaralquileradmin="editaralquileradmin.jsp";
    String principal="principal.jsp";
    String alquilerusuario="alquilerusuario.jsp";
    
    String altaexitosa="altaexitosa.jsp";
    String faltandatos="faltandatos.jsp";
    String edicionexitosa="edicionexitosa.jsp";
    
    String formatoInvalidoAlqAdmin="formatoInvalidoAlqAdmin.jsp";
    
//    int verificador = 0; //para que no se ejecute el ultimo dispatcher
    int idAlq = 0; 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession miSesion = request.getSession();
		
		String acceso="";
		String action=request.getParameter("accion");
		
		if (action==null) {
			acceso=login;
//			RequestDispatcher vista=request.getRequestDispatcher(acceso);
//			vista.forward(request, response);
		}
//		else if (action.equalsIgnoreCase("principalvehsxtipo")) {
//		acceso=principalvehsxtipo;
//		}
		else if (action.equalsIgnoreCase("BuscarVehi")) {
			if (request.getParameter("txtidtipovehiculo")=="") {
				//acceso=alquileradmin;
				//response.sendRedirect("alquileradmin.jsp");
				acceso=alquileradmin;
				RequestDispatcher vista=request.getRequestDispatcher(acceso);
				vista.forward(request, response);
			}
			int idTipoVehiculo = Integer.parseInt(request.getParameter("txtidtipovehiculo"));
			//el idTipoVehiculo es seteado 
			request.setAttribute("idTipoVehiculo", idTipoVehiculo); //esta linea y la de abajo deberian ser una pero, habria que ......
			miSesion.setAttribute("idTVSesion", idTipoVehiculo);    //modificar principalvehicxtipo.jsp 
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
			//esa variable es enviada al input de vehiculo en alquileradmin o alquilerusuario
			
			Boolean rol1 = (Boolean)request.getSession().getAttribute("rol1");
			Boolean rol2 = (Boolean)request.getSession().getAttribute("rol2");
			if (rol1 && rol2) {
				acceso=alquileradmin;
			}
			else if (rol2) {
				acceso=alquilerusuario;
			}
			//acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("personaelegida")) {
			int idPer = Integer.parseInt(request.getParameter("id"));//viene de la tabla principalclientes
			miSesion.setAttribute("idPer", idPer);
			miSesion.setAttribute("idPerqAlquila", idPer);
			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("clienteelegido")) {
			int idPers = Integer.parseInt(request.getParameter("id"));//viene de la tabla alquileres y clientes, y va a alquileresxcllte
			request.setAttribute("idPers", idPers);
			acceso=principalalquileresxclte;						
		} 
		else if (action.equalsIgnoreCase("CalculaImporte")) {
			VehiculoLogic vlogic = new VehiculoLogic();
			
			String fecInit = request.getParameter("fecInic");
			String fecFin = request.getParameter("fecFin");

			Vehiculo vehic = vlogic.getById(idVehicElegido);
			if ((vehic != null) && (fecInit != "") && (fecFin != "")) {
				//System.out.println("esto es: " + fecInit);
				double precio = vehic.getPrecio();
				request.setAttribute("fecInit", fecInit);
				request.setAttribute("fecFin", fecFin);
				
				LocalDate fechaInic = LocalDate.parse(fecInit);
				LocalDate fechaFin = LocalDate.parse(fecFin);
				
				long cantDias = ChronoUnit.DAYS.between(fechaInic, fechaFin);

				Double importeTotal = cantDias*precio/730;
				
				request.setAttribute("importeTotal", importeTotal);
				
			}

			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("Cancelar")) {
			miSesion.removeAttribute("idPerqAlquila");
			//miSesion.removeAttribute("idTVSesion");
			miSesion.removeAttribute("idVehic");
			acceso=alquileradmin;
		}
		else if (action.equalsIgnoreCase("Aceptar")) {
			Alquiler alq = new Alquiler();
			AlquilerLogic alqLog = new AlquilerLogic();
			
			PersonaLogic pl = new PersonaLogic();
			int idPers = Integer.parseInt(request.getParameter("idPers"));			
			Persona pers = pl.getById(idPers);
			
			VehiculoLogic vl = new VehiculoLogic();
			int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
			Vehiculo vehic = vl.getById(idVehiculo);
			
			String senia = request.getParameter("senia");
			String importe = request.getParameter("importe");
			String fecInic = request.getParameter("fecInic");
			String fecFin = request.getParameter("fecFin");
			String kminic = request.getParameter("kminic");
			String recyobs = request.getParameter("recyobs");
			String estado = request.getParameter("txtestado");
			
			if (pers == null || vehic == null || fecInic == "" || fecFin == "" || senia == "" || importe == "") {
				acceso=faltandatos;
			} else {
				if (recyobs == "" && Valida.isRealPositivo(senia) && Valida.isRealPositivo(importe) && Valida.isRealPositivo(kminic)) {
//					alta
					vehic.setEstado(false);
					vl.update(vehic);
					alq.setPersona(pers);
					alq.getPersona().setId(idPers);				
					alq.setVehiculo(vehic);
					alq.getVehiculo().setIdVehiculo(idVehiculo);
					alq.setSenia(Double.parseDouble(senia));
					alq.setFechaInic(LocalDate.parse(fecInic));
					alq.setFechaFin(LocalDate.parse(fecFin));
//					System.out.println(Double.parseDouble(importe));
//					System.out.println();
					alq.setImporte(Double.parseDouble(importe));
					alq.setKmInic(Double.parseDouble(kminic));
					alq.setEstado(estado);
//					alta exitosa
					alqLog.add(alq);
					idAlq = alq.getId();
					if (idAlq!=0) {
						miSesion.removeAttribute("idPerqAlquila");
						miSesion.removeAttribute("idTVSesion");
						miSesion.removeAttribute("idVehic");							
						acceso=altaexitosa;
					}					
					
				} 
				else if (Valida.isMarcaModelo(recyobs) && Valida.isRealPositivo(senia) && Valida.isRealPositivo(importe) && Valida.isRealPositivo(kminic)){
//					alta
					vehic.setEstado(false);
					vl.update(vehic);
					
					alq.setPersona(pers);
					alq.getPersona().setId(idPers);				
					alq.setVehiculo(vehic);
					alq.getVehiculo().setIdVehiculo(idVehiculo);
					alq.setSenia(Double.parseDouble(senia));
					alq.setFechaInic(LocalDate.parse(fecInic));
					alq.setFechaFin(LocalDate.parse(fecFin));
					alq.setImporte(Double.parseDouble(importe));
					alq.setKmInic(Double.parseDouble(kminic));
					alq.setReclamoyObs(recyobs);
//					alta exitosa
					alqLog.add(alq);
					idAlq = alq.getId();					
					if (idAlq!=0) {
						miSesion.removeAttribute("idPerqAlquila");
						miSesion.removeAttribute("idTVSesion");
						miSesion.removeAttribute("idVehic");						
						acceso=altaexitosa;
					}					
				}
				else {
					acceso=formatoInvalidoAlqAdmin;
				}
				
			}


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

			if (fecentrega!="") {
				alq.setFechaEntrega(LocalDate.parse(fecentrega));
				estado="Finalizado";
				alq.setEstado(estado);
			}

			if (feccancel!="") {
				alq.setFechaCancel(LocalDate.parse(feccancel));
				estado="Cancelado";
				alq.setEstado(estado);
				VehiculoLogic vl = new VehiculoLogic();
				Vehiculo vehic = new Vehiculo();				
				int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
				vehic = vl.getById(idVehiculo);
				vehic.setEstado(true);
				vl.update(vehic);
			}
			
			if (fecentrega!="") {     //(fecentrega!="")|| (feccancel!="") el vehic estara disponible despues que tecnico revise el auto
				alq.setFechaEntrega(LocalDate.parse(fecentrega));
				estado="Finalizado";
		
			}
			
			if (recyobs=="") {
				alq.setReclamoyObs("");
			} else {
				alq.setReclamoyObs(recyobs);
			}

			alqLog.update(alq);
			int idPersona = Integer.parseInt(idPer);//me esta devolviendo el idAlquiler
			request.setAttribute("idPers", idPersona);
			acceso=principalalquileresxclte;
		}
		
//		if (verificador != 1) {
//			RequestDispatcher vista=request.getRequestDispatcher(acceso);
//			vista.forward(request, response);			
//		}
		
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
