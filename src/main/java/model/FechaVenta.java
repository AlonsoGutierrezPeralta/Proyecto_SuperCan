package model;

public class FechaVenta {
	private String descripcion;
	private double precio;
	private int cantidad;
	private String Tipo;
	private String fch_bol;
	
	
	
	@Override
	public String toString() {
		return "FechaVenta [descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", Tipo="
				+ Tipo + ", fch_bol=" + fch_bol + "]";
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
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getFch_bol() {
		return fch_bol;
	}
	public void setFch_bol(String fch_bol) {
		this.fch_bol = fch_bol;
	}
	
	
}
