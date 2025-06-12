package herencias.ajedrez.clases.ajedrez;

import herencias.ajedrez.clases.Ajedrez;
import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Dama extends Ajedrez {

	public Dama(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color, "Ajedrez");

	}

	@Override
	public boolean movimiento(char x, int y) {

		return false;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;

		Dama d;

		if (obj instanceof Dama) {

			d = (Dama) obj;

			if (super.getPosicionX() == d.getPosicionX() && super.getPosicionY() == d.getPosicionY()) {

				res = true;

			}

		}

		return res;
	}

}
