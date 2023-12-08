package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.TipoInterfaces;
import model.TipoAccesorios;
import model.TipoHigiene;
import model.TipoTodo;
import model.tipoAlimentos;
import utils.MySQLConexion;

public class GestionTipo implements TipoInterfaces{

	@Override
	public ArrayList<TipoHigiene> listado() {
		ArrayList<TipoHigiene> lista = new ArrayList<TipoHigiene>();
		// Plantilla de BD!!!!! (Copy/paste)
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_tipohigiene";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila
				TipoHigiene th = new TipoHigiene();
				th.setIdHigiene(rs.getInt(1));
				th.setDescripcion(rs.getString(2));
				lista.add(th);
				
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<TipoAccesorios> listadoTA() {
		ArrayList<TipoAccesorios> lista = new ArrayList<TipoAccesorios>();
		// Plantilla de BD!!!!! (Copy/paste)
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_tipoaccesorio";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila
				TipoAccesorios ta = new TipoAccesorios();
				ta.setIdAccesorio(rs.getInt(1));
				ta.setDescripcion(rs.getString(2));
				lista.add(ta);
				
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<tipoAlimentos> ListadoTipoAl() {
		ArrayList<tipoAlimentos> lista = new ArrayList<tipoAlimentos>(); // null
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM supercan.tb_tipoalimento";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila
				tipoAlimentos a = new tipoAlimentos();

				a.setIdAlimento(rs.getInt(1));
				a.setDescripcion(rs.getString(2));
				
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
	public ArrayList<TipoTodo> ListadoTodo() {
		ArrayList<TipoTodo> lista = new ArrayList<TipoTodo>();
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{CALL cargar_cbo()}";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila
				TipoTodo t = new TipoTodo();
				
				t.setDescripcionT(rs.getString(1));
				
				
				lista.add(t);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

}
