package interfaces;

import java.util.ArrayList;

import model.Proveedor;

public interface ProveedoresInterfaces {
	public int registrar(Proveedor pr);
	   public int actualizar(Proveedor pr);
	   public int eliminar(Proveedor pr);
	   public ArrayList<Proveedor> listado( );
	   public Proveedor buscar (String codigoProv);
}
