package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentaInterfaces;
import model.Alimentos;
import model.CabeceraBoleta;
import model.DetalleBoleta;
import model.FechaVenta;
import model.ProductoVenta;
import model.TipoTodo;
import model.Usuario;
import utils.MySQLConexion;

public class GestionVentaMySQL implements VentaInterfaces {

	@Override
	public String generaNumboleta() {
String codigo = "B0001";  // valor del cÃ³digo x default, cuando no hay datos
		
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select substr(max(NUM_BOL),2) from tb_cab_boleta";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				codigo = String.format("B%04d", rs.getInt(1) + 1);
			}
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return codigo;
	}

	@Override
	public int realizarVentaAlimento(CabeceraBoleta cab, ArrayList<DetalleBoleta> det) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
	
		
		try {
			con = MySQLConexion.getConexion();

			con.setAutoCommit(false);
			System.out.println(cab);
			cab.setNum_bol(generaNumboleta());
			System.out.println(cab);
			String sql1 = "insert into tb_cab_boleta values (?,curdate(),?)";
			pst1 = con.prepareStatement(sql1);
			pst1.setString(1, cab.getNum_bol());
			pst1.setInt(2, cab.getCod_cliente());
			rs = pst1.executeUpdate();
			String sql2 = "REPLACE INTO `supercan`.`tb_det_boleta` (`num_bol`, `codigoAL`, `cantidad`, `preciovta`) VALUES (?, ?, ?, ?)";
			String sql3 = "update tb_alimento set stock = stock - ? where codigoAL = ?";
			
			
			

			for (DetalleBoleta d : det) {
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, cab.getNum_bol()); // mismo dato de la cabecera
				pst2.setString(2, d.getIdProd());
				pst2.setInt(3, d.getCantidad());
				pst2.setDouble(4, d.getPrecioVta());
				rs += pst2.executeUpdate();

				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, d.getCantidad());
				pst3.setString(2, d.getCodigoAL());

				rs += pst3.executeUpdate();
				
				
	
				
			}

			con.commit();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int realizarVentaHigiene(CabeceraBoleta cab, ArrayList<DetalleBoleta> det) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		
		try {
			con = MySQLConexion.getConexion();

			con.setAutoCommit(false);
			System.out.println(cab);
			cab.setNum_bol(generaNumboleta());
			System.out.println(cab);
			String sql1 = "insert into tb_cab_boleta values (?,curdate(),?)";
			pst1 = con.prepareStatement(sql1);
			pst1.setString(1, cab.getNum_bol());
			pst1.setInt(2, cab.getCod_cliente());
			rs = pst1.executeUpdate();
			String sql2 = "REPLACE  INTO `supercan`.`tb_det_boleta` (`num_bol`, `codigoH`, `cantidad`, `preciovta`) VALUES (?, ?, ?, ?)";
			String sql3 = "update tb_higiene set stock = stock - ? where codigoH = ?";
			
			

			for (DetalleBoleta d : det) {
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, cab.getNum_bol()); // mismo dato de la cabecera
				pst2.setString(2, d.getIdProd());
				pst2.setInt(3, d.getCantidad());
				pst2.setDouble(4, d.getPrecioVta());
				rs += pst2.executeUpdate();

				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, d.getCantidad());
				pst3.setString(2, d.getCodigoH());

				rs += pst3.executeUpdate();
				
			
			}

			con.commit();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int realizarVentaAccesorio(CabeceraBoleta cab, ArrayList<DetalleBoleta> det) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		
		try {
			con = MySQLConexion.getConexion();

			con.setAutoCommit(false);
			System.out.println(cab);
			cab.setNum_bol(generaNumboleta());
			System.out.println(cab);
			String sql1 = "insert into tb_cab_boleta values (?,curdate(),?)";
			pst1 = con.prepareStatement(sql1);
			pst1.setString(1, cab.getNum_bol());
			pst1.setInt(2, cab.getCod_cliente());
			rs = pst1.executeUpdate();
			String sql2 = "REPLACE  INTO `supercan`.`tb_det_boleta` (`num_bol`, `codigoA`, `cantidad`, `preciovta`) VALUES (?, ?, ?, ?)";
			String sql3 = "update tb_accesorios set stock = stock - ? where codigoA = ?";
			
			

			for (DetalleBoleta d : det) {
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, cab.getNum_bol()); // mismo dato de la cabecera
				pst2.setString(2, d.getIdProd());
				pst2.setInt(3, d.getCantidad());
				pst2.setDouble(4, d.getPrecioVta());
				rs += pst2.executeUpdate();

				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, d.getCantidad());
				pst3.setString(2, d.getCodigoA());

				rs += pst3.executeUpdate();
				
			
			}

			con.commit();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<FechaVenta> listadoFechaVenta(String fch_bol) {
		ArrayList<FechaVenta> lista = new ArrayList<FechaVenta>();
		
		
		// Plantilla de BD
		FechaVenta f = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{CALL consulta_fecha (?)}";
			pstm = con.prepareStatement(sql);
			//paso 4 : parametros --
			pstm.setString(1, fch_bol);
			//paso 5 : ejecutar la instrucciï¿½n 
			 res = pstm.executeQuery();
			 //paso 6 : bucle para realizar el recorrido  al objeto "res"
			 while(res.next()) {
				 //crear un objeto de tipo "reporteTipoUsuario"
				 f = new FechaVenta();
				 //setear (asignar valores del objeto "res" a los atributos privados)
				 f.setDescripcion(res.getString(1));
				 f.setPrecio(res.getDouble(2));
				 f.setCantidad(res.getInt(3));
				 f.setTipo(res.getString(4));
				 f.setFch_bol(res.getString(5));
			
				 
				 //aï¿½adir el objeto "user" al arreglo
				 lista.add(f);	 
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

	@Override
	public ArrayList<ProductoVenta> ListadoProductoVenta(String descripcionT) {
		ArrayList<ProductoVenta> lista = new ArrayList<ProductoVenta>();
		// Plantilla de BD
				TipoTodo td = null;
				Connection con = null;
				PreparedStatement pstm = null;
				ResultSet res = null;
				try {
					con = MySQLConexion.getConexion();
					String sql = "{call reporte_ventas(?)}";
					pstm = con.prepareStatement(sql);
					//paso 4 : parametros --
					pstm.setString(1, descripcionT);
					//paso 5 : ejecutar la instrucciï¿½n 
					 res = pstm.executeQuery();
					 //paso 6 : bucle para realizar el recorrido  al objeto "res"
					 while(res.next()) {
						 //crear un objeto de tipo "reporteTipoUsuario"
						 ProductoVenta  pv= new ProductoVenta();
						 //setear (asignar valores del objeto "res" a los atributos privados)
						 pv.setCodigo(res.getString(1));
						 pv.setDescripcion(res.getString(2));
						 pv.setPrecio(res.getDouble(3));
						 pv.setCantidad(res.getInt(4));
						 pv.setDescripcionT(res.getString(5));
						
					
						 
						 //aï¿½adir el objeto "user" al arreglo
						 lista.add(pv);	 
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
