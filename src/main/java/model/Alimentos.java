package model;

public class Alimentos {
	private String codigoAL;
	private String marca;
	private double precio;
	private double peso;
	private String etapaVida;
	private int idAlimento;
	private int stock;
	private String descripcion;
	
	
	
	@Override
	public String toString() {
		return "Alimentos [codigoAL=" + codigoAL + ", marca=" + marca + ", precio=" + precio + ", peso=" + peso
				+ ", etapaVida=" + etapaVida + " , idAlimento=" + idAlimento + ", stock=" + stock
				+ ", descripcion=" + descripcion + "]";
	}
	public String getCodigoAL() {
		return codigoAL;
	}
	public void setCodigoAL(String codigoAL) {
		this.codigoAL = codigoAL;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getEtapaVida() {
		return etapaVida;
	}
	public void setEtapaVida(String etapaVida) {
		this.etapaVida = etapaVida;
	}

	
	public int getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
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

