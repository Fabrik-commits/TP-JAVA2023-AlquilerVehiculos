package entities;

import java.util.HashMap;

public class Persona {
	
	private int id;
	private String nroDni;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private String tel;
	private boolean habilitado;
	public HashMap<Integer, Rol> roles;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNroDni() {
		return nroDni;
	}
	public void setNroDni(String nroDni) {
		this.nroDni = nroDni;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public HashMap<Integer, Rol> getRoles() {
		return roles;
	}
//	public void setRoles(HashMap<Integer, Rol> roles) {
//		this.roles = roles;
//	}
	
	public Persona() {
		this.roles=new HashMap<>();
	}
	
	public void addRol(Rol rolToBeAdded) {
		this.roles.put(rolToBeAdded.getId(), rolToBeAdded);
	}
	
	public void removeRol(Rol rolToBeRemoved) {
		this.roles.remove(rolToBeRemoved.getId());
	}
	
	public boolean hasRol(Rol rolToCheck) {
		return this.roles.containsKey(rolToCheck.getId());
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nro de Dni=" + nroDni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", password=" + password + ", tel=" + tel + ", habilitado=" + habilitado
				+ ", roles=" + roles + "]";
	}
	public void removeRolesPer() {
		this.roles.clear();
		
	}
	
}
