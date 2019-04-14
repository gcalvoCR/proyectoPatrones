package proyecto.juego;

import java.util.ArrayList;

import proyecto.Fabrica.FabricaPiezas;
import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.piezas.Pieza;
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
		tablero.getCelda(0, 1).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 3).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 5).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 7).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(2, 1).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(2, 3).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(2, 5).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(2, 7).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(1, 0).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(1, 2).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(1, 4).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		tablero.getCelda(1, 6).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));

		// para jugador B
		tablero.getCelda(6, 1).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(6, 3).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(6, 5).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(6, 7).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(5, 0).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(5, 2).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(5, 4).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(5, 6).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 0).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 2).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 4).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 6).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));

		for (int row = 0; row < tablero.getCeldas().length; row++) {
			for (int col = tablero.getCeldas()[row].length - 1; col >= 0; col--) {
				Pieza piezaX = tablero.getCeldas()[row][col].getPieza();
				if (piezaX != null) {
					piezas.add(piezaX);
				}
			}
		}
	}

	@Override
	public void movePiece(int initialX, int initialY, int finalX, int finalY) {
		if (validate(initialX, initialY, finalX, finalY)) {
			Pieza pieza = tablero.getCelda(initialX, initialY).getPieza();
			tablero.getCelda(initialX, initialY).setPieza(null);
			tablero.getCelda(finalX, finalY).setPieza(pieza);
			// tenemos que remover las piezas!!!!!!!!
		} else {
			System.out.println("movimiento no permitido");
		}

	}

	private boolean validate(int initialX, int initialY, int finalX, int finalY) {

		int diffX = Math.abs(finalX - initialX);
		int diffY = Math.abs(finalY - initialY);
		int promedioX = (finalX + initialX) / 2;
		int promedioY = (finalY + initialY) / 2;
		Pieza damaBlanca = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.BLANCO);
		Pieza damaNegra = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.NEGRO);

		// val0 que no se salga del tablero
		if (finalX > 7 || finalY > 7 || finalX < 0 || finalY < 0) {
			return false;
		}
		Pieza piezaPosicionFinal = tablero.getCelda(finalX, finalY).getPieza();
		Pieza piezaPosicionInicial = tablero.getCelda(initialX, initialY).getPieza();
		// Val1 = Valida si va en diagonal
		if (diffX != diffY) {
			return false;
		}

		if (piezaPosicionInicial.equals(damaBlanca) && (finalX < initialX)) {
			return false;
		}
		if (piezaPosicionInicial.equals(damaNegra) && (finalX > initialX)) {
			return false;
		}
		// Val2 = Valida si la posicion final esta null
		if (piezaPosicionFinal == null && Math.abs(finalX - initialX) == 1) {
			return true;
		}

		if (piezaPosicionFinal == null && Math.abs(finalX - initialX) == 2) {
			Pieza piezaIntermedia = tablero.getCelda(promedioX, promedioY).getPieza();
			if (piezaIntermedia.equals(piezaPosicionInicial)) {
				return false;
			}
			tablero.getCelda(promedioX, promedioY).setPieza(null);
			piezas.remove(piezaIntermedia);
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		Pieza damaBlanca = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.BLANCO);
		Pieza damaNegra = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.NEGRO);

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
					if (tablero.getCelda(x, y).getPieza().equals(damaNegra)) {
						output.append(" " + "☻" + " |");
					}
					if (tablero.getCelda(x, y).getPieza().equals(damaBlanca)) {
						output.append(" " + "☺" + " |");
					}

				}
			}
			output.append("\n");
			output.append("   ---------------------------------");
			output.append("\n");
		}

		return output.toString();
	}

	@Override
	public boolean validateWinner() {
		boolean win = false;

		Pieza damaBlanca = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.BLANCO);
		Pieza damaNegra = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.NEGRO);

		if (!(piezas.contains(damaBlanca))) {
			win = true;
			ganador = "Jugador B (negro) gano!";
		} else if (!(piezas.contains(damaNegra))) {
			win = true;
			ganador = "jugador A (blanco) gano!";
		}
		return win;

	}

}
