package arrays;

import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		char[][] tablero;
		char[][] tableroJ1;
		char[][] tableroJ2;

		int numBarquitos;
		int filas;
		int columnas;

		int barquitosJ1 = 0;
		int barquitosJ2 = 0;

		System.out.println("HUNDIR LA FLOTA");

		System.out.println("Indica las dimensiones del tablero:");
		System.out.println("Filas:");
		filas = sc.nextInt();
		System.out.println("Columnas:");
		columnas = sc.nextInt();

		tablero=creaTablero(filas, columnas);

		numBarquitos = (int) Math.sqrt(filas * columnas);
		
		generarBarquitos(tablero, numBarquitos);

		tableroJ1=inicializaTablero(filas, columnas);
		tableroJ2=inicializaTablero(filas, columnas);
		
		
		
		do {
			
			
			System.out.println("Jugador 1:");
			
			pintaTablero(tableroJ1);
			while( barquitosJ1<numBarquitos && turnoJugador(tablero, tableroJ1) ){
				
				barquitosJ1++;
				
			}
			
		if(barquitosJ1!=numBarquitos) {	
			
			
			System.out.println("Jugador 2:");
			pintaTablero(tableroJ2);
			while(barquitosJ2<numBarquitos && turnoJugador(tablero, tableroJ2) ) {
				
				barquitosJ2++;
				
			}
		}
			
			
			
		}while(barquitosJ1<numBarquitos && barquitosJ2<numBarquitos);
		
		System.out.println("HAS GANADO " + (barquitosJ1==numBarquitos ? "Jugador 1" : "Jugador 2"));

	}

	public static char[][] inicializaTablero(int filas, int columnas) {

		char[][] tablero = new char[filas][columnas];

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {

				tablero[i][j] = '-';

			}

		}

		return tablero;

	}

	public static char[][] creaTablero(int filas, int columnas) {

		char[][] tablero = new char[filas][columnas];

		for (int i = 0; i < tablero.length; i++) {

			for (int j = 0; j < tablero[i].length; j++) {

				tablero[i][j] = 'A';

			}

		}

		return tablero;

	}
	
	public static void generarBarquitos(char tablero[][], int numBarquitos) {
		
		Random rand= new Random();
		
		int barquitos=numBarquitos;
		int fila;
		int colum;
		
		while(barquitos>0) {
			
			fila=rand.nextInt(tablero.length);
			colum=rand.nextInt(tablero[0].length);
			
			if(tablero[fila][colum]=='A') {
				
				tablero[fila][colum]='B';
				
				barquitos--;
				
			}
			
		}
		
		
	}
	
	public static void pintaTablero(char tableroJ[][]) {
		
		char letra='A';
		
		System.out.print(" ");
		for(int i=0; i<tableroJ[0].length; i++) {
			
			System.out.print("\t"+(i+1));
		}
		System.out.println();
		
		for(int i=0; i<tableroJ.length; i++) {
			
			System.out.print(letra);
			
			for(int j=0; j<tableroJ[i].length; j++) {
			
				System.out.print("\t"+tableroJ[i][j]);
			}
			
			System.out.println();
			letra++;
			
		}
		
	}
	
	public static boolean turnoJugador(char tablero[][], char tableroJ[][]) {
		
		boolean acertar=false;
		
		char fila;
		int columna;
		
		System.out.println("Introduzca la fila y la columna que quieras descubrir:");
		
		System.out.println("Fila:");
		
		fila=sc.next().toUpperCase().charAt(0);
		
		System.out.println("Columna:");
		
		columna=sc.nextInt();
		
		if(tablero[fila-'A'][columna-1]=='B') {
			
			acertar=true;
			System.out.println("HUNDIDO");
			
		}else {
			System.out.println("AGUA");
		}
		
		tableroJ[fila-'A'][columna-1]=tablero[fila-'A'][columna-1];
		
		return acertar;
		
	}

}
