package dam.obj;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Menu {

	public static int menu() {
		boolean b = true;
		int opcion = 0;
		do {
			try {
		opcion = Integer.parseInt(JOptionPane.showInputDialog("JMusic Entertainment\n====================\n1. Agregar Representante - Grupo \n2. Ver lista de Representantes \n3. Buscar Discografía \n4. Modificar  \n5. Eliminar Representante \n0. Salir del programa\n\nIntroduzca una opcion: "));
		b=false;
			}catch (Exception Ex) {
				JOptionPane.showMessageDialog(null, "Número introducido erróneo");
			}
		}while (b);
		return opcion;
	}
	

	public static int menu2 () throws IOException {
		Excepciones entrada = new Excepciones();
		int opcion = 0;
		System.out.println("JMusic Entertainment\n====================\n1. Agregar Representante - Grupo \n2. Ver lista de Representantes \n3. Buscar Discografía \n4. Modificar  \n5. Eliminar Representante \n0. Salir del programa\n\nIntroduzca una opcion: ");
		opcion = entrada.controlaInt();
		return opcion;
	}
}
