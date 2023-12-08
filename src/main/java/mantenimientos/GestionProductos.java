package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductosInterfaces;
import model.Accesorios;
import model.Alimentos;
import model.FechaVenta;
import model.Higiene;
import model.ProductoTipo;
import model.TipoTodo;
import utils.MySQLConexion;

public class GestionProductos implements ProductosInterfaces{

	@Override
	public ArrayList<Alimentos> listadoA() {
		ArrayList<Alimentos> lista = new ArrayList<Alimentos>(); // null
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_alimento";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila
				Alimentos a = new Alimentos();

				a.setCodigoAL(rs.getString(1));
				a.setMarca(rs.getString(2));
				a.setPrecio(rs.getDouble(3));
				a.setPeso(rs.getDouble(4));
				a.setEtapaVida(rs.getString(5));
				a.setIdAlimento(rs.getInt(6));
				a.setStock(rs.getInt(7));
				a.setDescripcion(rs.getString(8));
				lista.add(a);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<Higiene> listadoH() {
		ArrayList<Higiene> lista = new ArrayList<Higiene>(); // null
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_higiene;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila
				Higiene h = new Higiene();

				h.setCodigoH(rs.getString(1));
				h.setMarca(rs.getString(2));
				h.setPrecio(rs.getDouble(3));
				h.setIdHigiene(rs.getInt(4));
				h.setStock(rs.getInt(5));
				h.setDescripcion(rs.getString(6));
				lista.add(h);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<Accesorios> listadoC() {
		ArrayList<Accesorios> lista = new ArrayList<Accesorios>(); // null
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_accesorios";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila

				Accesorios c = new Accesorios();

				c.setCodigoA(rs.getString(1));
				c.setMarca(rs.getString(2));
				c.setPrecio(rs.getDouble(3));				
	     		c.setIdAccesorio(rs.getInt(4));
				c.setStock(rs.getInt(5));
				c.setDescripcion(rs.getString(6));
				lista.add(c);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<ProductoTipo> ListadoProductoTipo(String descripcionT) {
		
		ArrayList<ProductoTipo> lista = new ArrayList<ProductoTipo>();
		// Plantilla de BD
				TipoTodo td = null;
				Connection con = null;
				PreparedStatement pstm = null;
				ResultSet res = null;
				try {
					con = MySQLConexion.getConexion();
					String sql = "{call consulta_producto(?)}";
					pstm = con.prepareStatement(sql);
					//paso 4 : parametros --
					pstm.setString(1, descripcionT);
					//paso 5 : ejecutar la instrucciï¿½n 
					 res = pstm.executeQuery();
					 //paso 6 : bucle para realizar el recorrido  al objeto "res"
					 while(res.next()) {
						 //crear un objeto de tipo "reporteTipoUsuario"
						 ProductoTipo  pt= new ProductoTipo();
						 //setear (asignar valores del objeto "res" a los atributos privados)
						 
						 pt.setDescripcion(res.getString(1));
						 pt.setPrecio(res.getDouble(2));
						 pt.setCantidad(res.getInt(3));
						 pt.setDescripcionT(res.getString(4));
						
					
						 
						 //aï¿½adir el objeto "user" al arreglo
						 lista.add(pt);	 
					 }
									
				} catch (Exception e) {
					System.out.println(">>>>>>>>>>>> Error en la Instruccion SQL - Consultar" + e.getMessage());
				}finally {
					try {
						if(pstm != null ) pstm.close();
						if(res != null) res.close();
						if(con != null) con.close();
						
					} catch (SQLException e2) {
						System.out.println("<<<< Error al cerrar la base de datos "+ e2.getMessage());
					}
				}
				return lista;
	}

}
