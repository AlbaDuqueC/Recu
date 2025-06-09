package herencias.juegoderol.clases;

import herencias.juegoderol.excepciones.ManaNegativoException;
import herencias.juegoderol.excepciones.VidaNegativaException;
import herencias.juegoderol.interfaces.Atacar;
import herencias.juegoderol.interfaces.Curar;

public class Mago extends Personaje implements Atacar, Curar{

	public Mago(String nombre, int pVida, int pMana) throws VidaNegativaException, ManaNegativoException {
		super(nombre, pVida, pMana);
		
	}

	@Override
	public boolean curar(Personaje p) {
		
		boolean res=false;
		
		int curar= this.getNivel() * 8;
		
		if(p.recuperarVida(curar)) {
			res=true;
		}
		
		return res;
		
	}

	@Override
	public boolean atacar(Personaje p) {
		boolean res = false;

		int ataque = (int) (this.pMana * 0.25);

		if (this.pMana > 0) {
			this.pMana -= ataque;

			res = p.recibirDaño(ataque);

			this.pMana = this.pMana < 0 ? 0 : this.pMana;

		}

		return res;
	}
	
	@Override
	public String toString() {
		
		return "Mago"+ super.toString();
	}

}
