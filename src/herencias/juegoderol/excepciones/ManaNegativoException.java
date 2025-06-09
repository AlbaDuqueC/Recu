package herencias.juegoderol.excepciones;

public class ManaNegativoException extends Exception{
	
	public String getMessage() {
		return "El Maná no puede ser negativo";
	}

	public String toString() {
		return "El Maná no puede ser negativo";
	}

	
}
