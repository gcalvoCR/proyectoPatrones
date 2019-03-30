package proyecto.juego;

import java.util.ArrayList;

import proyecto.Fabrica.FabricaPiezas;
import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.piezas.Pieza;
import proyecto.tablero.Tablero;

public class Ajedrez extends Juego {

	public Ajedrez() {
		tablero = new Tablero(8, 8);
	}

	@Override
	public void fillBoard() {
		piezas = new ArrayList<Pieza>();
		Jugador jugadorA = new Jugador("jugadorA", "A");
		Jugador jugadorB = new Jugador("jugadorB", "B");

		// para jugador A
		tablero.getCelda(0, 0).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, 0, 0, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 1).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, 0, 1, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 2).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, 0, 2, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 3).setPieza(FabricaPiezas.getPieza(TipoPiezas.REINA, 0, 3, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 4).setPieza(FabricaPiezas.getPieza(TipoPiezas.REY, 0, 4, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 5).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, 0, 5, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 6).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, 0, 6, jugadorA, Colores.BLANCO));
		tablero.getCelda(0, 7).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, 0, 7, jugadorA, Colores.BLANCO));
		for (int i = 0; i < tablero.getRows(); i++) {
			tablero.getCelda(1, i).setPieza(FabricaPiezas.getPieza(TipoPiezas.PEON, 1, i, jugadorA, Colores.BLANCO));
		}

		// para jugador B
		for (int i = 0; i < tablero.getRows(); i++) {
			tablero.getCelda(6, i).setPieza(FabricaPiezas.getPieza(TipoPiezas.PEON, 1, i, jugadorB, Colores.NEGRO));
		}
		tablero.getCelda(7, 0).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, 7, 0, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 1).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, 7, 1, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 2).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, 7, 2, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 3).setPieza(FabricaPiezas.getPieza(TipoPiezas.REINA, 7, 3, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 4).setPieza(FabricaPiezas.getPieza(TipoPiezas.REY, 7, 4, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 5).setPieza(FabricaPiezas.getPieza(TipoPiezas.ALFIL, 7, 5, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 6).setPieza(FabricaPiezas.getPieza(TipoPiezas.CABALLO, 7, 6, jugadorB, Colores.NEGRO));
		tablero.getCelda(7, 7).setPieza(FabricaPiezas.getPieza(TipoPiezas.TORRE, 7, 7, jugadorB, Colores.NEGRO));

	}

	@Override
	public void movePiece(int initialX, int initialY, int finalX, int finalY) {

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

}
