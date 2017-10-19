package unidad;

public class Caballero extends Unidad {
	
	private static int DISTANCIAATAQUEMINIMA = 1;
	private static int DISTANCIAATAQUEMAXIMA = 2;
	private static int CABALLOREBELDE = 3; 
	private int cantidadAtaques;
	
	public Caballero(Punto ubicacion) {
		super(200,50,ubicacion);
		this.cantidadAtaques = 0;
	}
	
	public void consumirPocionDeAgua() {
		this.cantidadAtaques = 0;
	}
	
	@Override
	public Unidad atacar(Unidad enemigo) {
		double distanciaConElEnemigo = this.distanciaConEnemigo(enemigo.ubicacion);
		if (this.cantidadAtaques < CABALLOREBELDE && distanciaConElEnemigo >= DISTANCIAATAQUEMINIMA && distanciaConElEnemigo <= DISTANCIAATAQUEMAXIMA) {
			this.cantidadAtaques++;
			enemigo = enemigo.defender(this);
		}
		return enemigo;
	}

}
