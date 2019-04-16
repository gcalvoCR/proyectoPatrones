package proyecto.persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public static boolean creartxt(ArrayList<Jugador> lista) throws IOException {
		FileWriter flwriter = null;
	
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("tx/texto.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Jugador jugador : lista) {
				//escribe los datos en el archivo
				bfwriter.write(jugador.getNombre() + "," + jugador.getUsername() + "\n");
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Jugador creado satisfactoriamente..");
 
			
			if (flwriter != null) {
			//cierra el flujo principal
					flwriter.close();
				
		
			}
			return true;
		}
	
	
	
	public static ArrayList leerArchivo() throws FileNotFoundException {
		// crea el flujo para leer desde el archivo
		File file = new File("tx/texto.txt");
		ArrayList listaJugadores= new ArrayList<>();	
		Scanner scanner;
	
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				Jugador j= new Jugador();
				j.setNombre(delimitar.next());
				j.setUsername(delimitar.next());
				listaJugadores.add(j);
			}
			//se cierra el objeto scanner
			scanner.close();

		return listaJugadores;
	}
	
	

	public static void aniadirArchivo(ArrayList<Jugador> lista) throws IOException {
		FileWriter flwriter = null;
		//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter("tx/texto.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Jugador jugador : lista) {
				//escribe los datos en el archivo
				bfwriter.write(jugador.getNombre() + "," + jugador.getUsername() + "\n");
			}
			bfwriter.close();
			System.out.println("Archivo modificado satisfactoriamente..");
 
			if (flwriter != null) {
				flwriter.close();
				
			}
		
	}	


}
