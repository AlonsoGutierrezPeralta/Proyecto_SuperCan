package model;

public class TipoAccesorios {
		private int idAccesorio;
		private String descripcion;
		
		
		
		@Override
		public String toString() {
			return "TipoAccesorios [idAccesorio=" + idAccesorio + ", descripcion=" + descripcion + "]";
		}
		
		
		public int getIdAccesorio() {
			return idAccesorio;
		}
		public void setIdAccesorio(int idAccesorio) {
			this.idAccesorio = idAccesorio;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
		
}
