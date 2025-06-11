package herencias.mandosdistancia.clases;

import herencias.mandosdistancia.excepciones.DimensionNegativaException;
import herencias.mandosdistancia.excepciones.PrecioNegativoException;

public class Mando implements Comparable<Mando> {

	private String modelo;
	private int anchura;
	private int altura;
	private double precio;
	private boolean encendido = false;

	public Mando(String modelo, int anchura, int altura)
			throws DimensionNegativaException, PrecioNegativoException {

		if (modelo != null && !modelo.isBlank()) {

			this.modelo = modelo;

		}

		if (anchura > 0) {

			this.anchura = anchura;
		} else {
			throw new DimensionNegativaException();
		}

		if (altura > 0) {
			this.altura = altura;
		} else {
			throw new DimensionNegativaException();
		}

	}
	
	public Mando(String modelo, int anchura, int altura, double precio)
			throws DimensionNegativaException, PrecioNegativoException {

		this(modelo,anchura,altura);

		if (precio > 0) {
			this.precio = precio;
		} else {
			throw new PrecioNegativoException();
		}

	}

	public String getModelo() {
		return modelo;
	}

	public int getAnchura() {
		return anchura;
	}

	public int getAltura() {
		return altura;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) throws PrecioNegativoException {
		if (precio > 0) {
			this.precio = precio;
		} else {
			throw new PrecioNegativoException();
		}
	}

	public boolean isEncendido() {
		return encendido;
	}

	public void encenderApagar() {

		this.encendido = !this.encendido;

	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;

		Mando mandito = (Mando) obj;

		if (mandito.modelo.equals(this.modelo)) {

			res = true;

		}

		return res;
	}

	@Override
	public int compareTo(Mando o) {

		return this.modelo.compareTo(o.modelo);

	}

	@Override
	public String toString() {

		String res = this.modelo + " - Altura: " + this.altura + " - Anchura: " + this.anchura + " - Precio: "
				+ this.precio + "€ - ";

		res += (encendido) ? "encendido" : "apagado";

		return res;

	}

}
