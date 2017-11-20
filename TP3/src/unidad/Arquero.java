package unidad;

public class Arquero extends Unidad {

	private static int DISTANCIAATAQUEMINIMA = 2;
	private static int DISTANCIAATAQUEMAXIMA = 5;
	private static int CANTIDADFLECHASTOPE = 20;
	private static int SALUDINICIAL = 50;
	private static int ATAQUEINICIAL = 5;
	private static int SINFLECHAS=0;
	private int cantidadFlechas;

	public Arquero(Punto ubicacion) {
		super(SALUDINICIAL, ATAQUEINICIAL, ubicacion);
		this.cantidadFlechas = CANTIDADFLECHASTOPE;
	}

	public void recargarFlechas(int flechas) {
		this.cantidadFlechas += flechas;
	}

	@Override
	public boolean condicionAtaque(double distanciaConElEnemigo) {
		if (this.cantidadFlechas > SINFLECHAS && distanciaConElEnemigo >= DISTANCIAATAQUEMINIMA
				&& distanciaConElEnemigo <= DISTANCIAATAQUEMAXIMA) {
			this.cantidadFlechas--;
			return true;
		}else {
			return false;
		}	
	}
}
