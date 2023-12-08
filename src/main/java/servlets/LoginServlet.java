package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOFactory;
import model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entro al Servlet: login");
		//leer la información ingresada en la pagina login.jsp
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		System.out.println(usuario + "/" + clave);
		
		//validaciones
		if(usuario.isEmpty()) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
					+ "Debe ingresar el usuario!</div>");
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		}
		
		/*if(!clave.matches("[a-z]A-Z][a-zA-Z0-9]{5,10}")) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
					+ "Formato de clave no correcto: 1° letra seguido de 5 a 10 caracteres!</div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}*/
		
		//proceso
		
		DAOFactory fabrica =  DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		Usuario u = fabrica.getUsuarioDAO().validarAcceso(usuario, clave);
		
		if(u != null) {
		System.out.println(u);
		//enviamos la informacion del usuario a la pagina principal
		//	request.setAttribute("u", u); //atributo enviado a nivel de rwquest
		System.out.println("Id de la sesion: " + request.getSession().getId());
		request.getSession().setAttribute("u", u); //envia el atributo a nivel de sesion
			request.getRequestDispatcher("Inicio.jsp").forward(request, response);
		//if(usuario.equals("admin@gmail.com") && clave.equals("12345")) {
			//System.out.println("Bienvenido, datos correctos");
			response.sendRedirect("Inicio.jsp");
		} else {
			//System.out.println("Usuario o clave incorrectos");
			//response.sendRedirect("login.jsp"); //solo cambia de pagina --> no envia
		//	request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
		//			+ "Usuario o clave incorrectos!</div>"); // debe estar en el jsp
		//	request.getRequestDispatcher("login.jsp").forward(request, response);
			request.setAttribute("mensaje", " <script>swal('Mensaje','Usuario o clave incorrectos','error');</scrip>  ");
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
		}
	}

}
