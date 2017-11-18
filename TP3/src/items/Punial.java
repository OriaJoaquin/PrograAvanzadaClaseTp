package items;

import unidad.Unidad;

public class Punial extends Items {

	private static final int PUNTOSEXTRAATQUE = 3;
	
	public Punial(Unidad unidad) {
		super(unidad);
		this.unidad.setAtaque(this.unidad.getAtaque() + PUNTOSEXTRAATQUE);
		if(this.manosDisponibles > 0)
			this.manosDisponibles --;//= 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see unidad.Unidad#atacar(unidad.Unidad) Increase the attack 3 points.
	 */
	@Override
	public void atacar(Unidad enemigo) {
		this.unidad.atacar(enemigo);
	}

	@Override
	protected double recibirAtaque(double puntosAtaque) {
		return puntosAtaque;
	}
}
