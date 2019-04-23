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
		Movimiento movimiento = new MovimientoPieza();
		Movimiento validacion1 = new Vertical(movimiento);
		Movimiento validacion2 = new Horizontal(validacion1);
		Movimiento validacion3 = new Diagonal(validacion2);
		Movimiento validacion4 = new UnEspacio(validacion3);
		return validacion4.movimientoValido(initialX, initialY, finalX, finalY);
	}

}
