package proyecto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import proyecto.controlador.ControllerJuego;
import proyecto.enums.TipoJuegos;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;

	public static void main(String[] args) throws IOException {
		int opc;
		boolean noSalir = true;

		do {
			mostrarMenu();
			opc = leerOpcion();
			noSalir = ejecutarAccion(opc);
		} while (noSalir);

	}

	static void mostrarMenu() {

		out.println();
		out.println("Oprima la opcion que desee:");
		out.println("1.  Jugar ajedrez");
		out.println("2.  Jugar tablero");
		out.println("3.  Jugar go");
		out.println("4.  Registrar jugador");
		out.println("0.  Salir");
	}

	static int leerOpcion() throws java.io.IOException {

		int opcion;

		out.print("Seleccione su opcion: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}

	static boolean ejecutarAccion(int popcion) throws java.io.IOException {

		boolean noSalir = true;

		switch (popcion) {

		case 1:
			jugarAjedrez();
			break;

		case 2:
			jugarTablero();
			break;

		case 3:
			jugarGo();
			break;

		case 4:
			registrarJugador();
			break;

		case 5:
			reproducirPartida();
			break;

		case 0:
			noSalir = false;
			break;

		default:
			out.println("************************");
			out.println("Opcion invalida");
			out.println();
			break;
		}
		return noSalir;
	}

	private static void reproducirPartida() {
		// TODO Auto-generated method stub

	}

	private static void registrarJugador() {
		// TODO Auto-generated method stub

	}

	private static void jugarGo() throws IOException {
		ControllerJuego controller = new ControllerJuego();
		controller.iniciarPartida(TipoJuegos.GO);
		jugar();

	}

	private static void jugarTablero() throws IOException {
		ControllerJuego controller = new ControllerJuego();
		controller.iniciarPartida(TipoJuegos.DAMAS);
		jugar();

	}

	private static void jugarAjedrez() throws IOException {
		ControllerJuego controller = new ControllerJuego();
		controller.iniciarPartida(TipoJuegos.AJEDREZ);
		jugar();

	}

	public static void jugar() throws IOException {
		String opc;
		boolean noSalir = true;

		do {
			mostrarMenu();
			opc = movida();
			noSalir = verificarGanador(opc);
		} while (noSalir);
	}

	public static String movida() throws java.io.IOException {

		String opcion;

		out.print("Ingrese su movimiento: ");
		opcion = in.readLine();
		out.println();

		return opcion;
	}

	static boolean verificarGanador(String movida) throws java.io.IOException {

		return true;
	}

}
