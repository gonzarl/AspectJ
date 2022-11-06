package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import entidad.enemigo.EnemigoAlfa;
import juego.Juego;

public class FabricaEnemigoAlfa implements FabricaEnemigo{

	/**
	 * Crea un nuevo EnemigoAlfa partiendo de ciertos parametros
	 * @param j Juego
	 * @param etiqueta JLabel
	 * @param pos_x int
	 * @param pos_y int
	 * @return enemigo alfa
	 */
	public Enemigo crearEnemigo(Juego j, JLabel etiqueta, int pos_x, int pos_y) {
		return new EnemigoAlfa(j,etiqueta,500,0, pos_x, pos_y);
	}
	
}
