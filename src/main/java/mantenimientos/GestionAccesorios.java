package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.AccesoriosInterfaces;
import model.Accesorios;

import utils.MySQLConexion;

public class GestionAccesorios implements AccesoriosInterfaces {

	@Override
	public int registrar(Accesorios c) {
		int rs = 0; // Valor x default en caso de error
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_accesorios values (?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, c.getCodigoA());
			pst.setString(2, c.getMarca());
			pst.setDouble(3, c.getPrecio());
			pst.setInt(4, c.getIdAccesorio());
			pst.setInt(5, c.getStock());
			pst.setString(6, c.getDescripcion());
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en registrar:" +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(Accesorios c) {
		int rs = 0; // Valor x default en caso de error
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update tb_accesorios set marca=?,precio=?,idAccesorio=?,stock=?,descripcion=? where codigoA=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, c.getMarca());
			pst.setDouble(2, c.getPrecio());
			pst.setInt(3, c.getIdAccesorio());
			pst.setInt(4, c.getStock());
			pst.setString(5, c.getDescripcion());
			pst.setString(6, c.getCodigoA());
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al actualizar:" +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int eliminar(Accesorios c) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "delete from tb_accesorios where codigoA = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, c.getCodigoA());

			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en eliminar:" +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<Accesorios> listadoH() {
		ArrayList<Accesorios> lista = new ArrayList<Accesorios>(); // null
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_accesorios";
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
	public Accesorios buscar(String codigoH) {
		Accesorios c = null;
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_accesorios where codigoA = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigoH);
			rs = pst.executeQuery();
			
			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { 
				c = new Accesorios();
				c.setCodigoA(rs.getString(1));
				c.setMarca(rs.getString(2));
				c.setPrecio(rs.getDouble(3));
				c.setIdAccesorio(rs.getInt(4));
				c.setStock(rs.getInt(5));
				c.setDescripcion(rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println("Error en buscar: " +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return c;
	}

}
