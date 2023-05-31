package entities;

public class Principal {

	public static void main(String[] args) {

			Agencia agencia = new Agencia();
			Vehiculo vehiculoToBeAdded = new VehiculoPasajerosCoche();
			//datos de vehiculo
			agencia.addVehiculo(vehiculoToBeAdded);

	}

}
