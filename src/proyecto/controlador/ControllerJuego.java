package proyecto.controlador;

import proyecto.Fabrica.FabricaJuego;
import proyecto.enums.TipoJuegos;
import proyecto.juego.Juego;

public class ControllerJuego {

	public void iniciarPartida(TipoJuegos pjuego) {

		Juego juego = FabricaJuego.getJuego(pjuego);

	}

}
