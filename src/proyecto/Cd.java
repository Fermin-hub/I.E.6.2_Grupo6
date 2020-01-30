package proyecto;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Cd {

	private String nombre;
	private LocalDate date;
	
	public Cd (String nombre,int año,int mes,int dia) {
		date = LocalDate.of(año, mes, dia);
		this.nombre=nombre;
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
	
	

}
