package string.recuJunio;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// Abrimosel scanner
		Scanner sc = new Scanner(System.in);

		// Objeto Mastermind
		Mastermind jugador;

		// Contador de intentos
		int contIntentos = 0;

		// Cadena que almacena el intento del jugador
		String intento = "";

		// Da la bienvenida al juego
		System.out.println("¡¡BIENVENIDO AL JUEGO MASTERMIND!!");
	

		// Crea el objeto Mastermind
		jugador = new Mastermind();
		System.out.println(jugador.getCodigo());

		do {

			do {

				// Pide que introduzcamos el codigo
				System.out.println("Introduzca el codigo de colores:");

				// Escanea el codigo y lo pone todo en mayusculas
				intento = sc.next().toUpperCase();

				// Si la longitud de la cadena no es 5, volvera a preguntar
			} while (intento.length() != 5 || !letrasCorrectas(intento, jugador));

			// Sumamos uno al contador
			++contIntentos;

			// Llama a la funcion que comprueba el codigo
			jugador.compruebaCodigo(intento);

			// Imprime todos los intentos del jugador
			System.out.println(jugador.getIntentosPrevios());

			// Numero de intentos que lleva el jugador
			System.out.println("Numero de intentos: " + contIntentos);

			// Si no ha hacertado el codigo o si no ha gastado todos los intentos, volvera a
			// entrar al bucle
		} while (!intento.equals(jugador.getCodigo()) && contIntentos < jugador.getNumIntentos());

		// Si es el mismo codigo se metera en el if
		if (intento.equals(jugador.getCodigo())) {

			// E imprime que has ganado
			System.out.println("ENHORABUENA HAS ACERTADO :) ");

		} else {

			// Si no imprime que has perdido y el codigo que era
			System.out.println("SE TE ACABARON LOS INTENTOS :( ");
			System.out.println("El codigo era " + jugador.getCodigo());

		}

		// Cierra el scanner
		sc.close();

	}

	/**
	 * Funcion que comprueba si todas las letras del codigo estan dentro de los
	 * colores
	 * 
	 * @param intento el intento del jugador
	 * @param jugador el jugador que esta participando
	 * @return devuelve un boolean, si esta devuelve true y si hay alguna letra que
	 *         no esta devuelve false
	 */
	public static boolean letrasCorrectas(String intento, Mastermind jugador) {

		boolean res = true;

		boolean esta = false;

		int j = 0;

		String colores = jugador.getColores();

		int i = 0;

		while (i < intento.length() && res) {

			j = 0;

			esta = false;

			while (j < colores.length() && !esta) {

				if (intento.charAt(i) == colores.charAt(j)) {

					esta = true;

				}

				++j;
			}

			res = esta;

			++i;

		}

		return res;

	}

}
