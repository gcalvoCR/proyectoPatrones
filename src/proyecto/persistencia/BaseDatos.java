package proyecto.persistencia;

import java.util.ArrayList;

import proyecto.jugador.Jugador;

public class BaseDatos extends Plataforma{
	
	protected void openConnection() {
		System.out.println("Abriendo conexion...");

	}

	protected void sendData(String Txt) {
		try {
			System.out.println("Guardando datos...");
			Thread.sleep(3000);
			System.out.println("Los datos se guardaron con éxito");
		} catch (InterruptedException e) {
			throw new RuntimeException("Hubo un error al guardar datos");
		}

	}

	protected ArrayList<String> getData() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("Listado de datos");
		return data;

	}

	protected void closeConnection() {
		System.out.println("Cierre de conexion");
	}

	@Override
	protected void sendDataJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	
	

}
