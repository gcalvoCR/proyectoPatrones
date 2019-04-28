package proyecto.juego;

import java.util.ArrayList;

import proyecto.enums.TipoPlataforma;
import proyecto.jugador.Jugador;
import proyecto.persistencia.Plataforma;
import proyecto.piezas.Pieza;
import proyecto.tablero.Tablero;
import proyecto.validadorTablero.ValidadorTablero;

public abstract class Juego {

	protected Tablero tablero;
	protected ArrayList<Pieza> piezas;
	protected String mensaje = "";
	protected Jugador jugadorA;
	protected Jugador jugadorB;
	protected Plataforma persistenciaMovimientos;
	protected ValidadorTablero validadorTablero;

	public abstract void fillBoard();

	public abstract boolean movePiece(String jugador, int initialX, int initialY, int finalX, int finalY);

	public abstract boolean validateMovement(String jugador, int initialX, int initialY, int finalX, int finalY);

	public abstract boolean validateWinner();

	public abstract void communicationHandler(TipoPlataforma target);

	public String getMensaje() {
		return mensaje;
	}
}
