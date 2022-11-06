package fabrica;

import entidad.Entidad;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilBase;
import juego.Juego;

public class FabricaProyectilBase implements FabricaProyectil{
	
	/**
	 * Crea un nuevo ProyectilBase partiendo de ciertos parametros
	 * @param juego Juego
	 * @param entidad Entidad
	 * @return proyectil base
	 */
	public Proyectil crearProyectil(Juego juego, Entidad e) {
		return new ProyectilBase(juego, (Jugador) e,-40);
	}

}
