package string.recuJunio;

import java.util.Random;

public class Mastermind {

	/**
	 * Atributo privado de tipo cadena que almacena las iniciales de cada color.
	 */
	private String colores = "RVABNL";

	/**
	 * Atributo privado de tipo cadena que almacenará el codigo a adivinar.
	 */
	private String codigo = "";

	/**
	 * Atributo privado constante de tipo int que almacena el numero de intentos que
	 * tiene el jugador.
	 */
	private final int NUM_INTENTOS = 20;

	/**
	 * Atributo privado de tipo String que almacenara todos los intentos que ha
	 * hecho el jugador.
	 */
	private String intentosPrevios = "";

	/**
	 * Constructor que crea aleatoriamente el codigo a adivinar
	 */
	public Mastermind() {

		Random rand = new Random();

		int i;

		int longitud = 5;

		int cont = 0;

		while (cont < longitud) {

			i = rand.nextInt(0, colores.length());

			this.codigo += String.valueOf(colores.charAt(i));

			++cont;
			
		}

	}

	/**
	 * Get del codigo que devuelve el codigo a adivinar
	 * 
	 * @return devuleve el valor del codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Get de intentosPrevios que devuelve un String con todos los intentos del
	 * jugador
	 * 
	 * @return devuelve todos los intentos del jugador
	 */
	public String getIntentosPrevios() {
		return intentosPrevios;
	}

	/**
	 * Get de la constante NUM_INTENTOS
	 * 
	 * @return devuelve el numero de intentos que tiene el jugador
	 */
	public int getNumIntentos() {
		return NUM_INTENTOS;
	}

	/**
	 * Devuelve los colores que se pueden usar
	 * 
	 * @return devuelve los colores a usar
	 */
	public String getColores() {
		return colores;
	}

	/**
	 * Funcion que comprueba cuantos caracteres estan bien en el codigo y cuales
	 * estan pero no en su posición.
	 * 
	 * @param intento cadena que contiene el intento del jugador.
	 */
	public void compruebaCodigo(String intento) {

		int posicionCorrecta = 0;

		int posicionErronia = 0;

		int bien;

		int j = 0;

		for (int i = 0; i < intento.length(); i++) {

			j = 0;
			bien = -1;

			while (j < codigo.length() && bien != 1) {

				if (codigo.charAt(j) == intento.charAt(i) && i == j) {

					++posicionCorrecta;

					bien = 1;

				} else if (codigo.charAt(j) == intento.charAt(i)) {

					bien = 0;

				}

				++j;

			}

			posicionErronia += bien == 0 ? 1 : 0;

		}

		intentosPrevios += intento + " - B" + posicionCorrecta + " R" + posicionErronia + "\n";

	}

}

