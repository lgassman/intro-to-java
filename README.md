# Intro a java

## Entorno de desarrollo.

### JDK

Un programa java se compila a bytecode, por lo que se necesita una máquina
virtual java para ejecutar(JVM). 

Una JRE es la distribución de una JVM para una arquitectura en particular.
Es algo que se instala en la computadora.

Una JVM es una JRE + herramientas para programar (básicamente el compilador)


Por lo tanto es necesario instalar una JDK. Hay varias disponibles para
lo que necesiten, la usada como referencia es:

[Openjdk](https://openjdk.org/projects/jdk/)

También se suele usar la de oracle, ya que esa empresa compró a SUN, madre
de java. 


### IDE

Hay varios ides para java, el que uso yo y también recomiendan en objetos 2 es [eclipse](eclipse.org), aunque viene perdiendo terreno desde hace varios años frente al intellij.
También existe el netbeans que es el recomendado por oracle.


## Hello World

Este es un hello world

```
package ar.edu.unq.obj1.c2;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hola mundo");
	}

}

```
- package
- static
- visibilidad
- tipos explícitos


## Pepita volar 

### Parte 1
- Hacer a pepita que puede volar 
- Hacer un setter y un getter (this)
- Hacer un program


```
package ar.edu.unq.obj1;

public class Golondrina {

	private int energia = 100;
	
	public void volar(int distancia) {
		energia -= distancia + 10;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
}

```
```
	public static void main(String[] args) {
		Golondrina pepita = new Golondrina();
		System.out.println("pepita.getEnergia(): " + pepita.getEnergia());
		pepita.volar(10);
		System.out.println("pepita.getEnergia(): " + pepita.getEnergia());		
	}
```

### Parte 2: validar y test

- Hacer un test (assertEquals, beforeTest)
- validar la energia para volar
- Hacer un test (assertThrows)

package ar.edu.unq.obj1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

```
public class Golondrina {

	private int energia = 100;
	
	public void volar(int distancia) {
		this.validarVolar(distancia);
		energia -= this.energiaParaVolar(distancia);
	}

	private void validarVolar(int distancia) {
		if (this.energia < this.energiaParaVolar(distancia)) {
			throw new RuntimeException("No se puede volar " + distancia);
		} 
	}

	private int energiaParaVolar(int distancia) {
		return distancia + 10;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
}

```

```
class GolondrinaTest {
	
	private Golondrina pepita;
	
	@BeforeEach
	void initialize() {
		pepita = new Golondrina();
	}
	
	@Test
	void testVolar() {
		pepita.volar(10);
		assertEquals(80, pepita.getEnergia());		
	}
	
	@Test
	void testNoPuedeVolar() {
		assertThrows(RuntimeException.class, ()->pepita.volar(1000) );
		assertEquals(100, pepita.getEnergia());		
	}

}
```

## Pepita comer alpiste y manzana

Hacer que coma alpiste

Para comer la manzana también, aparece el problema del polimorfismo y las interfaces

- polimorfismo
- constructor
- static final

```
public interface Alimento {

	public int energiaQueAporta();
}


```

```
public class Alpiste implements Alimento{

	
	public int energiaQueAporta() {
		return 20;
	}
	
}
```

```
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

```
## Herencia: Manzana Verde (aporte la mitad de energia, y la madurez inicial es 2)

```
public class ManzanaVerde extends Manzana {
	
	public ManzanaVerde() {
		this(2);
	}
	
	public ManzanaVerde(int madurez) {
		super(madurez);
	}
	
	@Override
	public int energiaQueAporta() {
		return super.energiaQueAporta() / 2;
	}

}
```

## Herencia: Ave abstracta (gorrion gasta 20 + la mitad de la distancia)

(Usar el refactor extract class, cambiar el tipo de acción sobre energia que aporta)
Roque usa a pepita o a pepon

## Roque entrena 1 ave. Luego entrena varias

```
package ar.edu.unq.obj1;

import java.util.Collection;

public class Entrenador {

	private Collection<Ave> entrenadas;

	public Entrenador(Collection<Ave> entrenadas) {
		this.entrenadas = entrenadas;
	}
	
	public void entrenar() {
		for (Ave ave : entrenadas) {
			ave.volar(10);
		}
	}

}
```

## Composite: combo
 - mostrar el test que pasa si la variable la declaro alimento
 
 ```
 package ar.edu.unq.obj1.c2.alimentos;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.edu.unq.obj1.c2.Alimento;

public class Combo implements Alimento {

	Collection<Alimento> comidas = new HashSet<Alimento>();
	
	public void agregar(Alimento alimento) {
		comidas.add(alimento);
	}
	
	@Override
	public int energiaQueAporta() {
//		int acumulador = 0;
//		for (Alimento alimento : alimentos) {
//			acumulador += alimento.energiaQueAporta();
//		}
//		return acumulador;
		
		//return comidas.stream().mapToInt( (alimento) -> alimento.energiaQueAporta() ).reduce(0, (a,b)->a+b );
	
		return comidas.stream().collect(Collectors.summingInt((alimento)->alimento.energiaQueAporta()));
	}
	
	public Collection<Alimento> aportanMasDe(int cantidad) {
		return comidas.stream().filter((alimento) -> alimento.energiaQueAporta() > cantidad).collect(Collectors.toSet());
	}
	
	public boolean hayAlgunoQueAportaMas(int cantidad) {
		return comidas.stream().anyMatch((alimento)->alimento.energiaQueAporta() > cantidad);
	}

	public boolean todosAportanMas(int cantidad) {
		return comidas.stream().allMatch((alimento)->alimento.energiaQueAporta() > cantidad);
	}

}
 ```
 
 ## Singletons
 
 Y si posta necesitaba un object{} de wollok?
 
 Entonces hay que hacer una clase que se pueda instanciar una sola vez,
 y esté de acceso global.
 
 Generalmente se instancia de manera lazy, siendo ésta una de las situaciones
 en que se permite que un método tenga efecto y devuelva un valor.
 

 
 ```
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
 ```
 
 
 
 
 

