package unidad;

public class Lancero extends Unidad {

	private static int DISTANCIAATAQUEMINIMA = 1;
	private static int DISTANCIAATAQUEMAXIMA = 3;
	private static int SALUDINICIAL = 150;
	private static int ATAQUEINICIAL = 25;
	
	public Lancero(Punto ubicacion) {
		super(SALUDINICIAL, ATAQUEINICIAL, ubicacion);
	}

	@Override
	public boolean condicionAtaque(double distanciaConElEnemigo) {
		 return (distanciaConElEnemigo >= DISTANCIAATAQUEMINIMA && distanciaConElEnemigo <= DISTANCIAATAQUEMAXIMA);	
	}

}
