package dam.obj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Jmusic {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"JMusic Entertainment\n====================\n1. Nuevo Grupo - Grupo\n2. Buscar Representante\n3. Buscar Discografía Grupo\n4. Listar Representante - Grupo\n5. Borrar Representante - Grupo\n0. Salir del programa\n\nIntroduzca una opción: "));

			switch (opcion) {
			case 1:
				createRepresentante();

				break;
			case 2:
				listarRG();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;

			default:
				break;
			}
		} while (opcion < 6);

	}

	private static List<Representante> listaRepresentante = new ArrayList<Representante>();

	public static void createRepresentante() {
		int opcion2;
		String nombre = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Representante");
		String apellido = JOptionPane.showInputDialog("Por favor, introduzca los apellidos del Representante");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca la edad del Representante"));
		float sueldo = Float
				.parseFloat(JOptionPane.showInputDialog("Por favor, introduzca el sueldo del Representante"));

		List<Cd> listaCd = new ArrayList<Cd>();
		String nombreGrupo = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Grupo");
		String pais = JOptionPane.showInputDialog("Por favor, introduzca el pais del Grupo");
		do {
			opcion2 = Integer.parseInt(JOptionPane
					.showInputDialog("JMusic Entertainment\n====================\n1. Nuevo Disco - Grupo\n2. Salir"));
			if (opcion2 == 1) {
				String nombrecd = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Disco");
				int anodisco = Integer.parseInt(
						JOptionPane.showInputDialog("Por favor, introduzca el anio de publicacion del disco"));
				int dia = (int) (Math.random() * 10) + 1;
				int mes = Integer
						.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el mes de publicacion del disco"));
				Cd cd = new Cd(nombrecd, anodisco, mes, dia);
				listaCd.add(cd);
			}
		} while (opcion2 == 1);
		Grupo g = new Grupo(nombreGrupo, pais, listaCd);
		Representante r = new Representante(nombre, apellido, edad, sueldo, g);
		listaRepresentante.add(r);

	}

	public static void listarRG() {

		for (Representante r : listaRepresentante) {

			System.out.println(r.toString());
			for (Cd cd : r.getGrupo().getListaCd()) {

				System.out.println(cd.toString());
			}
			
		}
	}
	
	public static void deleteRepresentante() {
		int id = Integer.parseInt(
				JOptionPane.showInputDialog("Por favor, introduzca el anio de publicacion del disco"));
			
			for(Representante r : listaRepresentante) {
				if (r.getId()==id) {
				    listaRepresentante.remove(r);
				}
			}
		}

}
