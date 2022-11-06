package entidad.proyectil;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.jugador.Jugador;
import entidad_grafica.*;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorProyectilMejorado;
import movimiento.*;

public class ProyectilMejorado extends Proyectil{
	private JLabel lbl;
	
	/**
	 * Crea un nuevo ProyectilMejorado partiendo de ciertos parametros
	 * @param juego Juego
	 * @param j Jugador
	 * @param lim int
	 */
	public ProyectilMejorado(Juego juego, Jugador jugador,int lim) {
	    this.juego = juego;
		lbl = new JLabel();
		lbl.setBounds(jugador.getPosX()+35, jugador.getPosY()-40, 11, 45);
		direccion = -1;
		velocidad = 5;
		cap_penetracion = 30;
		ent_graf = new EntidadGraficaProyectilMejorado(lbl);
		movimiento = new MovimientoVerticalProyectilJugador(this,direccion,velocidad,lim);
	    v = new VisitorProyectilMejorado(this);
		
		tiempo_pausa=0;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarProyectilMejorado(this);
	}
	
	/**
	 * Establece el danio de la colision con un enemigo alfa
	 * @param e EnemigoAlfa
	 */
	public void colisionarAlfa(EnemigoAlfa e) {
		e.recibirDanio(cap_penetracion);
	}
	
	/**
	 * Establece el danio de la colision con un enemigo beta
	 * @param e EnemigoBeta
	 */
	public void colisionarBeta(EnemigoBeta e) {
		e.recibirDanio(cap_penetracion);
	}

	@Override
	public void mover() {
		movimiento.mover();
	}

	@Override
	public void accionar() {
		Iterable<Entidad> colisiones = this.detectarColisiones();
		for (Entidad e:colisiones)
			e.aceptar(this.v);		
		
		if (tiempo_pausa==0)
			this.mover();
		else
			--tiempo_pausa;
	}
	
}