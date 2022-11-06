package entidad.proyectil;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad.enemigo.*;
import entidad.jugador.Jugador;
import entidad_grafica.*;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorProyectilBase;
import movimiento.*;

public class ProyectilBase extends Proyectil{
	private JLabel lbl;
	
	/**
	 * Crea un nuevo ProyectilBase partiendo de ciertos parametros
	 * @param juego Juego
	 * @param j Jugador
	 * @param lim
	 */
	public ProyectilBase(Juego juego, Jugador jugador, int lim) {
		this.juego = juego;
		lbl = new JLabel();
		lbl.setBounds(jugador.getPosX()+35, jugador.getPosY()-40, 11, 45);
		ent_graf = new EntidadGraficaProyectilBase(lbl);
		direccion = -1;
		velocidad = 4;
		cap_penetracion = 20;
		movimiento = new MovimientoVerticalProyectilJugador(this,direccion,velocidad,lim);
		v = new VisitorProyectilBase(this);
		
		tiempo_pausa=0;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarProyectilBase(this);
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
