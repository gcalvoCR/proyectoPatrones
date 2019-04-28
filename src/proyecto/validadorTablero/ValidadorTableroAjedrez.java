package proyecto.validadorTablero;

import proyecto.piezas.Pieza;
import proyecto.tablero.Tablero;

public class ValidadorTableroAjedrez implements ValidadorTablero {

	public boolean validateMovement(Tablero tablero, int initialX, int initialY, int finalX, int finalY) {
		Pieza piezaPosicionInicial = tablero.getCelda(initialX, initialY).getPieza();
		Pieza piezaPosicionFinal = tablero.getCelda(finalX, finalY).getPieza();
		int iIntermedias = 0;

		iIntermedias += getIntermediasDiagonal(tablero, initialX, initialY, finalX, finalY);
		iIntermedias += getIntermediasVertical(tablero, initialX, initialY, finalX, finalY);
		iIntermedias += getIntermediasHorizontal(tablero, initialX, initialY, finalX, finalY);

		if (iIntermedias == 0) {
			if (piezaPosicionFinal == null) {
				return true;
			} else {
				if (piezaPosicionInicial.getColor() == piezaPosicionFinal.getColor()) {
					return false;
				}
			}
		}
		return false;
	}

	private int getIntermediasVertical(Tablero tablero, int initialX, int initialY, int finalX, int finalY) {
		int cont = 0;
		int diffY = Math.abs(finalY - initialY);

		if (initialX == finalX && diffY > 1) {
			for (int i = 1; i < diffY; i++) {
				if (finalX > initialX) {
					if (tablero.getCelda(initialX + i, initialY) != null) {
						cont++;
					}
				}
				if (finalX < initialX) {
					if (tablero.getCelda(initialX - i, initialY) != null) {
						cont++;
					}
				}
			}
		}
		return cont;
	}

	private int getIntermediasHorizontal(Tablero tablero, int initialX, int initialY, int finalX, int finalY) {
		int cont = 0;
		int diffX = Math.abs(finalX - initialX);

		if (initialY == finalY && diffX > 1) {
			for (int i = 1; i < diffX; i++) {
				if (finalX > initialX) {
					if (tablero.getCelda(initialX, initialY + i) != null) {
						cont++;
					}
				}
				if (finalX < initialX) {
					if (tablero.getCelda(initialX, initialY - i) != null) {
						cont++;
					}
				}
			}
		}
		return cont;
	}

	private int getIntermediasDiagonal(Tablero tablero, int initialX, int initialY, int finalX, int finalY) {
		int cont = 0;
		int diffX = Math.abs(finalX - initialX);
		int diffY = Math.abs(finalY - initialY);

		if (diffX == diffY && diffY > 1) {
			for (int i = 1; i < diffX; i++) {
				if (finalX > initialX && finalY > initialX) {
					if (tablero.getCelda(initialX + i, initialY + i) != null) {
						cont++;
					}
				}
				if (finalX > initialX && finalY < initialX) {
					if (tablero.getCelda(initialX + i, initialY - i) != null) {
						cont++;
					}
				}
				if (finalX < initialX && finalY > initialX) {
					if (tablero.getCelda(initialX - i, initialY + i) != null) {
						cont++;
					}
				}
				if (finalX < initialX && finalY < initialX) {
					if (tablero.getCelda(initialX - i, initialY - i) != null) {
						cont++;
					}
				}
			}
		}
		return cont;
	}
}
