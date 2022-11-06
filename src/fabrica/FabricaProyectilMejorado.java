package fabrica;

import entidad.Entidad;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilMejorado;
import juego.Juego;

public class FabricaProyectilMejorado implements FabricaProyectil{

	/**
	 * Crea un nuevo ProyectilMejorado partiendo de ciertos parametros
	 * @param juego Juego
	 * @param entidad Entidad
	 * @return proyectil mejorado
	 */
	public Proyectil crearProyectil(Juego juego, Entidad e) {
		return new ProyectilMejorado(juego, (Jugador) e, -40);
	}

}
