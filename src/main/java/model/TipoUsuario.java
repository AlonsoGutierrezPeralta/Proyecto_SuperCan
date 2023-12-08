package model;

public class TipoUsuario {
	private int CodigoTipoUsuario;
	private String descripcion;
	
	
	
	@Override
	public String toString() {
		return "TipoUsuario [CodigoTipoUsuario=" + CodigoTipoUsuario + ", descripcion=" + descripcion
				+ "]";
	}
	
	public int getCodigoTipoUsuario() {
		return CodigoTipoUsuario;
	}
	public void setCodigoTipoUsuario(int codigoTipoUsuario) {
		CodigoTipoUsuario = codigoTipoUsuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
