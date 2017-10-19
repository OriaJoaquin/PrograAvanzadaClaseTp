package items;

import unidad.Unidad;

public class Escudo extends Items {

	public Escudo(Unidad unidad) {
		super(unidad);
	}

	@Override
	public Unidad atacar(Unidad enemigo) {
		return this.unidad.atacar(enemigo);
	}
	 
	@Override
	public Unidad defender(Unidad enemigo) {
		enemigo.setAtaque(enemigo.getAtaque()*0.4); //Receive only 40% of attack.
		return this.unidad.defender(enemigo);		
	}
		
}
