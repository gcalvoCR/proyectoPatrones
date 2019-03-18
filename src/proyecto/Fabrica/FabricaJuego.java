package proyecto.Fabrica;

import proyecto.enums.TipoJuegos;
import proyecto.juego.Ajedrez;
import proyecto.juego.Damas;
import proyecto.juego.Go;
import proyecto.juego.Juego;

public class FabricaJuego {
	public static Juego getJuego(TipoJuegos target) {
		switch (target) {
		case AJEDREZ:
			return new Ajedrez();
		case GO:
			return new Go();
		case DAMAS:
			return new Damas();
		default:
			throw new RuntimeException("Unknown option");
		}

	}

}
