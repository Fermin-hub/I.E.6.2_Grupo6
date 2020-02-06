package dam.obj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Representante
 * 
 * @author: Fermin Jimenez, Manuel Corona, Daniel Garcia.
 * @version: 05/02/2020
 */
public class Jmusic {

	public static void main(String[] args) throws IOException {
		/**
		 * Definimos variables
		 * 
		 * @param sc      Scanner
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
				} catch (Exception Ex) {
					b = true;
					System.out.println("Numero introducido erroneo");
					sc.nextLine();
				}
			} while (b);
			switch (opcion) {
			case 1:
				agregarDatos();
				break;
			case 2:
				visualizarDatos();
				break;
			case 3:
				// Modificar Datos
				break;
			case 4:
				buscarDiscografia();
				break;
			case 5:
				eliminarDatos();
				break;

			default:
				System.out.println("Guardando en la base de datos...\n\nGuardado");
				break;
			}
			sc.nextLine();

		} while (opcion != 0);
	}

	/**
	 * Definimos variables estaticas
	 * 
	 * @param listaRepresentante, arraylist de Representantes
	 * @param entrada,            para leer excepciones
	 */
	static Scanner sc = new Scanner(System.in);

	private static List<Representante> listaRepresentante = new ArrayList<Representante>(); // lista de representantes.

	/* COMPROBAR */
	// private static List<Cd> listaCd = new ArrayList<Cd>(); //esta arraylist hacia
	// que los CD no salieran bien.
	/**/

	private static Excepciones entrada = new Excepciones();

	/**
	 * MÃ©todo para Agregar los datos
	 * 
	 * @throws IOException
	 */
	public static void agregarDatos() throws IOException {
		List<Cd> temp = new ArrayList<Cd>(); // arraylist temporal para introducir los CD
		int opcion = 0;

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
			System.out.println(
					"\n====================\nJMusic Entertainment\n====================\n1. Agregar Disco \n2. Salir");
			boolean b = true;
			do {
				try {
					opcion = sc.nextInt();
					b = false;
				} catch (Exception Ex) {
					b = true;
					System.out.println("Por favor introduzca un caracter numerico");
					sc.nextLine();
				}
			} while (b);
			sc.nextLine();
			switch (opcion) {
			case 1:
				System.out.println("Por favor, introduzca el nombre del Disco");
				String nombrecd = sc.nextLine();
				int anodisco = 0, dia = 0, mes = 0;
				System.out.println("Por favor, introduzca el año de publicacion del disco");
				anodisco = entrada.controlaInt();
				System.out.println("Por favor, introduzca el numero de mes de la publicacion del disco");
				do {
					mes = entrada.controlaInt();
				} while (mes <= 0 || mes >= 13);

				dia = (int) (Math.random() * 10) + 1;
				Cd cd = new Cd(nombrecd, anodisco, mes, dia);
				temp.add(cd);

				break;
			case 2:
				System.out.println("Guardando en la base de datos...\n\nGuardado");
				break;

			default:
				System.out.println("Por favor seleccione una opcion correcta");
				break;
			}

		} while (opcion != 2);

		Grupo g = new Grupo(nombreGrupo, pais, temp);
		Representante r = new Representante(nombre, apellido, edad, sueldo, g);
		listaRepresentante.add(r);
	}

