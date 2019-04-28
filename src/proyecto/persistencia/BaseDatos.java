package proyecto.persistencia;

import java.util.ArrayList;

import proyecto.enums.TipoJuegos;
import proyecto.jugador.Jugador;

public class BaseDatos implements Plataforma {

	@Override
	public boolean guardarMovimiento(String texto, TipoJuegos target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> leerMovimiento(TipoJuegos target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> leerJugador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPersistencia(TipoJuegos target) {
		// TODO Auto-generated method stub

	}

}
