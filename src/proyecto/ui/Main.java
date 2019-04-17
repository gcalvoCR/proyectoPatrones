package proyecto.ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import proyecto.controlador.ControllerJuego;
import proyecto.controlador.ControllerJugador;
import proyecto.enums.TipoJuegos;
import proyecto.jugador.Jugador;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	public static ControllerJuego controller;
	public static ControllerJugador controllerJugador = new ControllerJugador();
	static String jugador;
	static String nombreA, userA, nombreB, userB;


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
		out.println("5.  Enlistar jugadores");
		out.println("6.  Elegir jugadores");
		out.println("0.  Salir");
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
			listarJugadores();
			break;
			
		case 6:
			listarJugadores();
			elegirJugador();
			break;
			
		case 0:
			noSalir = false;
			out.println("******************************");
			out.println("Gracias por jugar, Arrivederci!");
			out.println("******************************");
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


	private static void registrarJugador() throws IOException {
		
		
		String nombre;
		String username;
				
			out.println("Ingrese el nombre del jugador ");
			nombre = (in.readLine());
		
			out.println("Ingrese el username ");
			username = (in.readLine());
	
	
		//if (controllerJugador.registroNuevoJugador(nombre, username))
			controllerJugador.registroNuevoJugador(nombre, username);
		out.println("Jugador registrado correctamente");
		
	}
	
	private static void listarJugadores() throws IOException {
		
		ArrayList <String> lista = controllerJugador.listarJugadores();
		int i = 1;
		for (String jugador : lista) {
			out.println(i+ ") "+ jugador);
			i++;
		}
		
	}
	
	private static void elegirJugador() throws NumberFormatException, IOException {
		
		ArrayList<String> lista = controllerJugador.listarJugadores();
	
		out.println("Indique el número del Jugador que desea utilizar como Jugador A");
		int num = Integer.parseInt(in.readLine());
		
		String usuario = lista.get(num-1);
	       
		nombreA = usuario.substring(0,usuario.indexOf(","));
	    userA =  usuario.substring(usuario.indexOf(",")+1);
	       
		out.println("Indique el número del Jugador que desea utilizar como Jugador B");
	
		int num2 = Integer.parseInt(in.readLine());
		
		String usuario2 = lista.get(num2-1);
	       
		nombreB= usuario.substring(0,usuario.indexOf(","));
	    userB =  usuario.substring(usuario.indexOf(",")+1);	
			
	}

	private static void jugarGo() throws IOException {
		controller = new ControllerJuego(TipoJuegos.GO, nombreA, userA, nombreB, userB);
		jugador = "A";
		jugar();

	}

	private static void jugarDamas() throws IOException {
		controller = new ControllerJuego(TipoJuegos.DAMAS, nombreA, userA, nombreB, userB);
		jugador = "A";
		jugar();

	}

	private static void jugarAjedrez() throws IOException {
		controller = new ControllerJuego(TipoJuegos.AJEDREZ, nombreA, userA, nombreB, userB);
		jugador = "A";
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

		if (jugador.equals("A")) {
			out.println("Jugador " + userA + ", posicion inicial");
		} else if (jugador.equals("B")) {
			out.println("Jugador " + userB + ", posicion inicial");
		}
		
		String movida = in.readLine();

		return movida;
	}

	public static String movidaFinal() throws java.io.IOException {

		if (jugador.equals("A")) {
			out.println("Jugador " + userA + ", posicion final");
		} else if (jugador.equals("B")) {
			out.println("Jugador " + userB + ", posicion final");
		}
		
		String movida = in.readLine();

		return movida;
	}

	public static boolean moverPieza(String puntoInicial, String puntoFinal) throws java.io.IOException {

		boolean change =true;
		if (jugador.equals("A")) {
			change = controller.jugar(puntoInicial, puntoFinal, userA);
		} else if (jugador.equals("B")) {
			change = controller.jugar(puntoInicial, puntoFinal, userB);
		}
		
		

		if (!(controller.validarGanador())) {
			if (change) {
				changeJugador();
			} else {
				System.out.println(controller.getMensaje());
				System.out.println();
			}
			return false;
		}
		System.out.println(controller.getMensaje());
		System.out.println();
		return true;
	}

	public static void changeJugador() {
		if (jugador.equals("A")) {
			jugador = "B";
		} else if (jugador.equals("B")) {
			jugador = "A";
		}
	}

	public static void imprimirTablero() {
		out.println(controller.imprimirTablero());
	}
}
