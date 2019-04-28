package proyecto.controlador;

import java.io.IOException;
import java.util.ArrayList;

import proyecto.Fabrica.FabricaPersistencia;
import proyecto.enums.TipoPlataforma;
import proyecto.jugador.Jugador;
import proyecto.jugador.Jugador.JugadorBuilder;
import proyecto.persistencia.Plataforma;

public class ControllerJugador {

	Plataforma listaJugadores = FabricaPersistencia.getPlatform(TipoPlataforma.TXT);

	public boolean registroNuevoJugador(String nombre, String username) throws IOException {

		JugadorBuilder builder = new JugadorBuilder();
		builder.withNombre(nombre).withUsername(username);
		builder.build();
		Jugador jugador = builder.build();

		if (listaJugadores.guardarJugador(jugador))
			return true;
		else
			return false;

	}

	public ArrayList<String> listarJugadores() throws IOException {

		return listaJugadores.leerJugador();

	}

}
