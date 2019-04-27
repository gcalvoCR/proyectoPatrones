package proyecto.Fabrica;

import proyecto.enums.TipoPlataforma;
import proyecto.persistencia.BaseDatos;
import proyecto.persistencia.PersistenciaJugadores;
import proyecto.persistencia.PersistenciaMovimientos;
import proyecto.persistencia.Plataforma;


public class FabricaPersistencia {
	
	public static Plataforma getPlatform(TipoPlataforma tipoPlataforma) {
		switch (tipoPlataforma) {
		case TXT_JUGADOR:
			return new PersistenciaJugadores();
		case TXT_MOVIMIENTO:
			return new PersistenciaMovimientos();
		case BD:
			return new BaseDatos();
		default:
			throw new RuntimeException("Not implemented");
		}
	}
	
	

}
