package dam.obj;

import java.io.IOException;
import java.time.DateTimeException;
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
		int opcion = 0;
/**
 * Switch case para la aplicacion
 */
		do {
			boolean b = true;
			do {
				Menu.menu();
					try {
						opcion = sc.nextInt();
						b = false;
					}catch (Exception Ex) {
						b = true;
						System.out.println("Numero introducido erroneo");
						sc.nextLine();
					}
			}while (b);
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
				modificarRepresentante();			
				break;
			case 5:
				deleteRepresentante();
				break;
				
			//Añadir modificarGrupo() y modificarCD()
				
			default:
				System.out.println("Guardando en la base de datos...\n\nGuardado");
				break;
			}
			sc.nextLine();
			
		} while (opcion != 0);
	}
/**
 * Definimos variables estaticas
 * @param listaRepresentante, arraylist de Representantes
 * @param entrada, para leer excepciones
 */
	static Scanner sc = new Scanner(System.in);

	private static List<Representante> listaRepresentante = new ArrayList<Representante>(); // lista de representantes.
	
	/* COMPROBAR */
	//private static List<Cd> listaCd = new ArrayList<Cd>(); //esta arraylist hacia que los CD no salieran bien.
	/**/
	
	private static Excepciones entrada = new Excepciones();
/**
 * MÃ©todo para crear Representantes	
 * @throws IOException 
 */
	public static void createRepresentante() throws IOException { 
		List<Cd> temp = new ArrayList<Cd>(); // arraylist temporal para introducir los CD
		int opcion;

		System.out.println("Por favor, introduzca el nombre del representante: ");
		String nombre = sc.nextLine();
		System.out.println("Por favor, introduzca el apellido del representante: ");
		String apellido = sc.nextLine();
		System.out.println("Por favor, introduzca la edad del representante: ");
		int edad = entrada.controlaInt();
		System.out.println("Por favor, introduzca el sueldo del representante: ");
		float sueldo = entrada.controlaFloat();
		System.out.println("Por favor, introduzca el nombre del grupo: ");
		String nombreGrupo = sc.nextLine();
		System.out.println("Por favor, introduzca el pais del grupo: ");
		String pais = sc.nextLine();
		do {
			System.out.println("\n====================\nJMusic Entertainment\n====================\n1. Nuevo Disco \n2. Salir");
			opcion = entrada.controlaInt();
			if (opcion == 1) {
				System.out.println("Por favor, introduzca el nombre del disco: ");
				String nombrecd = sc.nextLine();
				int anodisco = 0,dia = 0,mes = 0;
				System.out.println("Por favor, introduzca el año de publicacion del disco: ");
				anodisco = entrada.controlaInt();
				System.out.println("Por favor, introduzca el numero de mes de la publicacion del disco: ");
				do {
					mes = entrada.controlaInt();
				}while(mes <1 || mes >12);
				dia = (int) (Math.random()*10)+1;
				Cd cd = new Cd(nombrecd, anodisco, mes, dia);
				temp.add(cd);
			}
		} while (opcion == 1);
		Grupo g = new Grupo(nombreGrupo, pais, temp);
		Representante r = new Representante(nombre, apellido, edad, sueldo, g);
		listaRepresentante.add(r);		
	}
/**
 * Metodo para listar los Representantes y grupos
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
 * Metodo para borrar representantes
 * @throws IOException
 */
	public static void deleteRepresentante() throws IOException {
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
 * Metodo para listar los CD de la banda
 * @throws IOException
 */
	public static void listarBandas() throws IOException {
		if (listaRepresentante.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No existen representantes almacenados");
		}else {
			for (int i = 0; i < listaRepresentante.size(); i++) {
				System.out.println((i+1)+". El representante "+listaRepresentante.get(i).getNombre()+" representa al grupo "+listaRepresentante.get(i).getGrupo().getNombre()+" y su ID es "+listaRepresentante.get(i).getId());
				System.out.println();
			}
			System.out.println("Introduzca la ID del representante para ver la discografia de la banda que representa");
			int id = entrada.controlaInt();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					System.out.println("La discografia de la banda solicitada esta compuesta por:\n");
					for (Cd cd : r.getGrupo().getListaCd()) {
						System.out.println(cd.toString());
						System.out.println("");		
					}
				}
			}
		}
	}
	
	public static void modificarRepresentante() throws IOException { //Metodo para modificar Representantes
		
		System.out.println("Lista para consultar el ID de cada representante, y modificar los datos necesarios");
		listarRG(); //Lista los representantes con su ID
		int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el ID del representante a modificar:"));
		for (Representante r : listaRepresentante) {
			if (r.getId() == id) {
				
				//Modifica nombre
				String nombre = JOptionPane.showInputDialog("Modifique el nombre: ");
				r.setNombre(nombre);
				//Modifica apellido
				String apellido = JOptionPane.showInputDialog("Modifique el apellido: ");
				r.setApellido(apellido);
				//Modifica edad
				/*int edad = JOptionPane.showInputDialog("Modifique la edad: ");
				r.setEdad(edad);
				//Modifica sueldo
				float sueldo = JOptionPane.showInputDialog("Modifique el sueldo: ");
				r.setSueldo(sueldo);
				//Modifica grupo
				Grupo = JOptionPane.showInputDialog("Modifique el Grupo: ");
				r.setgrupo(Grupo);*/
				
				System.out.println("El Representante " + r.getId() + " ha sido editado satisfactoriamente");
			}
		}
	}
	
	public static void modificarGrupo() throws IOException { //Metodo para modificar Grupos de Musica

		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Grupo a modificar:"));
		for (Representante r : listaRepresentante) {
			if (r.getNombre() == n) { //REVISAR MAÑANA EN CLASE
				
				//Modifica nombre
				String nombre = JOptionPane.showInputDialog("Modifique el nombre: ");
				r.setNombre(nombre);
				//Modifica apellido
				String pais = JOptionPane.showInputDialog("Modifique el pais: ");
				r.setApellido(pais);
				
				System.out.println("El Grupo " + r.getGrupo() + " ha sido editado satisfactoriamente");
			}
		}
	}
	
	public static void modificarCD() throws IOException { //Metodo para modificar CD

		int cd = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el CD a modificar:"));
		for (Representante r : listaRepresentante) {
			if (r.getNombre() == cd) { //REVISAR MAÑANA EN CLASE
				
				//Modifica nombre
				String nombre = JOptionPane.showInputDialog("Modifique el nombre: ");
				r.setNombre(nombre);
				//Modifica fecha
				String date = JOptionPane.showInputDialog("Modifique el año de publicacion: ");
				r.setDate(date);
				
				System.out.println("El Representante " + r.getId() + " ha sido editado satisfactoriamente");
			}
		}
	}
}
