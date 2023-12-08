package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOFactory;


import mantenimientos.GestionProductos;
import model.Alimentos;

/**
 * Servlet implementation class AlimentosControladorServlet
 */
@WebServlet(name = "MantenimientoAlimentos", description = "controlador de mantenimiento", urlPatterns = { "/MantenimientoAlimentos" })
public class AlimentosControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentosControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al Servlet de alimentos");
		//la opcion seleccionada
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		// segun la accion seleccionada, ralizar.....
		switch (accion) {
	case "reg": 
		String codigoAL = request.getParameter("txtCodigo");
		String descripcion = request.getParameter("txtDescripcion");
		String marca = request.getParameter("txtMarca");
		double peso = Double.parseDouble(request.getParameter("txtPeso"));
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		int stock =  Integer.parseInt(request.getParameter("txtStock"));
		String etapaVida = request.getParameter("txtEtapa");
		int tipo =  Integer.parseInt(request.getParameter("cboTipo"));
		
		// proceso grabar el producto
		Alimentos p = new Alimentos();
		p.setCodigoAL(codigoAL);
		p.setDescripcion(descripcion);
		p.setMarca(marca);
		p.setPeso(peso);
		p.setPrecio(precio);
		p.setStock(stock);
		p.setIdAlimento(tipo); 
		p.setEtapaVida(etapaVida);
		System.out.println(p);
		
		//GestionProductoMySQL gp = new GestionProductoMySQL();
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);			
		int ok = fabrica.getAlimentosDAO().registrar(p);
		
		//SALIDA
		if (ok == 0) {
			request.setAttribute("mensaje","<div class='alert alert-danger' role ='alert'>"
					+ "Error al registrar!</div>");
		}else {
			request.setAttribute("mensaje","<div class='alert alert-success' role ='alert'>"
					+ "Producto Registrado!</div>");
		}
		request.getRequestDispatcher("MantenimientoAlimentos.jsp").forward(request, response);
	break;	
case "act": 
	//proceso de actualizar
	String codigo = request.getParameter("txtCodigo");
	String des= request.getParameter("txtDescripcion");
	String marc = request.getParameter("txtMarca");
	double pes = Double.parseDouble(request.getParameter("txtPeso"));
	double preci = Double.parseDouble(request.getParameter("txtPrecio"));
	int stoc=  Integer.parseInt(request.getParameter("txtStock"));
	String etapa= request.getParameter("txtEtapa");
	int tip =  Integer.parseInt(request.getParameter("cboTipo"));
		// proceso grabar el producto
		Alimentos p1 = new Alimentos();
		p1.setCodigoAL(codigo);
		p1.setDescripcion(des);
		p1.setMarca(marc);
		p1.setPeso(pes);
		p1.setPrecio(preci);
		p1.setStock(stoc);
		p1.setEtapaVida(etapa);
		p1.setIdAlimento(tip); 
		
		System.out.println(p1);
		
		//SIN DAO GestionProductoMySQL gProd = new GestionProductoMySQL();	
		fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ok = fabrica.getAlimentosDAO().actualizar(p1);
		
		//SALIDA
		if (ok == 0) {
			request.setAttribute("mensaje","<div class='alert alert-danger' role ='alert'>"
					+ "Error al actualizar!</div>");
		}else {
			request.setAttribute("mensaje","<div class='alert alert-success' role ='alert'>"
					+ "Producto Actualizado!</div>");
		}
		request.getRequestDispatcher("MantenimientoAlimentos.jsp").forward(request, response);
		break;			
case "eli": 
		 codigo = request.getParameter("txtCodigo");
		// proceso para eliminar el producto
		p1 = new Alimentos();
		p1.setCodigoAL(codigo);
	    fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ok = fabrica.getAlimentosDAO().eliminar(p1);
		
		//salida
		if (ok == 0) {
			request.setAttribute("mensaje","<div class='alert alert-danger' role ='alert'>"
					+ "Error al Eliminar!</div>");
		}else {
			request.setAttribute("mensaje","<div class='alert alert-success' role ='alert'>"
					+ "Producto Eliminado!</div>");
		}
		request.getRequestDispatcher("MantenimientoAlimentos.jsp").forward(request, response);
	break;
case "lstA":
	// Proceso de listado
	// 1. Obtener una lista de todos los productos de la clase Gestión
	GestionProductos gp = new GestionProductos();
	ArrayList<Alimentos> lstAlimentos = gp.listadoA();

	// 2. Enviar la lista a la página "listadoA.jsp"
	request.setAttribute("lstAlimentos", lstAlimentos);

	// 3. Cambiar a la página "listadoA.jsp"
	request.getRequestDispatcher("ListadoAlimentos.jsp").forward(request, response);
	break;
	
	
case "buscar":
	//leer el codigo del producto q viene del  listado
	
	 codigoAL = request.getParameter("codigoAL");
	 //fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL)
	  fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	 p =  fabrica.getAlimentosDAO().buscar(codigoAL);
	 //enviar la informacion encontrada a la pagina crudproductos
	 request.setAttribute("p", p);
	 request.getRequestDispatcher("MantenimientoAlimentos.jsp").forward(request, response);
	break;


	}
	}

}
