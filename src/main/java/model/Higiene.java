package model;

public class Higiene {
	private String codigoH;
	private String marca;
	private Double precio;
	private int idHigiene;
	private int stock;
	private String descripcion;
	
	
	
	@Override
	public String toString() {
		return "Higiene [codigoH=" + codigoH + ", marca=" + marca + ", precio=" + precio + ", idHigiene=" + idHigiene
				+ ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}
	
	
	public String getCodigoH() {
		return codigoH;
	}
	public void setCodigoH(String codigoH) {
		this.codigoH = codigoH;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getIdHigiene() {
		return idHigiene;
	}
	public void setIdHigiene(int idHigiene) {
		this.idHigiene = idHigiene;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
