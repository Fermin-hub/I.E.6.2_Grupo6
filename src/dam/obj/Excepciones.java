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
}