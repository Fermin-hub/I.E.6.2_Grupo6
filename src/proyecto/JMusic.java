package proyecto;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;


public class JMusic {

	public static void main(String[] args) {
		
		int opcion;
		do {
		opcion = Integer.parseInt(JOptionPane.showInputDialog("JMusic Entertainment\n====================\n1. Nuevo Representante - Grupo\n2. Buscar Representante\n3. Buscar Discografía Grupo\n4. Listar Representante - Grupo\n5. Borrar Representante - Grupo\n0. Salir del programa\n\nIntroduzca una opción: "));

		switch (opcion) {
		case 1:
			aniadirRepresentante ();
			break;
		case 2:
			buscarRepresentante();
			break;
		case 3:
			
			break;
		case 4:
			listarRG ();
			break;
		case 5:
			borrar ();
			break;
		case 6:
			
			break;

		default:
			break;
		}
		}while (opcion<6);
		
		
	}
	//static ArrayList<Representante> arraylistrepresentante = new ArrayList<Representante>();
	static Map<Integer, Representante> arraylistrepresentante = new HashMap<Integer, Representante>();

	
	public static void aniadirRepresentante () {
		int opcion2;
		String nombre = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Representante");
		String apellido = JOptionPane.showInputDialog("Por favor, introduzca los apellidos del Representante");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca la edad del Representante"));
		float sueldo = Float.parseFloat(JOptionPane.showInputDialog("Por favor, introduzca el sueldo del Representante"));	
		Representante r = new Representante (nombre,apellido,edad,sueldo);	
		String nombregrupo = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Grupo");
		String pais = JOptionPane.showInputDialog("Por favor, introduzca el pais del Grupo");	
		Grupo g = new Grupo (nombregrupo,pais);
			r.setGrupo(g);
			do {
				opcion2 = Integer.parseInt(JOptionPane.showInputDialog("JMusic Entertainment\n====================\n1. Nuevo Disco - Grupo\n2. Salir"));
				if (opcion2==1) {
					String nombrecd = JOptionPane.showInputDialog("Por favor, introduzca el nombre del Disco");
					int anodisco = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el año de publicación del disco"));
					int dia = (int)(Math.random()*10)+1;
					int mes = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el mes de publicación del disco"));		
		Cd cd = new Cd (nombrecd,anodisco,mes,dia);
		g.setTreeMap(cd.getNombre(), cd);;
		}
		}while (opcion2==1);	
		arraylistrepresentante.put(r.getId(), r);
	}
	
	public static void listarRG () {
		/*for (int i = 0; i < arraylistrepresentante.size(); i++) {
			System.out.println((i+1)+". El representante "+arraylistrepresentante.get(i).getNombre()+" representa al grupo "+arraylistrepresentante.get(i).getGrupo().getNombre()+" y su ID es "+arraylistrepresentante.get(i).getId());		
		}*/
		java.util.Iterator<Integer> it = arraylistrepresentante.keySet().iterator();
		while(it.hasNext()){
		  Integer key = it.next();
		  System.out.println("Clave: " + key + " -> Valor: " + arraylistrepresentante.get(key));
		}	
	}
	
	public static void borrar () {
		listarRG ();
		int borrar = Integer.parseInt(JOptionPane.showInputDialog("Qué representante desea borrar?"));
		borrar = borrar-1;
		arraylistrepresentante.remove(borrar);
		JOptionPane.showMessageDialog(null, "El grupo "+arraylistrepresentante.get(borrar-1).getNombre()+" ha sido borrado satisfactoriamente");
	}
	
	public static void buscarRepresentante() {
		listarRG ();
		int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la ID del representante a mostrar"));
	}
	
	
}
