package herencias.mandosdistancia.clases;

import herencias.mandosdistancia.excepciones.DimensionNegativaException;
import herencias.mandosdistancia.excepciones.PrecioNegativoException;
import herencias.mandosdistancia.interfaces.Volumen;

public class Minicadena  extends Mando implements Volumen{
	
	private  int volumen= 0;

	public Minicadena(String modelo, int anchura, int altura, double precio)
			throws DimensionNegativaException, PrecioNegativoException {
		super(modelo, anchura, altura, precio);
		
	}

	public int getVolumen() {
		return volumen;
	}

	@Override
	public void subirVolumen() {
		
		this.volumen +=10;
		
	}

	@Override
	public void bajarVolumen() {
		this.volumen -=10;
		
	}
	
	@Override
	public String toString() {
		
		return "Minicadena - " + super.toString();
	}

	
	

}
