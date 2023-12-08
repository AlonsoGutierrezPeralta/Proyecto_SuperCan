package model;

public class Proveedor {
	private String codigo;
	private String ruc;
	private String 	razon_social;
	private String telefono;
	private String 	email;
	private String 	direccion;
	private String 	departamento;
	private String 	distrito;
	
	
	



	@Override
	public String toString() {
		return "Proveedor [codigo=" + codigo + ", ruc=" + ruc + ", razonSocial=" + razon_social + ", telefono="
				+ telefono + ", email=" + email + ", direccion=" + direccion + ", departamento=" + departamento
				+ ", distrito=" + distrito + "]";
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
	

}
