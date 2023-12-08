package model;

public class Usuario {
	private int  codigoU;
	private String nombre;
	private String apellido;
	private String dni;
	private String usuario;
	private String contraseña;
	private String correo;
	private int codigoTipoUsuario;
	
	
	
	@Override
	public String toString() {
		return "Usuario [codigoU=" + codigoU + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", usuario=" + usuario + ", contraseña=" + contraseña + ", correo=" + correo + ", codigoTipoUsuario="
				+ codigoTipoUsuario + "]";
	}
	
	public int getCodigoU() {
		return codigoU;
	}
	public void setCodigoU(int codigoU) {
		this.codigoU = codigoU;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getCodigoTipoUsuario() {
		return codigoTipoUsuario;
	}
	public void setCodigoTipoUsuario(int codigoTipoUsuario) {
		this.codigoTipoUsuario = codigoTipoUsuario;
	}
	
	
	

}
