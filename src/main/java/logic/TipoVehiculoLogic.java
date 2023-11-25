package logic;

import java.util.LinkedList;

import data.TipoVehiculoData;
//import entities.Persona;
import entities.TipoVehiculo;
import entities.Vehiculo;

public class TipoVehiculoLogic {
	
private TipoVehiculoData tvd;
	
	public TipoVehiculoLogic() {
		
		tvd = new TipoVehiculoData();
	}
	
	public LinkedList<TipoVehiculo> getAllTiposVehiculo(){
		
		return tvd.getAll();
	}
	
	public LinkedList<Vehiculo> getAllVehiculosporTipo(int id){
		
		return tvd.getAllVehiculosporTipo(id);
		
	}
	//
	public LinkedList<Vehiculo> getAllVehiculosDispPorTipo(int id){
		
		return tvd.getAllVehiculosDispPorTipo(id);
		
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
	
	public TipoVehiculo getTipodelVehic(int id) {
		return tvd.getTipodelVehic(id);
	}

}
