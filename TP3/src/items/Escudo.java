package items;

import unidad.Unidad;

public class Escudo extends Items {

	private static final double MULTIPLICADORDEFENSAESCUDO = 0.4;
	private static final int SINMANOSDISPONIBLES = 0;
	
	/**
	 * REDUCE UN 40% LOS ATAQUES QUE SE RECIBEN.
	 * @param unidad
	 */
	public Escudo(Unidad unidad) {
		super(unidad);
		if(this.manosDisponibles > SINMANOSDISPONIBLES) {;
			super.manosDisponibles --;
			super.multiplicadorDefensa *=MULTIPLICADORDEFENSAESCUDO;
		}else {
			System.out.println("No tiene manos disponibles.");
		}
	}

}
