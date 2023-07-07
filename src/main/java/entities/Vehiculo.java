package entities;

public class Vehiculo {

	private int idVehiculo;
	private double precioporKm;
	private String marcayModelo;
	private String color;
	private boolean estado;
	private int anio;
	private String matricula;
	private TipoVehiculo tipoVehiculo;
	
	private int cantPasajeros;
	private double capacidadMax;
			
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public double getPrecioporKm() {
		return precioporKm;
	}
	public void setPrecioporKm(double precioporKm) {
		this.precioporKm = precioporKm;
	}
	public String getMarcayModelo() {
		return marcayModelo;
	}
	public void setMarcayModelo(String marcayModelo) {
		this.marcayModelo = marcayModelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	
	public int getCantPasajeros() {
		return cantPasajeros;
	}
	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}
	public double getCapacidadMax() {
		return capacidadMax;
	}
	public void setCapacidadMax(double capacidadMax) {
		this.capacidadMax = capacidadMax;
	}
	
//	public double calculaImporte() {
//		// CalculaPrecio(sobrecargado)
//		double importe = 0;
//		if (tipoVehiculo.getDescripcion() == "auto") {
//			importe = tipoVehiculo.calculaPrecio(this);
//		}
//		if (tipoVehiculo.getDescripcion() == "microbus") {
//			importe = tipoVehiculo.calculaPrecio(this, cantPasajeros);
//		}
//		if (tipoVehiculo.getDescripcion() == "camion" || tipoVehiculo.getDescripcion() == "utilitario") {
//			importe = tipoVehiculo.calculaPrecio(this, capacidadMax);
//		}
//		return importe;
//	}
			
}
