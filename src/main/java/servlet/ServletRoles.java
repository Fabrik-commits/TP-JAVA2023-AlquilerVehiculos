package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Rol;
import entities.TipoVehiculo;
//import entities.TipoVehiculo;
import logic.RolLogic;
//import logic.TipoVehiculoLogic;
import logic.TipoVehiculoLogic;

/**
 * Servlet implementation class ServletRoles
 */
@WebServlet("/ServletRoles")
public class ServletRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRoles() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    String principalroles="principalroles.jsp";
    String add="altarol.jsp";
    String edit="editarrol.jsp";
    
    String eliminarrol="eliminarrol.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acceso="";
		String action=request.getParameter("accion");
		
		if (action.equalsIgnoreCase("principalroles")) {
		acceso=principalroles;
		}
		else if (action.equalsIgnoreCase("altarol")) {
			acceso=add;
		}
		else if (action.equalsIgnoreCase("Agregar")) {
			Rol rol = new Rol();
			RolLogic rollog = new RolLogic();
			String descripcion=request.getParameter("txtdescripcion");
			rol.setDescripcion(descripcion);
			rollog.add(rol);
			acceso=principalroles;
		}
		else if (action.equalsIgnoreCase("editarrol")) {
			request.setAttribute("idrol", request.getParameter("id"));
			acceso=edit;
		}
		else if (action.equalsIgnoreCase("Actualizar")) {
			Rol rol = new Rol();
			RolLogic rollog = new RolLogic();
			int id = Integer.parseInt(request.getParameter("txtid"));
			String descripcion = request.getParameter("txtdescripcion");
			rol.setId(id);
			rol.setDescripcion(descripcion);			
			rollog.update(rol);
			acceso=principalroles;
		}
		else if (action.equalsIgnoreCase("eliminarrol")) {
//			Rol rol = new Rol();
//			RolLogic rollog = new RolLogic();
//			int id = Integer.parseInt(request.getParameter("id"));
//			rol.setId(id);
//			rollog.remove(id);
//			acceso=principalroles;
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			acceso=eliminarrol;			
		}
		else if (action.equalsIgnoreCase("Eliminar")) {
			Rol rol = new Rol();
			RolLogic rolLogic = new RolLogic();
			int id = Integer.parseInt(request.getParameter("idRol"));
			rol.setId(id);
			rolLogic.remove(id);
			acceso=principalroles;
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
