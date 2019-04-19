package proyecto.controlador;

import java.io.IOException;
import java.util.ArrayList;

import proyecto.jugador.Jugador;
import proyecto.persistencia.PersistenciaJugadores;

public class ControllerJugador {

	PersistenciaJugadores listaJugadores = new PersistenciaJugadores();

	public boolean registroNuevoJugador(String nombre, String username) throws IOException {

		Jugador jugador = new Jugador(nombre, username, null);

		if (listaJugadores.crearLista(jugador))
			return true;
		else
			return false;

	}

	public ArrayList<String> listarJugadores() throws IOException {

		return listaJugadores.leerArchivo();

	}

}
