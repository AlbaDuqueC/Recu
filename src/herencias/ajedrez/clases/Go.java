package herencias.ajedrez.clases;

import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Go extends Pieza {

	public Go(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color);
	}



	@Override
	public String toString() {

		return "G: " + super.toString();
	}

}
