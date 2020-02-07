package dam.obj;

import java.time.LocalDate;

/**
 * 
 * @author Fermin Jimenez, Manuel Corona, Daniel Garcia.
 * @version 1.0
 *
 */

public class Cd {

	/**
	 * Atributos
	 */
	private String nombre;
	private LocalDate date;

	/**
	 * Constructor
	 * 
	 * @param nombre CD
	 * @param anio   anio de publicacion del disco
	 * @param mes    mes de publicacion del disco
	 * @param dia    dia de publicacion del disco
	 */
	public Cd(String nombre, int anio, int mes, int dia) {
		this.date = LocalDate.of(anio, mes, dia);
		this.nombre = nombre;

	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/*
	 * metodo para modificar las fechas de los CD
	 */
	public void modificarfecha(int anio, int mes, int dia) {
		this.date = LocalDate.of(anio, mes, dia);

	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return getNombre() + " cuyo CD fue lanzado en " + getDate();
	}

}
