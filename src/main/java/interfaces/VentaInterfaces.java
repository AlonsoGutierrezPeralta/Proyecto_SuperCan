package interfaces;

import java.util.ArrayList;

import model.CabeceraBoleta;
import model.DetalleBoleta;
import model.FechaVenta;
import model.ProductoVenta;

public interface VentaInterfaces {
	public String generaNumboleta();
	public int realizarVentaAlimento(CabeceraBoleta cab, ArrayList<DetalleBoleta> det);
	public int realizarVentaHigiene(CabeceraBoleta cab, ArrayList<DetalleBoleta> det);
	public int realizarVentaAccesorio(CabeceraBoleta cab, ArrayList<DetalleBoleta> det);
	public ArrayList<FechaVenta> listadoFechaVenta(String fch_bol);
	public ArrayList<ProductoVenta> ListadoProductoVenta(String descripcionT);

}
