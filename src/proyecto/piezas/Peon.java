package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.validadores.Diagonal;
import proyecto.validadores.DosEspacios;
import proyecto.validadores.Movimiento;
import proyecto.validadores.MovimientoPieza;
import proyecto.validadores.UnEspacio;
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
		Movimiento movimiento = new MovimientoPieza();// Si esta dentro del tablero
		Movimiento validacion1 = new UnEspacio(movimiento);// y si se mueve un espacio
		Movimiento validacion2 = new DosEspacios(validacion1);// o valida 2 espacios movimiento inicial
		Movimiento validacion3 = new Vertical(validacion2);// y si se mueve vertical
		Movimiento validacion4 = new Diagonal(validacion3);// o si se mueve diagonal
		return validacion4.movimientoValido(initialX, initialY, finalX, finalY);
	}

}
