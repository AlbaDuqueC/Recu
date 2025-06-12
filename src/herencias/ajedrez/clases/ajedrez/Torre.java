package herencias.ajedrez.clases.ajedrez;

import herencias.ajedrez.clases.Ajedrez;
import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Torre extends Ajedrez {

	public Torre(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color, "Torre");

	}

	@Override
	public boolean movimiento(char x, int y) {

		return false;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;

		Torre t;

		if (obj instanceof Torre) {

			t = (Torre) obj;

			if (super.getPosicionX() == t.getPosicionX() && super.getPosicionY() == t.getPosicionY()) {

				res = true;

			}

		}

		return res;
	}

}
