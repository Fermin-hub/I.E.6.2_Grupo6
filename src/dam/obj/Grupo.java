package dam.obj;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author: Fermin Jimenez, Manuel Corona, Daniel Garcia.
 * @version: 02/2020
 * 
 */

public class Grupo {
	
	/**
	 * Atributos
	 */
	private String nombre, pais;
	private List<Cd> listaCd = new ArrayList<Cd>();

	public Grupo(String nombre, String pais, List<Cd> cd) {
		this.nombre = nombre;
		this.pais = pais;
		this.listaCd = cd;
	}

	/**
	 * Getters y Setters
	 * @return
	 */
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

	/**
	 * Get y Set de ListaCd
	 * Ordena con sorted por nombre de CD
	 * @return
	 */
	public List<Cd> getListaCd() { // Ordena con sorted por nombre de CD
		return listaCd.stream().sorted(Comparator.comparing(Cd::getNombre)).collect(Collectors.toList());
	}

	public void setListaCd(List<Cd> listaCd) {
		this.listaCd = listaCd;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return getNombre();
	}

}