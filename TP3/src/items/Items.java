package items;

import unidad.Unidad;

/**
 * @author Lucas
 * ESTA CLASE ACT�A COMO DECORATOR, HACIENDO QUE TODOS LOS M�TODOS DE UNIDAD TENGAN ALGO EXTRA.
 */
public abstract class Items extends Unidad{

	protected Unidad unidad;//SE NECESITA, YA QUE SINO NUNCA TENDR�A UNA INSTANCIA DE condicionAtaque.
	
	public Items(Unidad unidad) {
		
		//SE NECESITA HEREDAR DE UNIDAD, AS� SE PUEDEN SOBREESCRIBIR VARIOS DE SUS M�TODOS.
		super(unidad);
		this.unidad = unidad;
	}
	
	@Override
	public boolean condicionAtaque(double distanciaConElEnemigo) {
		return this.unidad.condicionAtaque(distanciaConElEnemigo);
	}
}