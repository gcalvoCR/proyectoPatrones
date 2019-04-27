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
		
	
	//Fabricas
	
	//Fabrica Juegos
	
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
	
	// Fabrica Piezas
	
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
//		assertEquals(false, resultado1);
//		assertEquals(true, resultado2);
//		
//				
////		public boolean movePiece(String jugador, int initialX, int initialY, int finalX, int finalY) {
////			if (validateMovement(jugador, initialX, initialY, finalX, finalY)) {
////				Pieza pieza = tablero.getCelda(initialX, initialY).getPieza();
////				tablero.getCelda(initialX, initialY).setPieza(null);
////				piezas.remove(tablero.getCelda(finalX, finalY).getPieza());
////				tablero.getCelda(finalX, finalY).setPieza(pieza);
////				return true;
////			}
////			return false;
////		}
//		
//	
//	}
	
	
	
	@Test
	
	public void testValidateWinnerAjedrez() {
		
		JugadorBuilder builder = new JugadorBuilder();
		builder.withNombre("Gabriel").withUsername("gab56").withColor(Colores.BLANCO).withEmail("gabriel.6798@gmail.com").withSexo("Masculino");
		Jugador nuevoJugador = builder.build();
		builder.withNombre("Manuel Mora").withUsername("Man76").withColor(Colores.NEGRO).withEmail("manuelm7878@hotmail.com").withSexo("femenino");
		Jugador nuevoJugador2 = builder.build();
		
		Torre torreB = new Torre(nuevoJugador2, Colores.BLANCO);
		Alfil alfilB = new Alfil(nuevoJugador2, Colores.BLANCO);
		Caballo caballoB = new Caballo(nuevoJugador2, Colores.BLANCO);
		Rey reyB = new Rey(nuevoJugador2, Colores.BLANCO);
		Reina reinaB = new Reina(nuevoJugador2, Colores.BLANCO);
		Peon peonB = new Peon(nuevoJugador2, Colores.BLANCO);
		Dama damaB = new Dama(nuevoJugador2, Colores.BLANCO);
		
		Torre torreN = new Torre(nuevoJugador2, Colores.NEGRO);
		Alfil alfilN = new Alfil(nuevoJugador2, Colores.NEGRO);
		Caballo caballoN = new Caballo(nuevoJugador2, Colores.NEGRO);
		Rey reyN = new Rey(nuevoJugador2, Colores.NEGRO);
		Reina reinaN = new Reina(nuevoJugador2, Colores.NEGRO);
		Peon peonN = new Peon(nuevoJugador2, Colores.NEGRO);
		Dama damaN = new Dama(nuevoJugador2, Colores.NEGRO);
		
		Ajedrez ajedrez = new Ajedrez ("Gabriel", "gab56", "Manuel", "Man76");
		ArrayList<Pieza> piezas = new ArrayList<>();
		piezas.add(torreB);
		piezas.add(alfilB);
		piezas.add(caballoB);
	//	piezas.add(reyB);
		piezas.add(reinaB);
		piezas.add(peonB);
		piezas.add(damaB);
		piezas.add(torreN);
		piezas.add(alfilN);
		piezas.add(caballoN);
		piezas.add(reinaN);
		piezas.add(peonN);
		piezas.add(damaN);
		piezas.add(reyN);
						
		boolean resultadoWinner = ajedrez.validateWinner();
		assertEquals(true, resultadoWinner);
	
	}
	
	@Test
	public static void testGetPiezasNegras() {
		
		String resultadoRey = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoReina = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoTorre = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoAlfil = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoCaballo = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoPeon = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		
		assertEquals("♚", resultadoRey);
		assertEquals("♛", resultadoReina);
		assertEquals("♜", resultadoTorre);
		assertEquals("♝", resultadoAlfil);
		assertEquals("♞,", resultadoCaballo);
		assertEquals("♟", resultadoPeon);
		
	}
	
	@Test
	public static void testGetPiezasBlancas() {
		
		String resultadoRey = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoReina = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoTorre = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoAlfil = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoCaballo = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		String resultadoPeon = Ajedrez.getPiezasNegras(TipoPiezas.REY);
		
		assertEquals("♔", resultadoRey);
		assertEquals( "♕", resultadoReina);
		assertEquals( "♖", resultadoTorre);
		assertEquals("♗", resultadoAlfil);
		assertEquals("♘", resultadoCaballo);
		assertEquals("♙", resultadoPeon);
			
		
	}

	
	//Persistencia Jugadores
	
	@Test
	public void testCrearLista() throws IOException {

		PersistenciaJugadores persist = new PersistenciaJugadores();
		JugadorBuilder builder = new JugadorBuilder();
		builder.withNombre("Mateo Morales").withUsername("MateoM").withColor(Colores.BLANCO).withEmail("mateo.6798@gmail.com").withSexo("Masculino");
		Jugador nuevoJugador = builder.build();
		
		boolean resultadoCrearLista = persist.crearLista(nuevoJugador);
		
		assertEquals(true, resultadoCrearLista);
	
	}
	
	
	//Piezas
	
	
	//Tablero
	
	
	//Main
	
	//Utilidades
	
	@Test
	public static void testUtilidades() {
		char uno = 'A';
		char dos = 'D';
		char tres = 'G';
		char cuatro = 'B';
		char cinco = 'C';
		
		Utilidades nUtilidades = new Utilidades();
		int resultado1 = nUtilidades.getIntFromChar(uno);
		int resultado2 = nUtilidades.getIntFromChar(dos);
		int resultado3 = nUtilidades.getIntFromChar(tres);
		int resultado4 = nUtilidades.getIntFromChar(cuatro);
		int resultado5 = nUtilidades.getIntFromChar(cinco);
		
		assertEquals(0, resultado1);
		assertEquals(3, resultado2);
		assertEquals(7, resultado3);
		assertEquals(1, resultado4);
		assertEquals(2, resultado5);
		
	}
		

}
