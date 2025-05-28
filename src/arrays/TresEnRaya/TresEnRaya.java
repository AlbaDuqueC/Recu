package arrays.TresEnRaya;

import java.util.Random;

public class TresEnRaya {

	public static char[][] tablero = new char[3][3];

	public static void imprimeTablero() {

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print("\t" + tablero[i][j]);
				;
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

		int i;
		int j;

		do {

			i = rand.nextInt(0, tablero.length);
			j = rand.nextInt(0, tablero[0].length);

		} while (tablero[i][j] != '-');

		tablero[i][j] = 'O';

	}

	public static boolean usuarioMueveFicha(int i, int j) {
		boolean res = false;

		if (i >= 0 && j >= 0 && i < tablero.length && j < tablero[0].length && tablero[i][j] == '-') {

			tablero[i][j] = 'X';
			res = true;
		}

		return res;
	}

	public static void limpiaTablero() {

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = '-';
			}

		}
	}

	public static boolean esGanador(char caracter) {
		boolean res = false;

		int cont = 0;
		int i = 0;
		int j = 0;

		
		//horizontal
		while (i < tablero.length && !res) {

			while (j < tablero[0].length && !res) {

				if (tablero[i][j] == caracter) {

					cont+=1;
					if (cont == 3) {
						res = true;
					}

				}
				j++;

			}
			
			i++;
			j = 0;
			cont = 0;

		}


		i=0;

		
		//Vertical
		while (j < tablero[0].length && !res) {

			while (i < tablero.length && !res) {
				if (tablero[i][j] == caracter) {

					cont+=1;
					
					if (cont == 3) {
						res = true;
					}

				}
				i++;

			}
			cont = 0;
			i=0;
			j++;

			

		}
		
	
		j=0;

		while (i < tablero.length && j < tablero[0].length && !res) {

			if (tablero[i][j] == caracter) {

				++cont;

				if (cont == 3) {
					res = true;
				}
			}

			i++;
			j++;

		}

		cont = 0;
		j = 0;
		i = tablero.length - 1;
		while (i >= 0 && j < tablero[0].length && !res) {

			if (tablero[i][j] == caracter) {

				++cont;

				if (cont == 3) {
					res = true;
				}
			}

			i--;
			j++;

		}

		return res;
	}

}
