package herencias.ajedrez.excepciones;

public class PosicionYNegativaException extends Exception{
	
	public String getMessage() {
		return "la posicion Y no puede se negativa";
	}
	
	public String toString() {
		return "la posicion Y no puede se negativa";
	}

}
