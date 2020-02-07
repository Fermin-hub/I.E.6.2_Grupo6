package dam.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* Clase Excepciones
* @author: Fermin Jimenez Manuel Corona y Daniel Garcia
* @version: 12/11/2019
* 
*/

public class Excepciones {

	/**
	 * Variables
	 * @param entrada, Entrada por teclado
	 * @param error bolean repetir
	 */
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	boolean error = false;
	
	/**
	 * Excepcion para INT
	 * @return
	 * @throws IOException
	 */
	public int controlaInt() throws IOException {
		int entero = 0;
			do {
				try {
					entero = Integer.parseInt(entrada.readLine());
					error = false;
				} catch (NumberFormatException e) {
					System.out.println("Valor no valido. Introduzcalo de nuevo.");
					error = true;
				}
			} while (error);
			return entero;
	}
	
	/**
	 * Excepcion para FLOAT
	 * @return
	 * @throws IOException
	 */
		public float controlaFloat() throws IOException {
			float entero = 0;
				do {
					try {
						entero = Float.parseFloat(entrada.readLine());
						error = false;
					} catch (NumberFormatException e) {
						System.out.println("Valor no valido. Introduzcalo de nuevo.");
						error = true;
					}
				} while (error);
				return entero;
		}
}