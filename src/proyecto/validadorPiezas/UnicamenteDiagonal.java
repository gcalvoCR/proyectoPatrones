package proyecto.validadorPiezas;

public class UnicamenteDiagonal extends DecoradorMovimiento {
	Movimiento movimiento;

	@Override
	public boolean movimientoValido(int initialX, int initialY, int finalX, int finalY) {

		int diffX = Math.abs(finalX - initialX);
		int diffY = Math.abs(finalY - initialY);

		if (diffX == diffY) {
			return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && true;
		}
		return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && false;
	}

	public UnicamenteDiagonal(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

}
