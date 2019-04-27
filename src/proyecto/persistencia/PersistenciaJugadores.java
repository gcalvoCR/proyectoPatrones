package proyecto.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import proyecto.jugador.Jugador;

public class PersistenciaJugadores extends Plataforma{

	
	public boolean guardarDato(Jugador jugador) {
		
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
	public ArrayList<String> leerDato() throws IOException {
		
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
            throw e;
        }		
	}

	@Override
	protected void openConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void sendData(String Txt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<String> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void closeConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void sendDataJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

}
