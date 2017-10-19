package unidad;

public class Soldado extends Unidad {

	private static int DISTANCIAATAQUE = 0;
	private static int CONSUMOENERGIAATAQUE = 10;
	private static int ENERGIATOPE = 100;
	private int energia;
	
	public Soldado(Punto ubicacion) {
		super(200, 10, ubicacion);
		this.energia = ENERGIATOPE;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public void consumirPocionDeAgua() {
		this.energia = ENERGIATOPE;
	}

	@Override
	public Unidad atacar(Unidad enemigo) {
		if (this.energia >= CONSUMOENERGIAATAQUE && this.distanciaConEnemigo(enemigo.ubicacion) == DISTANCIAATAQUE) {
			this.energia -= CONSUMOENERGIAATAQUE;
			enemigo = enemigo.defender(this);
		}
		return enemigo;//To save the modification of the enemy
	}

}
