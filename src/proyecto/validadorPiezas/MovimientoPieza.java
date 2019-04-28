package proyecto.validadorPiezas;

public class MovimientoPieza extends Movimiento {

	@Override
	public boolean movimientoValido(int initialX, int initialY, int finalX, int finalY) {
		if (finalX > 7 || finalY > 7 || finalX < 0 || finalY < 0) {
			return false;
		}
		return true;
	}

}
