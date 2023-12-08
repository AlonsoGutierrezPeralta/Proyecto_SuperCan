package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.AlimentosInterfacesDAO;
import model.Alimentos;

import utils.MySQLConexion;

public class GestionAlimentos implements AlimentosInterfacesDAO {

	@Override
	public int registrar(Alimentos a) {
		int rs = 0; //valor x default en caso de error
		Connection con = null;
		PreparedStatement pstm= null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="insert into supercan.tb_alimento values (?,?,?,?,?,?,?,?);";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getCodigoAL());
			pstm.setString(2, a.getMarca());
			pstm.setDouble(3, a.getPrecio());
			pstm.setDouble(4, a.getPeso());
			pstm.setString(5, a.getEtapaVida());
			pstm.setInt(6, a.getIdAlimento());
			pstm.setInt(7, a.getStock());
			pstm.setString(8, a.getDescripcion());
			
			rs = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Registar" + e.getMessage());
		}
		return rs;
	}

	@Override
	public int actualizar(Alimentos a) {
		int rest = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="update supercan.tb_alimento set marca = ?, precio = ?, peso = ?, etapa_vida = ?, idAlimento = ?, stock = ?, descripcion = ?  where codigoAl = ?";
			pstm = con.prepareStatement(sql);
			//PASO 4: PARAMETROS
			pstm.setString(1, a.getMarca());
			pstm.setDouble(2, a.getPrecio());
			pstm.setDouble(3, a.getPeso());
			pstm.setString(4, a.getEtapaVida());
			pstm.setInt(5, a.getIdAlimento());
			pstm.setInt(6, a.getStock());
			pstm.setString(7, a.getDescripcion());
			pstm.setString(8, a.getCodigoAL());
			//PASO 5: EJECUTAR LA INSTRUCCION
			rest = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Actualizar" + e.getMessage());
		}finally {
			try{
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			}catch (SQLException e2) {
				System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
			}
			
		}
		return rest;
	}

	@Override
	public int eliminar(Alimentos a) {
		int rest = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql ="delete from supercan.tb_alimento where codigoAl = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getCodigoAL());
			
			rest = pstm.executeUpdate();
		}catch (Exception e){
			System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Eliminar" + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		return rest;
	}

	@Override
	public Alimentos buscar(String codigo) {
		Alimentos a = null;
		//plantilla
		PreparedStatement pstm = null; 
		 Connection con = null;
		 ResultSet res = null;
		 try {
				//PASO 1: ESTABLECER LA CONEXION A LA BD
				con = MySQLConexion.getConexion();
				//PASO 2: DETERMINAR LA INSTRUCCION SQL -->CONSULTAR
				String sql ="select * from supercan.tb_alimento where codigoAL = ?";
				//PASO 3: enviar la instrucion al objeto pstm --> ob tner los comandos sql
				pstm = con.prepareStatement(sql);
				pstm.setString(1, codigo);
				res = pstm.executeQuery();
				//paso 6: bucle para realizar el recorrido al objeto res
				while(res.next()) {
					//crear un objeto de tipo usuario
					a = new Alimentos();
					a.setCodigoAL(res.getString(1));
					a.setMarca(res.getString(2));
					a.setPrecio(res.getInt(3));
					a.setPeso(res.getDouble(4));
					a.setEtapaVida(res.getString(5));
					a.setIdAlimento(res.getInt(6));
					a.setStock(res.getInt(7));
					a.setDescripcion(res.getString(8));
				}
			}catch (Exception e){
				System.out.println(">>>>> ERROR EN LA INSTRUCCION SQL - Buscar" + e.getMessage());
			}finally {
				try{
					if(pstm != null) pstm.close();
					if(pstm != null) pstm.close();
					if(res != null) res.close();
				}catch (SQLException e2) {
					System.out.println(">>>>> ERROR AL CERRAR LA BD" + e2.getMessage());			
				}
				
			}
		return a ;
	}

	@Override
	public ArrayList<Alimentos> listadoA() {
		ArrayList<Alimentos> lista = new ArrayList<Alimentos>(); // null
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM supercan.tb_alimento";
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

}
