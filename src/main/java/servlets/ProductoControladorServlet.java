package servlets;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mantenimientos.GestionProductos;
import mantenimientos.GestionProveedor;
import mantenimientos.GestionTipo;
import mantenimientos.GestionVentaMySQL;
import model.Accesorios;
import model.Alimentos;
import model.Higiene;
import model.ProductoTipo;
import model.ProductoVenta;
import model.Proveedor;
import model.TipoTodo;
import model.tipoAlimentos;

/**
 * Servlet implementation class ProductoControladorServlet
 */
@WebServlet(name = "productos", urlPatterns = { "/productos" })
public class ProductoControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoControladorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entró al Servlet de producto");
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);

		switch (accion) {
		case "lstA":
			// Proceso de listado
			// 1. Obtener una lista de todos los productos de la clase Gestión
			GestionProductos gp = new GestionProductos();
			ArrayList<Alimentos> lstAlimentos = gp.listadoA();

			// 2. Enviar la lista a la página "listadoA.jsp"
			request.setAttribute("lstAlimentos", lstAlimentos);

			// 3. Cambiar a la página "listadoA.jsp"
			request.getRequestDispatcher("Alimentos.jsp").forward(request, response);
			break;
		case "lstH":
			// Proceso de listado
			// 1. Obtener una lista de todos los productos de la clase Gestión
			gp = new GestionProductos();
			ArrayList<Higiene> lstHigiene = gp.listadoH();

			// 2. Enviar la lista a la página "listadoH.jsp"
			request.setAttribute("lstHigiene", lstHigiene);

			// 3. Cambiar a la página "listadoH.jsp"
			request.getRequestDispatcher("Higiene.jsp").forward(request, response);
		case "lstC":
			// Proceso de listado
			// 1. Obtener una lista de todos los productos de la clase Gestión
			gp = new GestionProductos();
			ArrayList<Accesorios> lstAccesorios = gp.listadoC();

			// 2. Enviar la lista a la página "listadoC.jsp"
			request.setAttribute("lstAccesorios", lstAccesorios);

			// 3. Cambiar a la página "listadoC.jsp"
			request.getRequestDispatcher("Accesorios.jsp").forward(request, response);
			
		case "consultaprod":
			System.out.println("entro al proceso consulta producto");
			String descripcion = request.getParameter("cboTipoTodo");
			
			Alimentos a = new Alimentos();
			Higiene h = new Higiene();
			Accesorios c = new Accesorios();
			
			a.setDescripcion(descripcion);
			h.setDescripcion(descripcion);
			c.setDescripcion(descripcion);
			
			GestionProductos gpr = new GestionProductos();
			ArrayList<ProductoTipo> lstconsultaprod = gpr.ListadoProductoTipo(descripcion);
			request.setAttribute("lstconsultaprod", lstconsultaprod); 
			
			request.getRequestDispatcher("resultadoconsultaprodTipo.jsp").forward(request, response);break;
		case "reporteprod":
			System.out.println("entro al proceso consulta producto");
			String descripcion2 = request.getParameter("cboTipoTodo");
			
			 a = new Alimentos();
			 h = new Higiene();
			c = new Accesorios();
			
			a.setDescripcion(descripcion2);
			h.setDescripcion(descripcion2);
			c.setDescripcion(descripcion2);
			
			GestionVentaMySQL gpr2 = new GestionVentaMySQL();
			ArrayList<ProductoVenta> lstreporteprod = gpr2.ListadoProductoVenta(descripcion2);
			request.setAttribute("lstreporteprod", lstreporteprod);
			
			request.getRequestDispatcher("resultadoReporteVenta.jsp").forward(request, response);
			break;
		case "pdf":
			
			//PASO 1------ asignar nombre al archivo pdf
			String descripcionP = request.getParameter("cboTipoTodo");
			
			ProductoVenta rpv= new ProductoVenta();
			rpv.setCodigo(descripcionP);
			
					//String nombArchivo = "C:\\Users\\USUARIO\\Desktop\\Nueva carpeta\\lpi\\AvanceReporte\\src\\main\\webapp\\WEB-INF\\reportes\\ListarUsuarios.pdf";
					//String nombArchivo = "C:\\\\Users\\\\USUARIO\\\\Desktop\\\\Nueva carpeta\\\\lpi\\\\AvanceReporte\\\\src\\\\main\\\\webapp\\\\WEB-INF\\\\reportes\\\\ListarVentas.pdf";
					String nombArchivo = "D:\\ciclo 4\\Lenguaje de Programacion II\\eclipse EE\\Proyecto_SuperCan\\src\\main\\webapp\\WEB-INF\\reportes\\ListarVentas.pdf";
					try {
						//paso 2 crear plantilla
						Document plantilla = new Document();
						//paso 3 crear el archivo
						FileOutputStream fos = new FileOutputStream(nombArchivo);
						//paso 4 relacioanr la plantilla con el archivo pdf creado
						PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);
						//paso 5 abrir el documento a modo de escritura
						plantilla.open();
						
						//agregar titulo --- párrado
						Paragraph p = new Paragraph("Reporte Venta",FontFactory.getFont
													("arial",22,Font.BOLD,BaseColor.BLUE));
						p.setAlignment(Chunk.ALIGN_CENTER);
						plantilla.add(p);
						//agregar espacio
						p= new Paragraph(" ");
						plantilla.add(p);
						
						//llamar al proceso
						GestionVentaMySQL gus = new GestionVentaMySQL();
						ArrayList<ProductoVenta> lstReporte = gus.ListadoProductoVenta(descripcionP);
						//validar el resultado
						if(lstReporte.size() == 0) {
							p = new Paragraph("Lista Vacia",FontFactory.getFont("arial",14,Font.ITALIC,BaseColor.RED));
							plantilla.add(p);
						}else {
							//crear tabla
							PdfPTable tabla = new PdfPTable(5);
							//encabezado de la tabla --> agregar las columnas
							tabla.addCell("Código");
							tabla.addCell("Descripcion");
							tabla.addCell("Precio");
							tabla.addCell("Cantidad");
							tabla.addCell("Tipo");
							//recorrido
							
							for (ProductoVenta us : lstReporte) {
								tabla.addCell(us.getCodigo()+ " ");
								tabla.addCell(us.getDescripcion()+ " ");
								tabla.addCell(us.getPrecio()+ " ");
								tabla.addCell(us.getCantidad()+ " ");
								tabla.addCell(us.getDescripcionT()+ " ");
							}
							plantilla.add(tabla);
						}
						//cerrar el documento :v
						plantilla.close();
						
						//mostrar el archivo pdf :o
						Desktop.getDesktop().open(new File(nombArchivo));
						
					} catch (Exception e) {
						System.out.println("Error al generar reporte " + e.getMessage());
					}
					break;
	
		}
		
	}

}
