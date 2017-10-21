package unidad;

//Template Method
public abstract class Unidad {

	protected double saludTope;
	protected double energiaTope;
	protected double salud;
	protected double ataque;
	protected double energia;
	protected Punto ubicacion;

	public Unidad() {
	}

	public Unidad(double salud, double ataque, Punto ubicacion) {
		this.salud = salud;
		this.saludTope = salud;
		this.ataque = ataque;
		this.ubicacion = ubicacion;
		this.energia = 0;
		this.energiaTope = 0;
	}
	
	public Unidad(double salud, double ataque, Punto ubicacion, double energia) {
		this(salud,ataque,ubicacion);
		this.energia = energia;
		this.energiaTope = energia;
	}
	
	public double getEnergia() {
		return energia;
	}

	public void setEnergia(double energia) {
		this.energia = energia;
	}
	
	public double getSalud() {
		return salud;
	}

	public void setSalud(double salud) {
		this.salud = salud;
	}

	public double getAtaque() {
		return ataque;
	}

	public double getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(double energiaTope) {
		this.energiaTope = energiaTope;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public Punto getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Punto ubicacion) {
		this.ubicacion = ubicacion;
	}

	protected double distanciaConEnemigo(Punto ubicacionEnemigo) {
		return this.ubicacion.distanciaHasta(ubicacionEnemigo);
	}

	public abstract Unidad atacar(Unidad enemigo);

	public Unidad defender(Unidad enemigo) {
		if (enemigo.ataque < this.salud)
			this.salud -= enemigo.ataque;
		else
			this.salud = 0;
		return this;
	}
	
}
