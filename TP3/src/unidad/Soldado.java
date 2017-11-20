package unidad;

public class Soldado extends Unidad {

	private static int DISTANCIAATAQUE = 0;
	private static int ENERGIAINICIAL = 100;
	private static int CONSUMOENERGIAATAQUE = 10;
	private static int SALUDINICIAL = 200;
	private static int ATAQUEINICIAL = 10;
	
	public Soldado(Punto ubicacion) {
		super(SALUDINICIAL, ATAQUEINICIAL, ubicacion, ENERGIAINICIAL);
	}

	public void consumirPocionDeAgua() {
		this.energia = this.energiaTope;
	}

	@Override
	public boolean condicionAtaque(double distanciaConElEnemigo) {
		if (this.energia >= CONSUMOENERGIAATAQUE && distanciaConElEnemigo == DISTANCIAATAQUE) {
			this.energia -= CONSUMOENERGIAATAQUE;
			return true;
		}else {
			return false;
		}
			
	}

}
