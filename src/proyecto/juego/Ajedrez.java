package proyecto.juego;

import java.util.ArrayList;

import proyecto.Fabrica.FabricaPiezas;
import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.piezas.Pieza;
import proyecto.tablero.Tablero;

public class Ajedrez extends Juego {

	public Ajedrez(String nombreA, String userA, String nombreB, String userB) {
		tablero = new Tablero(8, 8);
	}

	@Override
	public void fillBoard() {
		piezas = new ArrayList<Pieza>();
		Jugador jugadorA = new Jugador("jugadorA", "A", "blanco");
		Jugador jugadorB = new Jugador("jugadorB", "B", "negro");

		// para jugador A
		tablero.getCelda(0, 0).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 1).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 2).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 3).setPieza(FabricaPiezas.getPieza(TipoPiezas.REINA, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 4).setPieza(FabricaPiezas.getPieza(TipoPiezas.REY, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 5).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 6).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 7).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, jugadorA, Colores.BLANCO));
		for (int i = 0; i < tablero.getRows(); i++) {
			tablero.getCelda(1, i).setPieza(FabricaPiezas.getPieza(TipoPiezas.PEON, jugadorA, Colores.BLANCO));
		}

		// para jugador B
		for (int i = 0; i < tablero.getRows(); i++) {
			tablero.getCelda(6, i).setPieza(FabricaPiezas.getPieza(TipoPiezas.PEON, jugadorB, Colores.NEGRO));
		}
		tablero.getCelda(7, 0).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 1).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 2).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 3).setPieza(FabricaPiezas.getPieza(TipoPiezas.REINA, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 4).setPieza(FabricaPiezas.getPieza(TipoPiezas.REY, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 5).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 6).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 7).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, jugadorB, Colores.NEGRO));

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
	public boolean movePiece(String jugador, int initialX, int initialY, int finalX, int finalY) {
		Pieza pieza = tablero.getCelda(initialX, initialY).getPieza();
		tablero.getCelda(initialX, initialY).setPieza(null);
		piezas.remove(tablero.getCelda(finalX, finalY).getPieza());
		tablero.getCelda(finalX, finalY).setPieza(pieza);
		return true;
	}

	@Override
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("      0    1    2    3    4    5    6    7  ");
		output.append("\n");
		output.append("   -----------------------------------------");
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
					output.append("    |");
				} else {
					output.append(" " + tablero.getCelda(x, y).getPieza().toString() + " |");
				}
			}
			output.append("\n");
			output.append("   -----------------------------------------");
			output.append("\n");
		}

		return output.toString();
	}

	@Override
	public boolean validateWinner() {
		boolean win = false;

		Pieza reyBlanco = FabricaPiezas.getPieza(TipoPiezas.REY, null, Colores.BLANCO);
		Pieza reyNegro = FabricaPiezas.getPieza(TipoPiezas.REY, null, Colores.NEGRO);

		if (!(piezas.contains(reyBlanco))) {
			win = true;
			mensaje = "Jugador B gano!";
		} else if (!(piezas.contains(reyNegro))) {
			win = true;
			mensaje = "jugador A gano!";
		}
		return win;
	}

}
