package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.ProveedoresInterfaces;

import model.Proveedor;
import utils.MySQLConexion;

public class GestionProveedor implements ProveedoresInterfaces {

	@Override
	public int registrar(Proveedor pr) {
		int rs = 0; // valor x default en caso de error 
		//plantilla de BD 
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_proveedor values (?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, pr.getCodigo());
			pst.setString(2, pr.getRuc());
			pst.setString(3, pr.getRazon_social());
			pst.setString(4, pr.getTelefono());
			pst.setString(5, pr.getEmail());
			pst.setString(6, pr.getDireccion());
			pst.setString(7, pr.getDepartamento());
			pst.setString(8, pr.getDistrito());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en el registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(Proveedor pr) {
		int rs = 0; // valor x default en caso de error 
		//plantilla de BD 
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update libros set ruc = ? , razon_social = ? , telefono = ?,email = ?, direccion = ? where codigo = ?";
			pst = con.prepareStatement(sql);
			
			
			pst.setString(1, pr.getRuc());
			pst.setString(2, pr.getRazon_social());
			pst.setString(3, pr.getTelefono());
			pst.setString(4, pr.getEmail());
			pst.setString(5, pr.getDireccion());
			pst.setString(6, pr.getDepartamento());
			pst.setString(7, pr.getDistrito());
			pst.setString(8, pr.getCodigo());
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en Actualizar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int eliminar(Proveedor pr) {
		int rs = 0;
		// plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "delete from tb_proveedor where codigo=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, pr.getCodigo());
			
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en eliminar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<Proveedor> listado() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>(); //null
		// plantilla de BD!
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_proveedor";
			pst = con.prepareStatement(sql);
		
			rs = pst.executeQuery();
			
			// pasar el contenido del "rs" a la variable
			while(rs.next()) { //lee el contenido de cada fila
				Proveedor pr = new Proveedor();
				pr.setCodigo(rs.getString(1));
				pr.setRuc(rs.getString(2));
				pr.setRazon_social(rs.getString(3));
				pr.setTelefono(rs.getString(4));
				pr.setEmail(rs.getString(5));
				pr.setDireccion(rs.getString(6));
				pr.setDepartamento(rs.getString(7));
				pr.setDistrito(rs.getString(8));
	
				lista.add(pr);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		return lista;
	}

	@Override
	public Proveedor buscar(String codigoProv) {
		Proveedor 	pr= null;
		// plantilla
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_proveedor where codigo= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigoProv);
			rs = pst.executeQuery();
			
			// pasar el contenido del "rs" a la variable
			while(rs.next()) { //lee el contenido de cada fila
				 pr = new Proveedor();
					pr.setCodigo(rs.getString(1));
					pr.setRuc(rs.getString(2));
					pr.setRazon_social(rs.getString(3));
					pr.setTelefono(rs.getString(4));
					pr.setEmail(rs.getString(5));
					pr.setDireccion(rs.getString(6));
					pr.setDepartamento(rs.getString(7));
					pr.setDistrito(rs.getString(8));
				
			}
		} catch (Exception e) {
			System.out.println("Error en buscar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		return pr;
	}

}
