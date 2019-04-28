package proyecto.validadorTablero;

import proyecto.tablero.Tablero;

public interface ValidadorTablero {

	boolean validateMovement(Tablero tablero, int initialX, int initialY, int finalX, int finalY);

}
