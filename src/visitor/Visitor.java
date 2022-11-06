package visitor;

import entidad.enemigo.*;
import entidad.proyectil.*;
import entidad.jugador.*;
import entidad.premio.EfectoArma;
import entidad.premio.EfectoCuarentena;
import entidad.premio.MejoraPocion;

public abstract class Visitor {
	
	/**
	 * Metodo visitar enemigo alfa
	 * @param e EnemigoAlfa
	 */
	public void visitarEnemigoAlfa(EnemigoAlfa e) {}
	
	/**
	 * Metodo visitar enemigo beta
	 * @param e EnemigoBeta
	 */
	public void visitarEnemigoBeta(EnemigoBeta e) {}
	
	/**
	 * Metodo visitar jugador
	 * @param j Jugador
	 */
	public void visitarJugador(Jugador j) {}
	
	/**
	 * Metodo visitar proyectil base
	 * @param p ProyectilBase
	 */
	public void visitarProyectilBase(ProyectilBase p) {}
	
	/**
	 * Metodo visitar proyectil mejorado
	 * @param p ProyectilMejorado
	 */
	public void visitarProyectilMejorado(ProyectilMejorado p) {}
	
	/**
	 * Metodo visitar proyectil enemigo
	 * @param e ProyectilEnemigo
	 */
	public void visitarProyectilEnemigo(ProyectilEnemigo e) {}
	
	/**
	 * Metodo visitar efecto cuarentena
	 * @param e EfectoCuarentena
	 */
	public void visitarEfectoCuarentena(EfectoCuarentena e) {}
	
	/**
	 * Metodo visitar efecto arma
	 * @param e EfectoArma
	 */
	public void visitarEfectoSuperArma(EfectoArma e) {}
	
	/**
	 * Metodo visitar procion
	 * @param p MejoraPocion
	 */
	public void visitarPocion(MejoraPocion p) {}
}
