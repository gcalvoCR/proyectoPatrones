package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public class Peon extends Pieza {

	public Peon(Jugador pjugador, Colores color) {
		super(pjugador, color);
		type = TipoPiezas.PEON;
	}

	@Override
	public String toString() {
		return color.toString().charAt(0) + "P";
	}

	@Override
	public boolean isValidMovement(int initialX, int initialY, int finalX, int finalY) {
		
		if (getColor().equals(Colores.BLANCO) && (finalX > initialX)) { //Validate piece white and go down
			
			if (finalY == initialY) { //Validate move direct
				
				if ((initialX == 1) && (finalX > 1 && finalX < 4)) { //Validate only first movement jump 1 or 2 step
					return true;	
				} else if (initialX > 1 && finalX == (initialX + 1)) { //Validate only 1 step
					return true;
				}
				
			} else if (finalY == (initialY + 1) || finalY == (initialY - 1)) { //Validate move diagonal
				
				if (finalX == (initialX + 1)) { //Validate only 1 move
					return true;
				}
			}
			
		} else if (getColor().equals(Colores.NEGRO) && (finalX < initialX)){ //Validate piece black and go up
			return true;
		}
		
		return false;
	}

}
