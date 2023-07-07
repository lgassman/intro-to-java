package ar.edu.unq.obj1.c2;

import ar.edu.unq.obj1.c2.alimentos.Alpiste;
import ar.edu.unq.obj1.c2.alimentos.Manzana;

public class Main {
	
	public static void main(String[] args) {
		Golondrina pepita = new Golondrina();
		Alpiste alpiste = new Alpiste(); 
		Manzana manzana = new Manzana();
		System.out.println("pepita.energia(): " + pepita.energia());
		pepita.volar(10);
		System.out.println("pepita.energia(): " + pepita.energia());		
		pepita.comer(alpiste);
		System.out.println("pepita.energia(): " + pepita.energia());		
		pepita.comer(manzana);
		System.out.println("pepita.energia(): " + pepita.energia());		
	}

}
