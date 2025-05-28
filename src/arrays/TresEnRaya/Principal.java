package arrays.TresEnRaya;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int turno = 0;
		int turnoAnterior=0;
		int posI;
		int posJ;
		boolean empate = true;
		String respuesta;

		System.out.println("Bienvenido al Tes en Raya");

		do {

			TresEnRaya.limpiaTablero();

			turno = TresEnRaya.jugadorInicial();

			if (turno == 1) {
				System.out.println("Empieza el usuario");
			} else {
				System.out.println("Empieza el progrma");
			}

			do {
				
				empate=true;

				System.out.println();
				
				TresEnRaya.imprimeTablero();

				switch (turno) {

				case 1 -> {
					do {

						System.out.println("Indica donde quiere colocar la ficha");
						System.out.println("Fila:");
						posI = sc.nextInt();
						System.out.println("Columna:");
						posJ = sc.nextInt();

					} while (!TresEnRaya.usuarioMueveFicha(posI, posJ));
					
					
				}
				case 0 -> {

					TresEnRaya.mueveFichaAleatoria();
					
				}

				}
				turnoAnterior = turno;
				turno=turno==1?0:1;

				for (int i = 0; i < TresEnRaya.tablero.length; i++) {
					for (int j = 0; j < TresEnRaya.tablero[i].length; j++) {
						if (TresEnRaya.tablero[i][j] == '-') {
							empate = false;
						}
					}
				}
				

			} while (!TresEnRaya.esGanador(turnoAnterior == 1 ? 'X' : 'O') && !empate);

			if (empate) {
				System.out.println("EMPATE");
			} else if (turnoAnterior == 1) {
				System.out.println("USUARIO GANADOR");
			} else {
				System.out.println("PROGRAMA GANADOR");
			}

			System.out.println("Quiere volver a jugar? (S/N)");
			respuesta = sc.next();

		} while (respuesta.equalsIgnoreCase("S")? true : false);
		
		System.out.println("Saliendo...");

	}

}
