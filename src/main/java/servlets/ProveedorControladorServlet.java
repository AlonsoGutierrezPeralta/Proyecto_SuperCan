package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionProveedor;
import model.Proveedor;

/**
 * Servlet implementation class ProveedorControladorServlet
 */
@WebServlet(name = "Proveedor", urlPatterns = { "/Proveedor" })
public class ProveedorControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Entro al servlet de proveedor");
		
		//la opcion seleccionada
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		
		//segun la accion seleccionada , realizar...
		switch (accion) {
		  	case "reg": 
			//proceso de registro
		  	//entrada
				String codigo = request.getParameter("txtCodigo");
				String RUC = request.getParameter("txtRUC");
				String Razon = request.getParameter("txtRazon");
				String telefono = request.getParameter("txtTelefono");
				String correo = request.getParameter("txtCorreo");
				String Direccion = request.getParameter("txtDireccion");
				String Departamento = request.getParameter("txtDepartamento");
				String Distrito = request.getParameter("txtDistrito");
				
				//proceso --> grabar el producto en la tabla
				Proveedor r = new Proveedor();
				r.setCodigo(codigo);
				r.setRuc(RUC);
				r.setRazon_social(Razon);
				r.setTelefono(telefono);
				r.setEmail(correo);
				r.setDireccion(Direccion);
				r.setDepartamento(Departamento);
				r.setDistrito(Distrito);

				
				System.out.println(r);
				
				//llama directamente a la clase de implementacion o gestion
				GestionProveedor gr = new GestionProveedor();
				int ok = gr.registrar(r); 
				//se llamara atravez de patron DAO -->
				/*DAOFactory fabrica  = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				int ok = fabrica.getProducDAO().registrar(p);*/
				
				//salida
				if(ok == 0 ) {
					request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
										+ "Error al registrar proveedor" + r.getCodigo() + "!</div>");
				} else {
					request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>"
										+ "proveedor" + r.getRazon_social() + " registrado!</div>");
				}
				
				request.getRequestDispatcher("MantenimientoProveedores.jsp").forward(request, response);
		  		break;
			case "act":
				//proceso de actualizar
				//entrada
				 codigo = request.getParameter("txtCodigo");
				 RUC = request.getParameter("txtRUC");
				 Razon = request.getParameter("txtRazon");
				 telefono = request.getParameter("txtTelefono");
				 correo = request.getParameter("txtCorreo");
				 Direccion = request.getParameter("txtDireccion");
				 Departamento = request.getParameter("txtDepartamento");
				 Distrito = request.getParameter("txtDistrito");
				 //proceso ---> actualizar el producto en su tabla
				 
				 r = new Proveedor();
					r.setCodigo(codigo);
					r.setRuc(RUC);
					r.setRazon_social(Razon);
					r.setTelefono(telefono);
					r.setEmail(correo);
					r.setDireccion(Direccion);
					r.setDepartamento(Departamento);
					r.setDistrito(Distrito);
				
					 gr = new GestionProveedor();
					 ok = gr.registrar(r); 
					
				//salida
					if(ok == 0 ) {
						request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
											+ "Error al Actualizar libro" + r.getCodigo() + "!</div>");
					} else {
						request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>"
											+ "libro" + r.getRazon_social() + " actualizado!</div>");
					}
					System.out.println(codigo + "," + RUC + "," + Razon + "," + telefono + "," + correo + "," + Direccion + "," + Departamento + "," + Distrito);
					
					request.getRequestDispatcher("MantenimientoProveedores.jsp").forward(request, response);
					break;
				
				
			case "eli":
				//proceso de eliminacion
				//entrada
				 codigo = request.getParameter("txtCodigo");
				 //proceso --> eliminar  el producto de la tabla 
				  r = new Proveedor();
				 r.setCodigo(codigo);
				 
				  gr = new GestionProveedor();
					 ok = gr.eliminar(r); 
					
					/* fabrica  = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
					 ok = fabrica.getProducDAO().eliminar(p);*/
					//salida
					if(ok == 0 ) {
						request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>"
											+ "Error al eliminar el  producto" + r.getCodigo() + "!</div>");
					} else {
						request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>"
											+ "proveedor" + r.getCodigo() + " eliminado!</div>");
					}
					
					request.getRequestDispatcher("MantenimientoProveedores.jsp").forward(request, response);
				break;
			case "lst":
				//proceso de listado
				//1.obtener una lista de todos los productos 
				 gr = new GestionProveedor();
				ArrayList<Proveedor> lstProveedor = gr.listado();
				
				/* fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				 ArrayList<Producto> lstProductos = fabrica.getProducDAO().listado(); */
				//2.enviar la lista a la pagina "listado.jsp"
			/*	DAOFactory fabrica  = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				int ok  */
				request.setAttribute("lstProveedor", lstProveedor);
				
				//3.cambiar a la pagina "listado.jsp"
				request.getRequestDispatcher("ListadoProveedor.jsp").forward(request, response);
				
				
			 case "buscar":
				//leer el codigo del producto a buscar --> listado
				   codigo = request.getParameter("codigo");
				   
				  
				 	 gr= new GestionProveedor();
				   r = gr.buscar(codigo); 
				  
				   
				   request.setAttribute("r", r);
				   request.getRequestDispatcher("MantenimientoProveedores.jsp").forward(request, response);
				   break;
				
				
		default :
			//throw new IllegalArgumentException("Unexpected value: "  + accion);
		}
	}

}
