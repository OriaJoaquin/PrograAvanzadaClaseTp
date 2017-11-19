package unidad;

public class Caballero extends Unidad {

	private static int DISTANCIAATAQUEMINIMA = 1;
	private static int DISTANCIAATAQUEMAXIMA = 2;
	private static int CABALLOREBELDE = 3;
	private static int SALUDINICIAL = 200;
	private static int ATAQUEINICIAL = 50;
	private static int CANTIDADATAQUEINICIAL = 0;
	private int cantidadAtaques;

	public Caballero(Punto ubicacion) {
		super(SALUDINICIAL, ATAQUEINICIAL, ubicacion);
		this.cantidadAtaques = CANTIDADATAQUEINICIAL;
	}

	public void consumirPocionDeAgua() {
		this.cantidadAtaques = CANTIDADATAQUEINICIAL;
	}

	@Override
	public boolean condicionAtaque(double distanciaConElEnemigo) {
		if (this.cantidadAtaques < CABALLOREBELDE && distanciaConElEnemigo >= DISTANCIAATAQUEMINIMA
				&& distanciaConElEnemigo <= DISTANCIAATAQUEMAXIMA) {
			this.cantidadAtaques++;
			return true;
		}else {
			return false;
		}	
	}

}
