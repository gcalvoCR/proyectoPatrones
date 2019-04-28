package proyecto.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import proyecto.Fabrica.FabricaJuego;
import proyecto.Fabrica.FabricaPiezas;
import proyecto.controlador.ControllerJuego;
import proyecto.controlador.ControllerJugador;
import proyecto.enums.Colores;
import proyecto.enums.TipoJuegos;
import proyecto.enums.TipoPiezas;
import proyecto.juego.Ajedrez;
import proyecto.juego.Damas;
import proyecto.juego.Juego;
import proyecto.jugador.Jugador;
import proyecto.jugador.Jugador.JugadorBuilder;
import proyecto.persistencia.PersistenciaJugadores;
import proyecto.persistencia.PersistenciaMovimientos;
import proyecto.piezas.Alfil;
import proyecto.piezas.Caballo;
import proyecto.piezas.Dama;
import proyecto.piezas.Peon;
import proyecto.piezas.Pieza;
import proyecto.piezas.Reina;
import proyecto.piezas.Rey;
import proyecto.piezas.Torre;
import proyecto.tablero.Tablero;
import proyecto.utils.Utilidades;


public class TestMove {
	
	//Controllers
	
	//Controller Juego
	
	@Test
	public static void testJugarAjedrez() {
		
		String puntoInicioPrueba = "D2"; 
		String puntoFinalPrueba = "C2";
		String jugadorNombre = "Juan";
		String jugadorNombre2 = "Felipe";
		String jugadorUser = "largartoJuancho";
		String jugadorUser2 = "pipe56";
		String jugador = "";
		TipoJuegos tipoJuego = null;
		ControllerJuego pruebaJuego = new ControllerJuego (tipoJuego.AJEDREZ, jugadorNombre, jugadorUser, jugadorNombre2, jugadorUser2);
	
		Boolean pruebaMetodo = pruebaJuego.jugar(puntoInicioPrueba, puntoFinalPrueba, jugador);
		
		assertEquals(true, pruebaMetodo, "Error");	
		
	}
	
	@Test
	public static void testJugarDamas() {
		
		String puntoInicioPrueba = "D2"; 
		String puntoFinalPrueba = "C2";
		String jugadorNombre = "Ana";
		String jugadorNombre2 = "Marce";
		String jugadorUser = "anit@";
		String jugadorUser2 = "meme90";
		String jugador = "";
		TipoJuegos tipoJuego = null;
		ControllerJuego pruebaJuego = new ControllerJuego (tipoJuego.DAMAS, jugadorNombre, jugadorUser, jugadorNombre2, jugadorUser2);
		
		Boolean pruebaMetodo = pruebaJuego.jugar(puntoInicioPrueba, puntoFinalPrueba, jugador);
		
		assertEquals(true, pruebaMetodo, "Error");	
		
	}
	
	//Controller Jugador
	
	@Test
	public static void testRegistroNuevoJugador() throws IOException {
		String jugadorNombre = "Mora Inés";
		String jugadorNombre2 = "Manuela";
		String jugadorUser = "morita";
		String jugadorUser2 = "Manu";
		ControllerJugador controller = new ControllerJugador();
		
		boolean resultadoRegistro = controller.registroNuevoJugador(jugadorNombre, jugadorUser);
		boolean resultadoRegistro2 = controller.registroNuevoJugador(jugadorNombre2, jugadorUser2);
		
		assertEquals(true, resultadoRegistro, "Error");	
		assertEquals(true, resultadoRegistro2, "Error");	
		
	}
		
	
//	//Fabricas
//	
//	//Fabrica Juegos

