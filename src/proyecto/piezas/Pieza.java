package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public abstract class Pieza {

	protected TipoPiezas type;
	protected int x, y;
	protected Colores color;
	protected Jugador jugador;

	public Pieza(int px, int py, Jugador pjugador, Colores pcolor) {
		x = px;
		y = py;
		jugador = pjugador;
		color = pcolor;
	}

	public abstract boolean isValidMovement(int finalX, int finalY);

	public abstract int[][] movePiece(int initialX, int initialY, int finalX, int finalY);

	public TipoPiezas getType() {
		return type;
	}

	public Colores getColor() {
		return color;
	}

}
