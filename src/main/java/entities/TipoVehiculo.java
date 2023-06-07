package entities;

public class TipoVehiculo {
	private int idTipoVehiculo;
	private String descripcion;
	private double senia;
	private double importe;
	private Reserva reserva;

	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double calculaSenia(Vehiculo vehiculo) {
		return senia = vehiculo.getPrecioporKm()*50;
	}

	public double calculaPrecio(Vehiculo vehiculo) {
		importe = vehiculo.getPrecioporKm()*(reserva.getKmFin()-reserva.getKmInic());
		if (importe == senia) {
        	importe = 0;
		} else {
			importe = importe - senia;
		}
		return importe;
	}

	public double calculaPrecio(Vehiculo vehiculo, int cantPasajeros) {
		importe = vehiculo.getPrecioporKm()*(reserva.getKmFin()-reserva.getKmInic())*cantPasajeros;
		if (importe == senia) {
        	importe = 0;
		} else {
			importe = importe - senia;
		}
		return importe;
	}

	public double calculaPrecio(Vehiculo vehiculo, double tonelaje) {
		importe = vehiculo.getPrecioporKm()*(reserva.getKmFin()-reserva.getKmInic())*tonelaje;
		if (importe == senia) {
        	importe = 0;
		} else {
			importe = importe - senia;
		}
		return importe;
	}
}
