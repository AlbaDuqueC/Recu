package herencias.ajedrez.excepciones;

public class PosicionXNegativaExcepcion extends Exception{

	public String getMessage() {
		return "la posicion X no puede se negativa";
	}
	
	public String toString() {
		return "la posicion X no puede se negativa";
	}
	
}
