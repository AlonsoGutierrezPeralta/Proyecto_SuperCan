package DAO;

import interfaces.AlimentosInterfacesDAO;
import interfaces.TipoInterfaces;
import interfaces.UsuarioInterfaces;
import interfaces.VentaInterfaces;

public abstract class DAOFactory {
	  public static final int MYSQL = 1;
	  public static final int SQL= 2;
	  
	  
	  public abstract UsuarioInterfaces getUsuarioDAO();
	  public abstract AlimentosInterfacesDAO getAlimentosDAO();
	  public abstract TipoInterfaces getTipoAlimentosDAO();
	  public abstract VentaInterfaces getVentaDAO();
	  
	  
	  public static DAOFactory getDAOFactory(int qdb) {
			switch (qdb) {
			case MYSQL:
				return new MySQLDAOFactory();
			case SQL:
				return new SQLDAOFactory();
				default:
					return null;
			}
			
		}
}
