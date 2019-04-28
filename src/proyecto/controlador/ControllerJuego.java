package proyecto.controlador;

import java.util.ArrayList;

import proyecto.Fabrica.FabricaJuego;
import proyecto.enums.TipoJuegos;
import proyecto.enums.TipoPlataforma;
import proyecto.juego.Juego;
import proyecto.persistencia.PersistenciaTXT;
import proyecto.persistencia.Plataforma;
import proyecto.utils.Utilidades;

public class ControllerJuego {

	private Juego juego;

	public ControllerJuego(TipoJuegos pjuego, String nombreA, String userA, String nombreB, String userB,
			TipoPlataforma target) {
		this.juego = FabricaJuego.getJuego(pjuego, nombreA, userA, nombreB, userB);
		juego.fillBoard();
		communicationHandler(target);
	}

	public boolean jugar(String puntoInicial, String puntoFinal, String jugador) {

		char charInitialX = puntoInicial.charAt(0);
		char charInitialY = puntoInicial.charAt(1);

		char charFinalX = puntoFinal.charAt(0);
		char charFinalY = puntoFinal.charAt(1);

		int initialX, initialY, finalX, finalY;

		initialX = Utilidades.getIntFromChar(charInitialX);
		initialY = Character.getNumericValue(charInitialY);

		finalX = Utilidades.getIntFromChar(charFinalX);
		finalY = Character.getNumericValue(charFinalY);

		return juego.movePiece(jugador, initialX, initialY, finalX, finalY);

	}

	public void communicationHandler(TipoPlataforma target) {
		juego.communicationHandler(target);
	}

	public boolean validarGanador() {
		return juego.validateWinner();
	}

	public String getMensaje() {
		return juego.getMensaje();
	}

	public String imprimirTablero() {
		return juego.toString();
	}

	public ArrayList<String> getMovimientosPartida(TipoJuegos target) {
		Plataforma persistencia = new PersistenciaTXT();
		return persistencia.leerMovimiento(target);
	}
}
