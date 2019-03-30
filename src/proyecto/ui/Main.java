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
	public static ControllerJuego controller;
	static String jugador;

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
		out.println("2.  Jugar damas");
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
			jugarDamas();
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
		controller = new ControllerJuego(TipoJuegos.GO);
		jugador = "A";
		jugar();

	}

	private static void jugarDamas() throws IOException {
		controller = new ControllerJuego(TipoJuegos.DAMAS);
		jugador = "A";
		jugar();

	}

	private static void jugarAjedrez() throws IOException {
		controller = new ControllerJuego(TipoJuegos.AJEDREZ);
		jugador = "A";
		jugar();

	}

	public static void jugar() throws IOException {
		String puntoInicial, puntoFinal;
		boolean ganador = false;
		boolean salir = false;

		do {
			puntoInicial = movidaInicial();
			salir = verificarSalir(puntoInicial);
			if (salir) {
				break;
			}
			puntoFinal = movidaFinal();
			salir = verificarSalir(puntoFinal);
			if (salir) {
				break;
			}
			ganador = verificarGanador(puntoInicial, puntoFinal);
		} while (!(ganador));
	}

	private static boolean verificarSalir(String salir) {
		if (salir.equals("0")) {
			return true;
		} else {
			return false;
		}

	}

	public static String movidaInicial() throws java.io.IOException {

		String movida;

		out.println("Jugador " + jugador + "        (oprima 0 para salir del juego)");
		out.println("------------------------------------------------");
		out.println("Ingrese la posicion inicial");
		out.println();
		movida = in.readLine();

		return movida;
	}

	public static String movidaFinal() throws java.io.IOException {

		String movida;

		out.println("Jugador " + jugador + "        (oprima 0 para salir del juego)");
		out.println("------------------------------------------------");
		out.println("Ingrese la posicion final");
		movida = in.readLine();
		out.println();

		return movida;
	}

	private static boolean verificarGanador(String puntoInicial, String puntoFinal) throws java.io.IOException {
		boolean ganador = false;
		ganador = controller.jugar(puntoInicial, puntoFinal, jugador);
		changeJugador();
		return ganador;
	}

	private static void changeJugador() {
		if (jugador.equals("A")) {
			jugador = "B";
		} else if (jugador.equals("B")) {
			jugador = "A";
		}

	}

}
