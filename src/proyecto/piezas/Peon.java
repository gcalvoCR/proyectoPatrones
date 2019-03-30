package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Peon extends Pieza {

	public Peon(int x, int y, Jugador pjugador, Colores color) {
		super(x, y, pjugador, color);
		type = TipoPiezas.PEON;
	}

	@Override
	public boolean isValidMovement(int finalX, int finalY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[][] movePiece(int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "P";
	}

}
