package entities;

import java.util.HashMap;

public class Agencia {
	
	private int id;
	private String empresaSucursal;
	private String direccion;
	private String telefono;
	private String email;
	public HashMap<Integer, Vehiculo> vehiculos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpresaSucursal() {
		return empresaSucursal;
	}
	public void setEmpresaSucursal(String empresaSucursal) {
		this.empresaSucursal = empresaSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	public Agencia() {
		this.vehiculos=new HashMap<>();
	}
	
	public void addVehiculo(Vehiculo vehiculoToBeAdded) {
		this.vehiculos.put(vehiculoToBeAdded.getIdVehiculo(), vehiculoToBeAdded);
	}
	
	public void removeVehiculo(Vehiculo vehiculoToBeRemoved) {
		this.vehiculos.remove(vehiculoToBeRemoved.getIdVehiculo());
	}

		
	
	public Vehiculo getVehiculobyId(int id) {
		System.out.println("El vehiculo buscado es: " + id + "y su estado es: ");
		Vehiculo vehiculo = new Vehiculo();
		return vehiculo;
	}
	
	public void mostrarVehiculosPrecios() {
		System.out.println("Los vehiculos son: y sus precios son: , ");
	}
	
	public void mostrarReservasentreFechas() {
		System.out.println("Los vehiculos reservados son: ");
	}
	
	

}
