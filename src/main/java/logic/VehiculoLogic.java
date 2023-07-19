package logic;

import java.util.LinkedList;

import data.VehiculoData;
import entities.Vehiculo;

public class VehiculoLogic {
	
	private VehiculoData vehicd ;
	
	public VehiculoLogic() {
		vehicd = new VehiculoData();
	}
	
	public LinkedList<Vehiculo> getAll() {
		return vehicd.getAll();
	}
	
}
