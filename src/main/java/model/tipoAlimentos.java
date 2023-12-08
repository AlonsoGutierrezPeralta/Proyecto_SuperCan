package model;

public class tipoAlimentos {
	private int idAlimento;
	private String descripcion;
	@Override
	public String toString() {
		return "tipoAlimentos [idAlimento=" + idAlimento + ", descripcion=" + descripcion + "]";
	}
	public int getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
