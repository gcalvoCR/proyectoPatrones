package proyecto.piezas;

import proyecto.utilidades.Jugador;

public class Alfil extends Piece {

	Tipos type;

	public Alfil(int x, int y, Jugador pjugador) {
		super(x, y, pjugador);
		type = Tipos.ALFIL;
	}

	@Override
	public boolean isValidMovement(int finalX, int finalY) {
		int diffX = Math.abs(finalX - this.x);
		int diffY = Math.abs(finalY - this.y);
		return diffX == diffY;
	}

	@Override
	public int[][] movePiece(int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipos getType() {
		return Tipos.ALFIL;
	}

}
