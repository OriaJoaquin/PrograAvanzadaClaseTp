package unidad;

public class Arquero extends Unidad {

	private static int DISTANCIAATAQUEMINIMA = 2;
	private static int DISTANCIAATAQUEMAXIMA = 5;
	private static int CANTIDADFLECHASTOPE = 20;
	private static int SALUDINICIAL = 50;
	private static int ATAQUEINICIAL = 5;
	private int cantidadFlechas;

	public Arquero(Punto ubicacion) {
		super(SALUDINICIAL, ATAQUEINICIAL, ubicacion);
		this.cantidadFlechas = CANTIDADFLECHASTOPE;
	}

	public int getCantidadFlechas() {
		return cantidadFlechas;
	}

	public void setCantidadFlechas(int cantidadFlechas) {
		this.cantidadFlechas = cantidadFlechas;
	}

	public void recargarFlechas(int flechas) {
		this.cantidadFlechas += flechas;
	}

	@Override
	public void atacar(Unidad enemigo) {
		double distanciaConElEnemigo = this.distanciaConEnemigo(enemigo.ubicacion);
		if (this.cantidadFlechas > 0 && distanciaConElEnemigo >= DISTANCIAATAQUEMINIMA
				&& distanciaConElEnemigo <= DISTANCIAATAQUEMAXIMA) {
			this.cantidadFlechas--;
			enemigo.defender(this);
		}
	}
	
	@Override
	protected double recibirAtaque(double puntosAtaque) {
		return puntosAtaque;
	}

}
