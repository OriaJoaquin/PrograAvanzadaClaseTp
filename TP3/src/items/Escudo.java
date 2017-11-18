package items;

import unidad.Unidad;

public class Escudo extends Items {

	private static final double MULTIPLICADORDEFENSA = 0.4;

	public Escudo(Unidad unidad) {
		super(unidad);
		unidad.setDefensa(MULTIPLICADORDEFENSA);
	}

	@Override
	public void atacar(Unidad enemigo) {
		this.unidad.atacar(enemigo);
	}

}
