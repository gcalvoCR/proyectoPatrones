package proyecto.piezas;

import proyecto.enums.Colores;
import proyecto.enums.TipoPiezas;
import proyecto.jugador.Jugador;

public abstract class Pieza {

	protected TipoPiezas type;
	protected Colores color;
	protected Jugador jugador;

	public Pieza(Jugador pjugador, Colores pcolor) {
		jugador = pjugador;
		color = pcolor;
	}

	public abstract boolean isValidMovement(int initialX, int initialY, int finalX, int finalY);

	public TipoPiezas getType() {
		return type;
	}

	public Colores getColor() {
		return color;
	}

	public Jugador getJugador() {
		return jugador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Pieza other = (Pieza) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
