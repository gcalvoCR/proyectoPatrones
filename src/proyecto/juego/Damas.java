package proyecto.juego;

import java.util.ArrayList;

import proyecto.Fabrica.FabricaPiezas;
import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.piezas.Pieza;
import proyecto.tablero.Tablero;

public class Damas extends Juego {

	private Pieza patronDamaBlanca = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.BLANCO);
	private Pieza patronDamaNegra = FabricaPiezas.getPieza(TipoPiezas.DAMA, null, Colores.NEGRO);

	public Damas(String nombreA, String userA, String nombreB, String userB) {
		jugadorA = new Jugador(nombreA, userA, "blanco");
		jugadorB = new Jugador(nombreB, userB, "negro");
		tablero = new Tablero(8, 8);
		piezas = new ArrayList<Pieza>();
	}

	@Override
	public void fillBoard() {

		// definicion de posiciones originales para piezas blancas
		int[] xBlancas = { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2 };
		int[] yBlancas = { 1, 3, 5, 7, 0, 2, 4, 6, 1, 3, 5, 7 };
		int[] xNegras = { 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7 };
		int[] yNegras = { 0, 2, 4, 6, 1, 3, 5, 7, 0, 2, 4, 6 };

		// definicion de posiciones originales para piezas negras
		int x = 0;
		int y = 0;

		// Setear piezas blancas (jugador A)
		for (int i = 0; i < xBlancas.length; i++) {
			x = xBlancas[i];
			y = yBlancas[i];
			tablero.getCelda(x, y).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorA, Colores.BLANCO));
		}

		// Setear piezas negras (jugador B)
		for (int i = 0; i < xBlancas.length; i++) {
			x = xNegras[i];
			y = yNegras[i];
			tablero.getCelda(x, y).setPieza(FabricaPiezas.getPieza(TipoPiezas.DAMA, jugadorB, Colores.NEGRO));
		}

		setArrayListPiezas();

	}

	// Almacenado de piezas en ArrayList de piezas
	private void setArrayListPiezas() {

		for (int x = 0; x < tablero.getCeldas().length; x++) {
			for (int y = 0; y < tablero.getCeldas().length; y++) {
				Pieza piezaX = tablero.getCeldas()[x][y].getPieza();
				if (piezaX != null) {
					piezas.add(piezaX);
				}
			}
		}

	}

	@Override
	public boolean movePiece(String jugador, int initialX, int initialY, int finalX, int finalY) {

		// Si el movimiento es valido mueve pieza
		if (validateMovement(jugador, initialX, initialY, finalX, finalY)) {
			Pieza pieza = tablero.getCelda(initialX, initialY).getPieza();
			tablero.getCelda(initialX, initialY).setPieza(null);
			tablero.getCelda(finalX, finalY).setPieza(pieza);
			return true;
		} else {
			mensaje = "El movimiento no es valido!";
		}
		return false;
	}

	private boolean validateMovement(String jugador, int initialX, int initialY, int finalX, int finalY) {

		Pieza piezaPosicionInicial = tablero.getCelda(initialX, initialY).getPieza();

		// Valida si el jugador mueve sus piezas o las del oponente
		if (jugador.equals(piezaPosicionInicial.getJugador().getUsername())) {
			// validacion del movimiento de la pieza en si
			if (piezaPosicionInicial.isValidMovement(initialX, initialY, finalX, finalY)) {

				Pieza piezaPosicionFinal = tablero.getCelda(finalX, finalY).getPieza();

				// Validacion respecto a las demas piezas
				// Si donde no tiene que saltar
				if (piezaPosicionFinal == null && Math.abs(finalX - initialX) == 1) {
					return true;
				}

				int piezaIntermediaX = (finalX + initialX) / 2;
				int piezaIntermediaY = (finalY + initialY) / 2;

				// Si tiene que saltar
				if (piezaPosicionFinal == null && Math.abs(finalX - initialX) == 2) {
					Pieza piezaIntermedia = tablero.getCelda(piezaIntermediaX, piezaIntermediaY).getPieza();
					if (piezaIntermedia.equals(piezaPosicionInicial)) {
						return false;
					}
					tablero.getCelda(piezaIntermediaX, piezaIntermediaY).setPieza(null);
					piezas.remove(piezaIntermedia);
					return true;
				}
			}
		} else {
			mensaje = "El jugador no puede mover piezas del oponente!";
		}
		return false;
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
					if (tablero.getCelda(x, y).getPieza().equals(patronDamaNegra)) {
						output.append(" " + "☻" + " |");
					}
					if (tablero.getCelda(x, y).getPieza().equals(patronDamaBlanca)) {
						output.append(" " + "☺" + " |");
					}

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

		if (!(piezas.contains(patronDamaBlanca))) {
			win = true;
			mensaje = "Jugador B (negro) gano!";
		} else if (!(piezas.contains(patronDamaNegra))) {
			win = true;
			mensaje = "jugador A (blanco) gano!";
		}
		return win;

	}

}
