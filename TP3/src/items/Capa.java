package items;

import unidad.Unidad;

public class Capa extends Items {

	private static final double MULTIPLICADORENERGIA = 2;
	private static final double MULTIPLICADORATAQUE = 0.9;

	/**
	 * DUPLICA LA ENERGÍA.
	 * REDUCE EL ATAQUE UN 10%.
	 * @param unidad
	 */
	public Capa(Unidad unidad) {
		super(unidad);
		this.energia = this.energia  * MULTIPLICADORENERGIA;
		this.energiaTope = this.energiaTope * MULTIPLICADORENERGIA;
		this.ataque *= MULTIPLICADORATAQUE;
	}

}