	/**
	 * Metodo para listar los Representantes y grupos
	 */
	public static void visualizarDatos() { // Metodo para extraer los datos.
		if (listaRepresentante.isEmpty()) {
			System.out.println("No existen Datos almacenados");
		} else {
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
	 * Metodo para listar los Representantes sin otros datos.
	 */
	public static void listarRepreresumido() { // Metodo para extraer solo los representantes sin banda ni cd.

		for (Representante r : listaRepresentante) {
			System.out.println("ID: " + r.getId() + " - El Manager " + r.getNombre() + " " + r.getApellido());

		}
	}

	public static void eliminarDatos() throws IOException { // Metodo para eliminar los representantes.
		int j = 0;
		Representante temp = new Representante();
		if (listaRepresentante.size() == 0) {
			System.out.println("No existen Datos Almacenados.");
		} else {
			do {
				j = 0;
				System.out.println("Por favor Introduzca la ID del representante para borrar todos los datos");
				listarRepreresumido();
				int id = entrada.controlaInt();
				for (int i = 0; i < listaRepresentante.size(); i++) {
					if (id == listaRepresentante.get(i).getId()) {
						temp = listaRepresentante.get(i);
					}
				}
				if (temp.getNombre() != null) {
					System.out.println("El representante " + temp.getNombre() + " con ID " + temp.getId()
							+ " ha sido eliminado correctamente juntos con los datos almacenados");
					listaRepresentante.remove(temp);
				} else {
					System.out.println("El ID introducido no es correcto por favor introduzca un ID valido");
					j++;
				}
			} while (j > 0);
		}

	}
	/*
	 * int id = Integer.parseInt(JOptionPane.
	 * showInputDialog("Por favor, escriba la id del representante que desea borrar"
	 * )); for (Representante r : listaRepresentante) { if (r.getId() == id) {
	 * listaRepresentante.remove(id);
	 * JOptionPane.showInputDialog("El representante "+listaRepresentante.get(id).
	 * getNombre()+" ha sido eliminado satisfactoriamente"); } }
	 */

	/**
	 * Metodo para listar los CD de la banda
	 * 
	 * @throws IOException
	 */
	public static void buscarDiscografia() throws IOException {
		int j =0;
		if (listaRepresentante.isEmpty()) {
			System.out.println("No existen Datos almacenados");
		} else {
			do {
				j = 0;
			
			for (int i = 0; i < listaRepresentante.size(); i++) {
				System.out.println((i + 1) + ". Banda Musical: " + listaRepresentante.get(i).getGrupo().getNombre()
						+ " cuya ID es " + listaRepresentante.get(i).getId() + "\n");
			}
			System.out.println("Introduzca la ID de la banda deseada para ver su discografia");
			int id = entrada.controlaInt();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					System.out.println("La discografia de la banda solicitada esta compuesta por:\n");
					for (Cd cd : r.getGrupo().getListaCd()) {
						System.out.println(cd.toString());
					}
					}else {
						System.out.println("El ID introducido no es correcto por favor introduzca un ID valido");
						j++;
				}
			}
		}while (j > 0);
	}
	/*
	  public static void modificarRepresentante() throws IOException { //Metodo
	  para modificar Representantes
	  
	  System.out.println("Lista para consultar el ID de cada representante, y
	  modificar los datos necesarios"); listarRG(); //Lista los representantes con
	  su ID int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el ID
	  del representante a modificar:")); for (Representante r : listaRepresentante)
	 { if (r.getId() == id) {
	  
	  //Modifica nombre String nombre = JOptionPane.showInputDialog("Modifique el
	  nombre: "); r.setNombre(nombre); //Modifica apellido String apellido =
	  JOptionPane.showInputDialog("Modifique el apellido: ");
	  r.setApellido(apellido); //Modifica edad /*int edad =
	  JOptionPane.showInputDialog("Modifique la edad: "); r.setEdad(edad);
	 //Modifica sueldo float sueldo = JOptionPane.showInputDialog("Modifique el
	  sueldo: "); r.setSueldo(sueldo); //Modifica grupo Grupo =
	  JOptionPane.showInputDialog("Modifique el Grupo: "); r.setgrupo(Grupo);
	 
	
	  System.out.println("El Representante " + r.getId() + " ha sido editado
	  satisfactoriamente"); } } }
	  
	  public static void modificarGrupo() throws IOException { //Metodo para
	  modificar Grupos de Musica
	  
	  int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Grupo a
	  modificar:")); for (Representante r : listaRepresentante) { if (r.getNombre()
	  == n) { //REVISAR MAÑANA EN CLASE
	  
	  //Modifica nombre String nombre = JOptionPane.showInputDialog("Modifique el
	  nombre: "); r.setNombre(nombre); //Modifica apellido String pais =
	  JOptionPane.showInputDialog("Modifique el pais: "); r.setApellido(pais);
	  
	  System.out.println("El Grupo " + r.getGrupo() + " ha sido editado
	  satisfactoriamente"); } } }
	  
	  public static void modificarCD() throws IOException { //Metodo para modificar
	  CD
	  
	  int cd = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el CD a
	  modificar:")); for (Representante r : listaRepresentante) { if (r.getNombre()
	  == cd) { //REVISAR MAÑANA EN CLASE
	  
	  //Modifica nombre String nombre = JOptionPane.showInputDialog("Modifique el
	  nombre: "); r.setNombre(nombre); //Modifica fecha String date =
	  JOptionPane.showInputDialog("Modifique el año de publicacion: ");
	  r.setDate(date);
	  
	  System.out.println("El Representante " + r.getId() + " ha sido editado
	  satisfactoriamente"); } } }
	 */
}}
