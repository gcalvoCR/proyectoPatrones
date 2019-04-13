package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Dama extends Pieza {

	public Dama(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.DAMA;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "X";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return false;
	}

}
