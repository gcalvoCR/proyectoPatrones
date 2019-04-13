package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Caballo extends Pieza {

	public Caballo(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.CABALLO;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "C";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return false;
	}

}
