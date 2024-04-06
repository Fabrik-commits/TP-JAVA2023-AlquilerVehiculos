package util;

public class Valida {

	public static boolean isAlpha(String s) {		
		return s.matches("^[A-Za-z]*$");
	}
	
	public static boolean isRealPositivo(String realPosit) {
		return realPosit.matches("^[0-9]+([\\.,][0-9]+)?$");
	}
	
	public static boolean isDni(String dni) {
		return dni.matches("^[1-9]\\d{7}$");
	}
	
	public static boolean isMarcaModelo(String marcaModelo) {  
		return marcaModelo.matches("^[A-Za-z0-9\\s]+$");
	}
	
	public static boolean isMatricula(String matricula) {
		return matricula.matches("^[A-Z0-9]*$");
	}
	
	public static boolean isMail(String email) {
		return email.matches("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$");
	}
	
	public static boolean isAnio(String anio) {
		return anio.matches("^20[2-9]|[0-9]");
	}
		
	public static boolean isEntero(String pasajeros) {
		return pasajeros.matches("^[0-9]*$");
	}
	
	public static boolean isDireccion(String pasajeros) {
		return pasajeros.matches("^[A-Za-z0-9\\s]+$");
	}
	
	public static boolean isPassword(String password) {
		return password.matches(password);
	}
	
}
