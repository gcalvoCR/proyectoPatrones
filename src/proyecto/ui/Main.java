package proyecto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import proyecto.controlador.ControllerJuego;
import proyecto.controlador.ControllerJugador;
import proyecto.enums.TipoJuegos;

public class Main {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static PrintStream out = System.out;
	private static ControllerJuego controllerJuego;
	private static ControllerJugador controllerJugador = new ControllerJugador();
	private static String turno;
	private static String nombreA, userA, nombreB, userB;

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
		out.println("********************************");
		out.println("1.  Jugar ajedrez");
		out.println("2.  Jugar damas");
		out.println("3.  Jugar go");
		out.println("4.  Registrar jugador");
		out.println("5.  Enlistar jugadores");
		out.println("6.  Elegir jugadores");
		out.println("7.  Reproducir partida");
		out.println("0.  Salir");
		out.println("********************************");
		out.println();
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
			validarCredenciales();
			jugarAjedrez();
			break;

		case 2:
			validarCredenciales();
			jugarDamas();
			break;

		case 3:
			validarCredenciales();
			jugarGo();
			break;

		case 4:
			registrarJugador();
			break;

		case 5:
			listarJugadores();
			break;

		case 6:
			listarJugadores();
			elegirJugador();
			break;
			
		case 7:
			
			
			break;

		case 0:
			noSalir = false;
			out.println("********************************");
			out.println("Gracias por jugar, Arrivederci!");
			out.println("********************************");
			out.println();
			break;

		default:
			out.println("************************");
			out.println("Opcion invalida");
			out.println();
			break;
		}
		return noSalir;
	}

	private static void validarCredenciales() {
		if (nombreA == null) {
			nombreA = "Jugador 1";
		}
		if (nombreB == null) {
			nombreA = "Jugador 2";
		}
		if (userA == null) {
			userA = "User 1";
		}
		if (nombreB == null) {
			userB = "User 2";
		}
	}

	private static void registrarJugador() throws IOException {

		String nombre;
		String username;

		out.println("Ingrese el nombre del jugador ");
		nombre = (in.readLine());

		out.println("Ingrese el username ");
		username = (in.readLine());

		if (controllerJugador.registroNuevoJugador(nombre, username))
			out.println("Jugador registrado correctamente");

	}

	private static void listarJugadores() throws IOException {

		Iterator iterador = controllerJugador.listarJugadores().iterator();
		int i = 1;

		out.println();
		out.println("Lista de jugadores registrados:");
		out.println("********************************");
		out.println("   [nombre	usuario]");
		while (iterador.hasNext()) {
			Object element = iterador.next();
			String nombre = ((String) element).substring(0, ((String) element).indexOf(","));
			String user = ((String) element).substring(((String) element).indexOf(",") + 1);

			out.println(i + ") " + nombre + "	" + user);
			i++;
		}
		out.println("********************************");
		out.println();
	}

	private static void elegirJugador() throws NumberFormatException, IOException {

		ArrayList<String> lista = controllerJugador.listarJugadores();

		out.println("Indique el número del jugador para fichas blancas");
		int num = Integer.parseInt(in.readLine());

		String usuario = lista.get(num - 1);

		nombreA = usuario.substring(0, usuario.indexOf(","));
		userA = usuario.substring(usuario.indexOf(",") + 1);

		out.println("Indique el número del jugador para fichas negras");

		int num2 = Integer.parseInt(in.readLine());

		String usuario2 = lista.get(num2 - 1);

		nombreB = usuario2.substring(0, usuario2.indexOf(","));
		userB = usuario2.substring(usuario2.indexOf(",") + 1);

	}

	private static void jugarGo() throws IOException {
		controllerJuego = new ControllerJuego(TipoJuegos.GO, nombreA, userA, nombreB, userB);
		turno = "blanco";
		jugar();

	}

	private static void jugarDamas() throws IOException {
		controllerJuego = new ControllerJuego(TipoJuegos.DAMAS, nombreA, userA, nombreB, userB);
		turno = "blanco";
		jugar();

	}

	private static void jugarAjedrez() throws IOException {
		controllerJuego = new ControllerJuego(TipoJuegos.AJEDREZ, nombreA, userA, nombreB, userB);
		turno = "blanco";
		jugar();

	}

	public static void jugar() throws IOException {

		String puntoInicial, puntoFinal;
		boolean ganador = false;
		boolean salir = false;

		do {
			imprimirTablero();
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
			ganador = moverPieza(puntoInicial, puntoFinal);
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

		if (turno.equals("blanco")) {
			out.println(userA + ", posicion inicial");
		} else if (turno.equals("negro")) {
			out.println(userB + ", posicion inicial");
		}

		String movida = in.readLine();

		return movida;
	}

	public static String movidaFinal() throws java.io.IOException {

		if (turno.equals("blanco")) {
			out.println("Jugador " + userA + ", posicion final");
		} else if (turno.equals("negro")) {
			out.println("Jugador " + userB + ", posicion final");
		}

		String movida = in.readLine();

		return movida;
	}

	public static boolean moverPieza(String puntoInicial, String puntoFinal) throws java.io.IOException {

		boolean change = true;
		if (turno.equals("blanco")) {
			change = controllerJuego.jugar(puntoInicial, puntoFinal, userA);
		} else if (turno.equals("negro")) {
			change = controllerJuego.jugar(puntoInicial, puntoFinal, userB);
		}

		if (!(controllerJuego.validarGanador())) {
			if (change) {
				changeJugador();
			} else {
				System.out.println(controllerJuego.getMensaje());

			}
			System.out.println();
			return false;
		}
		System.out.println(controllerJuego.getMensaje());
		System.out.println();
		return true;
	}

	public static void changeJugador() {
		if (turno.equals("blanco")) {
			turno = "negro";
		} else if (turno.equals("negro")) {
			turno = "blanco";
		}
	}

	public static void imprimirTablero() {
		out.println(controllerJuego.imprimirTablero());
	}
}
