package arrays.hundirlaflota1;

import java.util.Scanner;

public class HundirLaFlota {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		JugadorHundirLaFlota JugadorPrincipal;

		JugadorHundirLaFlota J1 = new JugadorHundirLaFlota("Pepa");
		JugadorHundirLaFlota J2 = new JugadorHundirLaFlota("Juana");

		int numBarquitos;
		int filas;
		int columnas;

		System.out.println("HUNDIR LA FLOTA");

		System.out.println("Indica las dimensiones del tablero:");
		System.out.println("Filas:");
		filas = sc.nextInt();
		System.out.println("Columnas:");
		columnas = sc.nextInt();

		JugadorHundirLaFlota.creaTablero(filas, columnas);

		numBarquitos = (int) Math.sqrt(filas * columnas);

		JugadorHundirLaFlota.generarBarquitos(numBarquitos);

		J1.inicializaTablero(filas, columnas);
		J2.inicializaTablero(filas, columnas);

		JugadorPrincipal = J2;

		do {

			JugadorPrincipal = JugadorPrincipal == J1 ? J2 : J1;

			System.out.println(JugadorPrincipal.toString());

			while (JugadorPrincipal.getCont() < numBarquitos && JugadorPrincipal.turnoJugador()) {

				JugadorPrincipal.setCont();

				
				

			}

		} while (JugadorPrincipal.getCont() < numBarquitos);

		System.out.println("HAS GANADO " + (JugadorPrincipal.getNombre()));

	}

}
