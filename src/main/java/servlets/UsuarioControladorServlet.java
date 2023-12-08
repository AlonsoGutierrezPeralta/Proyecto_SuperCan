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

import DAO.DAOFactory;
import mantenimientos.GestionUsuarioMySQL;
import model.TipoUsuario;
import model.Usuario;

/**
 * Servlet implementation class UsuarioControladorServlet
 */
@WebServlet(name = "usuario", urlPatterns = { "/usuario" })
public class UsuarioControladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControladorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al Servlet de Usuario");
		//la opcion seleccionada
		String accion = request.getParameter("btnAccion");
		System.out.println("Accion: " + accion);
		// segun la accion seleccionada, ralizar.....
		switch (accion) {
	case "reg": 
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String dni = request.getParameter("txtDni");
		String usuario = request.getParameter("txtUsuario");
		String contraseña =  request.getParameter("txtContraseña");
		String correo = request.getParameter("txtCorreo");
		int codigoTipoUsuario =  Integer.parseInt(request.getParameter("cboTipo"));
		
		// proceso grabar el producto
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setDni(dni);
		u.setUsuario(usuario);
		u.setContraseña(contraseña);
		u.setCorreo(correo); 
		u.setCodigoTipoUsuario(codigoTipoUsuario);
		System.out.println(u);
		
		//GestionProductoMySQL gp = new GestionProductoMySQL();
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);			
		int ok = fabrica.getUsuarioDAO().registrar(u);
		
		//SALIDA
		if (ok == 0) {
			request.setAttribute("mensaje","<div class='alert alert-danger' role ='alert'>"
					+ "Error al registrar!</div>");
		}else {
			request.setAttribute("mensaje","<div class='alert alert-success' role ='alert'>"
					+ "Usuario Registrado!</div>");
		}
		request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
	break;	
	
	case "rep":
		
		int codiL = Integer.parseInt(request.getParameter("cboTipo"));
	
		TipoUsuario t= new TipoUsuario();
		t.setCodigoTipoUsuario(codiL);
		
		// Proceso de listado
		// 1. Obtener una lista de todos los productos de la clase Gestión
		GestionUsuarioMySQL gu = new GestionUsuarioMySQL();
		ArrayList<Usuario> lstUsuario = gu.listarReporteUsuarioXTipo(codiL);

		// 2. Enviar la lista a la página "listadoA.jsp"
		request.setAttribute("lstUsuario", lstUsuario);

		// 3. Cambiar a la página "listadoA.jsp"
		request.getRequestDispatcher("resultadoReporte.jsp").forward(request, response);
		break;
		
	case "imp":
		
		//PASO 1------ asignar nombre al archivo pdf
		int codi = Integer.parseInt(request.getParameter("cboTipo"));
		
		TipoUsuario tp= new TipoUsuario();
		tp.setCodigoTipoUsuario(codi);
		
				//String nombArchivo = "C:\\Users\\USUARIO\\Desktop\\Nueva carpeta\\lpi\\AvanceReporte\\src\\main\\webapp\\WEB-INF\\reportes\\ListarUsuarios.pdf";
				String nombArchivo = "D:\\ciclo 4\\Lenguaje de Programacion II\\eclipse EE\\Proyecto_SuperCan\\src\\main\\webapp\\WEB-INF\\reportes\\ListarUsuarios.pdf";
				try {
					//paso 2 crear plantilla
					Document plantilla = new Document();
					//paso 3 crear el archivo
					FileOutputStream fos = new FileOutputStream(nombArchivo);
					//paso 4 relacioanr la plantilla con el archivo pdf creado
					PdfWriter pdfWr = PdfWriter.getInstance(plantilla, fos);
					//paso 5 abrir el documento a modo de escritura
					plantilla.open();
					
					//agregar un logo
					//Image img = new Image.getInstance("src/img/logociberfarma.png");
					//plantilla.add(img);
					
					//agregar titulo --- párrado
					Paragraph p = new Paragraph("Listado Usuario",FontFactory.getFont
												("arial",22,Font.BOLD,BaseColor.BLUE));
					p.setAlignment(Chunk.ALIGN_CENTER);
					plantilla.add(p);
					//agregar espacio
					p= new Paragraph(" ");
					plantilla.add(p);
					
					//llamar al proceso
					GestionUsuarioMySQL gus = new GestionUsuarioMySQL();
					ArrayList<Usuario> lstUsuarios = gus.listarReporteUsuarioXTipo(codi);
					//validar el resultado
					if(lstUsuarios.size() == 0) {
						p = new Paragraph("Lista Vacia",FontFactory.getFont("arial",14,Font.ITALIC,BaseColor.RED));
						plantilla.add(p);
					}else {
						//crear tabla
						PdfPTable tabla = new PdfPTable(4);
						//encabezado de la tabla --> agregar las columnas
						tabla.addCell("Código");
						tabla.addCell("Nombre");
						tabla.addCell("Apellido");
						tabla.addCell("Usuario");
						
						//recorrido
						
						for (Usuario us : lstUsuarios) {
							tabla.addCell(us.getCodigoU()+ " ");
							tabla.addCell(us.getNombre()+ " ");
							tabla.addCell(us.getApellido()+ " ");
							tabla.addCell(us.getUsuario()+ " ");
			
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
