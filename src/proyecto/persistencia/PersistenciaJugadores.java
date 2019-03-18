package proyecto.persistencia;

import java.util.ArrayList;

import proyecto.jugador.Jugador;

public class PersistenciaJugadores {

	private ArrayList<Jugador> listaJugadores;

	public PersistenciaJugadores() {
		listaJugadores = new ArrayList<>();
	}

	public void addJugador(Jugador pjugador) {
		listaJugadores.add(pjugador);
	}

	public ArrayList<Jugador> getJugador() {
		return listaJugadores;
	}

}
