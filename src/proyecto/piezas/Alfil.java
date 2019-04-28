package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadorPiezas.Movimiento;
import proyecto.validadorPiezas.MovimientoPieza;
import proyecto.validadorPiezas.UnicamenteDiagonal;

public class Alfil extends Pieza {

	public Alfil(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.ALFIL;
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		Movimiento movimiento = new MovimientoPieza();// Si pieza dentro de tablero
		Movimiento validacion1 = new UnicamenteDiagonal(movimiento);// y movimiento diagonal
		return validacion1.movimientoValido(initialX, initialY, finalX, finalY);
	}

	public Jugador getJugador() {
		return jugador;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "A";
	}

}
