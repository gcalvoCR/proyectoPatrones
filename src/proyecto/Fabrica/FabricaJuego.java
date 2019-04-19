package proyecto.Fabrica;

import proyecto.enums.TipoJuegos;
import proyecto.juego.Ajedrez;
import proyecto.juego.Damas;
import proyecto.juego.Go;
import proyecto.juego.Juego;

public class FabricaJuego {
	public static Juego getJuego(TipoJuegos target, String nombreA, String userA, String nombreB, String userB) {
		switch (target) {
		case AJEDREZ:
			return new Ajedrez(nombreA, userA, nombreB, userB);
		case GO:
			return new Go(nombreA, userA, nombreB, userB);
		case DAMAS:
			return new Damas(nombreA, userA, nombreB, userB);
		default:
			throw new RuntimeException("Unknown option");
		}

	}

}
