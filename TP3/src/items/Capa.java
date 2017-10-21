package items;

import unidad.Unidad;

public class Capa extends Items {
	
	public Capa(Unidad unidad) {
		super(unidad);
		unidad.setEnergia(unidad.getEnergia() * 2);
		unidad.setEnergiaTope(unidad.getEnergiaTope() * 2);
	}

	@Override
	public Unidad atacar(Unidad enemigo) {
		this.unidad.setAtaque(this.unidad.getAtaque()*0.9); //Reduce the attack a 10%.
		return this.unidad.atacar(enemigo);
	}

}
