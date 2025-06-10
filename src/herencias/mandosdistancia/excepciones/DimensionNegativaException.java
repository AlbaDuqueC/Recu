package herencias.mandosdistancia.excepciones;

public class DimensionNegativaException extends Exception{

	public String getMessage() {
		return "Las dimensiones del mando no pueden ser negativas";
	}
	
	public String toString() {
		return "Las dimensiones del mando no pueden ser negativas";
	}
	
}
