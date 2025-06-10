package herencias.mandosdistancia.clases;

import herencias.mandosdistancia.excepciones.DimensionNegativaException;
import herencias.mandosdistancia.excepciones.PrecioNegativoException;
import herencias.mandosdistancia.interfaces.Velocidad;

public class AireAcondicionado extends Mando implements Velocidad {

	private enum Modo {
		FRIO, CALOR
	};

	private Modo modoAire = Modo.FRIO;
	private int temperatura = 0;
	private int velocidad = 0;

	public AireAcondicionado(String modelo, int anchura, int altura, double precio)
			throws DimensionNegativaException, PrecioNegativoException {
		super(modelo, anchura, altura, precio);

	}

	public String getModoAire() {
		return String.valueOf(this.modoAire);
	}

	public int getTemperatura() {
		return temperatura;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void subirTemperatura() {

		this.temperatura += 1;

	}

	public void bajarTemperatura() {

		this.temperatura -= 1;

	}

	public void cambiarModoAire() {

		this.modoAire = this.modoAire == Modo.CALOR ? Modo.FRIO : Modo.CALOR;

	}

	@Override
	public void subirVelocidad() {

		this.velocidad += 1;

	}

	@Override
	public void bajarVelocidad() {

		if (this.velocidad > 0) {
			this.velocidad -= 1;
		}

	}

	@Override
	public String toString() {

		return "AireAcondicionado - " + super.toString();
	}

}
