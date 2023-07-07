# Intro a java

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

- Hacer a pepita que puede volar 
- Hacer un test (assertEquals)
- validar la energia para volar
- Hacer un test (assertThrows)
- this

- Hacer un program

```
	public static void main(String[] args) {
		Golondrina pepita = new Golondrina();
		System.out.println("pepita.energia(): " + pepita.energia());
		pepita.volar(10);
		System.out.println("pepita.energia(): " + pepita.energia());		
	}
```

## Pepita comer alpiste

Hacer que coma alpiste

## Manzana: 

Para comer la manzana también, aparece el problema del polimorfismo y las interfaces

- polimorfismo
 constructor
 static final

## Test
 - test de volar
 - excepciones
 - beforeEach

## Composite: combo
 - forEach
 - mostrar el test qu epasa si la variable la declaro alimento
 
## Herencia: Manzana Verde (aporte la mitad de energia)

## Herencia: Ave abstracta (gorrion gasta 20 + la mitad de la distancia)