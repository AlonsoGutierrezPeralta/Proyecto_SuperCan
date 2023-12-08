package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.TipoUsuarioInterfaces;

import model.TipoUsuario;
import utils.MySQLConexion;

public class GestionTipoUsuario implements TipoUsuarioInterfaces{

	@Override
	public ArrayList<TipoUsuario> ListadoTipoU() {
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		// Plantilla de BD!!!!! (Copy/paste)
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_tipousuario";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			// Pasar el contenido del "rs" a la variable
			while (rs.next()) { // Lee el contenido de cada fila
				TipoUsuario tu = new TipoUsuario();
				tu.setCodigoTipoUsuario(rs.getInt(1));
				tu.setDescripcion(rs.getString(2));
				lista.add(tu);
				
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " +e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

}
