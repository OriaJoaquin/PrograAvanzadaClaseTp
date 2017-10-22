package items;

import unidad.Unidad;

public class Capa extends Items {
	
	/**
	 * Duplica la energía
	 * @param unidad
	 */
	public Capa(Unidad unidad) {
		super(unidad);
		unidad.setEnergia(unidad.getEnergia() * 2);
		unidad.setEnergiaTope(unidad.getEnergiaTope() * 2);
	}

	/* (non-Javadoc)
	 * @see unidad.Unidad#atacar(unidad.Unidad)
	 * //Reduce the attack a 10%.
	 */
	@Override
	public Unidad atacar(Unidad enemigo) {
		this.unidad.setAtaque(this.unidad.getAtaque()*0.9); 
		return this.unidad.atacar(enemigo);
	}

}
