package dam.obj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Clase Representante
 * 
 * @author: Fermin Jimenez, Manuel Corona, Daniel Garcia.
 * @version: 27/12/2019
 */

public class Jmusic {

	public static void main(String[] args) {

		do {
			switch (Menu.menu()) {
			case 1:
				createRepresentante();
				break;
			case 2:
				listarRG();
				break;
			case 3:
				listarBandas();
				break;
			case 4:
				deleteRepresentante();
				break;
			case 5:
				//modificarRepresentante();
				break;
			case 6:

				break;

			default:
				break;
			}
		} while (Menu.menu() < 6);

	}

	private static List<Representante> listaRepresentante = new ArrayList<Representante>(); // lista de representantes.
	private static List<Cd> listaCd = new ArrayList<Cd>();

	public static void createRepresentante() { // Metodo para introducir representante con sus datos, el grupo que
		int opcion2;
		String nombre = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Representante");
		String apellido = JOptionPane.showInputDialog("Por favor, introduzca los apellidos del Representante");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca la edad del Representante"));
		float sueldo = Float.parseFloat(JOptionPane.showInputDialog("Por favor, introduzca el sueldo del Representante"));
		String nombreGrupo = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Grupo");
		String pais = JOptionPane.showInputDialog("Por favor, introduzca el pais del Grupo");
		do {
			opcion2 = Integer.parseInt(JOptionPane.showInputDialog("JMusic Entertainment\n====================\n1. Nuevo Disco - Grupo\n2. Salir"));
			if (opcion2 == 1) {
				String nombrecd = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Disco");
				int anodisco = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el anio de publicacion del disco"));
				int dia = (int) (Math.random() * 10) + 1;
				int mes = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el mes de publicacion del disco"));
				Cd cd = new Cd(nombrecd, anodisco, mes, dia);
				listaCd.add(cd);
			}
		} while (opcion2 == 1);
		Grupo g = new Grupo(nombreGrupo, pais, listaCd);
		Representante r = new Representante(nombre, apellido, edad, sueldo, g);
		listaRepresentante.add(r);
	}

	public static void listarRG() { // Metodo para extraer solo los representantes.
		for (Representante r : listaRepresentante) {
			System.out.println(r.toString());
			for (Cd cd : r.getGrupo().getListaCd()) {
				System.out.println(cd.toString());
			}
		}
	}

	public static void deleteRepresentante() { // Metodo para eliminar los representantes.
		listarRG();
		int borrar = Integer.parseInt(JOptionPane.showInputDialog("Qué representante desea borrar?"));
		borrar = borrar-1;
		listaRepresentante.remove(borrar);
		JOptionPane.showMessageDialog(null, "El grupo "+listaRepresentante.get(borrar-1).getNombre()+" ha sido borrado satisfactoriamente");
		/*
		int id = Integer.parseInt(JOptionPane.showInputDialog("Por favor, escriba la id del representante que desea borrar"));
		for (Representante r : listaRepresentante) {
			if (r.getId() == id) {
				listaRepresentante.remove(id);
				JOptionPane.showInputDialog("El representante "+listaRepresentante.get(id).getNombre()+" ha sido eliminado satisfactoriamente");
			}
		}*/
	}

	public static void listarBandas() { // metodo para listar las bandas registradas con sus discos
		for (int i = 0; i < listaRepresentante.size(); i++) {
			System.out.println((i+1)+". El representante "+listaRepresentante.get(i).getNombre()+" representa al grupo "+listaRepresentante.get(i).getGrupo().getNombre()+" y su ID es "+listaRepresentante.get(i).getId());		
		}
		int banda = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la id del representante"));	
		for (Representante r : listaRepresentante) {
			System.out.println("Grupo musical: " + r.getGrupo() + ".\nSu discografia esta formada por:");
			for (Cd cd : r.getGrupo().getListaCd()) {
				System.out.println(cd.toString());
			}

		}
	}
	
	/*public static void modificarRepresentante() {
		
		for (Representante r : modificarRepresentante()) {
		}
	}*/
}