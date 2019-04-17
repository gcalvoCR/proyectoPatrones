package proyecto.jugador;

import java.util.ArrayList;

import proyecto.piezas.Pieza;

public class Jugador {

	private String nombre, username;
	
	public Jugador() { }	


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
		
		return "Jugador: "+ this.getNombre() + " UserName: "+ getUsername() +"\n";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

}
