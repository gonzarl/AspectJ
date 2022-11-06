package fabrica;

import entidad.enemigo.Enemigo;
import entidad.premio.Premio;
import juego.Juego;

public interface FabricaPremio {
	/**
	 * Crea un nuevo Premio partiendo de ciertos parametros
	 * @param j Juego
	 * @param etiqueta JLabel
	 * @return premio
	 */
	public abstract Premio crearPremio(Juego j,Enemigo e);
}
