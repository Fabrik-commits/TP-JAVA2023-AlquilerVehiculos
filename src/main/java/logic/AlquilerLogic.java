package logic;

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
}
