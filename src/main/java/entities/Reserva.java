package entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Reserva {
	private int id;
	private Vehiculo vehiculo;
	private Date fechaInic;
	private Date fechaFin;
	private LocalDateTime Entregafechr;
	private LocalDateTime Devolucionfechr;
	private Agencia agencia;
	private boolean estado;
	
	Scanner s = null;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public Date getFechaInic() {
		return fechaInic;
	}
	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public LocalDateTime getEntregafechr() {
		return Entregafechr;
	}
	public void setEntregafechr(LocalDateTime entregafechr) {
		Entregafechr = entregafechr;
	}
	public LocalDateTime getDevolucionfechr() {
		return Devolucionfechr;
	}
	public void setDevolucionfechr(LocalDateTime devolucionfechr) {
		Devolucionfechr = devolucionfechr;
	}
	
	
	
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
		
	public void setAuto() {		
		//System.out.println("Elegir uno de los vehiculos mostrados");
		//agencia.mostrarVehiculosPrecios();
		//s = new Scanner(System.in);
		//int id = s.nextInt();
		//devolver el vehiculo buscado de un map
		//Vehiculo vehiculo = agencia.getVehiculobyId(id);
		this.setVehiculo(vehiculo);
	}
	
	
}
