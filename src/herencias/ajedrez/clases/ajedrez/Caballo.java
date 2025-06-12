package herencias.ajedrez.clases.ajedrez;

import herencias.ajedrez.clases.Ajedrez;
import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Caballo extends Ajedrez {

	public Caballo(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color, "Caballo");

	}

	@Override
	public boolean movimiento(char x, int y) {

		return false;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;

		Caballo c;

		if (obj instanceof Caballo) {

			c = (Caballo) obj;

			if (super.getPosicionX() == c.getPosicionX() && super.getPosicionY() == c.getPosicionY()) {

				res = true;

			}

		}

		return res;
	}

}
