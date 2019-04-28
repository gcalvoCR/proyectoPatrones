package proyecto.validadorPiezas;

public class EspecialCaballo extends DecoradorMovimiento {
	Movimiento movimiento;

	@Override
	public boolean movimientoValido(int initialX, int initialY, int finalX, int finalY) {

		int diffX = Math.abs(finalX - initialX);
		int diffY = Math.abs(finalY - initialY);

		if ((diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2)) {
			return movimiento.movimientoValido(initialX, initialY, finalX, finalY) && true;
		}
		return false;
	}

	public EspecialCaballo(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

}
