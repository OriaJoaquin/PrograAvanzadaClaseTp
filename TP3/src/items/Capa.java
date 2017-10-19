package items;

import unidad.Unidad;

public class Capa extends Items {

	//DUPLICA ENERGÍA PENDIENTE
	
	public Capa(Unidad unidad) {
		super(unidad);
	}

	@Override
	public Unidad atacar(Unidad enemigo) {
		this.unidad.setAtaque(this.unidad.getAtaque()*0.9); //Reduce the attack a 10%.
		return this.unidad.atacar(enemigo);
	}

}
