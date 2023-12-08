package DAO;

import interfaces.AlimentosInterfacesDAO;
import interfaces.TipoInterfaces;
import interfaces.UsuarioInterfaces;
import interfaces.VentaInterfaces;
import mantenimientos.GestionAlimentos;
import mantenimientos.GestionTipo;
import mantenimientos.GestionUsuarioMySQL;
import mantenimientos.GestionVentaMySQL;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public UsuarioInterfaces getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new GestionUsuarioMySQL();
	}

	@Override
	public AlimentosInterfacesDAO getAlimentosDAO() {
		// TODO Auto-generated method stub
		return new GestionAlimentos();
	}

	@Override
	public TipoInterfaces getTipoAlimentosDAO() {
		// TODO Auto-generated method stub
		return new GestionTipo();
	}

	@Override
	public VentaInterfaces getVentaDAO() {
		// TODO Auto-generated method stub
		return new GestionVentaMySQL();
	}

}
