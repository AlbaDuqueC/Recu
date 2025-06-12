package herencias.ajedrez.clases;

import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class HundirLaFlota extends Pieza {
	
	private enum Direccion {ARRIBA, ABAJO, IZQUIERDA, DERECHA};
	private int tamaño;
	private Direccion dir;
	

	public HundirLaFlota(char x, int y, String color, int tamaño, String dire) throws PosicionXNegativaExcepcion, PosicionYNegativaException {
		super(x, y, color);
		
		if(tamaño>0 && tamaño<=5) {
			this.tamaño= tamaño;
		}
		
		if(dire!=null && !dire.isBlank()) {
			
			
			switch (dire.toUpperCase()) {
			case "ARRIBA" ->{
				this.dir= Direccion.ARRIBA;
			}
			case "ABAJO" ->{
				this.dir=Direccion.ABAJO;
			}
			case "IZQUIERDA" ->{
				this.dir= Direccion.IZQUIERDA;
			}
			default ->{
				this.dir=Direccion.DERECHA;
			}
			}
			
		}
		
	}
	
	

	public int getTamaño() {
		return tamaño;
	}



	public String  getDir() {
		return String.valueOf(dir);
	}




	
	@Override
	public String toString() {
		
		return "H: "+ this.tamaño + " "+ this.dir+" " +super.toString();
	}

}
