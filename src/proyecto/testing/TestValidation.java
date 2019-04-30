package proyecto.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import proyecto.piezas.Alfil;
import proyecto.piezas.Caballo;
import proyecto.piezas.Peon;
import proyecto.piezas.Reina;
import proyecto.piezas.Rey;
import proyecto.piezas.Torre;

public class TestValidation {

	@Test
	public void testPeonA() {
		int initialX = 6;
		int initialY = 0;
		int finalX = 5;
		int finalY = 0;

		Peon p = new Peon(null, null);
		boolean movimiento = p.isValidMovement(initialX, initialY, finalX, finalY);

		assertTrue(movimiento);
	}
	
	@Test
	public void testPeonB() {
		int initialX = 6;
		int initialY = 0;
		int finalX = 3;
		int finalY = 0;

		Peon p = new Peon(null, null);
		boolean movimiento = p.isValidMovement(initialX, initialY, finalX, finalY);

		assertFalse(movimiento);
	}
	
	@Test
	public void testTorreA() {
		int initialX = 7;
		int initialY = 0;
		int finalX = 5;
		int finalY = 0;

		Torre t = new Torre(null, null);
		boolean movimiento = t.isValidMovement(initialX, initialY, finalX, finalY);

		assertTrue(movimiento);
	}
	
	@Test
	public void testTorreB() {
		int initialX = 7;
		int initialY = 0;
		int finalX = 6;
		int finalY = 1;

		Torre t = new Torre(null, null);
		boolean movimiento = t.isValidMovement(initialX, initialY, finalX, finalY);

		assertFalse(movimiento);
	}
	
	@Test
	public void testCaballoA() {
		int initialX = 7;
		int initialY = 1;
		int finalX = 5;
		int finalY = 0;

		Caballo c = new Caballo(null, null);
		boolean movimiento = c.isValidMovement(initialX, initialY, finalX, finalY);

		assertTrue(movimiento);
	}
	
	@Test
	public void testCaballoB() {
		int initialX = 7;
		int initialY = 1;
		int finalX = 5;
		int finalY = 1;

		Caballo c = new Caballo(null, null);
		boolean movimiento = c.isValidMovement(initialX, initialY, finalX, finalY);

		assertFalse(movimiento);
	}
	
	@Test
	public void testAlfilA() {
		int initialX = 7;
		int initialY = 2;
		int finalX = 6;
		int finalY = 1;

		Alfil a = new Alfil(null, null);
		boolean movimiento = a.isValidMovement(initialX, initialY, finalX, finalY);

		assertTrue(movimiento);
	}
	
	@Test
	public void testAlfilB() {
		int initialX = 7;
		int initialY = 2;
		int finalX = 7;
		int finalY = 0;

		Alfil a = new Alfil(null, null);
		boolean movimiento = a.isValidMovement(initialX, initialY, finalX, finalY);

		assertFalse(movimiento);
	}
	
	@Test
	public void testReinaA() {
		int initialX = 7;
		int initialY = 4;
		int finalX = 7;
		int finalY = 0;

		Reina r = new Reina(null, null);
		boolean movimiento = r.isValidMovement(initialX, initialY, finalX, finalY);

		assertTrue(movimiento);
	}
	
	@Test
	public void testReinaB() {
		int initialX = 7;
		int initialY = 4;
		int finalX = 5;
		int finalY = 3;

		Reina r = new Reina(null, null);
		boolean movimiento = r.isValidMovement(initialX, initialY, finalX, finalY);

		assertFalse(movimiento);
	}
	
	@Test
	public void testReyA() {
		int initialX = 7;
		int initialY = 3;
		int finalX = 6;
		int finalY = 3;

		Rey r = new Rey(null, null);
		boolean movimiento = r.isValidMovement(initialX, initialY, finalX, finalY);

		assertTrue(movimiento);
	}
	
	@Test
	public void testReyB() {
		int initialX = 7;
		int initialY = 3;
		int finalX = 5;
		int finalY = 3;

		Rey r = new Rey(null, null);
		boolean movimiento = r.isValidMovement(initialX, initialY, finalX, finalY);

		assertFalse(movimiento);
	}
}
