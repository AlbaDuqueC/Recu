package herencias.ajedrez.clases;

import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;
import herencias.ajedrez.interfaces.Movimiento;

public abstract class Ajedrez  extends Pieza implements Movimiento{
	
	private String nombre;

	public Ajedrez(char x, int y, String color, String nombre) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color);
		
		if(nombre!=null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public abstract boolean movimiento(char x, int y);
	
	@Override
	public String toString() {
		
		return "A: "+ this.nombre + " "+ super.toString();
	}

}
