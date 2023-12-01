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

//opcion a mano:
//		int acumulador = 0;
//		for (Alimento alimento : comidas) {
//			acumulador += alimento.energiaQueAporta();
//		}
//		return acumulador;
		
//  opcion map  + reduce (parecido a map + sum de wollok)		
//		return comidas.stream().mapToInt( (alimento) -> alimento.energiaQueAporta() ).reduce(0, (a,b)->a+b );
	
		//Esta es la opción más parecida a collecion.sum(bloque) de wollok
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
