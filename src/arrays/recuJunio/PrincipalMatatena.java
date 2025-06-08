package arrays.recuJunio;

import java.util.Random;
import java.util.Scanner;

public class PrincipalMatatena {

	public static void main(String[] args) {

		// Creamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Creamos un objeto de tipo JugadorMatatena llamado jugador1
		JugadorMatatena jugador1;

		// Creamos un objeto de tipo JugadorMatatena llamado jugador2
		JugadorMatatena jugador2;

		// Creamos un objeto de tipo JugadorMatatena llamado jugadorPrincipal
		JugadorMatatena jugadorPrincipal;

		// Variable de tipo String donde almacenara el nombre del jugador
		String nombre;

		// Variable de tipo entero donde almacenara el valor del dado
		int dado;

		// Variable donde almacenara la columna seleccionada por el jugador
		int columna;

		// Te da la bienvenida al juego
		System.out.println("¡Bienvenido al juego Matatena!\n");

		// Te pide que introduzcas los nombres de cada jugador
		System.out.println("Introduce los nombres de los jugadores:");

		// Pide el nombre del jugador 1
		System.out.println("Jugador 1:");

		// Escanea el nombre introducido por consola y lo guarda en la variable
		nombre = sc.next();

		// Introduce los datos del jugador 1 (el nombre)
		jugador1 = new JugadorMatatena(nombre);

		// Pide el nombre del jugador 2
		System.out.println("Jugador 2:");

		// Escanea el nombre introducido por consola y lo guarda en la variable
		nombre = sc.next();

		// Introduce los datos del jugador 2 (el nombre)
		jugador2 = new JugadorMatatena(nombre);

		// Llama a la funcion jugadorRand() si esta devuelve un 2 el jugadorPrincipal
		// sera el uno, ya que despues se cambiara a la inversa (se pondra al jugador
		// 2), si no se igualara al jugador 2 (y este despues sera el jugador 1)
		jugadorPrincipal = jugadorRand() == 2 ? jugador1 : jugador2;

		do {

			// Si antes el jugadorPrincipal era el 2, se cambiara al 1 y bicebersa
			jugadorPrincipal = jugadorPrincipal == jugador2 ? jugador1 : jugador2;

			// Muestra el tablero, nombre y puntuacion del jugador 1
			System.out.println(jugador1.toString());

			// Muestra el tablero, nombre y puntuacion del jugador 2
			System.out.println(jugador2.toString());

			// Indica el turno del jugador
			System.out.println("Turno de " + jugadorPrincipal.getNombre());

			// Introduce el valor aleatorio al dado
			dado = tirarDado();

			// Muestra el valor del dado por pantalla
			System.out.println("Valor del dado: " + dado);

			do {

				// Pregunta en que columna queremos insertar el valor del dado
				System.out.println("¿En que columna quieres insertar el dado?");

				// Escanea el valor de la columna
				columna = sc.nextInt();

				// Si no se puede colocar el dado entrara otra vez en el bucle y volvera a
				// preguntar la columna
			} while (!jugadorPrincipal.colocaDado(columna, dado));

			// Si el jugador principal es el 1 entrara en el if
			if (jugadorPrincipal == jugador1) {

				// Eliminara un valor al contrigante si esta el valor del dado en la columna
				// seleccionada
				jugador2.eliminarValores(columna, dado);

				// Si el jugador principal es el 2
			} else {

				// Eliminara un valor al contrigante si esta el valor del dado en la columna
				// seleccionada
				jugador1.eliminarValores(columna, dado);

			}

			// Calcula la puntuacion del jugador 1
			jugador1.calculaPuntuacion();

			// Calcula la puntuacion del jugador 2
			jugador2.calculaPuntuacion();

			// Si el tablero del jugador principal esta completo, saldrá del bucle
		} while (!jugadorPrincipal.tableroCompleto());
		
		//Imprime los resultados de la puntuacion de cada jugador
		System.out.println("\nPUNTUACIONES:");
		
		//Imprime la puntuacion del jugador 1
		System.out.println(jugador1.getNombre()+ ": " + jugador1.getPuntuacion() + " puntos");
		
		//Imprime la puntuacion del jugador 2
		System.out.println(jugador2.getNombre()+ ": " + jugador2.getPuntuacion() + " puntos");

		// Si el jugador 1 tiene mas puntuacion que le jugador 2
		if (jugador1.getPuntuacion() > jugador2.getPuntuacion()) {

			// Imprime que ha ganado y la puntuacion que tiene
			System.out.println("HA GANADO " + jugador1.getNombre() + " CON " + jugador1.getPuntuacion() + " PUNTOS");

			// Si el jugador 1 tiene menos puntuacion que el jugador 2
		} else if (jugador1.getPuntuacion() < jugador2.getPuntuacion()) {

			// Imprime que ha ganado el jugador 2 y su puntuacion
			System.out.println("HA GANADO " + jugador2.getNombre() + " CON " + jugador2.getPuntuacion() + " PUNTOS");

			// Si no
		} else {

			// Imprime que han quedado empate
			System.out.println("HAN QUEDADO EMPATE CON LAS PUNTUACIONES " + jugador1.getPuntuacion() + " y "
					+ jugador2.getPuntuacion());

		}

		// Scanner cerrado
		sc.close();

	}

	/**
	 * Funcion que selecciona aleatoriamente el jugador que empezara 
	 * @return devuelve el resultado de la seleccion aleatoria (1 o 2)
	 */
	public static int jugadorRand() {

		//Creamos el random
		Random rand = new Random();

		//Le damos el valor a jugador del 1 al 2
		int jugador = rand.nextInt(1, 3);

		//Devolvemos jugador
		return jugador;
	}

	/**
	 * Funcion que selecciona aleatoriamente el valor del dado
	 * 
	 * @return devuelve el valor seleccionado aleatoriamente del dado (del 1 al 6)
	 */
	public static int tirarDado() {

		//Creamos el random
		Random rand = new Random();

		//Le damos el calor a dado del 1 al 6
		int dado = rand.nextInt(1, 7);

		//Devolvemos dado
		return dado;

	}

}

