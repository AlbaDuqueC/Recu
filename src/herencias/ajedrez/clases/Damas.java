package herencias.ajedrez.clases;

import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;
import herencias.ajedrez.interfaces.Movimiento;

public class Damas extends Pieza implements Movimiento {

	public Damas(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color);

	}

	@Override
	public boolean movimiento(char x, int y) {

		boolean res = false;

		int posX = (int) x - 'a' +1;

		if (y == super.getPosicionY() + 1 || y == super.getPosicionY() - 1) {

			if (posX == super.getPosicionX() - 1 || posX == super.getPosicionX() + 1) {
				
				super.setPosicionX(posX);
				super.setPosicionY(y);

				res=true;
				
			}
		}

		return res;

	}

	@Override
	public boolean equals(Object obj) {
		
		boolean res=false;
		
		Damas d;
		
		if(obj instanceof Damas) {
			
			d=(Damas) obj;
			
			if(super.getPosicionX() == d.getPosicionX() && super.getPosicionY() == d.getPosicionY()) {
				
				res=true;
				
			}
			
		}
		
		return res;
		
	}
	
	@Override
	public String toString() {
		
		return "D: "+super.toString();
	}
}
