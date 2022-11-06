package fabrica;

import entidad.Entidad;
import entidad.proyectil.Proyectil;
import juego.Juego;

public interface FabricaProyectil {
	/**
	 * Crea un nuevo Proyectil partiendo de ciertos parametros
	 * @param juego Juego
	 * @param entidad Entidad
	 * @return proyectil
	 */
	public abstract Proyectil crearProyectil(Juego juego, Entidad e);
}
