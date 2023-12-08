package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOFactory;
import mantenimientos.GestionVentaMySQL;
import model.Accesorios;
import model.Alimentos;
import model.CabeceraBoleta;
import model.DetalleBoleta;
import model.FechaVenta;
import model.Higiene;
import model.Usuario;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet(name = "Venta", urlPatterns = { "/Venta" })
public class VentaProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso al servidor venta de productos");
		
		String opcion = request.getParameter("opcion");
		switch(opcion) {
		case "agregarAl" : agregarCompraAlimentos(request,response); break;
		case "agregarH" : agregarCompraHigiene(request,response); break;
		case "agregarA" : agregarCompraAccesorio(request,response); break;
		case "eliminar" : elimnarCompra(request,response); break;
		case "finalizar" : 	finalizarCompra(request,response); break;
		case "consultaFch": consultafechaVenta(request,response); 
				
		
		default:
		}
	}



	private void consultafechaVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entro al proceso de ventas por fecha");
		
		String fecha = request.getParameter("txtFecha");
		CabeceraBoleta cb = new CabeceraBoleta();
		cb.setFch_bol(fecha);
		
		GestionVentaMySQL gv = new GestionVentaMySQL();
		ArrayList<FechaVenta> lstVentaFecha = gv.listadoFechaVenta(fecha);
		request.setAttribute("lstVentaFecha", lstVentaFecha);
		
		request.getRequestDispatcher("resultadoConsultaFchVenta.jsp").forward(request, response);
		
		
	}

	private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entro al proceso de finalizar compra");
		
		
		
		
		
			CabeceraBoleta cb = new CabeceraBoleta();
			/*---------*/
			Usuario u = (Usuario) request.getSession().getAttribute("u");
			if (u == null) {
				
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
						+ "Para finalizar la compra, debe ingresar a su cuenta!</div>");
				request.getRequestDispatcher("LogIn.jsp").forward(request, response);
				return;
			}
			cb.setCod_cliente(u.getCodigoU());
			ArrayList<DetalleBoleta> carro = (ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			int ok = fabrica.getVentaDAO().realizarVentaAlimento(cb, carro);
			if(ok == 0) {
				// no se completo el proceso de venta
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>\"\r\n"
						+ "					+ \"Error al procesar la venta de alimentos,verifique o actualize los productos!</div>");
				request.getRequestDispatcher("carritoCompras.jsp").forward(request, response); 
				
			}else {
				request.setAttribute("mensaje", " <div class=\"alert alert-success\" role=\"alert\">\r\n"
						+ "  venta realizada exitosamente!\r\n"
						+ "</div>  ");
				request.getRequestDispatcher("carritoCompras.jsp").forward(request, response);
				
				
				request.getSession().setAttribute("carro", new ArrayList<DetalleBoleta>());
				request.getSession().setAttribute("subTotalVenta", 0.0);
				request.getSession().setAttribute("cantArticulos", 0); 
				
			} 

	}

	private void elimnarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("entro al proceso eliminar compra");
		// leer el código de producto a eliminar
		String codigo = request.getParameter("codigo");
		// buscar el producto y eliminarlo del carro, actualizar los montos
		ArrayList<DetalleBoleta> carro = (ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		for (DetalleBoleta d : carro) {
			if (d.getIdProd().equals(codigo)) {
				// actualizamos
				cantArticulos -= d.getCantidad();
			subTotalVenta -= d.getImporte();
				carro.remove(d);
				break;
			}
		}
		// actualizamos las variables a nivel de sesión -> como atributos
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		// redirecciona a una página -->> se lanza el Exception
		response.sendRedirect("carritoCompras.jsp");
	}

	private void agregarCompraAccesorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//leer los datos del producto seleccionados para "agregarlo " al carro de compras
		int cantidad = 	Integer.parseInt(request.getParameter("cantidad"));
		//la informacion del producto enviado como atributo de sesion --> objetos
		Accesorios c = (Accesorios) request.getSession().getAttribute("c");
		//agregar al carro  de compra el producto seleccionado  y su cantidad
		DetalleBoleta d = new DetalleBoleta();
		d.setIdProd(c.getCodigoA());
		d.setNomProd(c.getDescripcion());
		d.setPrecioVta(c.getPrecio());
		d.setCantidad(cantidad);
		d.setImporte(d.getCantidad() * d.getPrecioVta());
		//obtiene las variables del carro a nivel de sesion
		ArrayList<DetalleBoleta> carro =(ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		//agregar/ actualizamos
		carro.add(d);
		subTotalVenta += d.getImporte();
		cantArticulos += d.getCantidad();
		//actualizamos las variables a nivel de sesion --> como atributos
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		//redirecciona a una pagina -->	se lanza el exception
		response.sendRedirect("carritoCompras.jsp");
		
		System.out.println(c);
		System.out.println(cantidad);
	}

	private void agregarCompraHigiene(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cantidad = 	Integer.parseInt(request.getParameter("cantidad"));
		Higiene h = (Higiene) request.getSession().getAttribute("h");
		
		DetalleBoleta d = new DetalleBoleta();
		d.setIdProd(h.getCodigoH());
		d.setNomProd(h.getDescripcion());
		d.setPrecioVta(h.getPrecio());
		d.setCantidad(cantidad);
		d.setImporte(d.getCantidad() * d.getPrecioVta());
		
		ArrayList<DetalleBoleta> carro =(ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		
		carro.add(d);
		subTotalVenta += d.getImporte();
		cantArticulos += d.getCantidad();
		
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		
		response.sendRedirect("carritoCompras.jsp");
		
		System.out.println(h);
		System.out.println(cantidad);
	}

	private void agregarCompraAlimentos(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		int cantidad = 	Integer.parseInt(request.getParameter("cantidad"));
		Alimentos a = (Alimentos) request.getSession().getAttribute("a");
		
		DetalleBoleta d = new DetalleBoleta();
		d.setIdProd(a.getCodigoAL());
		d.setNomProd(a.getDescripcion());
		d.setPrecioVta(a.getPrecio());
		d.setCantidad(cantidad);
		d.setImporte(d.getCantidad() * d.getPrecioVta());
		
		ArrayList<DetalleBoleta> carro =(ArrayList<DetalleBoleta>) request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		
		carro.add(d);
		subTotalVenta += d.getImporte();
		cantArticulos += d.getCantidad();
		
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
	
		response.sendRedirect("carritoCompras.jsp");
		
		System.out.println(a);
		System.out.println(cantidad);
	}

}
