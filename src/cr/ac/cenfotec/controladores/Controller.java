package cr.ac.cenfotec.controladores;

import cr.ac.cenfotec.proyecto.Board;
import cr.ac.cenfotec.proyecto.Game;

public class Controller {

	public void iniciarPartida() {
		Game checkers = new Board();
		checkers.fillBoard();
		System.out.println(checkers.toString());

	}

}
