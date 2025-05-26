package arrays;

import java.util.Scanner;

public class BuscaDelTesoro {

	public static char[][] tablero;
	public static int posI;
	public static int posJ;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numObstaculos;
		int filas = 0;
		int columnas = 0;

		System.out.println("Buesqueda del tesoro");

		do {

			try {
				System.out.println("Indique las dimensiones del tablero");
				System.out.println("Filas:");
				filas = sc.nextInt();

				System.out.println("Columnas:");
				columnas = sc.nextInt();

				assert (filas < 2 || columnas < 2) : "No puede ser menor a 2";
			
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			}

		} while (filas < 2 || columnas < 2);

		// inicializaTablero(filas, columnas)

	}

}
