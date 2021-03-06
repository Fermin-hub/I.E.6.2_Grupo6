package dam.obj;

/**
 * 
 * @author Fermin Jimenez, Manuel Corona, Daniel Garcia.
 * @version 1.0
 * 
 */
public class Representante {

	/**
	 * Variables
	 * 
	 * @param nombre,   Nombre del Representante
	 * @param apellido, Apellido del Representante
	 * @param edad,     Edad del Representante
	 * @param id,       ID del Representante
	 * @param sueldo,   Sueldo del Representante
	 * @param grupo,    Grupo del Representante
	 */
	private String nombre, apellido;
	private int edad, id;
	private static int id2 = 100;
	private float sueldo;
	private Grupo grupo;

	/**
	 * Constructor vacio
	 */
	public Representante() {

	}

	/**
	 * Constructor
	 * 
	 * @param nombre,   Nombre del Representante
	 * @param apellido, Apellido del Representante
	 * @param edad,     Edad del Representante
	 * @param sueldo,   Sueldo del Representante
	 * @param grupo,    Grupo del Representante
	 */
	public Representante(String nombre, String apellido, int edad, float sueldo, Grupo grupo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sueldo = sueldo;
		this.grupo = grupo;
		id2++;
		id = id2;
	}

	
	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "ID: " + id + " - El manager " + nombre + " " + apellido + " representa al grupo musical '" + grupo
				+ "'." + " Su discografia esta formada por: ";
	}
}
