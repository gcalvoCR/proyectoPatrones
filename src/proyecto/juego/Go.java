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
	public boolean jugarPieza(String jugador, int initialX, int initialY, int finalX, int finalY) {
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
	public void initializeCommunicationHandler(TipoPlataforma target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarDatos(String datos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarDatos(TipoPlataforma target) {
		// TODO Auto-generated method stub

	}

}
