package model;

public class ProductoVenta {

	private String codigo;
	private String descripcion;
	private double precio;
	private int cantidad;
	private String descripcionT;
	@Override
	public String toString() {
		return "ProductoVenta [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad="
				+ cantidad + ", descripcionT=" + descripcionT + "]";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcionT() {
		return descripcionT;
	}
	public void setDescripcionT(String descripcionT) {
		this.descripcionT = descripcionT;
	}
	
	
	
}
