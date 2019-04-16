package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Peon extends Pieza {

	public Peon(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.PEON;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "P";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return false;
	}

}
