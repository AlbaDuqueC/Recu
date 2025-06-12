package herencias.ajedrez.main;

import herencias.ajedrez.clases.Damas;
import herencias.ajedrez.clases.Go;
import herencias.ajedrez.clases.HundirLaFlota;
import herencias.ajedrez.clases.ajedrez.Alfil;
import herencias.ajedrez.clases.ajedrez.Caballo;
import herencias.ajedrez.clases.ajedrez.Dama;
import herencias.ajedrez.clases.ajedrez.Peon;
import herencias.ajedrez.clases.ajedrez.Rey;
import herencias.ajedrez.clases.ajedrez.Torre;
import herencias.ajedrez.excepciones.PosicionXNegativaExcepcion;
import herencias.ajedrez.excepciones.PosicionYNegativaException;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Alfil p1= new Alfil('b', 3,"BLANCO");
			Caballo p2= new Caballo ('d', 5,"NEGRO");
			Dama p3= new Dama('c', 8,"BLANCO");
			Peon p4= new Peon('a', 2,"NEGRO");
			Rey p5= new Rey('e', 7,"BLANCO");
			Torre p6= new Torre('f', 4,"NEGRO");
			
			
			
			Damas p7= new Damas('a', 5,"BLANCO");
			Go p8= new Go('c', 2,"NEGRO");
			HundirLaFlota p9= new HundirLaFlota('a', 1,"GRIS", 4, "ARRIBA");
			
			Alfil p10= new Alfil('b', 3,"NEGRO");
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			System.out.println(p3.toString());
			System.out.println(p4.toString());
			System.out.println(p5.toString());
			System.out.println(p6.toString());
			System.out.println(p7.toString());
			System.out.println(p8.toString());
			System.out.println(p9.toString());
			
			if(p7.movimiento('b', 6)) {
				System.out.println("Si se pudo mover la pieza");
				System.out.println(p7.toString());
			}else {
				System.out.println("Illo que haces moviento ahi, echa pa allaaa");
			}
			
			if(p1.equals(p10)) {
				System.out.println("Son iguales");
			}else {
				System.out.println("No son iguales");
			}
			
			if(p7.movimiento('e', 6)) {
				System.out.println("Si se pudo mover la pieza");
				System.out.println(p7.toString());
			}else {
				System.out.println("Illo que haces moviento ahi, echa pa allaaa");
			}

			Alfil pError= new Alfil('c', -4,"NEGRO");
//			Alfil pError2= new Alfil('l', 4,"NEGRO");
			
		} catch (PosicionXNegativaExcepcion | PosicionYNegativaException e) {
		
			System.err.println(e.getMessage());
		}

	}

}
