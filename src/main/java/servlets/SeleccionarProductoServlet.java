package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOFactory;
import mantenimientos.GestionAccesorios;
import mantenimientos.GestionHigiene;
import model.Accesorios;
import model.Alimentos;
import model.Higiene;


/**
 * Servlet implementation class SeleccionarProductoServlet
 */
@WebServlet(name = "add", urlPatterns = { "/add" })
public class SeleccionarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entro en el servlet de Agregarseleccionado");
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		//captura el codigo del producto seleccionado  en el catalogo
		switch (accion) {
		case "addAlimentos":
		String codigoAL = request.getParameter("codigoAL");
		//obtener un obj de producto y enviarlo  como atributo  de sesion -> pag compra
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		Alimentos a = fabrica.getAlimentosDAO().buscar(codigoAL);
		request.getSession().setAttribute("a", a);
		response.sendRedirect("FormularioAlimentos.jsp");
			break;
		
		case "addHigiene":
			String codigoH = request.getParameter("codigoH");
			//obtener un obj de producto y enviarlo  como atributo  de sesion -> pag compra
			GestionHigiene  gh = new GestionHigiene();
			Higiene  h = gh.buscar(codigoH);
			request.getSession().setAttribute("h", h);
			response.sendRedirect("FormularioHigiene.jsp");
			break;
			
		case "addAccesorios":
			String codigoA = request.getParameter("codigoA");
			GestionAccesorios  ga = new GestionAccesorios();
			Accesorios  c = ga.buscar(codigoA);
			request.getSession().setAttribute("c", c);
			response.sendRedirect("FormularioAccesorios.jsp");
			
			
		}
		
		
			
		
	}
}
