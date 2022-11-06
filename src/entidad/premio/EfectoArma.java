package entidad.premio;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad.enemigo.Enemigo;
import entidad_grafica.EntidadGraficaPremioSnitch;
import juego.Juego;
import movimiento.MovimientoVerticalPremio;
import visitor.Visitor;
import visitor.VisitorPremio;

public class EfectoArma extends Efecto {
	/**
	 * Crea un nuevo EfectoArma partiendo de ciertos parametros
	 * @param lim_inf int
	 * @param lim_sup int
	 * @param juego Juego
	 * @param e Enemigo
	 */
	public EfectoArma(int lim_inf,int lim_sup, Juego juego, Enemigo e) {
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		JLabel etiqueta_enemigo = e.getEntidadGrafica().getEtiqueta();
		etiqueta.setBounds(etiqueta_enemigo.getX()+(etiqueta_enemigo.getWidth()/2), etiqueta_enemigo.getY()+80, 25, 25);
		ent_graf = new EntidadGraficaPremioSnitch(etiqueta); 
		int direccion = 1;
		int velocidad = 5;
		movimiento = new MovimientoVerticalPremio(this,direccion,velocidad,lim_inf,lim_sup);
		v = new VisitorPremio(this);
		
		tiempo_pausa=0;
	}
	
	@Override
	public void activar() {
		juego.mejorarHechizos();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarEfectoSuperArma(this);
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
