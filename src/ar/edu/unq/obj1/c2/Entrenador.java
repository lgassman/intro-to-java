package ar.edu.unq.obj1.c2;

import java.util.ArrayList;
import java.util.Collection;

public class Entrenador {
	
	private static Entrenador instance;

	private Collection<Ave> aves = new ArrayList<Ave>(); 
	
	
	private Entrenador() {
		
	}
	
	public static Entrenador getInstance() {
		if (instance == null) {
			instance = new Entrenador();
		}
		return instance;
	}
		
	public Entrenador(Collection<Ave> aves) {
		this.aves = aves;
	}
	
	public void agregarAve(Ave ave) {
		aves.add(ave);
	}
	
	public void entrenar() {
		for (Ave ave : aves) {
			ave.volar(10);
		}
	}
}
