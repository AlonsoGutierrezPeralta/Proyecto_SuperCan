package interfaces;

import java.util.ArrayList;

import model.Accesorios;
import model.Alimentos;
import model.Higiene;
import model.ProductoTipo;

public interface ProductosInterfaces {

		public ArrayList<Alimentos> listadoA();
		public ArrayList<Higiene> listadoH();
		public ArrayList<Accesorios> listadoC();
		public ArrayList<ProductoTipo> ListadoProductoTipo(String descripcionT);
}
