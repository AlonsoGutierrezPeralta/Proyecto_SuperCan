package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.HigieneInterfaces;
import model.Higiene;
import utils.MySQLConexion;

public class GestionHigiene implements HigieneInterfaces{

	@Override
	public int registrar(Higiene h) {
		int rs = 0; // Valor x default en caso de error
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_higiene values (?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, h.getCodigoH());
			pst.setString(2, h.getMarca());
			pst.setDouble(3, h.getPrecio());
			pst.setInt(4, h.getIdHigiene());
			pst.setInt(5, h.getStock());
			pst.setString(6, h.getDescripcion());
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en registrar:" +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(Higiene h) {
		int rs = 0; // Valor x default en caso de error
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update tb_higiene set marca=?,precio=?,idHigiene=?,stock=?,descripcion=? where codigoH=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, h.getMarca());
			pst.setDouble(2, h.getPrecio());
			pst.setInt(3, h.getIdHigiene());
			pst.setInt(4, h.getStock());
			pst.setString(5, h.getDescripcion());
			pst.setString(6, h.getCodigoH());
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al actualizar:" +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int eliminar(Higiene h) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "delete from tb_higiene where codigoH = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, h.getCodigoH());

			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en eliminar:" +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
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
			String sql = "select * from tb_higiene";
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
	public Higiene buscar(String codigoH) {
		Higiene h = null;
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_higiene where codigoH = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigoH);
			rs = pst.executeQuery();
			
			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { 
				h = new Higiene();
				h.setCodigoH(rs.getString(1));
				h.setMarca(rs.getString(2));
				h.setPrecio(rs.getDouble(3));
				h.setIdHigiene(rs.getInt(4));
				h.setStock(rs.getInt(5));
				h.setDescripcion(rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println("Error en buscar: " +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return h;
	}
	
}
