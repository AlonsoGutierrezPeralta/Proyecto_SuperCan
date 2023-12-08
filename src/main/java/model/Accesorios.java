package model;

public class Accesorios {
	private String codigoA;
	private String marca;
	private Double precio;
	private int idAccesorio;
	private int stock;
	private String descripcion;
	
	
	
	@Override
	public String toString() {
		return "Accesorios [codigoA=" + codigoA + ", marca=" + marca + ", precio=" + precio + ", idAccesorio="
				+ idAccesorio + ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}
	public String getCodigoA() {
		return codigoA;
	}
	public void setCodigoA(String codigoA) {
		this.codigoA = codigoA;
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
	public int getIdAccesorio() {
		return idAccesorio;
	}
	public void setIdAccesorio(int idAccesorio) {
		this.idAccesorio = idAccesorio;
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
