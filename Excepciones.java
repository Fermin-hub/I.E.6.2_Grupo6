package dam.obj;
/**
* Clase Excepciones
* @author: Fermín Jiménez
* @version: 13/12/2019
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excepciones {
/**
 * Variables para usar
 * @param entrada, Entrada por teclado
 * @param error bolean repetir
 */
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	boolean error = false;
/**
 * Excepción para INT
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
					System.out.println("Valor no válido");
					error = true;
				}
			} while (error);
			return entero;
	}
/**
 * Excepción para DOUBLE
 * @return
 * @throws IOException
 */
	public double controlaDouble() throws IOException {
		double entero = 0;
			do {
				try {
					entero = Double.parseDouble(entrada.readLine());
					error = false;
				} catch (NumberFormatException e) {
					System.out.println("Valor no válido, vuelva a introducirlo");
					error = true;
				}
			} while (error);
			return entero;
	}	
/**
 * Excepción para LONG	
 * @return
 * @throws IOException
 */
	public double controlaLong() throws IOException {
		long entero = 0;
			do {
				try {
					entero = Long.parseLong(entrada.readLine());
					error = false;
				} catch (NumberFormatException e) {
					System.out.println("Valor no válido, vuelva a introducirlo");
					error = true;
				}
			} while (error);
			return entero;
	}
/**
 * Excepción para FLOAT
 * @return
 * @throws IOException
 */
	public double controlaFloat() throws IOException {
		float entero = 0;
			do {
				try {
					entero = Long.parseLong(entrada.readLine());
					error = false;
				} catch (NumberFormatException e) {
					System.out.println("Valor no válido, vuelva a introducirlo");
					error = true;
				}
			} while (error);
			return entero;
	}
}