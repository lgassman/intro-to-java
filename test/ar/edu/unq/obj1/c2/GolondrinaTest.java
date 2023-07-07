package ar.edu.unq.obj1.c2;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GolondrinaTest {

	Golondrina pepita;
	
	@BeforeEach
	void setUp() {
		pepita = new Golondrina();
	}
	
	@Test
	void volar() {
		pepita.volar(10);
		assertEquals(80, pepita.energia());
	}
	
	@Test
	void volarMucho() {
		assertThrows(RuntimeException.class, () -> pepita.volar(100));
		assertEquals(100, pepita.energia());
		
	}


}
