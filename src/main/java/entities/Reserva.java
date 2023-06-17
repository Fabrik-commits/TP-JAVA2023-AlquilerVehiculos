package entities;

import java.time.LocalDateTime;
import java.util.Date;


public class Reserva {
	private int id;
	private Vehiculo vehiculo;
	private Persona persona;
	private Date fechaInic;
	private Date fechaFin;
	
	private Date fechaCancel;
	private double kmInic;
	private double kmFin;
	private String ReclamoyObs;
	
	private double importe;
	
	private LocalDateTime Entregafechr;
	private LocalDateTime Devolucionfechr;
	private Agencia agencia;
	private boolean estado;
	private int duracionCantDias;

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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
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
	
	
	
	
	public Date getFechaCancel() {
		return fechaCancel;
	}

	public void setFechaCancel(Date fechaCancel) {
		this.fechaCancel = fechaCancel;
	}

	public double getKmInic() {
		return kmInic;
	}

	public void setKmInic(double kmInic) {
		this.kmInic = kmInic;
	}
	
	public double getKmFin() {
		return kmFin;
	}

	public void setKmFin(double kmFin) {
		this.kmFin = kmFin;
	}

	public String getReclamoyObs() {
		return ReclamoyObs;
	}

	public void setReclamoyObs(String reclamoyObs) {
		ReclamoyObs = reclamoyObs;
	}
	
//	public double registraImporte() {
//		return vehiculo.calculaImmporte();
//	}

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

	public void calculaDuracion() {
		int milisecondsByDay = 86400000;
		//duracionCantDias = (int) ((fechaFin.getTime()-fechaInic.getTime()) / milisecondsByDay);
		this.setDuracionCantDias((int) ((fechaFin.getTime()-fechaInic.getTime()) / milisecondsByDay));
	}
		
	
	public int getDuracionCantDias() {
		return duracionCantDias;
	}

	public void setDuracionCantDias(int duracionCantDias) {
		this.duracionCantDias = duracionCantDias;
	}

	
	public void registraImporte() {		
		importe = this.vehiculo.calculaImporte();
		this.setImporte(importe);
	}
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
	

	public void registraVehiculo() {
		this.setVehiculo(vehiculo);
	}
	
	public void buscaVehiculo() {

	}
	
	public void mostrarVehiculosPrecios() {

	}

}
