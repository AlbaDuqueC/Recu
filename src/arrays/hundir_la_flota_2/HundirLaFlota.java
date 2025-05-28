package arrays.hundir_la_flota_2;

import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {

	public static char[][] inicializaTablero(int filas, int columnas) {

		char[][] tablero = new char[filas][columnas];

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[0].length; j++) {

				tablero[i][j] = '-';

			}

		}

		return tablero;

	}

	public static char[][] creaTablero(int filas, int columnas) {

		char[][] tablero = new char[filas][columnas];

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[0].length; j++) {

				tablero[i][j] = 'A';

			}

		}

		return tablero;

	}
	
	public static void generarBarquitos(char tablero[][], int numBarquitos) {
		
		Random rand = new Random();
		
		int cont=0;
		
		int i;
		int j;
		
		while(cont<numBarquitos) {
			
			i=rand.nextInt(0, tablero.length);
			j=rand.nextInt(0, tablero[0].length);
			
			if(tablero[i][j]!='B') {
				
				tablero[i][j]='B';
				
				cont++;
				
			}
			
		}
		
	}
	
	public static void pintaTablero(char tableroJugador[][]) {
		
		char letra='A';
		
		for(int j=0; j<tableroJugador[0].length ; j++) {
			
			System.out.print("\t"+j);
			
		}
		System.out.println();
		
		for(int i=0; i<tableroJugador.length; i++) {
			
			System.out.print(letra);
			letra++;
			
			for(int j=0; j<tableroJugador[0].length; j++) {
				
				System.out.print("\t" + tableroJugador[i][j]);
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean res=false;
		
		char letraFila;
		
		int columna;
		
		System.out.println("Introduzca la fila mediante una letra:");
		
		letraFila=sc.next().charAt(0);
		
		System.out.println("Introduzca el número de columna:");
		
		columna=sc.nextInt();
		
		if(tablero[letraFila-65][columna]=='B') {
			
			res=true;
			
			System.out.println("HUNDIDO");
			
		}else {
			System.out.println("AGUA");
		}
		
		tableroJugador[letraFila-65][columna]=tablero[letraFila-65][columna];
		
		return res;
		
	}

}
