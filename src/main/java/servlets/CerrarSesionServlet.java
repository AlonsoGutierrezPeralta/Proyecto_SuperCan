package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CerrarSesionServlet
 */
@WebServlet(name = "Cerrar", urlPatterns = { "/Cerrar" })
public class CerrarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet cerrar sesion...");
		//invalidar la sesion --> eliminas
		System.out.println("cerrando la sesion : " + request.getSession());
		request.getSession().invalidate();
		//redireccionar
		response.sendRedirect("LogIn.jsp");
	}

}
