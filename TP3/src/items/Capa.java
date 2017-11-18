package items;

import unidad.Unidad;

public class Capa extends Items {

	private static final double MULTIPLICADORENERGIA = 2;
	private static final double MULTIPLICADORATAQUE = 0.9;

	/**
	 * Duplica la energía
	 * 
	 * @param unidad
	 */
	public Capa(Unidad unidad) {
		super(unidad);
		unidad.setEnergia(unidad.getEnergia() * MULTIPLICADORENERGIA);
		unidad.setEnergiaTope(unidad.getEnergiaTope() * MULTIPLICADORENERGIA);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see unidad.Unidad#atacar(unidad.Unidad) //Reduce the attack a 10%.
	 */
	@Override
	public void atacar(Unidad enemigo) {
		this.unidad.setAtaque(this.unidad.getAtaque() * MULTIPLICADORATAQUE);
		this.unidad.atacar(enemigo);// SACAR
	}

}
