package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Alfil extends Pieza {

	public Alfil(int x, int y, Jugador pjugador, Colores color) {
		super(x, y, pjugador, color);
		type = TipoPiezas.ALFIL;
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

	public Jugador getJugador() {
		return jugador;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "A";
	}

}
