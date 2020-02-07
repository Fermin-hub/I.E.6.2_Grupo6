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
				modificarDatos();
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
	 * @param entrada,            para leer excepciones
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
			System.out
					.println("\n====================\nDiscografia\n====================\n1. Agregar Disco \n2. Salir");
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
				 * for (int i = 0; i < listaRepresentante.size() && encontrado == null; i++) {
				 * if (listaRepresentante.get(i).getId() == id) { encontrado =
				 * listaRepresentante.get(i); }
				 * 
				 * }
				 */
				Representante encontrado = listaRepresentante.stream().filter(r -> r.getId() == id).findFirst()
						.orElse(new Representante());
				// Imprime el resultado de la busqueda
				if (encontrado.getNombre() == null) {
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

	public static void modificarDatos() throws IOException {

		int opcion = 0;
		do {
			System.out.println(
					"\n====================\nMenu Modificar\n====================\n1. Editar Representante \n2. Editar Grupo \n3. Editar Discografia \n4. Salir");
			opcion=entrada.controlaInt();
			switch (opcion) {
			case 1:
				int j = 0;
				Representante temp = new Representante();
				if (listaRepresentante.size() == 0) {
					System.out.println("No existen Datos Almacenados.");
				} else {
					do {
						j = 0;
						System.out.println("Por favor Introduzca la ID del representante para Modificar sus datos");
						listarRepreresumido();
						int id = entrada.controlaInt();
						/*
						 * for (int i = 0; i < listaRepresentante.size(); i++) { if (id ==
						 * listaRepresentante.get(i).getId()) { temp = listaRepresentante.get(i); } }
						 */

						temp = listaRepresentante.stream().filter(r -> r.getId() == id).findFirst()
								.orElse(new Representante());

						if (temp.getNombre() != null) {
							int opcion6 = 0;
							do {
								System.out.println(
										"\n====================\nRepresentante\n====================\n1. Cambiar Nombre \n2. Cambiar Apellido \n3. Cambiar Edad \n4. Cambiar Sueldo \n5. Salir");
								opcion6=entrada.controlaInt();
								switch (opcion6) {

								case 1:
									System.out.println("Por favor, introduzca el nuevo Nombre del Representante");
									temp.setNombre(sc.nextLine());
									break;
								case 2:
									System.out.println("Por favor, introduzca el nuevo Apellido del Representante");
									temp.setApellido(sc.nextLine());
									break;
								case 3:
									System.out.println("Por favor, introduzca la nueva Edad del Representante");
									temp.setEdad(entrada.controlaInt());
									break;
								case 4:
									System.out.println("Por favor, introduzca el nuevo Sueldo del Representante");
									temp.setSueldo(entrada.controlaFloat());
									break;
								case 5:
									System.out.println("Guardando en la base de datos...\n\nGuardado");
									break;

								default:
									System.out.println("Por favor seleccione una opcion correcta");
									break;
								}

							} while (opcion6 != 5);

						} else {
							System.out.println("El ID introducido no es correcto por favor introduzca un ID valido");
							j++;
						}
					} while (j > 0);
				}

				break;
			case 2:

				int k = 0;
				if (listaRepresentante.isEmpty()) {
					System.out.println("No existen Datos almacenados");
				} else {
					do {
						k = 0;

						for (int i = 0; i < listaRepresentante.size(); i++) {
							System.out.println(
									(i + 1) + ". Banda Musical: " + listaRepresentante.get(i).getGrupo().getNombre()
											+ " cuya ID es " + listaRepresentante.get(i).getId() + "\n");
						}
						System.out.println("Introduzca la ID de la banda deseada para modificar sus datos");
						int id = entrada.controlaInt();
						Representante encontrado = listaRepresentante.stream().filter(r -> r.getId() == id).findFirst()
								.orElse(new Representante());

						/*
						 * for (int i = 0; i < listaRepresentante.size() && encontrado == null; i++) {
						 * if (listaRepresentante.get(i).getId() == id) { encontrado =
						 * listaRepresentante.get(i); }
						 * 
						 * }
						 */

						// Imprime el resultado de la busqueda
						if (encontrado.getNombre() == null) {
							System.out.println("El ID introducido no es correcto por favor introduzca un ID valido");
							k++;
						} else {
							int opcion2 = 0;
							do {
								System.out.println(
										"\n====================\nBanda Musical\n====================\n1. Cambiar Nombre \n2. Cambiar Pais \n3. Salir");
								opcion2=entrada.controlaInt();
								switch (opcion2) {
								case 1:
									System.out.println("Por favor, introduzca el nuevo nombre de la Banda Musical");
									encontrado.getGrupo().setNombre(sc.nextLine());
									break;
								case 2:
									System.out.println("Por favor, introduzca el nuevo Pais de la Banda Musical");
									encontrado.getGrupo().setPais(sc.nextLine());
									break;
								case 3:
									System.out.println("Guardando en la base de datos...\n\nGuardado");
									break;

								default:
									System.out.println("Por favor seleccione una opcion correcta");
									break;
								}

							} while (opcion2 != 3);

						}

					} while (k > 0);
				}

				break;
			case 3:
				int z = 0;
				if (listaRepresentante.isEmpty()) {
					System.out.println("No existen Datos almacenados");
				} else {
					do {
						z = 0;

						for (int i = 0; i < listaRepresentante.size(); i++) {
							System.out.println(
									(i + 1) + ". Banda Musical: " + listaRepresentante.get(i).getGrupo().getNombre()
											+ " cuya ID es " + listaRepresentante.get(i).getId() + "\n");
						}
						System.out.println("Introduzca la ID de la banda para modificar su discografia");
						int id = entrada.controlaInt();
						Representante encontrado = listaRepresentante.stream().filter(r -> r.getId() == id).findFirst()
								.orElse(new Representante());

						/*
						 * for (int i = 0; i < listaRepresentante.size() && encontrado == null; i++) {
						 * if (listaRepresentante.get(i).getId() == id) { encontrado =
						 * listaRepresentante.get(i); }
						 * 
						 * }
						 */

						// Imprime el resultado de la busqueda
						if (encontrado.getNombre() == null) {
							System.out.println("El ID introducido no es correcto por favor introduzca un ID valido");
							z++;
						} else {

							int opcion8 = 0;
							for (Cd cd : encontrado.getGrupo().getListaCd()) {
								System.out.println(cd.toString());
							}
							do {
								System.out.println(
										"\n====================\nBanda Musical\n====================\n1. Cambiar Nombre \n2. Cambiar Fecha \n3. Salir");
								opcion8=entrada.controlaInt();
								switch (opcion8) {

								case 1:
									System.out.println("Por favor, escriba el nombre del CD que desea cambiar");
									String nombre = sc.nextLine();

									if (encontrado.getGrupo().encontrarCD(nombre) == true) {
										System.out.println("Por favor, escriba el nuevo nombre del CD");
										String nuevonombre = sc.nextLine();
										encontrado.getGrupo().cambiarnombreCd(nombre, nuevonombre);
									} else {
										System.out.println("El nombre del CD introducido no es valido");

									}
									break;
								case 2:
									// System.out.println("Por favor, introduzca el nuevo A�o del CD");
									System.out.println("Por favor, escriba el nombre del CD que desea cambiar");
									String nombre2 = sc.nextLine();

									if (encontrado.getGrupo().encontrarCD(nombre2) == true) {
										int anodisco = 0, dia = 0, mes = 0;
										System.out.println("Por favor, introduzca el a�o de publicacion del disco");
										anodisco = entrada.controlaInt();
										do {
											System.out.println(
													"Por favor, introduzca el numero de mes de la publicacion del disco");
											mes = entrada.controlaInt();
										} while (mes < 1 || mes > 12);
										dia = (int) (Math.random() * 10) + 1;
										encontrado.getGrupo().cambiaranioCd(nombre2, anodisco, mes, dia);
									} else {
										System.out.println("El nombre del CD introducido no es valido");

									}

									break;
								case 3:
									System.out.println("Guardando en la base de datos...\n\nGuardado");
									break;

								default:
									System.out.println("Por favor seleccione una opcion correcta");
									break;
								}

							} while (opcion8 != 3);

						}

					} while (z > 0);
				}
				break;
			case 4:
				System.out.println("Guardando en la base de datos...\n\nGuardado");
				break;

			default:
				System.out.println("Por favor seleccione una opcion correcta");
				break;
			}

		} while (opcion != 4);

	}

}
