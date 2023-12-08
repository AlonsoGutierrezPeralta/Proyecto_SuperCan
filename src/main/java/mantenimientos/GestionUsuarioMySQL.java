package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterfaces;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuarioMySQL implements UsuarioInterfaces{

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
		int rs = 0; // Valor x default en caso de error
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_usuario values (null,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getDni());
			pst.setString(4, u.getUsuario());
			pst.setString(5, u.getContraseña());
			pst.setString(6, u.getCorreo());
			pst.setInt(7, u.getCodigoTipoUsuario());
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en registrar:" +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<Usuario> listarReporteUsuarioXTipo(int codigoTipoUsuario) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();//null
		Usuario repUser;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			//paso 1: Establecer la conexiï¿½n a la base de datos
			con = MySQLConexion.getConexion();
			//Paso 2 : determinar la instrucciï¿½n SQL --> Consultar
			String sql = "select * from supercan.tb_usuario where codigoTipoUsuario = ?";
			//paso 3: enviar la instrucciï¿½n al objeto pstm -- comandos SQL
			pstm = con.prepareStatement(sql);
			//paso 4 : parametros --
			pstm.setInt(1, codigoTipoUsuario);
			//paso 5 : ejecutar la instrucciï¿½n 
			 res = pstm.executeQuery();
			 //paso 6 : bucle para realizar el recorrido  al objeto "res"
			 while(res.next()) {
				 //crear un objeto de tipo "reporteTipoUsuario"
				 repUser = new Usuario();
				 //setear (asignar valores del objeto "res" a los atributos privados)
				 repUser.setCodigoU(res.getInt(1));
				 repUser.setNombre(res.getString(2));
				 repUser.setApellido(res.getString(3));
				 repUser.setDni(res.getString(4));
				 repUser.setUsuario(res.getString(5));
				 repUser.setContraseña(res.getString(6));
				 repUser.setCorreo(res.getString(7));
				 repUser.setCodigoTipoUsuario(res.getInt(8));
				 
				 //aï¿½adir el objeto "user" al arreglo
				 lista.add(repUser);	 
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
