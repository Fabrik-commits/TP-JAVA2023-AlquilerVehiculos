package logic;

import java.util.LinkedList;

import data.VehiculoData;
import entities.TipoVehiculo;
import entities.Vehiculo;

public class VehiculoLogic {
	
	private VehiculoData vehicd ;
	
	public VehiculoLogic() {
		vehicd = new VehiculoData();
	}
	
	public LinkedList<Vehiculo> getAll() {
		return vehicd.getAll();
	}
	
	public Vehiculo getById(int id) {
		return vehicd.getById(id);
	}
	
	public Vehiculo update(Vehiculo vehic) {
		return vehicd.update(vehic);
	}
	
	public  void add(Vehiculo vehic) {
		vehicd.add(vehic);
	}
	
	public void remove(int id) {
		vehicd.remove(id);
	}
	
}
