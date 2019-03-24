package proyecto.juego;

import java.util.ArrayList;

import proyecto.jugador.Jugador;
import proyecto.piezas.Pieza;
import proyecto.piezas.PiezaTablero;
import proyecto.tablero.Tablero;

public class Damas extends Juego {

	public Damas() {
		tablero = new Tablero(8, 8);
	}

	@Override
	public void fillBoard() {
		piezas = new ArrayList<Pieza>();
		Jugador jugadorA = new Jugador("jugadorA", "A");
		Jugador jugadorB = new Jugador("jugadorB", "B");

		// para jugador A
		tablero.getCelda(0, 1).setPieza(new PiezaTablero(0, 1, jugadorA));
		tablero.getCelda(0, 3).setPieza(new PiezaTablero(0, 3, jugadorA));
		tablero.getCelda(0, 5).setPieza(new PiezaTablero(0, 5, jugadorA));
		tablero.getCelda(0, 7).setPieza(new PiezaTablero(0, 7, jugadorA));
		tablero.getCelda(2, 1).setPieza(new PiezaTablero(2, 1, jugadorA));
		tablero.getCelda(2, 3).setPieza(new PiezaTablero(2, 3, jugadorA));
		tablero.getCelda(2, 5).setPieza(new PiezaTablero(2, 5, jugadorA));
		tablero.getCelda(2, 7).setPieza(new PiezaTablero(2, 7, jugadorA));
		tablero.getCelda(1, 0).setPieza(new PiezaTablero(1, 0, jugadorA));
		tablero.getCelda(1, 2).setPieza(new PiezaTablero(1, 2, jugadorA));
		tablero.getCelda(1, 4).setPieza(new PiezaTablero(1, 4, jugadorA));
		tablero.getCelda(1, 6).setPieza(new PiezaTablero(1, 6, jugadorA));
		// para jugador B
		tablero.getCelda(6, 1).setPieza(new PiezaTablero(6, 1, jugadorB));
		tablero.getCelda(6, 3).setPieza(new PiezaTablero(6, 3, jugadorB));
		tablero.getCelda(6, 5).setPieza(new PiezaTablero(6, 5, jugadorB));
		tablero.getCelda(6, 7).setPieza(new PiezaTablero(6, 7, jugadorB));
		tablero.getCelda(5, 0).setPieza(new PiezaTablero(5, 0, jugadorB));
		tablero.getCelda(5, 2).setPieza(new PiezaTablero(5, 2, jugadorB));
		tablero.getCelda(5, 4).setPieza(new PiezaTablero(5, 4, jugadorB));
		tablero.getCelda(5, 6).setPieza(new PiezaTablero(5, 6, jugadorB));
		tablero.getCelda(7, 0).setPieza(new PiezaTablero(7, 0, jugadorB));
		tablero.getCelda(7, 2).setPieza(new PiezaTablero(7, 2, jugadorB));
		tablero.getCelda(7, 4).setPieza(new PiezaTablero(7, 4, jugadorB));
		tablero.getCelda(7, 6).setPieza(new PiezaTablero(7, 6, jugadorB));
	}

	@Override
	public void movePiece(int initialX, int initialY, int finalX, int finalY) {
		Pieza pieza = tablero.getCelda(initialX, initialY).getPieza();
		tablero.getCelda(initialX, initialY).setPieza(null);
		tablero.getCelda(finalX, finalY).setPieza(pieza);
	}

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("     0   1   2   3   4   5   6   7  ");
		output.append("\n");
		output.append("   ---------------------------------");
		output.append("\n");

		for (int x = 0; x < tablero.getRows(); x++) {
			switch (x) {
			case 0:
				output.append(" A |");
				break;
			case 1:
				output.append(" B |");
				break;
			case 2:
				output.append(" C |");
				break;
			case 3:
				output.append(" D |");
				break;
			case 4:
				output.append(" E |");
				break;
			case 5:
				output.append(" F |");
				break;
			case 6:
				output.append(" G |");
				break;
			case 7:
				output.append(" H |");
				break;
			default:
				break;
			}

			for (int y = 0; y < tablero.getColumns(); y++) {
				if (tablero.getCelda(x, y).getPieza() == null) {
					output.append("   |");
				} else {
					output.append(" " + tablero.getCelda(x, y).getPieza().jugador.getUsername() + " |");
				}
			}
			output.append("\n");
			output.append("   ---------------------------------");
			output.append("\n");
		}

		return output.toString();
	}

}
