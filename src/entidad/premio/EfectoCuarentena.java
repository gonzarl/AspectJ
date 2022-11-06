package entidad.premio;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad.enemigo.Enemigo;
import entidad_grafica.EntidadGraficaPremioTiempo;
import juego.Juego;
import movimiento.MovimientoVerticalPremio;
import visitor.Visitor;
import visitor.VisitorPremio;

public class EfectoCuarentena extends Efecto{

	public EfectoCuarentena(int lim_inf,int lim_sup, Juego juego,Enemigo e) {
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		JLabel etiqueta_enemigo = e.getEntidadGrafica().getEtiqueta();
		etiqueta.setBounds(etiqueta_enemigo.getX()+(etiqueta_enemigo.getWidth()/2), etiqueta_enemigo.getY()+80, 25, 25);
		ent_graf = new EntidadGraficaPremioTiempo(etiqueta);
		int direccion=1;
		int velocidad=5;
		movimiento = new MovimientoVerticalPremio(this,direccion,velocidad,lim_inf,lim_sup);
		v = new VisitorPremio(this);
		
		tiempo_pausa=0;
	}
	
	@Override
	public void activar() {
		juego.pausar();
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visitarEfectoCuarentena(this);
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
