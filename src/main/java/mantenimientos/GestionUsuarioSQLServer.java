package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.UsuarioInterfaces;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuarioSQLServer implements UsuarioInterfaces{

	@Override
	public Usuario validarAcceso(String usuario, String contraseña) {
		Usuario u = null;
		//plantilla --> busqueda
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_validaAcceso(?,?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, contraseña);
			rs = pst.executeQuery();
			
			// pasar el contenido del "rs" a la variable
			while(rs.next()) { //lee el contenido de cada fila
				 u = new Usuario();
				u.setCodigoU(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setDni(rs.getString(4));
				u.setUsuario(rs.getString(5));
				u.setContraseña(rs.getString(6));
				u.setCorreo(rs.getString(7));
				u.setCodigoTipoUsuario(rs.getInt(8));
				
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		System.out.println(u);
		return u;
	}

	@Override
	public int registrar(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Usuario> listarReporteUsuarioXTipo(int codigoTipoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
