package logic;

import java.util.LinkedList;

import data.TipoVehiculoData;
import entities.Persona;
import entities.TipoVehiculo;

public class TipoVehiculoLogic {
	
private TipoVehiculoData tvd;
	
	public TipoVehiculoLogic() {
		
		tvd = new TipoVehiculoData();
	}
	
	public LinkedList<TipoVehiculo> getAllTiposVehiculo(){
		
		return tvd.getAll();
	}
	
	public TipoVehiculo getById(int id) {
		
		return tvd.getById(id);
		
	}
	
	public void add(TipoVehiculo tipov) {
		tvd.add(tipov);
	}
	
	public void remove(int id) {
		tvd.remove(id);
	}
	
	public TipoVehiculo update(TipoVehiculo tv) {
		return tvd.update(tv);
	}

}
