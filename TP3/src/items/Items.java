package items;

import unidad.Unidad;

/**
 * @author Lucas
 * Esta clase actúa como Decorator, haciendo que todos los métodos
 * de Unidad tengan algo extra.
 */
public abstract class Items extends Unidad{

	protected Unidad unidad;
	
	public Items(Unidad unidad) {
		super(unidad.getSalud(),unidad.getAtaque(),unidad.getUbicacion(),unidad.getEnergia());
		this.unidad = unidad;
	}
	
}
