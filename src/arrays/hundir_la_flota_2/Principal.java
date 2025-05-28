package arrays.hundir_la_flota_2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[][] tablero;
		char[][] tableroJ1;
		char[][] tableroJ2;

		int numBarquitos;
		int fila;
		int columna;

		int contJ1 = 0;
		int contJ2 = 0;

		boolean acertar = true;

		System.out.println("Bienvenido al Hundir la Flota");

		System.out.println("Indica el tamaño del tablero");
		System.out.println("Filas:");
		fila = sc.nextInt();

		System.out.println("Columna:");
		columna = sc.nextInt();

		numBarquitos = (int) (Math.sqrt(fila * columna));

		tablero = HundirLaFlota.creaTablero(fila, columna);

		HundirLaFlota.generarBarquitos(tablero, numBarquitos);

		tableroJ1 = HundirLaFlota.inicializaTablero(fila, columna);
		tableroJ2 = HundirLaFlota.inicializaTablero(fila, columna);

		do {
			acertar = true;

			while (acertar && contJ1 != numBarquitos && contJ2 != numBarquitos) {

				System.out.println("Turno jugador 1");

				HundirLaFlota.pintaTablero(tableroJ1);

				if (HundirLaFlota.turnoJugador(tablero, tableroJ1)) {
					contJ1++;
					acertar = true;
				} else {
					acertar = false;
				}

			}

			acertar = true;

			while (acertar && contJ2 != numBarquitos && contJ1 != numBarquitos) {
				System.out.println("Turno jugador 2");

				HundirLaFlota.pintaTablero(tableroJ2);

				if (HundirLaFlota.turnoJugador(tablero, tableroJ2)) {
					contJ2++;
					acertar = true;
				} else {
					acertar = false;
				}

			}

		} while (contJ1 < numBarquitos && contJ2 < numBarquitos);

		if (contJ1 == numBarquitos) {
			System.out.println("Ha ganado el jugador 1");
		} else {
			System.out.println("Ha ganado el jugador 2");
		}

	}

}
