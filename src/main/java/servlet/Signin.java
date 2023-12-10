package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

import entities.Persona;
import entities.Rol;
import logic.PersonaLogic;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    String loginvista = "loginvista.jsp";
    String index2 ="index2.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession miSesion = request.getSession();
		
		Persona per = new Persona();
		
		PersonaLogic pl = new PersonaLogic();
		
		Rol rol1 = new Rol();
		rol1.setId(1);
		
		Rol rol2 = new Rol();
		rol2.setId(2);
				
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		per.setEmail(email);
		per.setPassword(password);
		
		String acceso="";		
		String action=request.getParameter("accion");
		
		if (action==null) {
			acceso=loginvista;
			RequestDispatcher vista=request.getRequestDispatcher(acceso);
			vista.forward(request, response);
		}
		
		else if (action.equalsIgnoreCase("Login")) {
			if (pl.validate(per)!=null) {
								
				per = pl.validate(per);
				miSesion.setAttribute("idUsr", per.getId());
				miSesion.setAttribute("nombre", per.getNombre());
				miSesion.setAttribute("rol1", per.hasRol(rol1));
				miSesion.setAttribute("rol2", per.hasRol(rol2));
				//System.out.println( (per.getId()) );
				if ( (per.hasRol(rol1)) && (per.hasRol(rol2)) ) {
					request.getRequestDispatcher("principal.jsp").forward(request, response);
				}
				else if ( (per.hasRol(rol2)) ) {
					request.getRequestDispatcher("principalcliente.jsp").forward(request, response);
				}
				
			}
			else {
				//aviso de clave o usu incorrecto
				//JFrame f = new JFrame();
				//JOptionPane.showMessageDialog(f,"Usuario o Clave incorrecta"); 
				response.sendRedirect("loginvista2.jsp");
			}
		}
		
		else if (action.equalsIgnoreCase("Login2")) {
			if (pl.validate(per)!=null) {
								
				per = pl.validate(per);
				miSesion.setAttribute("idUsr", per.getId());
				miSesion.setAttribute("nombre", per.getNombre());
				miSesion.setAttribute("rol1", per.hasRol(rol1));
				miSesion.setAttribute("rol2", per.hasRol(rol2));
				//System.out.println( (per.getId()) );
				if ( (per.hasRol(rol1)) && (per.hasRol(rol2)) ) {
					request.getRequestDispatcher("principal.jsp").forward(request, response);
				}
				else if ( (per.hasRol(rol2)) ) {
					request.getRequestDispatcher("principalcliente.jsp").forward(request, response);
				}
				
			}
			else {
				//aviso de clave o usu incorrecto
				//JFrame f = new JFrame();
				//JOptionPane.showMessageDialog(f,"Usuario o Clave incorrecta"); 
				response.sendRedirect("loginvista2.jsp");
			}
		}
		
		else if (action.equalsIgnoreCase("cerrarsesion")) {
			miSesion.invalidate();
			acceso=loginvista;
			RequestDispatcher vista=request.getRequestDispatcher(acceso);
			//request.getRequestDispatcher(acceso).forward(request, response);
			vista.forward(request, response);
		}
		

		
		
		
//		else if (action.equalsIgnoreCase("cerrarsesion")) {
//			miSesion.invalidate();
//			acceso=loginvista;
//			RequestDispatcher vista=request.getRequestDispatcher(acceso);
//			//request.getRequestDispatcher(acceso).forward(request, response);
//			vista.forward(request, response);
//		}
				
		//per = pl.validate(per);		
		//request.getSession().setAttribute("usuario", per);
		//request.getRequestDispatcher("principal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);				
		
	}

}
