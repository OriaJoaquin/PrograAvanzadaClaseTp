package unidad;

public class Lancero extends Unidad {
	
	private static int DISTANCIAATAQUEMINIMA = 1;
	private static int DISTANCIAATAQUEMAXIMA = 3;
	
	public Lancero(Punto ubicacion) {
		super(150,25,ubicacion);
	}
	
	@Override
	public Unidad atacar(Unidad enemigo) {
		double distanciaConElEnemigo = this.distanciaConEnemigo(enemigo.ubicacion);

		if (distanciaConElEnemigo >= DISTANCIAATAQUEMINIMA && distanciaConElEnemigo <= DISTANCIAATAQUEMAXIMA) {
			enemigo = enemigo.defender(this);
		}
		return enemigo;
	}
	
}
