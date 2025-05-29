package arrays.conecta4;

import java.util.Random;

public class Conecta4 {

	public static char[][] tablero;

	public static void imprimeTablero() {

		for (int i = 0; i < tablero.length; i++) {

			System.out.print("   " + i);

		}

		for (int i = 0; i < tablero.length; i++) {

			System.out.print("  |");

			for (int j = 0; j < tablero[0].length; j++) {

				System.out.print("|" + tablero[i][j] + "|");

			}

			System.out.println();
		}

	}

	public static int jugadorInicial() {

		Random rand = new Random();

		return rand.nextInt(0, 2);

	}

	public static void mueveFichaAleatoria() {

		Random rand = new Random();

		int columna;

		do {

			columna = rand.nextInt(0, tablero.length);

		} while (!colocarFicha(columna, 'O'));

	}

	public static boolean colocarFicha(int columna, char caracter) {

		boolean res = false;

		int i = tablero.length - 1;

		while (i >= 0 && !res) {

			if (tablero[i][columna] == ' ') {

				res = true;

				tablero[i][columna] = caracter;

			} else {

				i--;

			}

		}

		return res;

	}

	public static void limpiarTablero() {

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[0].length; j++) {

				tablero[i][j] = ' ';

			}

		}

	}

	public static boolean esGanador(int columna, char caracter) {

		boolean res = false;

		boolean encontrado = false;

		int cont = 0;

		int i = 0;

		int iAnt;
		int jAnt;

		// Encontrar la i

		while (i < tablero.length && !encontrado) {

			if (tablero[i][columna] == caracter) {

				encontrado = true;

			} else {

				i++;

			}

		}

		// Comprobacion diagonal hacia arriba

		iAnt = i - 3;
		jAnt = columna + 3;

		while (iAnt <= i + 3 && jAnt >= columna - 3 && !res) {

			if (iAnt < tablero.length && iAnt >= 0 && jAnt < tablero[0].length && jAnt >= 0) {

				if (tablero[iAnt][jAnt] == caracter) {
					++cont;
				}

				if (cont == 4) {
					res = true;
				}
			}

			++iAnt;
			--jAnt;

		}

		// Comprobacion de linea horizontal
		iAnt = i;
		jAnt = columna - 3;

		while (jAnt <= columna + 3 && !res) {

			if (jAnt < tablero[0].length && jAnt >= 0) {

				if (tablero[iAnt][jAnt] == caracter) {
					++cont;

				} else {

					cont = 0;
				}

				if (cont == 4) {
					res = true;
				}
			}

			++jAnt;

		}

		// Comprobacion de linea vertical
		iAnt = i + 3;
		jAnt = columna;

		while (iAnt <= i - 3 && !res) {

			if (iAnt < tablero.length && iAnt >= 0) {

				if (tablero[iAnt][jAnt] == caracter) {
					++cont;
				} else {
					cont = 0;
				}

				if (cont == 4) {
					res = true;
				}
			}

			--iAnt;

		}

		// Comprobacion de linea diagonal para abajo
		iAnt = i - 3;
		jAnt = columna - 3;

		while (iAnt <= i + 3 && jAnt <= i + 3 && !res) {

			if (iAnt < tablero.length && iAnt >= 0 && jAnt < tablero[0].length && jAnt >= 0) {

				if (tablero[iAnt][jAnt] == caracter) {
					++cont;
				} else {
					cont = 0;
				}

				if (cont == 4) {
					res = true;
				}
			}

			++jAnt;
			++iAnt;

		}

		return res;

	}

}
