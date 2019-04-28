package proyecto.Fabrica;

import proyecto.enums.TipoPlataforma;
import proyecto.persistencia.BaseDatos;
import proyecto.persistencia.PersistenciaTXT;
import proyecto.persistencia.Plataforma;

public class FabricaPersistencia {

	public static Plataforma getPlatform(TipoPlataforma tipoPlataforma) {
		switch (tipoPlataforma) {
		case TXT:
			return new PersistenciaTXT();
		case BD:
			return new BaseDatos();
		default:
			throw new RuntimeException("Not implemented");
		}
	}

}
