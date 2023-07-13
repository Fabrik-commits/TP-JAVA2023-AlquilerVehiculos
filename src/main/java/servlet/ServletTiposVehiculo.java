package servlet;

import java.io.IOException;
//import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.TipoVehiculo;
import logic.TipoVehiculoLogic;

/**
 * Servlet implementation class ServletTiposVehiculo
 */
@WebServlet("/ServletTiposVehiculo")
public class ServletTiposVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTiposVehiculo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    String principaltiposvehic="principaltiposvehic.jsp";
    //String add="vistas/add.jsp";
    String edit="editartipovehiculo.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acceso="";
		String action=request.getParameter("accion");
		
		if (action.equalsIgnoreCase("principaltiposvehic")) {
		acceso=principaltiposvehic;
		}
		else if (action.equalsIgnoreCase("editartipovehiculo")) {
			request.setAttribute("idtipovehiculo", request.getParameter("id"));
			acceso=edit;
		}
		else if (action.equalsIgnoreCase("Actualizar")) {
			TipoVehiculo tv = new TipoVehiculo();
			TipoVehiculoLogic tvl = new TipoVehiculoLogic();
			int id = Integer.parseInt(request.getParameter("txtid"));
			String descripcion = request.getParameter("txtdescripcion");
			String costo = request.getParameter("txtcosto");
			tv.setId(id);
			tv.setDescripcion(descripcion);
			tv.setCosto(Double.parseDouble(costo));
			tvl.update(tv);
			acceso=principaltiposvehic;
		}
		else if (action.equalsIgnoreCase("Cancelar")) {
			acceso=principaltiposvehic;
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
		
		//request.getSession().setAttribute("usuario", per);
		
//		TipoVehiculoLogic tvl = new TipoVehiculoLogic();
//		
//		LinkedList<TipoVehiculo> tiposvehiculo = tvl.getAllTiposVehiculo();
//		
//		request.setAttribute("listaTiposvehiculo", tiposvehiculo);
//		
//		request.getRequestDispatcher("principaltiposvehic.jsp").forward(request, response);
	}

}
