package dam.obj;

public class Representante {

	private String nombre, apellido;
	private int edad, id;
	private static int id2 = 100;
	private float sueldo;
	private Grupo grupo;

	/**
	 * 
	 * @param nombre   del representante
	 * @param apellido del representante
	 * @param edad     del representante
	 * @param sueldo   del representante
	 * @param grupo    Objeto Grupo
	 */
	public Representante(String nombre, String apellido, int edad, float sueldo, Grupo grupo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sueldo = sueldo;
		this.grupo = grupo;
		id2++; // contador que se inicializa en 100 y que sirve para sacar la id de cada
				// representante.
		id = id2; // id del representante que sera igualada al contador cuando el objeto sea
					// creado.

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

	@Override
	public String toString() {
		return "ID: " + id + " - El Manager " + nombre + " " + apellido + " representa al grupo musical " + grupo + "."
				+ " Su discografia esta formada por: ";
	}

}