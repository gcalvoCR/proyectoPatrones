package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Alfil extends Pieza {

	public Alfil(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.ALFIL;
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		return false;
	}

	public Jugador getJugador() {
		return jugador;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "A";
	}

}
