package herencias.juegoderol.clases;

import herencias.juegoderol.excepciones.ManaNegativoException;
import herencias.juegoderol.excepciones.VidaNegativaException;
import herencias.juegoderol.interfaces.Atacar;

public class Picaro extends Personaje implements Atacar{

	public Picaro(String nombre, int pVida, int pMana) throws VidaNegativaException, ManaNegativoException {
		super(nombre, pVida, pMana);
		
	}

	@Override
	public boolean atacar(Personaje p) {
		boolean res = false;

		int ataque = (int) (this.pMana * 0.1);

		if (this.pMana > 0) {
			this.pMana -= ataque;

			res = p.recibirDaño(ataque);

			this.pMana = this.pMana < 0 ? 0 : this.pMana;

		}

		return res;
	}
	
	@Override
	public String toString() {
		
		return "Picaro" + super.toString();
	}

}
