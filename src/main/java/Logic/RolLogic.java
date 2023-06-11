package Logic;

import java.util.LinkedList;

import data.RolData;
import entities.Rol;

public class RolLogic {
	
	private RolData rd;
	
	public RolLogic() {
		
		rd = new RolData();
	}
	
	public LinkedList<Rol> getAllRoles(){
		
		return rd.getAll();
	}
			
	public Rol getByDesc(Rol rolToSearch) {
		return rd.getByDesc(rolToSearch);
	}

}
