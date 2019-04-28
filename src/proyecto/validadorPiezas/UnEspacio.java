package proyecto.validadorPiezas;

public class UnEspacio extends DecoradorMovimiento {
	Movimiento movimiento;

	@Override
	public boolean movimientoValido(int initialX, int initialY, int finalX, int finalY) {

		int diffX = Math.abs(finalX - initialX);
		int diffY = Math.abs(finalY - initialY);

		if (diffX > 1 || diffY > 1) {
			return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && false;
		}
		return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && true;
	}

	public UnEspacio(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

}
