package proyecto.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import proyecto.enums.TipoJuegos;
import proyecto.jugador.Jugador;

public class PersistenciaTXT implements Plataforma {

	public PersistenciaTXT() {
	}

	@Override
	public boolean guardarMovimiento(String texto, TipoJuegos target) {
		try {
			File path = null;
			switch (target) {
			case AJEDREZ:
				path = new File("./ajedrez.txt");
				break;
			case DAMAS:
				path = new File("./damas.txt");
				break;
			case GO:
				path = new File("./go.txt");
				break;
			}
			FileWriter output = new FileWriter(path, true);
			BufferedWriter writer = new BufferedWriter(output);

			writer.write(texto);
			writer.newLine();
			writer.close();
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<String> leerMovimiento(TipoJuegos target) {
		try {
			File path;
			switch (target) {
			case AJEDREZ:
				path = new File("./ajedrez.txt");
				break;
			case DAMAS:
				path = new File("./damas.txt");
				break;
			case GO:
				path = new File("./go.txt");
				break;
			}
			ArrayList<String> data = new ArrayList<>();
			path = new File("movimientos.txt");
			FileReader reader = new FileReader(path);
			BufferedReader buffer = new BufferedReader(reader);
			String datos;
			while ((datos = buffer.readLine()) != null) {
				data.add(datos);
			}
			reader.close();
			return data;

		} catch (IOException e) {

		}
		return null;
	}

	@Override
	public boolean guardarJugador(Jugador jugador) {
		try {
			File path = new File("./Jugador.txt");
			FileWriter output = new FileWriter(path, true);
			BufferedWriter writer = new BufferedWriter(output);

			writer.write(jugador.getNombre() + "," + jugador.getUsername());
			writer.newLine();
			writer.close();
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<String> leerJugador() {
		ArrayList<String> data = new ArrayList<>();
		try {
			File path = new File("Jugador.txt");
			FileReader reader = new FileReader(path);
			BufferedReader buffer = new BufferedReader(reader);
			String datos;
			while ((datos = buffer.readLine()) != null) {
				data.add(datos);
			}
			reader.close();
			return data;

		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void eliminarPersistencia(TipoJuegos target) {
		try {
			File path = null;
			switch (target) {
			case AJEDREZ:
				path = new File("./ajedrez.txt");

				break;
			case DAMAS:
				path = new File("./damas.txt");
				break;
			case GO:
				path = new File("./go.txt");
				break;
			}
			path.delete();
		} catch (Exception e) {
		}
	}

}
