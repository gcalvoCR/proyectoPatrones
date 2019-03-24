package proyecto.piezas;

import proyecto.enums.TipoPiezasAjedrez;
import proyecto.jugador.Jugador;

public class Caballo extends Pieza {

	public Caballo(int px, int py, Jugador pjugador) {
		super(px, py, pjugador);
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
	public TipoPiezasAjedrez getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
