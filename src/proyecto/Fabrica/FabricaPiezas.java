package proyecto.Fabrica;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;
import proyecto.piezas.Alfil;
import proyecto.piezas.Caballo;
import proyecto.piezas.Dama;
import proyecto.piezas.Peon;
import proyecto.piezas.Pieza;
import proyecto.piezas.Reina;
import proyecto.piezas.Rey;
import proyecto.piezas.Torre;

public class FabricaPiezas {
	public static Pieza getPieza(TipoPiezas target, int x, int y, Jugador pjugador, Colores color) {
		switch (target) {
		case TORRE:
			return new Torre(x, y, pjugador, color);
		case ALFIL:
			return new Alfil(x, y, pjugador, color);
		case CABALLO:
			return new Caballo(x, y, pjugador, color);
		case REY:
			return new Rey(x, y, pjugador, color);
		case REINA:
			return new Reina(x, y, pjugador, color);
		case PEON:
			return new Peon(x, y, pjugador, color);
		case DAMA:
			return new Dama(x, y, pjugador, color);
		case DAMAREINA:
			throw new RuntimeException("Not implemented yet");

		default:
			throw new RuntimeException("Unknown piece");
		}

	}

}
