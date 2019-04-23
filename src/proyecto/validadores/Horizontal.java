package proyecto.validadores;

public class Horizontal extends DecoradorMovimiento {
	Movimiento movimiento;

	@Override
	public boolean movimientoValido(int initialX, int initialY, int finalX, int finalY) {
		if (initialX == finalX) {
			return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && true;
		}
		return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && false;
	}

	public Horizontal(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

}
