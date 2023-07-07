package ar.edu.unq.obj1.c2;

public abstract class Ave {
	private int energia = 100;


	private void validarVolar(int distancia) {
		if (this.energia < this.energiaParaVolar(distancia)) {
			throw new RuntimeException("Se necesitan " + this.energiaParaVolar(distancia)
					+ " de energia para volar y solo se tiene " + this.energia);
		}
	}

	public void volar(int kms) {
		this.validarVolar(kms);
		energia -= this.energiaParaVolar(kms);
	}

	public int energia() {
		return energia;
	}

	public void comer(Alimento alimento) {
		energia = energia + alimento.energiaQueAporta();
	}
	
	abstract protected int energiaParaVolar(int distancia);

}
