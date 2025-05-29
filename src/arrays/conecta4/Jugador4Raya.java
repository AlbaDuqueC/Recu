package arrays.conecta4;

public class Jugador4Raya {
	
	private static char[][] tablero;
	private String nombre;
	private char caracter;
	
	public Jugador4Raya(String nombre, String caracter) {
		
		if(nombre!=null && !nombre.isBlank()) {
			this.nombre=nombre;
		}
		
		if(caracter!=null && !nombre.isBlank()) {
			
			this.caracter= caracter.charAt(0);
			
		}
		
	}

	public static char[][] getTablero() {
		return tablero;
	}

	public static void setTablero(char[][] tablero) {
		Jugador4Raya.tablero = tablero;
	}

	public String getNombre() {
		return nombre;
	}


	public char getCaracter() {
		return caracter;
	}

	
	@Override
	public String toString() {
		
		String res="TURNO DEL JUGADO "+this.nombre;
		
		for(int i=0; i<tablero.length; i++) {
			
			for(int j=0; j<tablero.length; j++) {
				
			}
			
		}
		
		
		
		return res;
	}
	

}
