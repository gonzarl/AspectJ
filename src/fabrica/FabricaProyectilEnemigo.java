package fabrica;

import entidad.Entidad;
import entidad.enemigo.*;
import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilEnemigo;
import juego.Juego;

public class FabricaProyectilEnemigo implements FabricaProyectil{

	/**
	 * Crea un nuevo ProyectilEnemigo partiendo de ciertos parametros
	 * @param juego Juego
	 * @param entidad Entidad
	 * @return proyectil enemigo
	 */
	public Proyectil crearProyectil(Juego juego, Entidad e) {
		return new ProyectilEnemigo(juego, (Enemigo) e, e.getEntidadGrafica().getEtiqueta().getY()+250, 0);
	}
	
}
