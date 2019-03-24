package proyecto.controlador;

import proyecto.Fabrica.FabricaJuego;
import proyecto.enums.TipoJuegos;
import proyecto.juego.Juego;
import proyecto.utils.Utilidades;

public class ControllerJuego {

	private Juego juego;

	public ControllerJuego(TipoJuegos pjuego) {
		this.juego = FabricaJuego.getJuego(pjuego);
		juego.fillBoard();
		System.out.println(juego.toString());
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

		System.out.println("x: " + initialX + " y: " + initialY + "    x: " + finalX + " y: " + finalY);

		juego.movePiece(initialX, initialY, finalX, finalY);
		System.out.println(juego.toString());

		return false;
	}

}
