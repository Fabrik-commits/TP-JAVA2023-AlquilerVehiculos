package logic;

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
	
	public void add(Rol rol) {
		rd.add(rol);
	}
	
	public void remove(int id) {
		rd.remove(id);
	}
	
	public void update(Rol rol) {
		rd.update(rol);
	}
	
	public Rol getById(int id) {
		return rd.getById(id);
	}

}
