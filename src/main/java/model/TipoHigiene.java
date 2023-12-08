package model;

public class TipoHigiene {
	
	private int idHigiene;
	private String descripcion;
	
	@Override
	public String toString() {
		return "TipoHigiene [idHigiene=" + idHigiene + ", descripcion=" + descripcion + "]";
	}
	
	
	public int getIdHigiene() {
		return idHigiene;
	}
	public void setIdHigiene(int idHigiene) {
		this.idHigiene = idHigiene;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
