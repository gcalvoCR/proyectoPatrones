package proyecto.juego;

import java.util.ArrayList;

import proyecto.Fabrica.FabricaPiezas;
import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador.JugadorBuilder;
import proyecto.piezas.Pieza;
import proyecto.tablero.Tablero;

public class Ajedrez extends Juego {

	public Ajedrez(String nombreA, String userA, String nombreB, String userB) {

		JugadorBuilder builder = new JugadorBuilder();
		builder.withNombre(nombreA).withUsername(userA).withColor(Colores.BLANCO);
		jugadorA = builder.build();
		builder.withNombre(nombreB).withUsername(userB).withColor(Colores.NEGRO);
		jugadorB = builder.build();

		tablero = new Tablero(8, 8);
		piezas = new ArrayList<Pieza>();
	}

	@Override
	public void fillBoard() {

		// definicion de posiciones originales para piezas negras
		int[] xNegras = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] yNegras = { 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7 };
		TipoPiezas[] piezasNegras = { TipoPiezas.TORRE, TipoPiezas.CABALLO, TipoPiezas.ALFIL, TipoPiezas.REINA,
				TipoPiezas.REY, TipoPiezas.ALFIL, TipoPiezas.CABALLO, TipoPiezas.TORRE, TipoPiezas.PEON,
				TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON,
				TipoPiezas.PEON };

		// definicion de posiciones originales para piezas negras
		int x = 0;
		int y = 0;
		TipoPiezas pieza;

		// Setear piezas negras (jugador B)
		for (int i = 0; i < xNegras.length; i++) {
			x = xNegras[i];
			y = yNegras[i];
			pieza = piezasNegras[i];
			tablero.getCelda(x, y).setPieza(FabricaPiezas.getPieza(pieza, jugadorA, Colores.NEGRO));
		}

		// definicion de posiciones originales para piezas blancas
		int[] xBlancas = { 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7 };
		int[] yBlancas = { 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7 };
		TipoPiezas[] piezasBlancas = { TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON,
				TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.PEON, TipoPiezas.TORRE,
				TipoPiezas.CABALLO, TipoPiezas.ALFIL, TipoPiezas.REY, TipoPiezas.REINA, TipoPiezas.ALFIL,
				TipoPiezas.CABALLO, TipoPiezas.TORRE };

		// Setear piezas blancas (jugador A)
		for (int i = 0; i < xNegras.length; i++) {
			x = xBlancas[i];
			y = yBlancas[i];
			pieza = piezasBlancas[i];
			tablero.getCelda(x, y).setPieza(FabricaPiezas.getPieza(pieza, jugadorA, Colores.BLANCO));
		}

		setArrayListPiezas();

	}

	public void setArrayListPiezas() {
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
					Pieza pieza = tablero.getCelda(x, y).getPieza();
					output.append(" " + getSymbol(pieza) + "  |");
				}
			}
			output.append("\n");
			output.append("   ---------------------------------");
			output.append("\n");
		}
		output.append("                  ** 0 para salir **");
		output.append("\n");

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

	public String getSymbol(Pieza pieza) {
		TipoPiezas tipo = pieza.getType();
		Colores color = pieza.getColor();
		switch (color) {
		case BLANCO:
			return getPiezasblancas(tipo);
		case NEGRO:
			return getPiezasNegras(tipo);
		default:
			return "";

		}

	}

	private String getPiezasblancas(TipoPiezas tipo) {
		switch (tipo) {
		case REY:
			return "♔";
		case REINA:
			return "♕";
		case TORRE:
			return "♖";
		case ALFIL:
			return "♗";
		case CABALLO:
			return "♘";
		case PEON:
			return "♙";
		default:
			return "";
		}
	}

	private String getPiezasNegras(TipoPiezas tipo) {
		switch (tipo) {
		case REY:
			return "♚";
		case REINA:
			return "♛";
		case TORRE:
			return "♜";
		case ALFIL:
			return "♝";
		case CABALLO:
			return "♞";
		case PEON:
			return "♟";
		default:
			return "";
		}
	}

}
