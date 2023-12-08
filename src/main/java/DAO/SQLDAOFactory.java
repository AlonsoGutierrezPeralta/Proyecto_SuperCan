package DAO;

import interfaces.AlimentosInterfacesDAO;
import interfaces.TipoInterfaces;
import interfaces.UsuarioInterfaces;
import interfaces.VentaInterfaces;
import mantenimientos.GestionUsuarioSQLServer;


public class SQLDAOFactory  extends DAOFactory{

	@Override
	public UsuarioInterfaces getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionUsuarioSQLServer();
	}

	@Override
	public AlimentosInterfacesDAO getAlimentosDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoInterfaces getTipoAlimentosDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VentaInterfaces getVentaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
