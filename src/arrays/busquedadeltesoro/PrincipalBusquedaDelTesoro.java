package arrays.busquedadeltesoro;

import java.util.Scanner;

public class PrincipalBusquedaDelTesoro {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numObstaculos;
		int filas = 0;
		int columnas = 0;
		String movimiento;
		int respuesta = 0;

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

		BusquedaDelTesoro.inicializaTablero(filas, columnas);

		numObstaculos = (int) ((Math.sqrt(filas * columnas)) / 2);

		BusquedaDelTesoro.generaPosicionTesoro();

		BusquedaDelTesoro.generaObstaculos(numObstaculos);

		BusquedaDelTesoro.generaPosicionJugador();

		do {
			
			BusquedaDelTesoro.pintaTablero();

			System.out.println("Indica a que direccion quieres que se mueva el jugador:");
			movimiento = sc.next();

			respuesta = BusquedaDelTesoro.mueveJugador(movimiento);

			if (respuesta == -2) {

				System.out.println("Vuelve a introducir bien la dirección");

			} else if (respuesta == -1) {
				System.out.println("Te has chocado");
			}

		} while (BusquedaDelTesoro.tablero[BusquedaDelTesoro.posI][BusquedaDelTesoro.posJ] != 'X');

		System.out.println("ENORABUENAS HAS ENCONTRADO EL TESORO");

	}

}
