package string.ahorcado;

import java.util.Random;

public class Ahorcado {

	static String[] palabras = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia" };

	static int NUMINTENTOS = 7;

	static String palabraSecreta = "";

	static String palabraPista = "";

	static String noAcertadas = "";

	public static void generaPalabra() {

		Random rand = new Random();

		int pos = rand.nextInt(0, palabras.length);

		palabraSecreta = palabras[pos];

		palabraPista = "_".repeat(palabraSecreta.length());

	}

	public static boolean compruebaLetra(char letra) {
		
		boolean res=false;

		String letrita = String.valueOf(letra).toLowerCase();

		char[] pistita = palabraSecreta.toCharArray();

		int pos = palabraSecreta.indexOf(letrita);

		if (pos < 0) {

			noAcertadas += letrita+" ";

		} else {

			while (pos >= 0) {

				pistita[pos] =Character.toLowerCase(letra);

				pos = palabraSecreta.indexOf(letrita, pos + 1);

			}

			palabraPista = String.valueOf(pistita);
			
			res=true;

		}
		
		return res;

	}
	
	public static void compruebaPalabra(String palabra) {
		
		if(palabraSecreta.equalsIgnoreCase(palabra)) {
			
			palabraPista=palabra;
			
		}
		
	}
	
	public static void pintaPista() {
		
		System.out.println(noAcertadas);
		System.out.println(palabraPista);
		
	}

}
