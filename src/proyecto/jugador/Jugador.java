package proyecto.jugador;

import java.util.ArrayList;

import proyecto.piezas.Pieza;

public class Jugador {

	private String nombre, username;
<<<<<<< HEAD
	
	public Jugador() { }
=======
	ArrayList<Pieza> piezas;
>>>>>>> origin/master

	public Jugador(String pnombre, String pusername) {
		nombre = pnombre;
		username = pusername;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		
		return "Jugador: "+ this.getNombre() + " UserName: "+ getUsername();
	}

}
