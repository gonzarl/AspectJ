package visitor;

import entidad.proyectil.ProyectilEnemigo;

public class VisitorProyectilEnemigo extends Visitor{
	
	private ProyectilEnemigo p;
	
	public VisitorProyectilEnemigo(ProyectilEnemigo p) {
		this.p = p;
	}
	
}
