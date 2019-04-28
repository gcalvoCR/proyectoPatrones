package proyecto.persistencia;

import java.util.ArrayList;

import proyecto.enums.TipoJuegos;
import proyecto.jugador.Jugador;

public interface Plataforma {

	public boolean guardarMovimiento(String texto, TipoJuegos target);

	ArrayList<String> leerMovimiento(TipoJuegos target);

	public boolean guardarJugador(Jugador jugador);

	ArrayList<String> leerJugador();

	void eliminarPersistencia(TipoJuegos target);

}
