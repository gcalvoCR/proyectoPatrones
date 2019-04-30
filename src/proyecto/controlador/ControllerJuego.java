package proyecto.controlador;

import java.util.ArrayList;

import proyecto.Fabrica.FabricaJuego;
import proyecto.enums.TipoAcciones;
import proyecto.enums.TipoJuegos;
import proyecto.enums.TipoPlataforma;
import proyecto.juego.Juego;
import proyecto.persistencia.PersistenciaTXT;
import proyecto.persistencia.Plataforma;
import proyecto.utils.Utilidades;

public class ControllerJuego {

	private Juego juego;
	private TipoPlataforma plataforma;
	private int cont = 1;

	public ControllerJuego(TipoJuegos pjuego, String nombreA, String userA, String nombreB, String userB,
			TipoPlataforma target) {
		this.juego = FabricaJuego.getJuego(pjuego, nombreA, userA, nombreB, userB);
		plataforma = target;
		juego.fillBoard();
		juego.initializeCommunicationHandler(target);
	}

	public boolean jugar(String puntoInicial, String puntoFinal, String jugador, TipoAcciones accion) {

		char charInitialX = puntoInicial.charAt(0);
		char charInitialY = puntoInicial.charAt(1);

		char charFinalX = puntoFinal.charAt(0);
		char charFinalY = puntoFinal.charAt(1);

		int initialX, initialY, finalX, finalY;

		initialX = Utilidades.getIntFromChar(charInitialX);
		initialY = Character.getNumericValue(charInitialY);

		finalX = Utilidades.getIntFromChar(charFinalX);
		finalY = Character.getNumericValue(charFinalY);

		switch (accion) {
		case JUGAR:
			if (cont == 1) {
				juego.eliminarDatos(plataforma);
				cont = 0;
			}
			return juego.jugarPieza(jugador, initialX, initialY, finalX, finalY);
		case REPRODUCIR:
			juego.reproducir(initialX, initialY, finalX, finalY);
			break;
		}
		return false;
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
