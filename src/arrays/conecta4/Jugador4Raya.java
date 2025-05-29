package arrays.conecta4;

public class Jugador4Raya {

	private static char[][] tablero;
	private String nombre;
	private char caracter;

	public Jugador4Raya(String nombre, String caracter) {

		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}

		if (caracter != null && !nombre.isBlank()) {

			this.caracter = caracter.charAt(0);

		}

	}

	public static char[][] getTablero() {
		return tablero;
	}

	public static void setTablero(int i, int j) {

		Jugador4Raya.tablero = new char[i][j];
	}

	public String getNombre() {
		return nombre;
	}

	public char getCaracter() {
		return caracter;
	}

	public boolean colocarFicha(int columna) {

		boolean res = false;

		int i = tablero.length - 1;

		while (i >= 0 && !res) {

			if (tablero[i][columna] == ' ') {

				res = true;

				tablero[i][columna] = this.caracter;

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

	public boolean esGanador(int columna) {

		boolean res = false;

		boolean encontrado = false;

		int cont = 0;

		int i = 0;

		int iAnt;
		int jAnt;

		// Encontrar la i

		while (i < tablero.length && !encontrado) {

			if (tablero[i][columna] == this.caracter) {

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

				if (tablero[iAnt][jAnt] == this.caracter) {
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
		cont = 0;
		iAnt = i;
		jAnt = columna - 3;

		while (jAnt <= columna + 3 && !res) {

			if (jAnt < tablero[0].length && jAnt >= 0) {

				if (tablero[iAnt][jAnt] == this.caracter) {
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
		cont = 0;
		iAnt = i + 3;
		jAnt = columna;

		while (iAnt >= i - 3 && !res) {

			if (iAnt < tablero.length && iAnt >= 0) {

				if (tablero[iAnt][jAnt] == this.caracter) {
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
		cont = 0;
		iAnt = i - 3;
		jAnt = columna - 3;

		while (iAnt <= i + 3 && jAnt <= i + 3 && !res) {

			if (iAnt < tablero.length && iAnt >= 0 && jAnt < tablero[0].length && jAnt >= 0) {

				if (tablero[iAnt][jAnt] == this.caracter) {
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

	public static boolean empate() {
		boolean res = true;

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[0].length; j++) {

				if (tablero[i][j] == ' ') {

					res = false;
				}

			}

		}

		return res;

	}

	@Override
	public String toString() {

		String res = "TURNO DEL JUGADO " + this.nombre + "\n  ";

		for (int i = 0; i < tablero.length; i++) {

			res += (" " + i);

		}
		res += "\n";

		for (int i = 0; i < tablero.length; i++) {

			res += ("  |");

			for (int j = 0; j < tablero[0].length; j++) {

				res += (tablero[i][j] + "|");

			}

			res += "\n";
		}

		return res;
	}

}
