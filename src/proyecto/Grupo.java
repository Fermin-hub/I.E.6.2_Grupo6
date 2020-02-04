package proyecto;

import java.util.Comparator;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Grupo implements Comparable<Cd>{

	private static String nombre,pais;
	private Cd cd;
	private Map<String, Cd> treeMap = new TreeMap<String, Cd>();

	public Grupo (String nombre,String pais) {
		this.nombre=nombre;
		this.pais=pais;
	}
	
	public Map<String, Cd> getTreeMap() {
		return treeMap;
	}

	public void setTreeMap(Map<String, Cd> treeMap) {
		this.treeMap = treeMap;
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

	public Cd getCd() {
		return treeMap.get(nombre);
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	@Override
	public int compareTo(Cd o) {
		LocalDate r = Grupo.this.getCd().getDate();
		r.compareTo(o.getDate());
        if (r.compareTo(o.getDate()) < 0) {
            return -1;
        } else if (r.compareTo(o.getDate())  == 0) {
        	return 0;    
        } else {
            return 1;
        }
	}

	public void setTreeMap(String nombre, Cd cd) {
		treeMap.put(nombre, cd);	
	}

	@Override
	public String toString() {
		return "Grupo "+ getNombre() +" CD: ";// +cd.getNombre();
		//return "Grupo [cd=" + cd + ", getNombre()=" + getNombre() + "]";
	}
	

}
