package proyecto.controlador;

import proyecto.Fabrica.FabricaJuego;
import proyecto.enums.TipoJuegos;
import proyecto.juego.Juego;
import proyecto.utils.Utilidades;

public class ControllerJuego {

	private Juego juego;

	public ControllerJuego(TipoJuegos pjuego, String nombreA, String userA, String nombreB, String userB) {
		this.juego = FabricaJuego.getJuego(pjuego, nombreA, userA, nombreB, userB);
		juego.fillBoard();
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

	public boolean validarGanador() {
		return juego.validateWinner();
	}

	public String getMensaje() {
		return juego.getMensaje();
	}

	public String imprimirTablero() {
		return juego.toString();
	}

}
