package dam.obj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * Clase Representante
 * @author: Fermin Jimenez, Manuel Corona, Daniel Garcia.
 * @version: 05/02/2020
 */
public class Jmusic {

	public static void main(String[] args) throws IOException {
/**
 * Definimos variables
 * @param sc Scanner
 * @param opcion, Menu
 */
		Scanner sc = new Scanner(System.in);
		int opcion;
/**
 * Switch case para la aplicación
 */
		do {
			Menu.menu();
			opcion = sc.nextInt();
			switch (opcion) {
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
				//modificarRepresentante();			
				break;
			case 5:
				deleteRepresentante();
				break;
			default:
				System.out.println("Guardando en la base de datos...\n\nGuardado");
				break;
			}
			sc.nextLine();
			
		} while (opcion != 0);
	}
/**
 * Definimos variables estáticas
 * @param listaRepresentante, arraylist de Representantes
 * @param entrada, para leer excepciones
 */
	private static List<Representante> listaRepresentante = new ArrayList<Representante>(); // lista de representantes.
	//private static List<Cd> listaCd = new ArrayList<Cd>(); esta arraylist hacia que los cD no salieran bien.
	private static Excepciones entrada = new Excepciones();
/**
 * Método para crear Representantes	
 */
	public static void createRepresentante() { 
		List<Cd> temp = new ArrayList<Cd>(); // arraylist temporal para introducir los CD
		int opcion2;
		boolean b = true;
		boolean b2 = true;
		int edad = 0;
		float sueldo = 0;
		String nombre = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Representante");
		String apellido = JOptionPane.showInputDialog("Por favor, introduzca los apellidos del Representante");
		do {
			try {
		edad = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca la edad del Representante"));
		sueldo = Float.parseFloat(JOptionPane.showInputDialog("Por favor, introduzca el sueldo del Representante"));
		b = false;
			}catch (Exception Ex) {
			b = true;	
			JOptionPane.showMessageDialog(null, "Número introducido erróneo");
			}
		}while (b);
		String nombreGrupo = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Grupo");
		String pais = JOptionPane.showInputDialog("Por favor, introduzca el pais del Grupo");
		do {
			opcion2 = Integer.parseInt(JOptionPane.showInputDialog("====================\nJMusic Entertainment\n====================\n1. Nuevo Disco - Grupo\n2. Salir"));
			if (opcion2 == 1) {
				String nombrecd = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Disco");
				int anodisco = 0,dia = 0,mes = 0;
				do {
					try {
				anodisco = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el año de publicacion del disco"));
				dia = (int) (Math.random() * 10) + 1;
				mes = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el mes de publicacion del disco"));
				b2 = false;
					}catch (Exception Ex) {
					b2 = true;	
					JOptionPane.showMessageDialog(null, "Número introducido erróneo");
					}
				}while (b2);
				Cd cd = new Cd(nombrecd, anodisco, mes, dia);
				temp.add(cd);
			}
		} while (opcion2 == 1);
		Grupo g = new Grupo(nombreGrupo, pais, temp);
		Representante r = new Representante(nombre, apellido, edad, sueldo, g);
		listaRepresentante.add(r);		
	}
/**
 * Método para listar los Representantes y grupos
 */
	public static void listarRG() { // Metodo para extraer solo los representantes.
		if (listaRepresentante.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No existen Representantes registrados");
		}else {
			for (Representante r : listaRepresentante) {
				System.out.println(r.toString());
				for (Cd cd : r.getGrupo().getListaCd()) {
					System.out.println(cd.toString());
					System.out.println();
				}
			}
		}
	}
/**
 * Método para borrar representantes
 * @throws IOException
 */
	public static void deleteRepresentante() throws IOException { // Metodo para eliminar los representantes.
		listarRG();
		System.out.println("Introduzca la ID del representante a borrar");
		int borrar = entrada.controlaInt();
		for (int i = 0; i < listaRepresentante.size(); i++) {
			if (borrar==listaRepresentante.get(i).getId()) {
				listaRepresentante.remove(i);
				System.out.println("El Representante "+listaRepresentante.get(i).getNombre()+" ha sido borrado satisfactoriamente");
				System.out.println();
			}
		}
		/*
		int id = Integer.parseInt(JOptionPane.showInputDialog("Por favor, escriba la id del representante que desea borrar"));
		for (Representante r : listaRepresentante) {
			if (r.getId() == id) {
				listaRepresentante.remove(id);
				JOptionPane.showInputDialog("El representante "+listaRepresentante.get(id).getNombre()+" ha sido eliminado satisfactoriamente");
			}
		}*/
	}
/**
 * Método para liistar los CD de la banda
 * @throws IOException
 */
	public static void listarBandas() throws IOException { // metodo para listar las bandas registradas con sus discos
		if (listaRepresentante.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No existen Representantes registrados");
		}else {
			for (int i = 0; i < listaRepresentante.size(); i++) {
				System.out.println((i+1)+". El representante "+listaRepresentante.get(i).getNombre()+" representa al grupo "+listaRepresentante.get(i).getGrupo().getNombre()+" y su ID es "+listaRepresentante.get(i).getId());
				System.out.println();
			}
			System.out.println("Introduzca la ID del representante para ver la discografia de la banda que representa");
			int id = entrada.controlaInt();
		//int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la ID del representante para ver la discografia de la banda que desea ver"));		
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					System.out.println("La discografia de la banda solicitada esta compuesta por:");
					for (Cd cd : r.getGrupo().getListaCd()) {
						System.out.println(cd.toString());
						System.out.println("");		
					}
				}
			}
		}
	}
	

}
