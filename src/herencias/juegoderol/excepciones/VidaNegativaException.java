package herencias.juegoderol.excepciones;

public class VidaNegativaException extends Exception{
	
	public String getMessage() {
		return "La Vida no puede ser negativo";
	}
	
	public String toString() {
		return "La Vida no puede ser negativo";
	}


}
