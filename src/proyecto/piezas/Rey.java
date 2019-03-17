package proyecto.piezas;

import proyecto.utilidades.Jugador;

public class Rey extends Piece {

	public Rey(int px, int py, Jugador pjugador) {
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
	public Tipos getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
