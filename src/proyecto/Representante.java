package proyecto;

import java.util.ArrayList;

/**
* Clase Representante
* @author: Fermín Jiménez, Manuel Corona, Daniel García
* @version: 27/12/2019
*/
public class Representante {
/**
 * Declaramos atributos
 * @param nombre, Nombre Representante
 * @param apellido, Apellidos representante
 * @param edad, Edad representante
 * @param sueldo, Sueldo representante
 */
	private String nombre,apellido;
	private int edad,id;
	private static int id2 = 100;
	private float sueldo;
	private Grupo grupo;
	private boolean representando;

/**
 * Constructor
 * @param nombre Nombre representante
 * @param apellido Apellidos representante
 * @param edad Edad representante
 * @param sueldo Sueldo representante
 */
	public Representante(String nombre, String apellido, int edad, float sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sueldo = sueldo;
		id2++;
		id=id2;
		representando=true;
	}
/**
 * GETS and SETS
 */
/**
 * getNombre
 * @return nombre
 */
	public String getNombre() {
		return nombre;
	}
/**
 * getGrupo
 * @return grupo
 */
	public Grupo getGrupo() {
		return grupo;
	}
/**
 * setGrupo
 * @param grupo
 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
}
/**
 * getId
 * @return id
 */
	public int getId() {
		return id;
	}
/**
 * setId
 * @param id
 */
	public void setId(int id) {
		this.id = id;
	}
/**
 * setNombre
 * @param nombre
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * getApellido
 * @return apellido
 */
	public String getApellido() {
		return apellido;
	}
/**
 * setApellido
 * @param apellido
 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
/**
 * getEdad
 * @return edad
 */
	public int getEdad() {
		return edad;
	}
/**
 * setEdad
 * @param edad
 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
/**
 * getSueldo
 * @return sueldo
 */
	public float getSueldo() {
		return sueldo;
	}
/**
 * setSueldo
 * @param sueldo
 */
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
/**
 * Método toString
 * @return toString
 */
	@Override
	public String toString() {
		return "Representante [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}	
}
