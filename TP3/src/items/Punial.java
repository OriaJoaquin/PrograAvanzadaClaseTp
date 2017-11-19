package items;

import unidad.Unidad;

public class Punial extends Items {

	private static final int PUNTOSEXTRAATQUE = 3;
	private static final int PUNTOSMENOSDEFENSA = 3;
	private static final int SINMANOSDISPONIBLES = 0;
	
	/**
	 * AUMENTA EL ATAQUE 3 PUNTOS.
	 * REDUCE LA DEFENSA 3 PUNTOS.
	 * @param unidad
	 */
	public Punial(Unidad unidad) {
		super(unidad);
		if(this.manosDisponibles > SINMANOSDISPONIBLES) {
			super.manosDisponibles --;
			super.ataque += PUNTOSEXTRAATQUE;
			super.puntosMenosDefensa +=PUNTOSMENOSDEFENSA;
		}else {
			System.out.println("No tiene manos disponibles.");
		}
	}

}
