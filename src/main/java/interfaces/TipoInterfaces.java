package interfaces;

import java.util.ArrayList;

import model.TipoAccesorios;
import model.TipoHigiene;
import model.TipoTodo;
import model.tipoAlimentos;

public interface TipoInterfaces {

	public ArrayList<TipoHigiene> listado();
	public ArrayList<TipoAccesorios> listadoTA();
	public ArrayList<tipoAlimentos>ListadoTipoAl();
	public ArrayList<TipoTodo> ListadoTodo();
}
