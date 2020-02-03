package dam.obj;

import java.time.LocalDate;

public class Cd {

	private String nombre;
	private LocalDate date;

	/**
	 * 
	 * @param nombre del CD
	 * @param anio   de la publicacion del CD
	 * @param mes    de la publicacion del CD
	 * @param dia    de la publicacion del CD
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

	@Override
	public String toString() {
		return getNombre() + " Cuyo CD fue lanzado en " + getDate();
	}

}
