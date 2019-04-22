package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadores.Diagonal;
import proyecto.validadores.Movimiento;
import proyecto.validadores.MovimientoPieza;
import proyecto.validadores.Vertical;

public class Peon extends Pieza {

	public Peon(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.PEON;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "P";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		Movimiento movimiento = new MovimientoPieza();
		Diagonal validacion1 = new Diagonal(movimiento);
		Vertical validacion2 = new Vertical(validacion1);

		return validacion2.movimientoValido(initialX, initialY, finalX, finalY);
	}

}
