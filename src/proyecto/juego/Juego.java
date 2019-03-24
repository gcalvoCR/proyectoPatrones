package proyecto.juego;

import java.util.ArrayList;

import proyecto.piezas.Pieza;
import proyecto.tablero.Tablero;

public abstract class Juego {

	protected Tablero tablero;
	protected ArrayList<Pieza> piezas;

	public abstract void fillBoard();

	public abstract void movePiece(int initialX, int initialY, int finalX, int finalY);

}
