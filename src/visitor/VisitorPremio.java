package visitor;

import entidad.jugador.Jugador;
import entidad.premio.Premio;

public class VisitorPremio extends Visitor{
	private Premio p;
	
	/**
	 * Crea un nuevo visitorPremio partiendo de un parametro
	 * @param p Premio
	 */
	public VisitorPremio(Premio p) {
		this.p=p;
	}
	
	@Override
	public void visitarJugador(Jugador j) {
		this.p.activar();
		j.getJuego().porEliminarEntidad(this.p);
	}
}
