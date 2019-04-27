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
	
	public static Pieza getPieza(TipoPiezas target, Jugador pjugador, Colores color) {
		switch (target) {
		case TORRE:
			return new Torre(pjugador, color);
		case ALFIL:
			return new Alfil(pjugador, color);
		case CABALLO:
			return new Caballo(pjugador, color);
		case REY:
			return new Rey(pjugador, color);
		case REINA:
			return new Reina(pjugador, color);
		case PEON:
			return new Peon(pjugador, color);
		case DAMA:
			return new Dama(pjugador, color);
//		case DAMAREINA:
//			throw new RuntimeException("Not implemented yet");
		default:
			throw new RuntimeException("Unknown piece");
		}

	}

}
