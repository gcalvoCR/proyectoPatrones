package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadores.Diagonal;
import proyecto.validadores.Horizontal;
import proyecto.validadores.Movimiento;
import proyecto.validadores.MovimientoPieza;
import proyecto.validadores.Vertical;

public class Reina extends Pieza {

	public Reina(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.REINA;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "Q";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		Movimiento movimiento = new MovimientoPieza();// Si esta dentro del tablero
		Movimiento validacion1 = new Vertical(movimiento);// y si se mueve vertical
		Movimiento validacion2 = new Diagonal(validacion1);// o si se mueve diagonal
		Movimiento validacion3 = new Horizontal(validacion2); // o si se mueve horizontal
		return validacion3.movimientoValido(initialX, initialY, finalX, finalY);
	}
}
