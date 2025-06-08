package arrays.recuJunio;

public class JugadorMatatena {

	/**
	 * Array que almacenara todos los valores enteros que vayamos introduciendo,
	 * cada jugador tendra el suyo propio.
	 */
	private int[][] tablero = new int[3][3];

	/**
	 * String que alacenara el nombre del jugador.
	 */
	private String nombre;

	/**
	 * Atributo de tipo entero que almacenara la puntuacion de cada jugador.
	 */
	private int puntuacion = 0;

	/**
	 * Contructor de la funcion donde se insertara y comprobara el valor pasado por
	 * parametro
	 * 
	 * @param nombre Parametro de tipo String que corresponde con el nombre del
	 *               jugador
	 */
	public JugadorMatatena(String nombre) {

		if (nombre != null && !nombre.isBlank()) {

			this.nombre = nombre;

		}

	}

	/**
	 * Metodo que devuelve el nombre del jugador.
	 * 
	 * @return devuelve el nombre del jugador.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que devuelve la puntuación del jugador.
	 * 
	 * @return devuleve la puntuación del jugador.
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Funcion que sirve para colocar el dado que ha sacado el jugador en el
	 * tablero, teniendo en cuenta que se insertara en el primer hueco vacio de la
	 * columna seleccionada.
	 * 
	 * @param columna valor entero pasado por parametro que indica la columna
	 *                seleccionada.
	 * @param dado    valor entero pasado por parametro que indica el valor del dado
	 *                que ha salido.
	 * @return devuelve true si se ha podido insertar en la columna, si no hay hueco
	 *         devolvera false
	 */
	public boolean colocaDado(int columna, int dado) {

		boolean res = false;
		int i = 0;

		if (columna > 0 && columna <= this.tablero[0].length) {

			while (i < this.tablero.length && !res) {

				if (tablero[i][columna - 1] == 0) {

					tablero[i][columna - 1] = dado;
					res = true;

				} else {
					i++;
				}

			}
		}

		return res;

	}

	/**
	 * Funcion que calcula la puntuacion total del jugador y la inserta en el
	 * atributo puntuación. Si hay en la misma columna tres numeros iguales, el
	 * resultado de la suma de estos se multiplicara por tres. Si hay dos numero
	 * iguales, el resultado de la suma de estos se multiplicara por 2 y se le
	 * sumara al otro restante. Si no hay ningun numero igual, se sumara.
	 */
	public void calculaPuntuacion() {

		int res = 0;

		int i = 0;

		for (int j = 0; j < this.tablero[0].length; j++) {

			if (this.tablero[i][j] == this.tablero[i + 1][j] && this.tablero[i + 1][j] == this.tablero[i + 2][j]) {

				res += (this.tablero[i][j] + this.tablero[i + 1][j] + this.tablero[i + 2][j]) * 3;

			} else if (this.tablero[i][j] == this.tablero[i + 1][j]) {

				res += ((this.tablero[i][j] + this.tablero[i + 1][j]) * 2) + this.tablero[i + 2][j];

			} else if (this.tablero[i][j] == this.tablero[i + 2][j]) {

				res += ((this.tablero[i][j] + this.tablero[i + 2][j]) * 2) + this.tablero[i + 1][j];

			} else if (this.tablero[i + 1][j] == this.tablero[i + 2][j]) {

				res += ((this.tablero[i + 1][j] + this.tablero[i + 2][j]) * 2) + this.tablero[i][j];

			} else {

				res += this.tablero[i][j] + this.tablero[i + 1][j] + this.tablero[i + 2][j];

			}

		}

		this.puntuacion = res;

	}

	/**
	 * Funcion que elimina todos los atributos que sean iguales al parametro dado de
	 * entrada en la columna introducida por parametro.
	 * 
	 * @param columna Parametro de entra de tipo entero el cual su valor es la
	 *                columna del jugador contrario.
	 * @param dado    Parametro de entrada de tipo entero el cual su valor es el
	 *                numero que ha salido al contrincante.
	 */
	public void eliminarValores(int columna, int dado) {

		for (int i = 0; i < this.tablero.length; i++) {

			if (this.tablero[i][columna - 1] == dado) {

				this.tablero[i][columna - 1] = 0;

			}

		}

	}

	/**
	 * Comprueba que el tablero del jugador esta lleno.
	 * 
	 * @return devuelve true si esta lleno el tablero, si no devolvera false.
	 */
	public boolean tableroCompleto() {

		boolean res = true;

		for (int i = 0; i < this.tablero.length; i++) {

			for (int j = 0; j < this.tablero[i].length; j++) {

				if (this.tablero[i][j] == 0) {
					res = false;
				}

			}

		}

		return res;

	}

	/**
	 * Funcion toString que devuelve un String con el nombre del jugador, su
	 * puntuacion y el tablero.
	 */
	@Override
	public String toString() {

		String res = this.nombre + ": " + this.puntuacion + " puntos \n";

		for (int i = 0; i < this.tablero.length; i++) {

			for (int j = 0; j < this.tablero[i].length; j++) {

				res += this.tablero[i][j] + " ";

			}

			res += "\n";

		}

		return res;

	}

}

