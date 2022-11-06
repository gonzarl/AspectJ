package visitor;

import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.proyectil.*;

public class VisitorProyectilMejorado extends Visitor{
	
	private ProyectilMejorado p;
	
	/**
	 * Crea un nuevo visitorPremio partiendo de un parametro
	 * @param p ProyectilMejorado
	 */
	public VisitorProyectilMejorado(ProyectilMejorado p) {
		this.p = p;
	}
	
	@Override
	public void visitarEnemigoAlfa(EnemigoAlfa e) {
		p.colisionarAlfa(e);
		p.getJuego().porEliminarEntidad(p);

	}
	
	@Override
	public void visitarEnemigoBeta(EnemigoBeta e) {
		p.colisionarBeta(e);
		p.getJuego().porEliminarEntidad(p);

	}
	
	public void visitarProyectilEnemigo(ProyectilEnemigo p) {
		p.getJuego().porEliminarEntidad(p);
		p.getJuego().porEliminarEntidad(this.p);
	}
}
