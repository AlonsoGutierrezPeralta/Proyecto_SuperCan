package interfaces;

import java.util.ArrayList;

import model.Accesorios;

public interface AccesoriosInterfaces {
	public int registrar(Accesorios c);
	public int actualizar(Accesorios c);
	public int eliminar(Accesorios c);
	public ArrayList<Accesorios> listadoH();
	public Accesorios buscar(String codigoH);
}
