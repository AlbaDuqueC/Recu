package herencias.ajedrez.clases.ajedrez;

import herencias.ajedrez.clases.Ajedrez;
import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Alfil extends Ajedrez {

	public Alfil(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color, "Alfil");

	}
	
	@Override
	public boolean movimiento(char x, int y) {

		return false;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;

		Alfil a;

		if (obj instanceof Alfil) {

			a = (Alfil) obj;

			if (super.getPosicionX() == a.getPosicionX() && super.getPosicionY() == a.getPosicionY()) {

				res = true;

			}

		}

		return res;
	}
	

	

}
