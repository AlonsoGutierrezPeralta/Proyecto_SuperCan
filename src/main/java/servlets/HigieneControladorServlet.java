package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionHigiene;
import model.Higiene;

/**
 * Servlet implementation class HigieneControladorServlet
 */
@WebServlet(name = "crudHigiene", urlPatterns = { "/crudHigiene" })
public class HigieneControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HigieneControladorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entró al Servlet de higiene");
		
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		
		switch(accion) {
		
		case "reg":
			String codigo = request.getParameter("txtCodigo");
			String descripcion = request.getParameter("txtDescripcion");
			String marca = request.getParameter("txtMarca");
			int stock = Integer.parseInt(request.getParameter("txtStock"));
			double precio = Double.parseDouble(request.getParameter("txtPrecio"));
			int tipo = Integer.parseInt(request.getParameter("cboTipo"));
			
			Higiene h = new Higiene();
			h.setCodigoH(codigo);
			h.setDescripcion(descripcion);
			h.setMarca(marca);
			h.setStock(stock);
			h.setPrecio(precio);
			h.setIdHigiene(tipo);		
			System.out.println(h);

			GestionHigiene gh = new GestionHigiene();
			int ok = gh.registrar(h);
		
			if(ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
						+ "Error al registrar higiene " + h.getCodigoH() + "!</div>");
			}else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>" + "Higiene"
						+ h.getDescripcion() + "Registrado!</div>");
			}
			request.getRequestDispatcher("MantenimientoCuidados.jsp").forward(request, response);
			break;
		case "act":
			codigo = request.getParameter("txtCodigo");
			descripcion = request.getParameter("txtDescripcion");
			marca = request.getParameter("txtMarca");
			stock = Integer.parseInt(request.getParameter("txtStock"));
			precio = Double.parseDouble(request.getParameter("txtPrecio"));
			tipo = Integer.parseInt(request.getParameter("cboTipo"));
			
			h = new Higiene();
			h.setCodigoH(codigo);
			h.setDescripcion(descripcion);
			h.setMarca(marca);
			h.setStock(stock);
			h.setPrecio(precio);
			h.setIdHigiene(tipo);	
			System.out.println(h);
			
			gh = new GestionHigiene();
			ok = gh.actualizar(h);
			
			if(ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
						+ "Error al actualizar higiene " + h.getCodigoH() + "!</div>");
			}else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>" + "Higiene "
						+ h.getDescripcion() + "Actualizado!</div>");
			}
			request.getRequestDispatcher("MantenimientoCuidados.jsp").forward(request, response);
			break;
		case "eli":
			codigo = request.getParameter("txtCodigo");
			h = new Higiene();
			h.setCodigoH(codigo);
			
			gh = new GestionHigiene();
			ok = gh.eliminar(h);
			
			if(ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
						+ "Error al eliminar higiene " + h.getCodigoH() + "!</div>");
			}else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>" + "Higiene "
						+ h.getCodigoH() + "Eliminado!</div>");
			}
			request.getRequestDispatcher("MantenimientoCuidados.jsp").forward(request, response);
			break;
		
		case "lst":
			gh = new GestionHigiene();
			ArrayList<Higiene> listadoH = gh.listadoH();
			
			request.setAttribute("lstHigiene", listadoH);
			request.getRequestDispatcher("ListadoHigiene.jsp").forward(request, response);
			break;
			
	
		case "buscar":
			codigo = request.getParameter("codigo");
			gh = new GestionHigiene();
			h = gh.buscar(codigo);
			
			request.setAttribute("h", h);
			request.getRequestDispatcher("MantenimientoCuidados.jsp").forward(request, response);
			break;
		default:
		}
		
	}

}
