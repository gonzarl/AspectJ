package entidad.proyectil;

import java.util.Random;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad_grafica.EntidadGraficaProyectilEnemigo;
import juego.Juego;
import movimiento.MovimientoVerticalProyectilEnemigo;
import visitor.Visitor;
import visitor.VisitorProyectilEnemigo;
import entidad.enemigo.*;

public class ProyectilEnemigo extends Proyectil{
	/**
	 * Crea un nuevo ProyectilEnemigo partiendo de ciertos parametros 
	 * @param juego Juego
	 * @param e Enemigo
	 * @param lim_inf int
	 * @param lim_sup int
	 */
	public ProyectilEnemigo(Juego juego, Enemigo e, int lim_inf,int lim_sup) {
		this.juego = juego;
		JLabel lbl = new JLabel();
		int ancho_enemigo = e.getEntidadGrafica().getEtiqueta().getWidth();
		Random rand = new Random();
		int random_x = rand.nextInt(ancho_enemigo);
		lbl.setBounds(e.getEntidadGrafica().getEtiqueta().getX()+random_x, e.getEntidadGrafica().getEtiqueta().getY()+80, 15, 20);
		this.ent_graf = new EntidadGraficaProyectilEnemigo(lbl);
		this.direccion = 1;
		this.velocidad = 4;
		this.cap_penetracion = 5;
		this.movimiento = new MovimientoVerticalProyectilEnemigo(this,direccion,velocidad,lim_inf,lim_sup);
		
		v = new VisitorProyectilEnemigo(this);
		
		tiempo_pausa=0;
	}
	

	@Override
	public void aceptar(Visitor v) {
		v.visitarProyectilEnemigo(this);
	}
	
	/**
	 * Metodo colisionar
	 */
	public void colisionar() {
		juego.getJugador().recibirDanio(cap_penetracion);
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
