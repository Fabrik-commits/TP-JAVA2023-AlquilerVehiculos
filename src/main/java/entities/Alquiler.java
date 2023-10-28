package entities;

import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;


public class Alquiler {
	public static final String ESTADO_PENDIENTE="Pendiente";
	public static final String ESTADO_VIGENTE="Vigente";
	public static final String ESTADO_FINALIZADO="Finalizado";
	public static final String ESTADO_CANCELADO="Cancelado";
	
	private int id;
	private Vehiculo vehiculo;
	private Persona persona;
	private LocalDate fechaInic;
	private LocalDate fechaFin;
	
	private LocalDate fechaCancel;
	private double kmInic;
	private double kmFin;
	private String ReclamoyObs;
	
	private double importe;
	
	private LocalDate fechaEntrega;
	//private LocalDate fechaDevolucion;
	//private LocalDate Entregafechr;
	//private LocalDate Devolucionfechr;
	//private Agencia agencia;
	//private boolean estado;
	private double senia;
	private int duracionCantDias;
	
	private String estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		//Alquiler.ESTADO_CANCELADO=="Pendiente";
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

	public LocalDate getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(LocalDate fechaInic) {
		this.fechaInic = fechaInic;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
			
	public LocalDate getFechaCancel() {
		return fechaCancel;
	}

	public void setFechaCancel(LocalDate fechaCancel) {
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

//	public LocalDate getEntregafechr() {
//		return Entregafechr;
//	}
//	
//	public void setEntregafechr(LocalDate entregafechr) {
//		Entregafechr = entregafechr;
//	}
//
//	public LocalDate getDevolucionfechr() {
//		return Devolucionfechr;
//	}
//
//	public void setDevolucionfechr(LocalDate devolucionfechr) {
//		Devolucionfechr = devolucionfechr;
//	}
	
	

//	public Agencia getAgencia() {
//		return agencia;
//	}
//
//	public void setAgencia(Agencia agencia) {
//		this.agencia = agencia;
//	}

//	public boolean isEstado() {
//		return estado;
//	}
//
//	public void setEstado(boolean estado) {
//		this.estado = estado;
//	}

	public double getSenia() {
		return senia;
	}

	public void setSenia(double senia) {
		this.senia = senia;
	}

	public void calculaDuracion() {
		int milisecondsByDay = 86400000;
		//duracionCantDias = (int) ((fechaFin.getTime()-fechaInic.getTime()) / milisecondsByDay);
		this.setDuracionCantDias((int) ((fechaFin.getDayOfYear()-fechaInic.getDayOfYear()) / milisecondsByDay));
	}
	
	public int calculaDuracAlquiler() {
		int milisecondsByDay = 86400000;
		return (int) ((fechaFin.getDayOfYear()-fechaInic.getDayOfYear()) / milisecondsByDay);
	}
			
	public int getDuracionCantDias() {
		return duracionCantDias;
	}

	public void setDuracionCantDias(int duracionCantDias) {
		this.duracionCantDias = duracionCantDias;
	}
	
//	public void registraImporte() {		
//		importe = this.vehiculo.calculaImporte();
//		this.setImporte(importe);
//	}
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
		
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

//	public LocalDate getFechaDevolucion() {
//		return fechaDevolucion;
//	}
//
//	public void setFechaDevolucion(LocalDate fechaDevolucion) {
//		this.fechaDevolucion = fechaDevolucion;
//	}

	public void registraVehiculo() {
		this.setVehiculo(vehiculo);
	}
	
	public void buscaVehiculo() {

	}
	
	public void mostrarVehiculosPrecios() {

	}
	
	public void calculaImporte() {
		this.setImporte(this.getDuracionCantDias()*vehiculo.getPrecio()/(365*4));
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
