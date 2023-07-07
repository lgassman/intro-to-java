package ar.edu.unq.obj1.c2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.obj1.c2.Alimento;
import ar.edu.unq.obj1.c2.Golondrina;
import ar.edu.unq.obj1.c2.alimentos.Alpiste;
import ar.edu.unq.obj1.c2.alimentos.Combo;
import ar.edu.unq.obj1.c2.alimentos.Manzana;

class ComboTest {

	private Golondrina pepita;
	private Combo almuerzo;
	private Combo manzanas;
	private Alimento alpiste;
	
	@BeforeEach
	void setUp() {
		pepita = new Golondrina();
		almuerzo = new Combo();
		manzanas = new Combo();
		manzanas.agregar(new Manzana());
		manzanas.agregar(new Manzana(2));
		
		alpiste = new Alpiste();
		almuerzo.agregar(manzanas);
		almuerzo.agregar(alpiste);
	}
	
	@Test
	void testEnergiaQueAporta() {
		
		pepita.comer(almuerzo);
		assertEquals(135, pepita.energia());
		
	}
	
	@Test
	void testAportan() {
		Collection<Alimento> alimentos = almuerzo.aportanMasDe(19);
		assertEquals(1, alimentos.size());
		assertTrue(alimentos.contains(alpiste));
		
		assertFalse(almuerzo.todosAportanMas(19));
		assertTrue(almuerzo.hayAlgunoQueAportaMas(19));
	}

}
