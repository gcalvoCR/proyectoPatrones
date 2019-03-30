package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class PiezaTablero extends Pieza {

	public PiezaTablero(int px, int py, Jugador pjugador, Colores color) {
		super(px, py, pjugador, color);
		// TODO Auto-generated constructor stub
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
	public TipoPiezas getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "P";
	}

}
