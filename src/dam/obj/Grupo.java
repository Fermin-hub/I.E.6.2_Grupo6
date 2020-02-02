package dam.obj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Grupo {

	private String nombre, pais;
	private List<Cd> listaCd = new ArrayList<Cd>();

	public Grupo(String nombre, String pais, List<Cd> cd) {
		this.nombre = nombre;
		this.pais = pais;
		this.listaCd = cd;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Cd> getListaCd() {
		return listaCd.stream().sorted(Comparator.comparing(Cd::getNombre)).collect(Collectors.toList());
	}

	public void setListaCd(List<Cd> listaCd) {
		this.listaCd = listaCd;
	}

	@Override
	public String toString() {
		return getNombre();
	}

}