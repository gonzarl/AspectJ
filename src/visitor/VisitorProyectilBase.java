package visitor;

import entidad.enemigo.*;
import entidad.proyectil.*;

public class VisitorProyectilBase extends Visitor{
	
	private ProyectilBase p;
	
	/**
	 * Crea un nuevo visitorPremio partiendo de un parametro
	 * @param p ProyectilBase
	 */
	public VisitorProyectilBase(ProyectilBase p) {
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
