package string.criptograma;

import java.util.Random;

public class Criptograma {

	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia",
			"alaverga" };

	static String fraseReal = "";

	static String fraseCodificada = "";

	public static void desordenaAbecedario() {

		Random rand = new Random();

		int iRand;
		int jRand;

		char letra;

		for (int i = 0; i < abecedario.length; i++) {

			for (int j = 0; j < abecedario[i].length; j++) {

				iRand = rand.nextInt(0, abecedario.length);
				jRand = rand.nextInt(0, abecedario[0].length);

				letra = abecedario[iRand][jRand];

				abecedario[iRand][jRand] = abecedario[i][j];
				abecedario[i][j] = letra;

			}

		}

	}

	public static void eligeFrase() {

		Random rand = new Random();

		int num = rand.nextInt(0, frases.length);

		fraseReal = frases[num];

	}

	public static void codificaFrase() {

		boolean res = false;

		int i = 0;
		int j = 0;

		char caracter;

		for (int k = 0; k < fraseReal.length(); k++) {

			res = false;

			i = 0;

			caracter = fraseReal.charAt(k);

			if (caracter == ' ') {

				fraseCodificada += "  ";

			} else {

				while (i < abecedario.length && !res) {

					j = 0;

					while (j < abecedario[i].length && !res) {

						if (abecedario[i][j] == caracter) {

							fraseCodificada += i + "" + j + " ";

							res = true;

						}
						++j;

					}
					++i;

				}
			}

		}

	}

	public static boolean compruebaCodigo(int codigo, char letra) {

		boolean res = false;

		int iNum = codigo / 10;
		int jNum = codigo % 10;

		String codigoString = iNum + "" + jNum;

		String letraString = String.valueOf(letra);

		if (abecedario[iNum][jNum] == letra) {

			fraseCodificada = fraseCodificada.replace(codigoString, letraString);

			res = true;

		}

		return res;

	}

	public static boolean sonIguales() {

		boolean res;

		String fraseCod = "";

		char caracter;

		int sig;

		for (int i = 0; i < fraseCodificada.length(); i++) {

			caracter = fraseCodificada.charAt(i);

			sig = i + 1;

			if (caracter != ' ') {

				fraseCod += String.valueOf(caracter);

			} else if (sig < fraseCodificada.length() && fraseCodificada.charAt(sig) == ' ') {

				fraseCod += String.valueOf(caracter);
				++i;

			}

		}

		res = fraseCod.equals(fraseReal);

		return res;

	}
	
	public static boolean sonIguales2() {
		
		boolean res;
		
		String frase1=fraseReal.replace(" ", "");
		String frase2=fraseCodificada.replace(" ", "");
		
		res=frase1.equals(frase2);
		
		return res;
		
	}

}
