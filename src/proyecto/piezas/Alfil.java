package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadores.Diagonal;
import proyecto.validadores.Movimiento;
import proyecto.validadores.MovimientoPieza;

public class Alfil extends Pieza {

	public Alfil(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.ALFIL;
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		Movimiento movimiento = new MovimientoPieza();
		Movimiento validacion1 = new Diagonal(movimiento);
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
