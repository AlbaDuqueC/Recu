package arrays.busquedadeltesoro;

import java.util.Random;

public class BusquedaDelTesoro {


	public static char[][] tablero;
	public static int posI;
	public static int posJ;

	public static void inicializaTablero(int numFilas, int numColumnas) {

		tablero = new char[numFilas][numColumnas];

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {

				tablero[i][j] = ' ';

			}

		}

	}

	public static void generaPosicionTesoro() {

		Random rand = new Random();
		
		int iX = rand.nextInt(tablero.length);
		int jX = rand.nextInt(tablero[0].length);

		tablero[iX][jX] = 'X';

	}

	public static void generaObstaculos(int numObstaculos) {

		Random rand = new Random();
		
		int cont = 0;
		int iO;
		int jO;

		while (cont < numObstaculos) {

			iO = rand.nextInt(tablero.length);
			jO = rand.nextInt(tablero[0].length);
			
			if(tablero[iO][jO]==' ' && !obstaculosAlrededor(iO, jO)) {
				
				tablero[iO][jO]='*';
				
				cont++;
				
			}

			
		}

	}
	
	public static boolean obstaculosAlrededor(int iRand , int jRand) {
		
		boolean res=false;
		
		int i= (iRand -1)<0 ? (iRand+1) : (iRand-1);
		int j;
		
		while(i<=iRand+1 && i<tablero.length && !res) {
			
			j=(jRand-1)<0 ? (jRand+1) : (jRand -1);
			
			while(j<=jRand+1 && j<tablero[0].length && !res) {
				
				if(tablero[i][j]=='*') {
					res=true;
				}
				
				j +=2;
				
			}
			
			i += 2;
			
		}
		
		return res;
		
	}

	public static void generaPosicionJugador() {

		Random rand = new Random();
		
		do {

			posI = rand.nextInt(0, tablero.length);
			posJ = rand.nextInt(0, tablero[0].length);

			
		} while (tablero[posI][posJ] != ' ');

	}

	public static void pintaTablero() {

		for (int j = 1; j <= tablero[0].length; j++) {
			System.out.print(" \t" + (j));
		}

		System.out.println();

		for (int i = 0; i < tablero.length; i++) {

			System.out.print(i + 1);

			for (int j = 0; j < tablero[i].length; j++) {

				if ( i == posI && j == posJ) {

					System.out.print("\tJ");

				} else if (tablero[i][j] == 'X') {

					System.out.print("\t ");
				} else {
					System.out.print("\t"+tablero[i][j]);
				}

			}
			System.out.println();

		}

	}

	public static int mueveJugador(String movimiento) {

		int res = 0;

		switch (movimiento.toUpperCase()) {

		case "ARRIBA" -> {
			if (posI - 1 >= 0 && tablero[posI - 1][posJ] != '*') {
				posI--;
			} else {
				res = -1;
			}
		}
		case "ABAJO" -> {
			if (posI + 1 <tablero.length && tablero[posI + 1][posJ] != '*') {
				posI++;
			} else {
				res = -1;
			}
		}
		case "DERECHA" -> {
			if (posJ + 1 <tablero[0].length && tablero[posI][posJ + 1] != '*') {
				posJ++;
			} else {
				res = -1;
			}
		}
		case "IZQUIERDA" -> {
			if (posJ - 1 >= 0 && tablero[posI][posJ - 1] != '*') {
				posJ--;
			} else {
				res = -1;
			}
		}
		default -> {
			res = -2;
		}

		}

		return res;

	}

}
