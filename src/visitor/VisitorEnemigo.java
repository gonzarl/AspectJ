package visitor;

import entidad.enemigo.Enemigo;
import entidad.proyectil.Proyectil;

public class VisitorEnemigo extends Visitor{
	private Enemigo enemigo;
	
	public VisitorEnemigo(Enemigo e) {
		this.enemigo=e;
	}
	
	public void visitProyectil(Proyectil p) {
		enemigo.getJuego().porEliminarEntidad(p);
	}
}
