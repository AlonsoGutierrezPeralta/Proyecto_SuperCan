package interfaces;

import java.util.ArrayList;

import model.Higiene;

public interface HigieneInterfaces {

	public int registrar(Higiene h);
	public int actualizar(Higiene h);
	public int eliminar(Higiene h);
	public ArrayList<Higiene> listadoH();
	public Higiene buscar(String codigoH);
	
}
