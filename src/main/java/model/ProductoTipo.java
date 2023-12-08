package model;

public class ProductoTipo {
	private String descripcion;
	private double precio;
	private int cantidad;
	private String descripcionT;
	
	
	
	@Override
	public String toString() {
		return "ProductoTipo [descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", descripcionT=" + descripcionT + "]";
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
