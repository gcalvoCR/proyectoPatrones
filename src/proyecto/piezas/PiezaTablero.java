package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class PiezaTablero extends Pieza {

	public PiezaTablero(Jugador pjugador, Colores color) {
		super(pjugador, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoPiezas getType() {
		// TODO Auto-generated method stub
		return null;
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
