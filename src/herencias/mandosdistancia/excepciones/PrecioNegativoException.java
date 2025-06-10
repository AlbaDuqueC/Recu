package herencias.mandosdistancia.excepciones;

public class PrecioNegativoException extends Exception{

	public String getMessage() {
		return "El precio del mando no puede ser negativo";
	}
	
	public String toString() {
		return "El precio del mando no puede ser negativo";
	}
	
}
