package proyecto.juego;

import proyecto.enums.TipoPlataforma;

public class Go extends Juego {

	public Go(String nombreA, String userA, String nombreB, String userB) {

	}

	@Override
	public void fillBoard() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean movePiece(String jugador, int initialX, int initialY, int finalX, int finalY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateMovement(String jugador, int initialX, int initialY, int finalX, int finalY) {
		return false;
	}

	@Override
	public boolean validateWinner() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void communicationHandler(TipoPlataforma target) {
		// TODO Auto-generated method stub

	}

}
