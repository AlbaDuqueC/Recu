package string.escalera;

import java.util.Random;

public class Escaleras {

	static String[][] juegos = { { "CASA", "PATO" }, { "PISO", "TUBO" }, { "CENA", "MURO" }, { "BONO", "DEDO" },
			{ "ROJO", "PASA" } };
	
	static String palabraInicio="";
	
	static String palabraObjetivo="";
	
	static String jugada="";
	
	public static void seleccionaJuego() {
		
		Random rand= new Random();
		
		int pos=rand.nextInt(0, juegos[0].length);
		
		palabraInicio=juegos[0][pos];
		palabraObjetivo=juegos[1][pos];
		
		jugada+=palabraInicio;
		
	}
	
	public static String ultimoIntento() {
		
		String res="";
		
		int ultimoEspacio= jugada.lastIndexOf(" ");
		
		res=jugada.substring(ultimoEspacio, jugada.length());
		
		return res;
		
	}
	
	public static boolean compruebaIntento(String intento) {
		
		boolean res=true;
		
		char [] arrayIntento= intento.toCharArray();
		char[] arrayUltimaJugada= ultimoIntento().toCharArray();
		
		int i=0;
		
		int cont=0;
		
		while(i<arrayUltimaJugada.length && !res) {
		
			if(arrayIntento[i]!=arrayUltimaJugada[i]) {
				
				++cont;
				
				if(cont>1) {
					res=false;
				}
				
			}
			
		}
		
		return res;
		
	}

}
