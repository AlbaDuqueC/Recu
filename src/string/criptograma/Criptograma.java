package string.criptograma;

import java.util.Random;

public class Criptograma {

	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	static String fraseReal = "";

	static String fraseCodificada = "";

	public static void desordenaAbecedario() {

		Random rand = new Random();

		int iRand;
		int jRand;

		char[][] nuevoAbecedario = new char[abecedario.length][abecedario.length];

		for (int i = 0; i < abecedario.length; i++) {

			for (int j = 0; j < abecedario.length; j++) {

				do {
					iRand = rand.nextInt(0, nuevoAbecedario.length);
					jRand = rand.nextInt(0, nuevoAbecedario[0].length);

				} while (String.valueOf(nuevoAbecedario[iRand][jRand]) != null);

				nuevoAbecedario[iRand][jRand] = abecedario[i][j];

			}

		}

		abecedario = nuevoAbecedario;

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

		for (int k = 0; k < fraseReal.length(); k++) {

			while (i < abecedario.length && !res) {

				while (j < abecedario[0].length && !res) {

					if (abecedario[i][j] == fraseReal.charAt(k)) {

						fraseCodificada += i + "" + j + " ";

						res = true;

					}

				}

			}

			res = false;

		}

	}

	public static boolean compruebaCodigo(int codigo, char letra) {

		boolean res = false;

		int iNum = codigo / 10;
		int jNum = codigo % 10;

		if (abecedario[iNum][jNum] == letra) {

			fraseCodificada.replace(String.valueOf(codigo), String.valueOf(letra));

			res = true;

		}

		return res;

	}

	public static boolean sonIguales() {

		boolean res;

		String fraseCod = "";

		for (int i = 0; i < fraseCodificada.length(); i++) {

			if (fraseCodificada.charAt(i) == ' ' && fraseCodificada.charAt(i + 1) == ' ') {

				fraseCod += " ";

			} else if (fraseCodificada.charAt(i) != ' ') {

				fraseCod += String.valueOf(fraseCodificada.charAt(i));

			}

		}

		res = fraseCod.equals(fraseReal);

		return res;

	}

}
