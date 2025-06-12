package herencias.ajedrez.clases;

import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public abstract class Pieza {

	private enum Color {
		BLANCO, NEGRO, GRIS
	};

	private int posicionX; // min 1 , max 8
	private int posicionY; // min 1 , max 8
	private Color colorPieza;

	public Pieza(char x, int y, String color) throws PosicionXNegativaExcepcion, PosicionYNegativaException {

		int posX = (int) x - 'a' + 1;

		if (posX > 0 && posX<=8) {
			this.posicionX = posX;

		} else {
			throw new PosicionXNegativaExcepcion();
		}

		if (y > 0 && y<=8) {
			this.posicionY = y;

		} else {
			throw new PosicionYNegativaException();
		}

		switch (color) {
		case "NEGRO" -> {

			this.colorPieza = Color.NEGRO;
		}
		case "GRIS" -> {

			this.colorPieza = Color.GRIS;
		}
		default -> {
			this.colorPieza = Color.BLANCO;
		}
		}

	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}
	
	

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public String getColorPieza() {
		return String.valueOf(this.colorPieza);
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean res=false;
		
		if(this.getClass() == obj.getClass()) {
			
			Pieza p= (Pieza) obj;
			
			if(p.posicionX == this.posicionX && p.posicionY== this.posicionY) {
				res=true;
			}
			
			
		}
		
		return res;
		
	}

	@Override
	public String toString() {

		char posX = (char) (this.posicionX + 'a' -1);

		return String.valueOf(this.colorPieza) + " (" + this.posicionY + ", " + posX + ")";
	}

}
