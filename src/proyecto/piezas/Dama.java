package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Dama extends Pieza {

	public Dama(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.DAMA;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "X";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {

		int diffX = Math.abs(finalX - initialX);
		int diffY = Math.abs(finalY - initialY);

		// validacion que no se salga del tablero
		if (finalX > 7 || finalY > 7 || finalX < 0 || finalY < 0) {
			return false;
		}
		// validacion que se mueva diagonal
		if (diffX != diffY) {
			return false;
		}

		// validacion que se mueva en la direccion correcta
		if (getColor().equals(Colores.BLANCO) && (finalX < initialX)) {
			return false;
		}
		if (getColor().equals(Colores.NEGRO) && (finalX > initialX)) {
			return false;
		}

		return true;
	}

}
