package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadorPiezas.Horizontal;
import proyecto.validadorPiezas.Movimiento;
import proyecto.validadorPiezas.MovimientoPieza;
import proyecto.validadorPiezas.Vertical;

public class Torre extends Pieza {

	public Torre(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.TORRE;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "T";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		Movimiento movimiento = new MovimientoPieza();// Si esta dentro del tablero
		Movimiento validacion1 = new Vertical(movimiento);// y si se mueve vertical
		Movimiento validacion2 = new Horizontal(validacion1); // o si se mueve horizontal
		return validacion2.movimientoValido(initialX, initialY, finalX, finalY);
	}

}
