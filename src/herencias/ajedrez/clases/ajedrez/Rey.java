package herencias.ajedrez.clases.ajedrez;

import herencias.ajedrez.clases.Ajedrez;
import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Rey extends Ajedrez {

	public Rey(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color, "Rey");

	}

	@Override
	public boolean movimiento(char x, int y) {

		return false;
	}



}
