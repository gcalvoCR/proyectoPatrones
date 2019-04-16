package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Rey extends Pieza {

	public Rey(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.REY;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "K";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return false;
	}

}
