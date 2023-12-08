package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionAccesorios;
import model.Accesorios;

/**
 * Servlet implementation class AccesoriosControladorServlet
 */
@WebServlet(name = "crudAccesorios", urlPatterns = { "/crudAccesorios" })
public class AccesoriosControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccesoriosControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("Entró al Servlet de Accesorios");
		
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
			
			Accesorios c = new Accesorios();
			c.setCodigoA(codigo);
			c.setDescripcion(descripcion);
			c.setMarca(marca);
			c.setStock(stock);
			c.setPrecio(precio);
			c.setIdAccesorio(tipo);		
			System.out.println(c);

			GestionAccesorios ga = new GestionAccesorios();
			int ok = ga.registrar(c);
		
			if(ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
						+ "Error al registrar higiene " + c.getCodigoA() + "!</div>");
			}else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>" + "Higiene"
						+ c.getDescripcion() + "Registrado!</div>");
			}
			request.getRequestDispatcher("MantenimientoAccesorios.jsp").forward(request, response);
			break;
		case "act":
			codigo = request.getParameter("txtCodigo");
			descripcion = request.getParameter("txtDescripcion");
			marca = request.getParameter("txtMarca");
			stock = Integer.parseInt(request.getParameter("txtStock"));
			precio = Double.parseDouble(request.getParameter("txtPrecio"));
			tipo = Integer.parseInt(request.getParameter("cboTipo"));
			
			c = new Accesorios();
			c.setCodigoA(codigo);
			c.setDescripcion(descripcion);
			c.setMarca(marca);
			c.setStock(stock);
			c.setPrecio(precio);
			c.setIdAccesorio(tipo);	
			System.out.println(c);
			
			ga = new GestionAccesorios();
			ok = ga.actualizar(c);
			
			if(ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
						+ "Error al actualizar higiene " + c.getCodigoA() + "!</div>");
			}else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>" + "Higiene "
						+ c.getDescripcion() + "Actualizado!</div>");
			}
			request.getRequestDispatcher("MantenimientoAccesorios.jsp").forward(request, response);
			break;
		case "eli":
			codigo = request.getParameter("txtCodigo");
			c = new Accesorios();
			c.setCodigoA(codigo);
			
			ga = new GestionAccesorios();
			ok = ga.eliminar(c);
			
			if(ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
						+ "Error al eliminar higiene " + c.getCodigoA() + "!</div>");
			}else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>" + "Higiene "
						+ c.getCodigoA() + "Eliminado!</div>");
			}
			request.getRequestDispatcher("MantenimientoAccesorios.jsp").forward(request, response);
			break;
			
	
		case "lst":
			ga = new GestionAccesorios();
			ArrayList<Accesorios> listadoC = ga.listadoH();
			
			request.setAttribute("lstAccesorios", listadoC);
			request.getRequestDispatcher("ListadoAccesorios.jsp").forward(request, response);
			break;
		case "buscar":
			codigo = request.getParameter("codigo");
			ga = new GestionAccesorios();
			c = ga.buscar(codigo);
			
			request.setAttribute("c", c);
			request.getRequestDispatcher("MantenimientoAccesorios.jsp").forward(request, response);
			break;
		default:
		}
	}

}
