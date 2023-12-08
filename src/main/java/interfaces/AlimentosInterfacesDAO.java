package interfaces;

import java.util.ArrayList;

import model.Alimentos;

public interface AlimentosInterfacesDAO {
	public int registrar(Alimentos a);
	public int actualizar(Alimentos a);
	public int eliminar(Alimentos a);
	public Alimentos buscar(String codigoAl);
	public ArrayList<Alimentos> listadoA();
}
