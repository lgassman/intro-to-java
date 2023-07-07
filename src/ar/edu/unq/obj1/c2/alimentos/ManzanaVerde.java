package ar.edu.unq.obj1.c2.alimentos;

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
