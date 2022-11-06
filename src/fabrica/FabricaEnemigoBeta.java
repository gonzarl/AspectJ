package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import entidad.enemigo.EnemigoBeta;
import juego.Juego;

public class FabricaEnemigoBeta implements FabricaEnemigo{

	/**
	 * Crea un nuevo EnemigoBeta partiendo de ciertos parametros
	 * @param j Juego
	 * @param etiqueta JLabel
	 * @param pos_x int
	 * @param pos_y int
	 * @return enemigo beta
	 */
	public Enemigo crearEnemigo(Juego j, JLabel etiqueta, int pos_x, int pos_y) {
		return new EnemigoBeta(j,etiqueta,500,0, pos_x, pos_y);
	}
	
}
