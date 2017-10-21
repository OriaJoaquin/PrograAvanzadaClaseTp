package unidad;

public class Soldado extends Unidad {

	private static int DISTANCIAATAQUE = 0;
	private static int CONSUMOENERGIAATAQUE = 10;
	
	public Soldado(Punto ubicacion) {
		super(200, 10, ubicacion,100);
	}

	public void consumirPocionDeAgua() {
		this.energia = this.energiaTope;
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
