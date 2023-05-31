package entities;

public class Vehiculo {

	private int idVehiculo;
	private double preciopordia;
	private String marca;
	private String color;
	private boolean estado;
	private int ano;
	private String matricula;
			
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public double getPreciopordia() {
		return preciopordia;
	}
	public void setPreciopordia(double preciopordia) {
		this.preciopordia = preciopordia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
//	public void CalculaPrecio() {
//		
//	}
	
}
