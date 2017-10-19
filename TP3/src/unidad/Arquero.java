package unidad;

public class Arquero extends Unidad {
	
	private static int DISTANCIAATAQUEMINIMA = 2;
	private static int DISTANCIAATAQUEMAXIMA = 5;
	private static int CANTIDADFLECHASTOPE = 20;
	private int cantidadFlechas;

	public Arquero(Punto ubicacion) {
		super(50, 5, ubicacion);
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
	public Unidad atacar(Unidad enemigo) {

		double distanciaConElEnemigo = this.distanciaConEnemigo(enemigo.ubicacion);
		if (this.cantidadFlechas > 0 && distanciaConElEnemigo >= DISTANCIAATAQUEMINIMA && distanciaConElEnemigo <= DISTANCIAATAQUEMAXIMA) {
			this.cantidadFlechas--;			
			enemigo = enemigo.defender(this);
		}
		return enemigo;
	}
	
}
