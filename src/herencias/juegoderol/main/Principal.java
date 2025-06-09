package herencias.juegoderol.main;

import java.util.ArrayList;
import java.util.List;

import herencias.juegoderol.clases.Guerrero;
import herencias.juegoderol.clases.Mago;
import herencias.juegoderol.clases.Personaje;
import herencias.juegoderol.clases.Picaro;
import herencias.juegoderol.clases.Pocion;
import herencias.juegoderol.excepciones.ManaNegativoException;
import herencias.juegoderol.excepciones.VidaNegativaException;

public class Principal {

	public static void main(String[] args) throws VidaNegativaException, ManaNegativoException {

		List<Personaje> jugadores = new ArrayList<Personaje>();

		Picaro p1 = new Picaro("Fede", 50, 60);
		Guerrero p2 = new Guerrero("Ainoa", 70, 50);
		Mago p3 = new Mago("Alicia", 60, 80);

		jugadores.add(p1);
		jugadores.add(p2);
		jugadores.add(p3);

		for (Personaje p : jugadores) {
			System.out.println(p.toString());
			System.out.println("-----------------------------------------------------------");
		}

		jugadores.sort((o1, o2) -> o1.compareTo(o2));

		for (Personaje p : jugadores) {
			System.out.println(p.toString());
			System.out.println("-----------------------------------------------------------");
		}
		
		p1.setNivel(10);
		p2.setNivel(5);
		p3.setNivel(20);

		jugadores.sort((o1, o2) -> o2.getNivel()-o1.getNivel());

		for (Personaje p : jugadores) {
			System.out.println(p.toString());
			System.out.println("-----------------------------------------------------------");
		}
		
		System.out.println("\n\n1.Recibir daño:");
		
		System.out.println(p1.toString());
		
		p1.recibirDaño(5);
		
		System.out.println("----o----");
		
		System.out.println(p1.toString());
		
		
		System.out.println("\n\n2.Recuperar vida");
		
		System.out.println(p2.toString());
		
		p2.recuperarVida(5);
		
		System.out.println("----o----");
		
		System.out.println(p2.toString());
		
		System.out.println("\n\n3.Recuperar maná");
		
		p2.recuperarMana(5);
		
		System.out.println(p2.toString());
		
		System.out.println("\n\n4.Coger varias pociones de distinto tipo.");
		
		Pocion poc1= new Pocion("MANA", 40);
		Pocion poc2= new Pocion("VIDA", 40);
		
		System.out.println(p3.toString());
		
		p3.cogerPocion(poc1);
		p3.cogerPocion(poc2);
		
		System.out.println("----o----");
		
		System.out.println(p3.toString());
		
		System.out.println("\n\n5.Usar al menos una poción de maná y una de vida");
		
		p3.usarPocion(poc1);
		p3.usarPocion(poc2);
		
		System.out.println("\n\n6.Atacar (sólo para los personajes que puedan atacar).");
		
		if(p1.atacar(p3)) {
			System.out.println("Ataco con exito");
		}else {
			System.out.println("No le distes");
		}
		
		
		System.out.println("\n\n7.Curar (sólo para los personajes que puedan curar).");
		
		if(p3.curar(p3)) {
			System.out.println("Pudiste curar");
		}else {
			System.out.println("no pudistes curar");
		}
		
		System.out.println("\n\n8.Defender (sólo para los personajes que puedan defender).");

		if(p2.defender(p3)) {
			System.out.println("Pudistes defender");
		}else {
			System.out.println("No pudistes defender");
		}
		
	}

}
