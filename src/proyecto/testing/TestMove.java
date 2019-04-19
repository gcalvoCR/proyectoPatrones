package proyecto.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import proyecto.Fabrica.FabricaJuego;
import proyecto.Fabrica.FabricaPiezas;
import proyecto.controlador.ControllerJuego;
import proyecto.enums.Colores;
import proyecto.enums.TipoJuegos;
import proyecto.enums.TipoPiezas;
import proyecto.juego.Ajedrez;
import proyecto.juego.Damas;
import proyecto.juego.Juego;
import proyecto.jugador.Jugador;
import proyecto.piezas.Pieza;
import proyecto.piezas.Torre;
import proyecto.utils.Utilidades;


public class TestMove {
	
	//Controllers
	
	//Controller Juego
	
//	@Test
//	public static void testJugarAjedrez() {
//		String puntoInicioPrueba = "D2"; 
//		String puntoFinalPrueba = "C2";
//		String jugador = "Juan";
//		TipoJuegos tipoJuego = null;
//		ControllerJuego pruebaJuego = new ControllerJuego (tipoJuego.AJEDREZ);
//		
//		Boolean pruebaMetodo = pruebaJuego.jugar(puntoInicioPrueba, puntoFinalPrueba, jugador);
//		
//		assertEquals(true, pruebaMetodo, "Error");	
//		
//	}
//	
//	@Test
//	public static void testJugarDamas() {
//		String puntoInicioPrueba = "D2"; 
//		String puntoFinalPrueba = "C2";
//		String jugador = "Ana";
//		TipoJuegos tipoJuego = null;
//		ControllerJuego pruebaJuego = new ControllerJuego (tipoJuego.DAMAS);
//		
//		Boolean pruebaMetodo = pruebaJuego.jugar(puntoInicioPrueba, puntoFinalPrueba, jugador);
//		
//		assertEquals(true, pruebaMetodo, "Error");	
//		
//	}
//	
//	//Controller Jugador
//	
//	@Test
//	public static void testRegistroNuevoJugador() {
//		
//		
//	}
//	
//	@Test 
//	public void testListarJugadores() {
//		
//		
//	}
//	
//	
//	//Fabricas
//	
//	//Fabrica Juegos
//	
//	@Test
//	public static void testGetJuego(){
//		
//		TipoJuegos tipoJuego1 = null;
//		TipoJuegos tipoJuego2 = null;
//		
//		Ajedrez ajedrez = new Ajedrez ();
//		Damas damas = new Damas();
//		
//		Juego pruebaJuego1 = FabricaJuego.getJuego(tipoJuego1.AJEDREZ);
//		Juego pruebaJuego2 = FabricaJuego.getJuego(tipoJuego1.DAMAS);
//		
//		
//		assertEquals(ajedrez, pruebaJuego1);
//		assertEquals(damas, pruebaJuego2);
//		
//	}
//	
//	// Fabrica Piezas
//	
////	@Test
////	public void testGetPieza() {
////		
////		Jugador nuevoJugador = new Jugador ("Mateo Morales", "MateoM");
////		Jugador nuevoJugador2 = new Jugador ("Luz Morelas ", "Lucita");
////			
////		Pieza nuevaPieza = FabricaPiezas.getPieza(TipoPiezas.TORRE, nuevoJugador2, Colores.BLANCO);
////		Pieza nuevaPieza1 = FabricaPiezas.getPieza(TipoPiezas.ALFIL, nuevoJugador, Colores.NEGRO);
////		Pieza nuevaPieza2 = FabricaPiezas.getPieza(TipoPiezas.CABALLO, nuevoJugador2, Colores.BLANCO);
////		Pieza nuevaPieza3 = FabricaPiezas.getPieza(TipoPiezas.REY, nuevoJugador, Colores.NEGRO);
////		Pieza nuevaPieza4 = FabricaPiezas.getPieza(TipoPiezas.REINA, nuevoJugador2, Colores.BLANCO);
////		Pieza nuevaPieza5 = FabricaPiezas.getPieza(TipoPiezas.PEON, nuevoJugador, Colores.NEGRO);
////		Pieza nuevaPieza6 = FabricaPiezas.getPieza(TipoPiezas.DAMA, nuevoJugador2, Colores.BLANCO);
////		Pieza nuevaPieza7 = FabricaPiezas.getPieza(TipoPiezas.DAMAREINA, nuevoJugador, Colores.NEGRO);
////		
////		assertEquals(TipoPiezas.TORRE, nuevaPieza);
////		assertEquals(TipoPiezas.ALFIL, nuevaPieza1);
////		assertEquals(TipoPiezas.CABALLO, nuevaPieza2);
////		assertEquals(TipoPiezas.REY, nuevaPieza3);
////		assertEquals(TipoPiezas.REINA, nuevaPieza4);	
////		assertEquals(TipoPiezas.PEON, nuevaPieza5);
////		assertEquals(TipoPiezas.DAMA, nuevaPieza6);
////		assertEquals(TipoPiezas.DAMAREINA, nuevaPieza7);
////	
////	}
//	
//	//Juegos
//	
//	//Ajedrez
//	
//	@Test
//	public void testMovePieceAjedrez() {
//		
//		String jugador = "Mariano";
//		String jugador2 = "Noelia";
//		int xInicial = 2;
//		int xFinal = 1;
//		int yInicial = 3;
//		int yFinal = 2;
//		
//		Ajedrez nuevoAjedrez = new Ajedrez();
//		
//		boolean resultado1 = nuevoAjedrez.movePiece(jugador, xInicial, yInicial, xFinal, yFinal);
//	//	boolean resultado2 = nuevoAjedrez.movePiece(jugador2,2, 3, 1, 9);
//		
//		assertEquals(true, resultado1);
//	//	assertEquals(false, resultado2);
//		
//	}
//	
//	@Test
//	
//	public void testValidateWinnerAjedrez() {
//		
//		
//	}
//	
//	
//	
//	//Persistencia Jugadores
//	
//	
//	//Piezas
//	
//	
//	//Tablero
//	
//	
//	//Main
//	
//	//Utilidades
//	
//	@Test
//	public static void testUtilidades() {
//		char uno = 'A';
//		char dos = 'D';
//		char tres = 'G';
//		char cuatro = 'B';
//		char cinco = 'C';
//		
//		Utilidades nUtilidades = new Utilidades();
//		int resultado1 = nUtilidades.getIntFromChar(uno);
//		int resultado2 = nUtilidades.getIntFromChar(dos);
//		int resultado3 = nUtilidades.getIntFromChar(tres);
//		int resultado4 = nUtilidades.getIntFromChar(cuatro);
//		int resultado5 = nUtilidades.getIntFromChar(cinco);
//		
//		assertEquals(0, resultado1);
//		assertEquals(3, resultado2);
//		assertEquals(7, resultado3);
//		assertEquals(1, resultado3);
//		assertEquals(2, resultado3);
//		
//	}
//		

}
