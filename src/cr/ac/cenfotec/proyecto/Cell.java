package cr.ac.cenfotec.proyecto;

public class Cell {

	private CheckerType checker;
	private boolean ocupado;
	private int x, y;

	public Cell(int x, int y) {
		this.ocupado = false;
		this.x = x;
		this.y = y;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public CheckerType getChecker() {
		return checker;
	}

	public void setChecker(CheckerType checker) {
		this.checker = checker;
	}

}
