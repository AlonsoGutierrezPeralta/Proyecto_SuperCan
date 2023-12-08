package model;

public class DetalleBoleta {

	private String idProd;
	private double precioVta;
	private int cantidad;
	private String nomProd;
	private double importe;
	private String codigoAL;
	private String codigoH;
	private String codigoA;
	
	
	

	
	
	@Override
	public String toString() {
		return "DetalleBoleta [idProd=" + idProd + ", precioVta=" + precioVta + ", cantidad=" + cantidad + ", nomProd="
				+ nomProd + ", importe=" + importe + ", codigoAL=" + codigoAL + ", codigoH=" + codigoH + ", codigoA="
				+ codigoA + "]";
	}


	public String getCodigoAL() {
		return codigoAL;
	}


	public void setCodigoAL(String codigoAL) {
		this.codigoAL = codigoAL;
	}


	public String getCodigoH() {
		return codigoH;
	}


	public void setCodigoH(String codigoH) {
		this.codigoH = codigoH;
	}


	public String getCodigoA() {
		return codigoA;
	}


	public void setCodigoA(String codigoA) {
		this.codigoA = codigoA;
	}


	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public double getPrecioVta() {
		return precioVta;
	}
	public void setPrecioVta(double precioVta) {
		this.precioVta = precioVta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	} 
	
	
	
}
