package entities;

public class Rol {
	private int id;
	private String descripcion;
	//private boolean habilitado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
//	public boolean isHabilitado() {
//		return habilitado;
//	}
//	public void setHabilitado(boolean habilitado) {
//		this.habilitado = habilitado;
//	}
	
	
	@Override
	public String toString() {
		return "Rol [id=" + id + ", descripcion=" + descripcion + "]";
	}
}
