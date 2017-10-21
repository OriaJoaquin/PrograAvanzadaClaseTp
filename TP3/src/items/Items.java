package items;

import unidad.Unidad;

//Decorator
//This methods do all that do the methods of UNIDAD but with thing extra. 
public abstract class Items extends Unidad{

	protected Unidad unidad;
	
	public Items(Unidad unidad) {
		super(unidad.getSalud(),unidad.getAtaque(),unidad.getUbicacion(),unidad.getEnergia());
		this.unidad = unidad;
	}
	
}
