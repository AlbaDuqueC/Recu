package herencias.ajedrez.clases.ajedrez;

import herencias.ajedrez.clases.Ajedrez;
import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Peon extends Ajedrez {

	public Peon(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color, "Peon");

	}

	@Override
	public boolean movimiento(char x, int y) {
		// TODO Auto-generated method stub
		return false;
	}



}
