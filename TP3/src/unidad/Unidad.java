package unidad;

/**
 * @author Lucas Esta clase actúa como Template Method Hace que sea una
 *         plantilla para todas las clases hijos que tenga.
 */
public abstract class Unidad {

	private static final double SINSALUD = 0;
	private static final double INICIOENERGIA = 0;
	private static final int MANOSDISPONIBLESINICIAL = 2;
	private static final int MULTIPLICADORDEFENSAINICIAL = 1;
	protected double saludTope;
	protected double energiaTope;
	protected double salud;
	protected double ataque;
	protected double energia;
	// protected double multiplicadorAtaque;
	protected double multiplicadorDefensa;
	protected double puntosMenosDefensa;
	protected int manosDisponibles;
	protected Punto ubicacion;

	public Unidad() {
	}

	public Unidad(double salud, double ataque, Punto ubicacion) {
		this.salud = salud;
		this.saludTope = salud;
		this.ataque = ataque;
		this.ubicacion = ubicacion;
		this.manosDisponibles = MANOSDISPONIBLESINICIAL;
		this.energia = INICIOENERGIA;
		this.energiaTope = INICIOENERGIA;
		this.multiplicadorDefensa = MULTIPLICADORDEFENSAINICIAL;
	}

	protected Unidad(double salud, double ataque, Punto ubicacion, double energia) {
		this(salud, ataque, ubicacion);
		this.energia = energia;
		this.energiaTope = energia;
	}
	
	protected Unidad(Unidad unidad) {
		this.salud = unidad.salud;
		this.saludTope = unidad.saludTope;
		this.ataque = unidad.ataque;
		this.ubicacion = unidad.ubicacion;
		this.manosDisponibles = unidad.manosDisponibles;
		this.energia = unidad.energia;//INICIOENERGIA;
		this.energiaTope = unidad.energiaTope;//INICIOENERGIA;
		this.multiplicadorDefensa = unidad.multiplicadorDefensa;//MULTIPLICADORDEFENSAINICIAL;
		this.puntosMenosDefensa = unidad.puntosMenosDefensa;
	}

	public double getEnergia() {
		return energia;
	}

	public double getSalud() {
		return salud;
	}

	public double getAtaque() {
		return ataque;
	}

	public void setUbicacion(Punto ubicacion) {
		this.ubicacion = ubicacion;
	}

	protected double distanciaConEnemigo(Punto ubicacionEnemigo) {
		return this.ubicacion.distanciaHasta(ubicacionEnemigo);
	}

	public abstract boolean condicionAtaque(double distanciaConElEnemigo);

	/**
	 * Establece políticas de alto nivel para batallar contra un enemigo.
	 * 
	 * @param enemigo
	 */
	public void atacar(Unidad enemigo) {
		if (condicionAtaque(this.distanciaConEnemigo(enemigo.ubicacion))) {
			enemigo.defender(this.ataque);// this.getPuntosAtaqueReal());
		}
	}

	/**
	 * Establece políticas de alto nivel para la defensa de una Unidad.
	 * 
	 * @param puntosAtaque
	 */
	public void defender(double puntosAtaque) {
		double puntosAtaqueReal = (puntosAtaque * multiplicadorDefensa) +puntosMenosDefensa;
		if (puntosAtaqueReal < this.salud)
			this.salud -= puntosAtaqueReal;
		else
			this.salud = SINSALUD;
	}

}
