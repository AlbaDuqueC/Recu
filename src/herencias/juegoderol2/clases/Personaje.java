package herencias.juegoderol2.clases;

import java.util.ArrayList;
import java.util.List;

import herencias.juegoderol.excepciones.VidaNegativaException;
import herencias.juegoderol2.excepciones.ManaNegativaException;

public abstract class Personaje implements Comparable<Personaje> {

	private String nombre;
	private int nivel = 0;
	private int pVida;
	private int pMana;
	private boolean escudo = false;

	private List<Pocion> inventario = new ArrayList<Pocion>();

	public Personaje(String nombre, int pV, int pM) throws VidaNegativaException, ManaNegativaException {

		if (nombre != null && !nombre.isBlank()) {

			this.nombre = nombre;

		}

		if (pV > 0) {

			this.pVida = pV;

		} else {

			throw new VidaNegativaException();

		}

		if (pM > 0) {

			this.pMana = pM;
		} else {

			throw new ManaNegativaException();

		}

	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {

		if (nivel > 0) {
			this.nivel = nivel;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getpVida() {
		return pVida;
	}

	public int getpMana() {
		return pMana;
	}

	public boolean isEscudo() {
		return escudo;
	}
	
	

}
