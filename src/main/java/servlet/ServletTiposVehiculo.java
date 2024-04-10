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

import util.Valida;

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
    String add="altatipovehiculo.jsp";
    String edit="editartipovehiculo.jsp";
    
    String altaexitosaTipoVehic="altaexitosaTipoVehic.jsp";
    String faltadatoTipoVehic="faltadatoTipoVehic.jsp";

    String eliminarTipoVehic="eliminarTipoVehic.jsp";
    
    String formatoInvalidoTipoVehic="formatoInvalidoTipoVehic.jsp";
    
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
		else if (action.equalsIgnoreCase("altatipovehiculo")) {
			acceso=add;
			//System.out.println();
		}
		else if (action.equalsIgnoreCase("Agregar")) {
			TipoVehiculo tv = new TipoVehiculo();
			TipoVehiculoLogic tvlogic = new TipoVehiculoLogic();
			String descripcion=request.getParameter("txtdescripcion");
			tv.setDescripcion(descripcion);
			
			int idTVehic = 0;
			if (descripcion!="") {
				if (Valida.isAlpha(descripcion)) {
					tvlogic.add(tv);
					idTVehic = tv.getId();					
				} else {
					acceso=formatoInvalidoTipoVehic;
				}
//				tvlogic.add(tv);
//				idTVehic = tv.getId();
			}
			if (idTVehic!=0) {
				acceso=altaexitosaTipoVehic;
			}
			if (descripcion=="") {
				acceso=faltadatoTipoVehic;
			}
			//tvlogic.add(tv);
			//acceso=principaltiposvehic;
		}
		else if (action.equalsIgnoreCase("editartipovehiculo")) {
			request.setAttribute("idtipovehiculo", request.getParameter("id"));
			acceso=edit;
		}
		else if (action.equalsIgnoreCase("Actualizar")) {
			TipoVehiculo tv = new TipoVehiculo();
			TipoVehiculoLogic tvl = new TipoVehiculoLogic();
//			int id = Integer.parseInt(request.getParameter("txtid"));
			String descripcion = request.getParameter("txtdescripcion");
			
			if (Valida.isAlpha(descripcion)) {
//				alta
				int id = Integer.parseInt(request.getParameter("txtid"));
				tv.setId(id);
				tv.setDescripcion(descripcion);
				tvl.update(tv);
				acceso=principaltiposvehic;				

			} else {
				acceso=formatoInvalidoTipoVehic;
			}
			
			//String costo = request.getParameter("txtcosto");
//			tv.setId(id);
//			tv.setDescripcion(descripcion);
			//tv.setCosto(Double.parseDouble(costo));
//			tvl.update(tv);
//			acceso=principaltiposvehic;
		}
		else if (action.equalsIgnoreCase("eliminartipovehiculo")) {
//			TipoVehiculo tipov = new TipoVehiculo();
//			TipoVehiculoLogic tvl = new TipoVehiculoLogic();
//			int id = Integer.parseInt(request.getParameter("id"));
//			tipov.setId(id);
//			tvl.remove(id);
//			acceso=principaltiposvehic;
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			acceso=eliminarTipoVehic;			
		}
		else if (action.equalsIgnoreCase("Eliminar")) {
			TipoVehiculo tv = new TipoVehiculo();
			TipoVehiculoLogic tvLogic = new TipoVehiculoLogic();
			int id = Integer.parseInt(request.getParameter("idTipoVehic"));
			tv.setId(id);
			tvLogic.remove(id);
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
