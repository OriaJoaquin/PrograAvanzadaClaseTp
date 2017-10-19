package items;

import unidad.Unidad;

public class Punial extends Items {

	public Punial(Unidad unidad) {
		super(unidad);
	}

	@Override
	public Unidad atacar(Unidad enemigo) {
		this.unidad.setAtaque(this.unidad.getAtaque()+3);//Increase the attack 3 points.
		enemigo = this.unidad.atacar(enemigo);
		return  enemigo;
	}

	@Override
	public Unidad defender(Unidad enemigo) {
		enemigo.setAtaque(enemigo.getAtaque()+3);//Reduce the defense 3 points.
		return this.unidad.defender(enemigo);
	}
	
}
