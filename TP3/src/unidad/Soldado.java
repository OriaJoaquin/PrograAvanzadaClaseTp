package unidad;

public class Soldado extends Unidad {

	private static int DISTANCIAATAQUE = 0;
	private static int ENERGIAINICIAL = 100;
	private static int CONSUMOENERGIAATAQUE = 10;
	private static int SALUDINICIAL = 200;
	private static int ATAQUEINICIAL = 10;
	private static final double MULTIPLICADORDEFENSA = 1;
	
	public Soldado(Punto ubicacion) {
		super(SALUDINICIAL, ATAQUEINICIAL, ubicacion, ENERGIAINICIAL);
	}

	public void consumirPocionDeAgua() {
		this.energia = this.energiaTope;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see unidad.Unidad#atacar(unidad.Unidad) retorna enemigo para poder guardar
	 * los cambios.
	 */
	@Override
	public void atacar(Unidad enemigo) {
		if (this.energia >= CONSUMOENERGIAATAQUE && this.distanciaConEnemigo(enemigo.ubicacion) == DISTANCIAATAQUE) {
			this.energia -= CONSUMOENERGIAATAQUE;
			enemigo.defender(this);
		}
	}
	
	@Override
	protected double recibirAtaque(double puntosAtaque) {
		return puntosAtaque;
	}

}
