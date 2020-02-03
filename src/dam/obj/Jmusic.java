package dam.obj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Jmusic {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"JMusic Entertainment\n====================\n1. Agregar Representante \n2. Ver la lista de Representantes \n3. Eliminar Representante \n4. Ver lista de Bandas Musicales \n5. null \n0. Salir del programa\n\nIntroduzca una opcion: "));

			switch (opcion) {
			case 1:
				createRepresentante();

				break;
			case 2:
				listarRG();
				break;
			case 3:
				deleteRepresentante();
				break;
			case 4:
				listarBandas();
				break;
			case 5:

				break;
			case 6:

				break;

			default:
				break;
			}
		} while (opcion < 6);
		
		scanner.close();
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
		int id = Integer
				.parseInt(JOptionPane.showInputDialog("Por favor, diga la id del representante que quiere borrar"));

		for (Representante r : listaRepresentante) {
			if (r.getId() == id) {
				listaRepresentante.remove(r);
				System.out.println("El representante ha sido eliminado");
			}
		}
	}
	

	public static void listarBandas() { // metodo para listar las bandas registradas con sus discos

		for (Representante r : listaRepresentante) {

			System.out.println("Grupo musical: " + r.getGrupo()
			+". Su discografia esta formada por:");
			for (Cd cd : r.getGrupo().getListaCd()) {

				System.out.println(cd.toString());
			}

		}
	}
}
