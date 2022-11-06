package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import juego.Juego;

public interface FabricaEnemigo {
	
	/**
	 * Crea un nuevo Enemigo partiendo de ciertos parametros
	 * @param j Juego
	 * @param etiqueta JLabel
	 * @param pos_x int
	 * @param pos_y int
	 * @return enemigo
	 */
	public abstract Enemigo crearEnemigo(Juego j, JLabel etiqueta, int pos_x, int pos_y);
}
