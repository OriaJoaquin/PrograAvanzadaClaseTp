package items;

import unidad.Unidad;

/**
 * @author Lucas
 * ESTA CLASE ACTÚA COMO DECORATOR, HACIENDO QUE TODOS LOS MÉTODOS DE UNIDAD TENGAN ALGO EXTRA.
 */
public abstract class Items extends Unidad{

	protected Unidad unidad;//SE NECESITA, YA QUE SINO NUNCA TENDRÍA UNA INSTANCIA DE condicionAtaque.
	
	public Items(Unidad unidad) {
		
		//SE NECESITA HEREDAR DE UNIDAD, ASÍ SE PUEDEN SOBREESCRIBIR VARIOS DE SUS MÉTODOS.
		super(unidad);
		this.unidad = unidad;
	}
	
	@Override
	public boolean condicionAtaque(double distanciaConElEnemigo) {
		return this.unidad.condicionAtaque(distanciaConElEnemigo);
	}
}