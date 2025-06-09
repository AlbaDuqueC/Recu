package herencias.juegoderol.clases;

import java.util.ArrayList;
import java.util.List;

import herencias.juegoderol.excepciones.ManaNegativoException;
import herencias.juegoderol.excepciones.VidaNegativaException;

public abstract class Personaje implements Comparable<Personaje> {

	private String nombre;
	private int nivel = 0;
	private int pVida;
	private int pMana;
	private boolean escudo = false;

	private List<Pocion> inventario = new ArrayList<Pocion>();

	public Personaje(String nombre, int pVida, int pMana) throws VidaNegativaException, ManaNegativoException {

		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		if (pVida > 0) {
			this.pVida = pVida;
		} else {
			throw new VidaNegativaException();
		}

		if (pMana > 0) {
			this.pMana = pMana;
		} else {
			throw new ManaNegativoException();
		}

	}

	public String getNombre() {
		return nombre;
	}

	public int getNivel() {
		return nivel;
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

	public void setNivel(int nivel) {

		if (nivel > 0) {
			this.nivel = nivel;
		}
	}

	public void activarEscudo() {

		this.escudo = true;

	}

	public boolean recibirDaño(int daño) {

		boolean res = false;

		if (!escudo) {

			if (daño > 0) {
				this.pVida -= daño;
				res = true;

				if (this.pVida < 0) {
					this.pVida = 0;
				}

			}

		} else {
			this.escudo = false;
		}

		return res;

	}

	public boolean recuperarVida(int vida) throws VidaNegativaException {
		boolean res = false;

		if (vida > 0) {
			this.pVida += vida;
			res = true;
		} else {
			throw new VidaNegativaException();
		}

		return res;
	}

	public boolean recuperarMana(int mana) throws ManaNegativoException {

		boolean res = false;

		if (mana > 0) {
			this.pMana += mana;
			res = true;
		} else {
			throw new ManaNegativoException();
		}

		return res;

	}

	public void cogerPocion(Pocion poc) {

		inventario.add(poc);

	}

	public void usarPocion(Pocion poc) {

		if (inventario.remove(poc)) {

			if (poc.getTipoPocion().equals("MANA")) {
				this.pMana += poc.getCantidad();
			} else {
				this.pVida += poc.getCantidad();
			}

		}

	}

	@Override
	public boolean equals(Object obj) {

		boolean res = false;

		Personaje per = (Personaje) obj;

		if (per.nombre.equals(this.nombre)) {
			res = true;
		}

		return res;

	}

	@Override
	public int compareTo(Personaje per) {

		return this.nombre.compareTo(per.nombre);

	}

	@Override
	public String toString() {

		String res = "";

		String esc = (this.escudo) ? "- Escudo: activo" : "";

		res += " - " + this.nombre + " - nivel:" + this.nivel + " - PV: " + this.pVida + " - PH: " + this.pMana + esc;

		res += "\nPociones: ";

		for (Pocion poc : inventario) {

			res += poc.toString() + ", ";

		}

		return res;

	}

}
