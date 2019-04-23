package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadores.Horizontal;
import proyecto.validadores.Movimiento;
import proyecto.validadores.MovimientoPieza;
import proyecto.validadores.Vertical;

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
		Movimiento movimiento = new MovimientoPieza();
		Movimiento validacion1 = new Vertical(movimiento);
		Movimiento validacion2 = new Horizontal(validacion1);
		return validacion2.movimientoValido(initialX, initialY, finalX, finalY);
	}

}
