package proyecto.controlador;

import proyecto.juego.Board;
import proyecto.juego.Juego;

public class Controller {

	public void iniciarPartida() {
		Juego checkers = new Board();
		checkers.fillBoard();
		System.out.println(checkers.toString());

	}

}