	@Test
	public static void testGetJuego(){
		
		TipoJuegos tipoJuego1 = null;
		TipoJuegos tipoJuego2 = null;
		String jugadorNombre = "Gabriel";
		String jugadorNombre2 = "Manuel";
		String jugadorUser = "gab56";
		String jugadorUser2 = "Man76";
		
		Ajedrez ajedrez = new Ajedrez (jugadorNombre, jugadorUser, jugadorNombre2, jugadorUser2);
		Damas damas = new Damas(jugadorNombre, jugadorUser, jugadorNombre2, jugadorUser2);
		
		Juego pruebaJuego1 = FabricaJuego.getJuego(tipoJuego1.AJEDREZ, jugadorNombre, jugadorUser, jugadorNombre2, jugadorUser2);
		Juego pruebaJuego2 = FabricaJuego.getJuego(tipoJuego1.DAMAS, jugadorNombre, jugadorUser, jugadorNombre2, jugadorUser2);
		
		
		assertEquals(ajedrez, pruebaJuego1);
		assertEquals(damas, pruebaJuego2);
		
	}
//	
//	// Fabrica Piezas
//	
	@Test
	public void testGetPieza() {
		
		JugadorBuilder builder = new JugadorBuilder();
		builder.withNombre("Mateo Morales").withUsername("MateoM").withColor(Colores.BLANCO).withEmail("mateo.6798@gmail.com").withSexo("Masculino");
		Jugador nuevoJugador = builder.build();
		builder.withNombre("Luz Morelas").withUsername("Lucita").withColor(Colores.NEGRO).withEmail("marialuz7878@hotmail.com").withSexo("femenino");
		Jugador nuevoJugador2 = builder.build();
		
		Torre torre = new Torre(nuevoJugador2, Colores.BLANCO);
		Alfil alfil = new Alfil(nuevoJugador2, Colores.NEGRO);
		Caballo caballo = new Caballo(nuevoJugador2, Colores.BLANCO);
		Rey rey = new Rey(nuevoJugador2, Colores.NEGRO);
		Reina reina = new Reina(nuevoJugador2, Colores.BLANCO);
		Peon peon = new Peon(nuevoJugador2, Colores.NEGRO);
		Dama dama = new Dama(nuevoJugador2, Colores.BLANCO);
		
		Pieza nuevaPieza = FabricaPiezas.getPieza(TipoPiezas.TORRE, nuevoJugador2, Colores.BLANCO);
		Pieza nuevaPieza1 = FabricaPiezas.getPieza(TipoPiezas.ALFIL, nuevoJugador, Colores.NEGRO);
		Pieza nuevaPieza2 = FabricaPiezas.getPieza(TipoPiezas.CABALLO, nuevoJugador2, Colores.BLANCO);
		Pieza nuevaPieza3 = FabricaPiezas.getPieza(TipoPiezas.REY, nuevoJugador, Colores.NEGRO);
		Pieza nuevaPieza4 = FabricaPiezas.getPieza(TipoPiezas.REINA, nuevoJugador2, Colores.BLANCO);
		Pieza nuevaPieza5 = FabricaPiezas.getPieza(TipoPiezas.PEON, nuevoJugador, Colores.NEGRO);
		Pieza nuevaPieza6 = FabricaPiezas.getPieza(TipoPiezas.DAMA, nuevoJugador2, Colores.BLANCO);
	//	Pieza nuevaPieza7 = FabricaPiezas.getPieza(TipoPiezas.DAMAREINA, nuevoJugador, Colores.NEGRO);
	
		assertEquals(torre, nuevaPieza);
		assertEquals(alfil, nuevaPieza1);
		assertEquals(caballo, nuevaPieza2);
		assertEquals(rey, nuevaPieza3);
		assertEquals(reina, nuevaPieza4);	
		assertEquals(peon, nuevaPieza5);
		assertEquals(dama, nuevaPieza6);
		//assertEquals("Not implemented yet", nuevaPieza7);
	
	}
	
	@Test
	public void testPersistenciaMovimientos() throws IOException {
		
		String movimientos= "0938, 2392";
		PersistenciaMovimientos persistencia = new PersistenciaMovimientos();
		boolean resultado = persistencia.guardarDato(movimientos);
		
		assertEquals(true, resultado);
	}
	
	//Juegos
	
	//Ajedrez
	
//	@Test
//	public void testMovePieceAjedrez() {
//		
//		String jugador = "Mariano Mant";
//		String jugador2 = "Noelia Rod";
//		String user = "Mariano78";
//		String user2 = "Noelia782";
//		int xInicial = 2;
//		int xFinal = 1;
//		int yInicial = 3;
//		int yFinal = 2;
//		
//	Tablero tablero = new Tablero(8, 8);
//	

//		
//		Ajedrez nuevoAjedrez = new Ajedrez(jugador, user, jugador2, user2);
//		
//		boolean resultado1 = nuevoAjedrez.movePiece(jugador, xInicial, yInicial, xFinal, yFinal);
//		boolean resultado2 = nuevoAjedrez.movePiece(jugador2,2, 3, 1, 9);
//		
//	assertEquals(false, resultado1);
//		assertEquals(true, resultado2);
		
				
//		public boolean movePiece(String jugador, int initialX, int initialY, int finalX, int finalY) {
//			if (validateMovement(jugador, initialX, initialY, finalX, finalY)) {
//				Pieza pieza = tablero.getCelda(initialX, initialY).getPieza();
//				tablero.getCelda(initialX, initialY).setPieza(null);
//				piezas.remove(tablero.getCelda(finalX, finalY).getPieza());
//				tablero.getCelda(finalX, finalY).setPieza(pieza);
//				return true;
//			}
//			return false;
//		}
		
	
//	}
	
	
	
		

}
