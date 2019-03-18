package proyecto.piezas;

import proyecto.enums.TipoPiezasAjedrez;
import proyecto.jugador.Jugador;

public abstract class Piece {

	// Tiene posicion

	// realiza movimientos

	// Tiene un jugador asociado

	public int x, y;
	public Jugador jugador;

	public Piece(int px, int py, Jugador pjugador) {
		x = px;
		y = py;
		jugador = pjugador;
	}

	public abstract boolean isValidMovement(int finalX, int finalY);

	public abstract int[][] movePiece(int initialX, int initialY, int finalX, int finalY);

	public abstract TipoPiezasAjedrez getType();

}
