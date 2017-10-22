package items;

import unidad.Unidad;

public class Punial extends Items {

	public Punial(Unidad unidad) {
		super(unidad);
	}

	/* (non-Javadoc)
	 * @see unidad.Unidad#atacar(unidad.Unidad)
	 * Increase the attack 3 points.
	 */
	@Override
	public Unidad atacar(Unidad enemigo) {
		this.unidad.setAtaque(this.unidad.getAtaque()+3);
		enemigo = this.unidad.atacar(enemigo);
		return  enemigo;
	}

	/* (non-Javadoc)
	 * @see unidad.Unidad#defender(unidad.Unidad)
	 * Reduce the defense 3 points.
	 */
	@Override
	public Unidad defender(Unidad enemigo) {
		enemigo.setAtaque(enemigo.getAtaque()+3);
		return this.unidad.defender(enemigo);
	}
	
}
