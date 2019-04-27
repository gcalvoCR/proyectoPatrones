package proyecto.tablero;

import java.util.ArrayList;

import proyecto.piezas.Pieza;

public class Tablero {

	private int rows = 8;
	private int columns = 8;

	private Celda[][] celdas;
	ArrayList<Pieza> piezas;

	public Tablero(int filas, int columnas) {
		rows = filas;
		columns = columnas;
		celdas = new Celda[rows][columns];
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				celdas[x][y] = new Celda(x, y);
			}
		}
	}

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public void putPieza(Pieza pieza) {
		if (piezas == null) {
			piezas = new ArrayList<Pieza>();
		}
		piezas.add(pieza);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Celda[][] getCeldas() {
		return celdas;
	}

	public void setCeldas(Celda[][] celdas) {
		this.celdas = celdas;
	}

	public Celda getCelda(int x, int y) {
		return celdas[x][y];
	}
	
//	public Celda getCelda(int x, int y) {
//		return celdas[x][y];
//	}
	

}
