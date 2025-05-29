package arrays.hundirlaflota1;

import java.util.Random;
import java.util.Scanner;

public class JugadorHundirLaFlota {

	public static char[][] tableroPrincipal;
	private char[][] tablero;
	private String nombre;
	private int cont=0;

	public JugadorHundirLaFlota(String nombre) {

		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}

	}

	public static char[][] getTableroPrincipal() {
		return tableroPrincipal;
	}

	public char[][] getTablero() {
		return tablero;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	

	public int getCont() {
		return cont;
	}

	public void setCont() {
		this.cont +=1;
	}

	public void inicializaTablero(int filas, int columnas) {

		this.tablero = new char[filas][columnas];

		for (int i = 0; i < this.tablero.length; i++) {

			for (int j = 0; j < this.tablero[i].length; j++) {

				this.tablero[i][j] = '-';

			}

		}

	}

	public static void creaTablero(int filas, int columnas) {

		tableroPrincipal = new char[filas][columnas];

		for (int i = 0; i < tableroPrincipal.length; i++) {

			for (int j = 0; j < tableroPrincipal[i].length; j++) {

				tableroPrincipal[i][j] = 'A';

			}

		}

	}

	public static void generarBarquitos(int numBarquitos) {

		Random rand = new Random();

		int barquitos = numBarquitos;
		int fila;
		int colum;

		while (barquitos > 0) {

			fila = rand.nextInt(tableroPrincipal.length);
			colum = rand.nextInt(tableroPrincipal[0].length);

			if (tableroPrincipal[fila][colum] == 'A') {

				tableroPrincipal[fila][colum] = 'B';

				barquitos--;

			}

		}

	}

	public boolean turnoJugador() {

		Scanner sc= new Scanner(System.in);
		boolean acertar = false;

		char fila;
		int columna;

		System.out.println("Introduzca la fila y la columna que quieras descubrir:");

		System.out.println("Fila:");

		fila = sc.next().toUpperCase().charAt(0);

		System.out.println("Columna:");

		columna = sc.nextInt();

		if (tableroPrincipal[fila - 'A'][columna - 1] == 'B') {

			acertar = true;
			System.out.println("HUNDIDO");

		} else {
			System.out.println("AGUA");
		}

		this.tablero[fila - 'A'][columna - 1] = tableroPrincipal[fila - 'A'][columna - 1];

		return acertar;

	}

	@Override
	public String toString() {

		String res = "TABLERO DE " + this.nombre + "\n ";

		char letra = 'A';

		for (int i = 0; i < this.tablero[0].length; i++) {

			res += ("\t" + (i + 1));
		}
		res += "\n";

		for (int i = 0; i < this.tablero.length; i++) {

			res += (letra);

			for (int j = 0; j < this.tablero[i].length; j++) {

				res += ("\t" + this.tablero[i][j]);
			}

			res += "\n";
			letra++;

		}

		return res;

	}

}
