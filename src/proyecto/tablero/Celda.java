package proyecto.tablero;

import proyecto.piezas.Pieza;

public class Celda {

	private Pieza pieza;
	private int x, y;

	public Celda(int x, int y) {
		this.pieza = null;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

}