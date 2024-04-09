package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.TipoVehiculo;
import entities.Vehiculo;
//import logic.TipoVehiculoLogic;
import logic.VehiculoLogic;
import util.Valida;

/**
 * Servlet implementation class ServletVehiculos
 */
@WebServlet("/ServletVehiculos")
public class ServletVehiculos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVehiculos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    String principalvehic="principalvehic.jsp";
    String add="altavehiculo.jsp";
    String edit="editarvehiculo.jsp";
    String principalvehicnodisp="principalvehicnodisp.jsp";
    String faltandatosVehic="faltandatosVehic.jsp";
    String altaexitosavehiculo="altaexitosavehiculo.jsp";
    
    String eliminarvehiculo="eliminarvehiculo.jsp";
    
    String formatoInvalidoVehic="formatoInvalidoVehic.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acceso="";
		String action=request.getParameter("accion");
		
		if (action.equalsIgnoreCase("principalvehic")) {
		acceso=principalvehic;
		}
		else if (action.equalsIgnoreCase("altavehiculo")) {
			acceso=add;
		}
		else if (action.equalsIgnoreCase("Agregar")) {
			Vehiculo vehic = new Vehiculo();
			TipoVehiculo tvehic = new TipoVehiculo();
			VehiculoLogic vlogic = new VehiculoLogic();;
			String marcaymodelo = request.getParameter("txtmarcaymodelo");
			String anio = request.getParameter("txtanio");
			String kilometraje = request.getParameter("txtkilometraje");
			String pasajeros = request.getParameter("txtpasajeros");
			String color = request.getParameter("txtcolor");
			boolean estado = Boolean.valueOf(request.getParameter("txtestado"));
			String precio = request.getParameter("txtprecio");
			String matricula = request.getParameter("txtmatricula");
			String capacidadmaxima = request.getParameter("txtcapacidadmaxima");
			String idMiSelec =request.getParameter("miSelect");
//			String idtipovehiculo = request.getParameter("miSelect");
			
			int idVehic=0;
			if (marcaymodelo=="" || precio=="" || matricula=="" || idMiSelec=="") {
				acceso=faltandatosVehic;
			} else {
				boolean marymodboolean = Valida.isMarcaModelo(marcaymodelo);
				boolean precboolean = Valida.isRealPositivo(precio);				
				boolean matricboolean = Valida.isMatricula(matricula);
				
				if (marymodboolean && precboolean && matricboolean) {
					if (kilometraje=="" && anio=="" && pasajeros=="" && color=="" && capacidadmaxima=="") {
//						alta
//						vehic.setCapacidadMaxima(Double.parseDouble(capacidadmaxima));
						vehic.setPrecio(Double.parseDouble(precio));
						vehic.setEstado(estado);
//						vehic.setAnio(Integer.parseInt(anio));
//						vehic.setPasajeros(Integer.parseInt(pasajeros));
//						vehic.setColor(color);
						vehic.setMarcayModelo(marcaymodelo);
						
						tvehic.setId(Integer.parseInt(idMiSelec));
						vehic.setTipoVehiculo(tvehic);

						vlogic.add(vehic);
						idVehic=vehic.getIdVehiculo();
						if(idVehic!=0) {
							acceso=altaexitosavehiculo;
						}						
					}
					else if (Valida.isRealPositivo(kilometraje) && Valida.isEntero(anio) && Valida.isEntero(pasajeros) && Valida.isAlpha(color)) {
//						alta
						vehic.setCapacidadMaxima(Double.parseDouble(capacidadmaxima));
						vehic.setPrecio(Double.parseDouble(precio));
						vehic.setEstado(estado);
						vehic.setAnio(Integer.parseInt(anio));
						vehic.setPasajeros(Integer.parseInt(pasajeros));
						vehic.setColor(color);
						vehic.setMarcayModelo(marcaymodelo);
						
						tvehic.setId(Integer.parseInt(idMiSelec));
						vehic.setTipoVehiculo(tvehic);
						
						vlogic.add(vehic);
						idVehic=vehic.getIdVehiculo();
						if(idVehic!=0) {
							acceso=altaexitosavehiculo;
						}
					} else {
						acceso=formatoInvalidoVehic;
					}

				} else {
					acceso=formatoInvalidoVehic;
				}
				
			}
			

		}
		
		
		
		
		
		
		else if (action.equalsIgnoreCase("editarvehiculo")) {
			request.setAttribute("idvehiculo", request.getParameter("id"));
			acceso=edit;
		}
		else if (action.equalsIgnoreCase("Actualizar")) {
			Vehiculo vehic = new Vehiculo();
			TipoVehiculo tvehic = new TipoVehiculo();
			VehiculoLogic vlogic = new VehiculoLogic();
			int id = Integer.parseInt(request.getParameter("txtidvehiculo"));
			String marcaymodelo = request.getParameter("txtmarcaymodelo");
			int anio = Integer.parseInt(request.getParameter("txtanio"));
			String kilometraje = request.getParameter("txtkilometraje");
			int pasajeros = Integer.parseInt(request.getParameter("txtpasajeros"));
			String color = request.getParameter("txtcolor");
			boolean estado = Boolean.valueOf(request.getParameter("txtestado"));
			String precio = request.getParameter("txtprecio");
			String matricula = request.getParameter("txtmatricula");
			String capacidadmaxima = request.getParameter("txtcapacidadmaxima");
			
			int idtipovehiculo = Integer.parseInt(request.getParameter("txtidtipovehiculo"));
//			System.out.println(idtipovehiculo);
			
			tvehic.setId(idtipovehiculo);
//			System.out.println();
			vehic.setIdVehiculo(id);
			vehic.setMarcayModelo(marcaymodelo);			
			vehic.setAnio(anio);
			vehic.setKilometraje(Double.parseDouble(kilometraje));
			vehic.setPasajeros(pasajeros);
			vehic.setColor(color);
			vehic.setEstado(estado);
			vehic.setPrecio(Double.parseDouble(precio));
			vehic.setMatricula(matricula);
			vehic.setCapacidadMaxima(Double.parseDouble(capacidadmaxima));
			vehic.setTipoVehiculo(tvehic);  //aca estaba el problema pero no mas
//			System.out.println(vehic.getTipoVehiculo().getId());			
//			System.out.println();
//			vehic.getTipoVehiculo().getId();
			vlogic.update(vehic);
			acceso=principalvehic;
		}
		else if (action.equalsIgnoreCase("estado")) {
			Vehiculo vehic = new Vehiculo();
			VehiculoLogic vlogic = new VehiculoLogic();
			int id = Integer.parseInt(request.getParameter("id"));
			vehic = vlogic.getById(id);
			vehic.setEstado(true);
			vlogic.update(vehic);
			acceso=principalvehicnodisp;
		}		
		else if (action.equalsIgnoreCase("eliminarvehiculo")) {
//			Vehiculo vehic = new Vehiculo();
//			VehiculoLogic vehicl = new VehiculoLogic();
//			int id = Integer.parseInt(request.getParameter("id"));
//			vehic.setIdVehiculo(id);
//			vehicl.remove(id);
//			acceso=principalvehic;
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			acceso=eliminarvehiculo;
		}
		else if (action.equalsIgnoreCase("Eliminar")) {
			Vehiculo vehic = new Vehiculo();
			VehiculoLogic vl = new VehiculoLogic();
			int id = Integer.parseInt(request.getParameter("idVehic"));
			vehic.setIdVehiculo(id);
			vl.remove(id);
			acceso=principalvehic;
		}
		else if (action.equalsIgnoreCase("Cancelar")) {
			acceso=principalvehic;
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
