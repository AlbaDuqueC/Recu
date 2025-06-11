package herencias.mandosdistancia.clases;

import herencias.mandosdistancia.excepciones.DimensionNegativaException;
import herencias.mandosdistancia.excepciones.PrecioNegativoException;
import herencias.mandosdistancia.interfaces.Volumen;

public class Television extends Mando implements Volumen {

	private int volumen = 0;
	private int canal = 1;

	public Television(String modelo, int anchura, int altura)
			throws DimensionNegativaException, PrecioNegativoException {
		super(modelo, anchura, altura);

	}
	
	public Television(String modelo, int anchura, int altura, double precio)
			throws DimensionNegativaException, PrecioNegativoException {
		super(modelo, anchura, altura, precio);

	}
	
	

	public int getVolumen() {
		return volumen;
	}

	public int getCanal() {
		return canal;
	}

	public void cambiarCanal(int canal) {
		if (canal > 0) {
			this.canal = canal;
		}

	}

	@Override
	public void subirVolumen() {

		this.volumen += 5;
	}

	@Override
	public void bajarVolumen() {

		this.volumen -= 5;

	}
	
	@Override
	public String toString() {
		
		return "Television - " + super.toString();
	}

}
