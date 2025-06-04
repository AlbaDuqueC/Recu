package string.criptograma;

import java.util.Random;

public class Criptograma {

	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	static String fraseReal="";
	
	static String fraseCodificada="";
	
	public static void desordenaAbecedario() {
		
		Random rand= new Random();
		
		int iRand;
		int jRand;
		
		char[][] nuevoAbecedario= new char[abecedario.length][abecedario.length];
		
		for(int i=0; i<abecedario.length; i++) {
			
			for(int j=0; j<abecedario.length; j++) {
				
				do {
				iRand=rand.nextInt(0, nuevoAbecedario.length);
				jRand=rand.nextInt(0, nuevoAbecedario[0].length);
				
				}while(nuevoAbecedario[iRand][jRand]);
				
			}
			
		}
		
		
		
		
	}
	
}
