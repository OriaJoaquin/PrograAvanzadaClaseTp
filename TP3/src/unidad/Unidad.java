package unidad;

//Template Method
public abstract class Unidad {

	protected double salud;
	protected double ataque;
	protected Punto ubicacion;

	public Unidad() {
	}

	public Unidad(double salud, double ataque, Punto ubicacion) {
		this.salud = salud;
		this.ataque = ataque;
		this.ubicacion = ubicacion;
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
