package string.escalera;

import java.util.Scanner;

public class PrincipalEscalera {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String palabra = "";

		int intentos = 0;		

		Escaleras.seleccionaJuego();

		System.out.println("Juego seleccionado: " + Escaleras.palabraInicio + " - " + Escaleras.palabraObjetivo);

		do {

			do {

				System.out.println("\nIntroduce una palabra de 4 carateres: ");

				palabra = sc.next().toUpperCase();

			} while (palabra.length() != 4 || !Escaleras.compruebaIntento(palabra));

			Escaleras.jugada += " - " + palabra;
			
			++intentos;

			System.out.println(Escaleras.jugada);

		} while (intentos < Escaleras.NUMINTENTOS && !palabra.equals(Escaleras.palabraObjetivo));

		if (palabra.equals(Escaleras.palabraObjetivo)) {
			
			System.out.println("ENHORABUENA!!! HAS ALCANZADO LA PALABRA ");
			
		} else  {
			
			System.out.println("Se te acabaron los intentos...");
		}

	}

}
