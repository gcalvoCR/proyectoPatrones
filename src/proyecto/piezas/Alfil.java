package proyecto.piezas;

import proyecto.enums.TipoPiezasAjedrez;
import proyecto.jugador.Jugador;

public class Alfil extends Pieza {

	TipoPiezasAjedrez type;

	public Alfil(int x, int y, Jugador pjugador) {
		super(x, y, pjugador);
		type = TipoPiezasAjedrez.ALFIL;
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
	public TipoPiezasAjedrez getType() {
		return TipoPiezasAjedrez.ALFIL;
	}

}
