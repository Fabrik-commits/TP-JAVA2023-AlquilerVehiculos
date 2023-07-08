package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Persona per = new Persona();
		
		PersonaLogic pl = new PersonaLogic();
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//validar email y password
		
		per.setEmail(email);
		per.setPassword(password);
		
		//String var = per.getEmail();
		
		per = pl.validate(per);
		
		request.getSession().setAttribute("usuario", per);
		//response.getWriter().append("Bienvenido ").append(per.getNombre()).append(" ").append(per.getApellido());
		request.getRequestDispatcher("principal.jsp").forward(request, response);
	}

}
