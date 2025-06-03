package string.ahorcado;

import java.util.Scanner;

public class PrincipalAhorcado {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int resMenu;
		
		String palabra;
		char letra;
		
		int cont=0;
		
		boolean acertar=false;
		
		Ahorcado.generaPalabra();
		
		System.out.println(Ahorcado.palabraPista);
		
		while(!acertar && cont<Ahorcado.NUMINTENTOS) {
			
			menu();
			
			resMenu=sc.nextInt();
			
			switch (resMenu) {
			case 1-> {
				
				letra=sc.next().charAt(0);
				
				if(!Ahorcado.compruebaLetra(letra)) {
					
					++cont;
					
				}
				
			}
			case 2->{
				
				palabra=sc.next();
				
				Ahorcado.compruebaPalabra(palabra);
				
			}
			}
			
			Ahorcado.pintaPista();
			
			if(Ahorcado.palabraPista.equals(Ahorcado.palabraSecreta)) {
				acertar=true;
				
				System.out.println("¡¡ENHORABUENA!! HAS ACERTADO");
			}else {
				
				if(cont==Ahorcado.NUMINTENTOS){
					System.out.println("GAME OVER");
				}
			}
			
			
		}
		
		System.out.println("Saliendo...");
		
	}
	
	private static void menu() {
		
		System.out.println("1.Introducir una letra");
		System.out.println("2.Introducir una palabra");
		
	}

}
