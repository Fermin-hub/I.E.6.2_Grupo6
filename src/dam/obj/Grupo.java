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

	public Grupo() {
		
	}

	/**
	 * Getters y Setters
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
	 * @return lista ordenada por nombre
	 */
	public List<Cd> getListaCd() { // Ordena con sorted por nombre de CD
		return listaCd.stream().sorted(Comparator.comparing(Cd::getNombre)).collect(Collectors.toList());
	}

	public void setListaCd(List<Cd> listaCd) {
		this.listaCd = listaCd;
	}
	
	/**
	 * Metodo para encontrar un CD especifico.
	 * @param nombre
	 * @return
	 */
	public boolean encontrarCD(String nombre) {
		int h=0;
		for (Cd cd : listaCd) {
			if (cd.getNombre().equals(nombre)) {
				h++;
			}
			
		}
		if (h>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void cambiarnombreCd(String nombre, String nuevonombre) {
	 for (Cd cd : listaCd) {
		if (cd.getNombre().equals(nombre)) {
			cd.setNombre(nuevonombre);
			
		}
	 }
	}
	
	public void cambiaranioCd(String nombre, int nuevoanio, int mes , int dia) {
		 for (Cd cd : listaCd) {
			if (cd.getNombre().equals(nombre)) {
				cd.modificarfecha(nuevoanio, mes, dia);
				
			}
		 }
		}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return getNombre();
	}

}