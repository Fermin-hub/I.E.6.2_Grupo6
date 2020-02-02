package dam.obj;

import java.time.LocalDate;

public class Cd {

	private String nombre;
	private LocalDate date;
	private static int contador= 0;

	public Cd(String nombre, int anio, int mes, int dia) {
		this.date = LocalDate.of(anio, mes, dia);
		this.nombre = nombre;
		contador++;
		

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
	
	
	public static int getContador() {
		return contador;
	}

	@Override
	public String toString() {
		return getNombre() + " Cuyo CD fue lanzado en "+ getDate();
	}

}
