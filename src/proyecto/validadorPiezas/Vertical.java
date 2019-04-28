package proyecto.validadorPiezas;

public class Vertical extends DecoradorMovimiento {
	Movimiento movimiento;

	@Override
	public boolean movimientoValido(int initialX, int initialY, int finalX, int finalY) {
		if (initialY == finalY) {
			return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && true;
		}
		return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && false;
	}

	public Vertical(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

}
