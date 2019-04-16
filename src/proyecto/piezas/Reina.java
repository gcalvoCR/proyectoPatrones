package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Reina extends Pieza {

	public Reina(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.REINA;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "Q";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return false;
	}

}
