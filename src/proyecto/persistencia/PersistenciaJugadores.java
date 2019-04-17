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
				
		
		
		
		
//		FileWriter flwriter = null;
//	
//		flwriter = new FileWriter("tx/texto.txt");
//		BufferedWriter bfwriter = new BufferedWriter(flwriter);
//		bfwriter.write(jugador.getNombre() + "," + jugador.getUsername() + "\n");
//		
//		bfwriter.close();
//		//System.out.println("Jugador creado satisfactoriamente");
// 
//		if (flwriter != null) {
//			flwriter.close();
//		}
//		return true;
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
		
	
		
//		File file = new File("tx/texto.txt");
//		ArrayList listaJugadores= new ArrayList ();	
//		Scanner scanner;
//	
//			scanner = new Scanner(file);
//			while (scanner.hasNextLine()) {
//				String linea = scanner.nextLine();
//				Scanner delimitar = new Scanner(linea);
//					
//				delimitar.useDelimiter("\\s*,\\s*");
//				Jugador j= new Jugador();
//				j.setNombre(delimitar.next());
//				j.setUsername(delimitar.next());
//				listaJugadores.add(j);
//			}
//	
//			scanner.close();
//
//		return listaJugadores;
	}
	
	

	public void agregarJugador(ArrayList<Jugador> lista) throws IOException {
		FileWriter flwriter = null;
		//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter("tx/texto.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Jugador jugador : lista) {
			
				bfwriter.write(jugador.getNombre() + "," + jugador.getUsername() + "\n");
			}
			bfwriter.close();
			System.out.println("Jugador agregado satisfactoriamente");
 
			if (flwriter != null) {
				flwriter.close();
				
			}
		
	}	


}
