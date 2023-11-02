package logic;

import java.util.LinkedList;

import data.AlquilerData;
import entities.Alquiler;

public class AlquilerLogic {
	private AlquilerData alqd;
	
	public AlquilerLogic() {
		alqd = new AlquilerData();
	}

	public void add(Alquiler alq) {
		alqd.add(alq);
	}
	
	public LinkedList<Alquiler> getAllByALquileresxClte(int id) {
		return alqd.getAllByALquileresxClte(id);
	}
	
	public Alquiler getById(int id) {
		return alqd.getById(id);
	} 
}
