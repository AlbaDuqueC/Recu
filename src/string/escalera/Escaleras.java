package string.escalera;

import java.util.Random;

public class Escaleras {

	static String[][] juegos = { { "CASA", "PATO" }, { "PISO", "TUBO" }, { "CENA", "MURO" }, { "BONO", "DEDO" },
			{ "ROJO", "PASA" } };
	
	static String palabraInicio="";
	
	static String palabraObjetivo="";
	
	static String jugada="";
	
	static final int NUMINTENTOS=7;
	
	public static void seleccionaJuego() {
		
		Random rand= new Random();
		
		int pos=rand.nextInt(0, juegos.length);
		
		palabraInicio=juegos[pos][0];
		palabraObjetivo=juegos[pos][1];
		
		jugada = palabraInicio;
		
	}
	
	public static String ultimoIntento() {
		
		String res="";
		
		int ultimoEspacio= jugada.lastIndexOf(" ")+1;
		
		res=jugada.substring(ultimoEspacio);
		
		return res;
		
	}
	
	public static boolean compruebaIntento(String intento) {
		
		boolean res;
		
		String ultimaJugada= ultimoIntento();
		
		int i=0;
		
		int cont=0;
		
		
		
		while(i<ultimaJugada.length() && cont<=1) {
			
			if(intento.charAt(i) != ultimaJugada.charAt(i)) {
				
				++cont;
				
			}
			++i;
		}
		
		res = cont == 1;
		
		return res;
		
	}
	

}
