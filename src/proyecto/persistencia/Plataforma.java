package proyecto.persistencia;

import java.io.IOException;
import java.util.ArrayList;

import proyecto.jugador.Jugador;

public abstract class Plataforma {
	
	public boolean guardarDato(String movimientos) {
		openConnection();
		sendData(movimientos);
		closeConnection();
		return true;
	}
	public void guardarDatoDamas(String movimientos) {
		openConnection();
		sendData(movimientos);
		closeConnection();		
	}
	
	public boolean guardarDato(Jugador jugador) {
		openConnection();
		sendDataJugador(jugador);
		closeConnection();	
		return true;
	}

	public ArrayList<String> leerDato() throws IOException {
		openConnection();
		ArrayList<String> data = getData();
		closeConnection();
		return data;
	}

	protected abstract void openConnection();

	protected abstract void sendData(String Txt);
	
	protected abstract void sendDataJugador(Jugador jugador);

	protected abstract ArrayList<String> getData();

	protected abstract void closeConnection();


}
