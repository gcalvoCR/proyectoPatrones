package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadores.EspecialCaballo;
import proyecto.validadores.Movimiento;
import proyecto.validadores.MovimientoPieza;

public class Caballo extends Pieza {

	public Caballo(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.CABALLO;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "C";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		Movimiento movimiento = new MovimientoPieza();// Si esta dentro del tablero
		Movimiento validacion1 = new EspecialCaballo(movimiento);// y movimiento especial caballo
		return validacion1.movimientoValido(initialX, initialY, finalX, finalY);
	}

}
