package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadores.Diagonal;
import proyecto.validadores.Horizontal;
import proyecto.validadores.Movimiento;
import proyecto.validadores.MovimientoPieza;
import proyecto.validadores.UnEspacio;
import proyecto.validadores.Vertical;

public class Rey extends Pieza {

	public Rey(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.REY;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "K";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		Movimiento movimiento = new MovimientoPieza();// Si esta dentro del tablero
		Movimiento validacion1 = new UnEspacio(movimiento);// y si se mueve un espacio
		Movimiento validacion2 = new Vertical(validacion1);// y si se mueve vertical
		Movimiento validacion3 = new Diagonal(validacion2);// o si se mueve diagonal
		Movimiento validacion4 = new Horizontal(validacion3); // o si se mueve horizontal
		return validacion4.movimientoValido(initialX, initialY, finalX, finalY);
	}
}
