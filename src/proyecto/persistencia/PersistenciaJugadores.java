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

public class PersistenciaJugadores {

	
	public boolean crearLista(Jugador jugador) throws IOException {
		
		try {
            File path = new File("./test.txt");
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
	
	public ArrayList<String> leerArchivo() throws IOException {
		
		ArrayList<String> data = new ArrayList<>();
        try {
            File path = new File("test.txt");
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

}
