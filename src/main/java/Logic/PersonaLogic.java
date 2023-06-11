package Logic;

import java.util.LinkedList;

import data.PersonaData;
import data.RolData;
import entities.Persona;
import entities.Rol;

public class PersonaLogic {
	private PersonaData pd;
	private RolData rd;
	
	public PersonaLogic() {
		pd = new PersonaData();
		rd = new RolData();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return pd.getByUser(p);
	}
	
	public LinkedList<Persona> getAll(){
		return pd.getAll();
	}		

//	public Persona getByDocumento(Persona per) {
//		return pd.getByDocumento(per);
//		
//	}
	
	public LinkedList<Persona> getAllByApellido(Persona per){
		return pd.getAllByApellido(per);
	}
	
	public void add(Persona per) {
		pd.add(per);
	}
	
	public void update(Persona p ) {
		pd.update(p);
	}
	
	public void remove(Persona p ) {
		pd.remove(p);
	}
	
	public LinkedList<Rol> getAllRoles(){
		return rd.getAll();
	}
	
	public Rol getByDesc(Rol rolToSearch) {
		return rd.getByDesc(rolToSearch);
	}
}
