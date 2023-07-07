package ar.edu.unq.obj1.c2.alimentos;

import ar.edu.unq.obj1.c2.Alimento;

public class Manzana implements Alimento {
	
	private int madurez = 1;
	private static final int BASE = 5;
	
	public Manzana() {
		
	}
	
	public Manzana(int madurez) {
		this.madurez = madurez;
	}
	
	public int getMadurez() {
		return madurez;
	}
	
	public void setMadurez(int madurez) {
		this.madurez = madurez;
	}
	
	public void madurar() {
		this.setMadurez(this.getMadurez() + 1);
	}
	
	public int energiaQueAporta( ) {
		return this.madurez * Manzana.BASE;
	}

}
