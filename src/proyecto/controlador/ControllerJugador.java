package proyecto.controlador;

import proyecto.jugador.Jugador;
import proyecto.persistencia.PersistenciaJugadores;

public class ControllerJugador {

	private PersistenciaJugadores listaJugadores;

	public ControllerJugador() {
		listaJugadores = new PersistenciaJugadores();
	}

	public void registrarJugador(String pnombre, String pusername) {
		Jugador nuevoJugador = new Jugador(pnombre, pusername);
		listaJugadores.addJugador(nuevoJugador);

	}

}
