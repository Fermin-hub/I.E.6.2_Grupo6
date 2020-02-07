package dam.obj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author: Fermin Jimenez, Manuel Corona, Daniel Garcia.
 * @version: 02/2020
 * 
 */

public class Jmusic {

	public static void main(String[] args) throws IOException {
		/**
		 * Variables
		 * 
		 * @param sc      Scanner
		 * @param opcion, Menu
		 */
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		/**
		 * Switch case
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
				// modificarDatos();
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
	 * Variables estaticas
	 * 
	 * @param listaRepresentante, arraylist de Representantes
	 * @param entrada, para leer excepciones
	 */
	static Scanner sc = new Scanner(System.in);

	private static List<Representante> listaRepresentante = new ArrayList<Representante>(); // lista de representantes

	private static Excepciones entrada = new Excepciones();

	/**
	 * A�ade Representante y Grupo
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

		/**
		 * Agregar Discografia (CD)
		 */
		do {
			System.out.println(
					"\n====================\nDiscografia\n====================\n1. Agregar Disco \n2. Salir");
			boolean b = true;
			do {
				try {
					opcion = sc.nextInt();
					b = false;
				} catch (Exception Ex) {
					b = true;
					System.out.println ("Por favor introduzca un caracter numerico");
					sc.nextLine();
				}
			} while (b);
			sc.nextLine();
			switch (opcion) {
			case 1:
				System.out.println("Por favor, introduzca el nombre del Disco");
				String nombrecd = sc.nextLine();
				int anodisco = 0, dia = 0, mes = 0;
				System.out.println("Por favor, introduzca el a�o de publicacion del disco");
				anodisco = entrada.controlaInt();
				do {
					System.out.println("Por favor, introduzca el numero de mes de la publicacion del disco");
					mes = entrada.controlaInt();
				} while (mes < 1 || mes > 12);
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
	 * Visualiza los datos de representante, grupo y discografia
	 */
	public static void visualizarDatos() {
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
	 * Lista solo los REPRESENTANTES
	 */
	public static void listarRepreresumido() {
		for (Representante r : listaRepresentante) {
			System.out.println("ID: " + r.getId() + " - El Manager " + r.getNombre() + " " + r.getApellido());
		}
	}

	/**
	 * Eliminar representante, grupo y cd
	 * 
	 * @throws IOException
	 */
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
				/*
				 * for (int i = 0; i < listaRepresentante.size(); i++) { if (id ==
				 * listaRepresentante.get(i).getId()) { temp = listaRepresentante.get(i); } }
				 */

				temp = listaRepresentante.stream().filter(r -> r.getId() == id).findFirst().orElse(new Representante());

				if (temp.getNombre() != null) {
					System.out.println("El representante " + temp.getNombre() + " con ID " + temp.getId()
							+ " ha sido eliminado correctamente junto con los datos almacenados");
					listaRepresentante.remove(temp);
				} else {
					System.out.println("El ID introducido no es correcto por favor introduzca un ID valido");
					j++;
				}
			} while (j > 0);
		}

	}

	/**
	 * Lista los CD del grupo
	 * 
	 * @throws IOException
	 */
	public static void buscarDiscografia() throws IOException {
		int j = 0;
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
				// Busca el posible objeto
				/*	
				for (int i = 0; i < listaRepresentante.size() && encontrado == null; i++) {
					if (listaRepresentante.get(i).getId() == id) {
						encontrado = listaRepresentante.get(i);
					} 
					
				}*/
				Representante encontrado = listaRepresentante.stream().filter(r -> r.getId()==id).findFirst().orElse(new Representante());
				// Imprime el resultado de la busqueda
				if (encontrado.getNombre()==null) {
					System.out.println("El ID introducido no es correcto por favor introduzca un ID valido");
					j++;
				} else {
					System.out.println("La discografia de la banda solicitada esta compuesta por:\n");
					if (encontrado.getGrupo().getListaCd().isEmpty()) {
						System.out.println("Este grupo musical no contiene discografia aun.");
					} else {
						for (Cd cd : encontrado.getGrupo().getListaCd()) {
							System.out.println(cd.toString());
						}
					}
				}
				
			} while (j > 0);
		}
	}

	/*public static void modificar () throws IOException {
	System.out.println("Por favor, introduzca la id del representante amodificar");
	int id = entrada.controlaInt();
	
	System.out.println("\n====================\nModificación\n====================\n1. Modificar Representante \n2. Modificar Grupo \n3. Modificar Discografia \n0. Salir");
	int opcion = entrada.controlaInt();
	switch (opcion) {
	case 1:
		System.out.println("\n====================\nModificación\n====================\n1. Modificar Nombre \n2. Apellidos \n3. Modificar Sueldo \n4. Modificar Edad\n0. Salir");
		int opcion2 = entrada.controlaInt();
		switch (opcion2) {
		case 1:
			System.out.println("Introduzca el nuevo nombre");
			String nombre2=sc.nextLine();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					r.setNombre(nombre2);
				} 
			}
			System.out.println("Nombre modificado");
			break;
		case 2:
			System.out.println("Introduzca los apellidos");
			String apellido2=sc.nextLine();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					r.setNombre(apellido2);
				} 
			}
			System.out.println("Apellidos modificados");
			break;
		case 3:
			System.out.println("Introduzca los apellidos");
			float sueldo2=entrada.controlaFloat();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					r.setSueldo(sueldo2);
				} 
			}
			System.out.println("Sueldo modificado");
			break;
		default:
		}
		break;
	case 2:
		System.out.println("\n====================\nModificación\n====================\n1. Modificar Nombre \n2. Modificar Pais \n0. Salir");
		int opcion3 = entrada.controlaInt();
		switch (opcion3) {
		case 1:
			System.out.println("Introduzca el nuevo nombre");
			String nombre2=sc.nextLine();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					r.getGrupo().setNombre(nombre2);
				} 
			}
			System.out.println("Nombre modificado");
			break;
		case 2:
			System.out.println("Introduzca El pais");
			String pais=sc.nextLine();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					r.getGrupo().setPais(pais);
				} 
			}
			System.out.println("Pais modificado");
			break;

	default:
	}
		
	case 3:
		System.out.println("\n====================\nModificación\n====================\n1. Modificar Nombre \n2. Modificar anio \n3. Modificar mes \n0. Salir");
		int opcion4 = entrada.controlaInt();
		switch (opcion4) {
		case 1:
			System.out.println("Introduzca el nuevo nombre");
			String nombre2=sc.nextLine();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					r.getGrupo().getListaCd().get(opcion4).setNombre(nombre2);
				} 
			}
			System.out.println("Nombre modificado");
			break;
		case 2:
			System.out.println("Introduzca el anio");
			String anio=sc.nextLine();
			for (Representante r : listaRepresentante) {
				if (r.getId() == id) {
					r.getGrupo().getListaCd().get(opcion4).setDate(date);;
				} 
			}
			System.out.println("Pais modificado");
		
		
		
		
		break;
	}
	
	}	
	
	
}*/
	/*public static void modificar () throws IOException {
		System.out.println("Por favor, introduzca la id del representante amodificar");
		int id = entrada.controlaInt();
		
		System.out.println("\n====================\nModificación\n====================\n1. Modificar Representante \n2. Modificar Grupo \n3. Modificar Discografia \n0. Salir");
		int opcion = entrada.controlaInt();
		switch (opcion) {
		case 1:
			System.out.println("\n====================\nModificación\n====================\n1. Modificar Nombre \n2. Apellidos \n3. Modificar Sueldo \n4. Modificar Edad\n0. Salir");
			int opcion2 = entrada.controlaInt();
			switch (opcion2) {
			case 1:
				System.out.println("Introduzca el nuevo nombre");
				String nombre2=sc.nextLine();
				for (Representante r : listaRepresentante) {
					if (r.getId() == id) {
						r.setNombre(nombre2);
					} 
				}
				System.out.println("Nombre modificado");
				break;
			case 2:
				System.out.println("Introduzca los apellidos");
				String apellido2=sc.nextLine();
				for (Representante r : listaRepresentante) {
					if (r.getId() == id) {
						r.setNombre(apellido2);
					} 
				}
				System.out.println("Apellidos modificados");
				break;
			case 3:
				System.out.println("Introduzca los apellidos");
				float sueldo2=entrada.controlaFloat();
				for (Representante r : listaRepresentante) {
					if (r.getId() == id) {
						r.setSueldo(sueldo2);
					} 
				}
				System.out.println("Sueldo modificado");
				break;
			default:
			}
			break;
		case 2:
			System.out.println("\n====================\nModificación\n====================\n1. Modificar Nombre \n2. Modificar Pais \n0. Salir");
			int opcion3 = entrada.controlaInt();
			switch (opcion3) {
			case 1:
				System.out.println("Introduzca el nuevo nombre");
				String nombre2=sc.nextLine();
				for (Representante r : listaRepresentante) {
					if (r.getId() == id) {
						r.getGrupo().setNombre(nombre2);
					} 
				}
				System.out.println("Nombre modificado");
				break;
			case 2:
				System.out.println("Introduzca El pais");
				String pais=sc.nextLine();
				for (Representante r : listaRepresentante) {
					if (r.getId() == id) {
						r.getGrupo().setPais(pais);
					} 
				}
				System.out.println("Pais modificado");
				break;

		default:
		}
			
		case 3:
			System.out.println("\n====================\nModificación\n====================\n1. Modificar Nombre \n2. Modificar anio \n3. Modificar mes \n0. Salir");
			int opcion4 = entrada.controlaInt();
			switch (opcion4) {
			case 1:
				System.out.println("Introduzca el nuevo nombre");
				String nombre2=sc.nextLine();
				for (Representante r : listaRepresentante) {
					if (r.getId() == id) {
						r.getGrupo().getListaCd().get(opcion4).setNombre(nombre2);
					} 
				}
				System.out.println("Nombre modificado");
				break;
			case 2:
				System.out.println("Introduzca el anio");
				String anio=sc.nextLine();
				for (Representante r : listaRepresentante) {
					if (r.getId() == id) {
						r.getGrupo().getListaCd().get(opcion4).setDate(date);;
					} 
				}
				System.out.println("Pais modificado");
			
			
			
			
			break;
		}
		
		}	
		
		
	}*/
	/**
	 * Metodos de modificar
	 * 
	 * @return
	 */

	/*
	  public static void modificarRepresentante() throws IOException { //Metodo
	  para modificar Representantes
	  
	  System.out.
	  println("Lista para consultar el ID de cada representante, y modificar los datos necesarios"
	  ); listarRepreresumido(); //Lista los representantes con su ID int id =
	 System.out.println("Introduzca el ID del representante a modificar:"); for
	  (Representante r : listaRepresentante) { if (r.getId() == id) {//Modifica
	  nombre String nombre = System.out.println("Modifique el nombre: ");
	  r.setNombre(nombre); //Modifica apellido String apellido =
	  System.out.println("Modifique el apellido: "); r.setApellido(apellido);
	  //Modifica edad /*int edad = System.out.println("Modifique la edad: ");
	  r.setEdad(edad); //Modifica sueldo float sueldo =
	  JOptionPane.showInputDialog("Modifique el sueldo: "); r.setSueldo(sueldo);
	  //Modifica grupo Grupo = System.out.println("Modifique el Grupo: ");
	  r.setgrupo(Grupo);
	  
	  
	  System.out.println("El Representante " + r.getId() +
	  " ha sido editado satisfactoriamente"); } } } /* public static void
	  modificarGrupo() throws IOException { //Metodo para modificar Grupos de
	  Musica
	  
	  int n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Grupo a
	  modificar:")); for (Representante r : listaRepresentante) { if (r.getNombre()
	  == n) { //REVISAR MA�ANA EN CLASE
	  
	  //Modifica nombre String nombre = JOptionPane.showInputDialog("Modifique el
	  nombre: "); r.setNombre(nombre); //Modifica apellido String pais =
	  JOptionPane.showInputDialog("Modifique el pais: "); r.setApellido(pais);
	  
	  System.out.println("El Grupo " + r.getGrupo() + " ha sido editado
	  satisfactoriamente"); } } }
	  
	  public static void modificarCD() throws IOException { //Metodo para modificar
	  CD
	  
	  int cd = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el CD a
	  modificar:")); for (Representante r : listaRepresentante) { if (r.getNombre()
	  == cd) { //REVISAR MA�ANA EN CLASE
	  
	  //Modifica nombre String nombre = JOptionPane.showInputDialog("Modifique el
	  nombre: "); r.setNombre(nombre); //Modifica fecha String date =
	  JOptionPane.showInputDialog("Modifique el a�o de publicacion: ");
	  r.setDate(date);
	  
	  System.out.println("El Representante " + r.getId() + " ha sido editado
	  satisfactoriamente"); } } }
	 */

	// **************************
	// �����������������������������
	// ********************************
	// Metodo Alternativo para modificacion de datos.
	/*
	  public static void modificarDatos() throws IOException {
	  
	  if (listaRepresentante.isEmpty()) {
	  System.out.println("No existen Datos almacenados"); 
	  } else { 
		  int opcion = 0;
		  do { System.out.println("\n====================\nMenu Modificaciones\n====================\n1. Modificar Representante \n2. Modificar Grupo \n3. Modificar Discografia \n4. No realizar mas cambios"); 
		  boolean b = true; 
		  do { 
			  try { 
				  opcion = sc.nextInt(); 
				  b = false; 
				  } catch  (Exception Ex) { 
					  b = true;
					  System.out.println("Por favor introduzca un caracter numerico");
					  sc.nextLine();
					  } 
		  		} while (b); 
	  sc.nextLine(); 
	  switch (opcion) { 
	  case 1: int j= 0; 
	   
	  do { 
		  j = 0; 
		  listarRepreresumido();
		  System.out.println("Introduzca la ID del representante que desea modificar");
		  int id = entrada.controlaInt(); 
		  for (Representante r : listaRepresentante) {
			  if (r.getId() == id) { System.out.println("Modifique su nombre: ");
			  r.setNombre(sc.nextLine()); System.out.println("Modifique su apellido: ");
			  r.setApellido(sc.nextLine()); System.out.println("Modifique su edad: ");
			  r.setEdad(entrada.controlaInt());
			  System.out.println("Modifique su sueldo: ");
			  r.setSueldo(entrada.controlaInt()); System.out.println( "El Representante " +
					  r.getId() + " ha sido editado satisfactoriamente"); 
			  } 
			  else { 
				  System.out.println("El ID introducido no es correcto por favor introduzca un ID valido"); 
				  j++; 
				  k++; 
				  } 
			  		} if (k > 0) { System.out.
	  println("El ID introducido no es correcto por favor introduzca un ID valido"
	  ); } } while (j > 0);
	  
	  break; case 2: int l = 0; int m = 0; do { l = 0; for (int i = 0; i <
	  listaRepresentante.size(); i++) { System.out.println( (i + 1) +
	  ". Banda Musical: " + listaRepresentante.get(i).getGrupo().getNombre() +
	  " cuya ID es " + listaRepresentante.get(i).getId() + "\n"); }
	  System.out.println("Introduzca la ID de la banda que desea modificar"); int
	  id = entrada.controlaInt(); for (Representante r : listaRepresentante) { if
	  (r.getId() == id) { System.out.println("Modifique su nombre: ");
	  r.getGrupo().setNombre(sc.nextLine());
	  System.out.println("Modifique su pais: ");
	  r.getGrupo().setPais(sc.nextLine());
	  System.out.println("La Banda Musical ha sido editada satisfactoriamente"); }
	  else { System.out
	  .println("El ID introducido no es correcto por favor introduzca un ID valido"
	  ); l++; m++; } } if (m > 0) { System.out.
	  println("El ID introducido no es correcto por favor introduzca un ID valido"
	  ); } } while (l > 0);
	  
	  break; case 3:
	  System.out.println("Guardando en la base de datos...\n\nGuardado"); break;
	  case 4: System.out.println("Guardando en la base de datos...\n\nGuardado");
	  break;
	  
	  default: System.out.println("Por favor seleccione una opcion correcta");
	  break; }
	  
	 } while (opcion != 4); } }
	 */
}
