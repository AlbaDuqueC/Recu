package arrays.conecta4;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		Jugador4Raya J1= new Jugador4Raya("Juana", "X");
		Jugador4Raya J2= new Jugador4Raya("Pepa", "O");
		
		Jugador4Raya JugadorPrincipal;
		
		int turno;
		
		int columna;
		int fila;
		
		String res;
		
		int i;
		int j;
		
		System.out.println("BIENVENIDO AL 4 EN RAYA");
		
		do {
			
		System.out.println("Inserte el tamaño del tablero:");
		
		i=sc.nextInt();
		j=sc.nextInt();
			
		Jugador4Raya.setTablero(i, j);
		
		Jugador4Raya.limpiarTablero();
		
		turno=jugadorInicial();
		
		do {
			
			JugadorPrincipal= turno==1? J1 : J2;
			
			
			
			System.out.println(JugadorPrincipal.toString());
			
			System.out.println("Ingrese la columna a la que quieras insertar la pieza:");
			columna=sc.nextInt();
			
			if(JugadorPrincipal.colocarFicha(columna)) {
				
				turno= turno==1?2:1;
				
			}
			
			
		}while(!JugadorPrincipal.esGanador(columna) && !Jugador4Raya.empate());
		
			JugadorPrincipal= turno==1? J2 : J1;
			
			System.out.println(JugadorPrincipal.toString());
		
			if(!Jugador4Raya.empate()) {
			
			System.out.println("\u001B[33m"+"HA GANADO "+ JugadorPrincipal.getNombre()+ "\u001B[0m");
			
			}else {
				System.out.println("\u001B[36m"+"EMPATE"+ "\u001B[0m");
			}
			
			System.out.println("Quisiera volver a jugar? (S/N)");
			
			res=sc.next();
		
		}while(res.equalsIgnoreCase("S"));
		
		System.out.println("saliendo del programa...");
		
	}
	
	public static int jugadorInicial() {

		Random rand = new Random();

		return rand.nextInt(1, 3);

	}

	
	
}
