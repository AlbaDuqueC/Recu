package herencias.mandosdistancia.clases;

import herencias.mandosdistancia.excepciones.DimensionNegativaException;
import herencias.mandosdistancia.excepciones.PrecioNegativoException;
import herencias.mandosdistancia.interfaces.Velocidad;

public class Aspiradora extends Mando implements Velocidad {

	private int velocidad = 0; // Max 3

	public Aspiradora(String modelo, int anchura, int altura, double precio)
			throws DimensionNegativaException, PrecioNegativoException {
		super(modelo, anchura, altura, precio);

	}

	public int getVelocidad() {
		return velocidad;
	}

	@Override
	public void subirVelocidad() {

		if (this.velocidad < 3) {
			this.velocidad += 1;
		}

	}

	@Override
	public void bajarVelocidad() {
		if (this.velocidad > 0) {
			this.velocidad -= 1;
		}

	}
	
	@Override
	public String toString() {
		
		return "Aspiradora" + super.toString();
	}

}
