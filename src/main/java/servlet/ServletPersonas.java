package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import entities.Rol;
//import entities.Vehiculo;
import logic.PersonaLogic;
import util.Valida;
//import logic.VehiculoLogic;

//import entities.TipoVehiculo;
//import entities.Vehiculo;
//import logic.VehiculoLogic;

/**
 * Servlet implementation class ServletPersonas
 */
@WebServlet("/ServletPersonas")
public class ServletPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonas() {
        super();
        // TODO Auto-generated constructor stub
    }

    String principalpersonas="principalpersonas.jsp";
    String add="altapersona.jsp";
    String edit="editarpersona.jsp";
    String loginvista="loginvista.jsp";
    
    String altaexitosaPers="altaexitosaPers.jsp";
    String eliminarpers="eliminarpers.jsp";
    String faltandatosPers="faltandatosPers.jsp";
    
    String formatoInvalidopers="formatoInvalidopers.jsp";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String acceso="";
		String action=request.getParameter("accion");
		
		if (action.equalsIgnoreCase("principalpersonas")) {
		acceso=principalpersonas;
		}
		else if (action.equalsIgnoreCase("altapersona")) {
			acceso=add;
		}
		else if (action.equalsIgnoreCase("Registrate")) {
			Persona pers = new Persona();
			PersonaLogic plogic = new PersonaLogic();
			
			String nombre = request.getParameter("txtnombre");
			String apellido = request.getParameter("txtapellido");
			String direccion = request.getParameter("txtdireccion");
			String dni = request.getParameter("txtdni");
			String telefono = request.getParameter("txttelefono");
			String email = request.getParameter("txtemail");
			String password = request.getParameter("txtpassword");
			
			pers.setNombre(nombre);
			pers.setApellido(apellido);
			pers.setDireccion(direccion);
			pers.setDni(dni);
			pers.setTel(telefono);
			pers.setEmail(email);
			pers.setPassword(password);
			
			Rol rol2 = new Rol();
			rol2.setId(2);
			pers.addRol(rol2);	
			
			plogic.add(pers);
			acceso=loginvista;
		}		
		else if (action.equalsIgnoreCase("Agregar")) {
			Persona pers = new Persona();
			PersonaLogic plogic = new PersonaLogic();			
			//int id = Integer.parseInt(request.getParameter("txtid"));
			String nombre = request.getParameter("txtnombre");
			String apellido = request.getParameter("txtapellido");
			String direccion = request.getParameter("txtdireccion");
			String dni = request.getParameter("txtdni");
			String telefono = request.getParameter("txttelefono");
			String email = request.getParameter("txtemail");
			String password = request.getParameter("txtpassword");
			
			if (request.getParameter("checkrol1")!=null) {
				Rol rol1 = new Rol();
				rol1.setId(1);
				pers.addRol(rol1);
			}
			if (request.getParameter("checkrol2")!=null) {
				Rol rol2 = new Rol();
				rol2.setId(2);
				pers.addRol(rol2);
			}			
								
			int idPers = 0;
			if (nombre=="" || apellido=="" || dni=="" || direccion=="" || telefono=="" || email=="" || password=="") {
				acceso=faltandatosPers;
			}
			else if (Valida.isAlpha(nombre) && Valida.isAlpha(apellido) && Valida.isDni(dni) && Valida.isDireccion(direccion) && Valida.isEntero(telefono) && Valida.isMail(email) && Valida.isPassword(password)) {
//				alta
				pers.setNombre(nombre);
				pers.setApellido(apellido);
				pers.setDni(dni);
				pers.setDireccion(direccion);
				pers.setTel(telefono);
				pers.setEmail(email);
				pers.setPassword(password);					
				
				plogic.add(pers);
				idPers = pers.getId();
				if (idPers != 0) {
					acceso=altaexitosaPers;
				}				
				
			}
			else {
				acceso=formatoInvalidopers;
			}
			
			
		}
			
		
		else if (action.equalsIgnoreCase("editarpersona")) {
			request.setAttribute("id", request.getParameter("id"));
			acceso=edit;
		}
		else if (action.equalsIgnoreCase("Actualizar")) {
			Persona pers = new Persona();
			PersonaLogic plogic = new PersonaLogic();
			
			int id = Integer.parseInt(request.getParameter("txtid"));
			String nombre = request.getParameter("txtnombre");
			String apellido = request.getParameter("txtapellido");
			String dni = request.getParameter("txtdni");
			String telefono = request.getParameter("txttelefono");
			String email = request.getParameter("txtemail");
			String password = request.getParameter("txtpassword");
			
			if (request.getParameter("checkrol1")!=null) {
				Rol rol1 = new Rol();
				rol1.setId(1);
				pers.addRol(rol1);
			}
			if (request.getParameter("checkrol2")!=null) {
				Rol rol2 = new Rol();
				rol2.setId(2);
				pers.addRol(rol2);
			}
			
			pers.setId(id);
			pers.setNombre(nombre);
			pers.setApellido(apellido);
			pers.setDni(dni);
			pers.setTel(telefono);
			pers.setEmail(email);
			pers.setPassword(password);
			
			
			//vehic.setTipoVehiculo(tvehic);
						
			plogic.update(pers);
			acceso=principalpersonas;
		}
		else if (action.equalsIgnoreCase("eliminarpersona")) {
//			Persona pers = new Persona();
//			PersonaLogic perLog = new PersonaLogic();
//			int id = Integer.parseInt(request.getParameter("id"));
//			pers.setId(id);
//			perLog.remove(pers);
//			acceso=principalpersonas;
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			acceso=eliminarpers;
		}
		else if (action.equalsIgnoreCase("Eliminar")) {
			Persona pers = new Persona();
			PersonaLogic perLog = new PersonaLogic();
			int id = Integer.parseInt(request.getParameter("idPers"));
			pers.setId(id);
			perLog.remove(pers);
			acceso=principalpersonas;
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
