package proyecto.validadorPiezas;

public class DosEspacios extends DecoradorMovimiento {
	Movimiento movimiento;

	@Override
	public boolean movimientoValido(int initialX, int initialY, int finalX, int finalY) {
		if (((initialX == 1) && (finalX > 1 && finalX < 4)) || ((initialX == 6) && (finalX < 6 && finalX > 3))) {
			return movimiento.movimientoValido(initialX, initialY, finalX, finalY) || true;
		}
		return movimiento.movimientoValido(initialX, initialY, finalX, finalY) || false;
	}

	public DosEspacios(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

}
