package string.criptograma;

import java.util.Scanner;

public class PrincipalCriptograma {

	public static void main(String[] args) {
		
		Scanner sc=  new Scanner(System.in);
		
		int codigo;
		
		char letra;
		
		Criptograma.desordenaAbecedario();
		
		pintaAbecedario();
		
		Criptograma.eligeFrase();
		
		Criptograma.codificaFrase();
		
		while(!Criptograma.sonIguales()) {
			
			System.out.println(Criptograma.fraseCodificada);
			
			System.out.println("Introfuce el cogido y la letra que quieras descodificar: ");
			
			codigo=sc.nextInt();
			
			letra=sc.next().charAt(0);
			
			if(Criptograma.compruebaCodigo(codigo, letra)) {
				
				System.out.println("Has acertado");
				
			}else {
				System.out.println("No ha acertado");
			}
			
		}
		
		System.out.println("ENHORABUENA HAS ACERTADO");

	}
	
	public static void pintaAbecedario() {
		
		for(int i=0; i<Criptograma.abecedario.length; i++) {
			
			for(int j=0; j<Criptograma.abecedario[i].length; j++) {
				
				System.out.print(Criptograma.abecedario[i][j]);
				
			}
			
			System.out.println();
			
		}
		
		
	}

}
