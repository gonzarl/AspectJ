package entidad.enemigo;

import java.awt.geom.Area;
import javax.swing.JLabel;
import entidad.Entidad;
import entidad.proyectil.ProyectilEnemigo;
import entidad_grafica.EntidadGraficaEnemigo;
import fabrica.FabricaProyectilEnemigo;
import juego.Juego;
import movimiento.MovimientoVerticalEnemigo;
import visitor.Visitor;
import visitor.VisitorEnemigo;

public class EnemigoBeta extends Enemigo{
	protected int delay;
	
	/**
	 * Crea un nuevo EnemigoAlfa partiendo de ciertos parametros
	 * @param j Juego
	 * @param etiqueta JLabel
	 * @param lim_inf int
	 * @param lim_sup int
	 * @param pos_X int 
	 * @param pos_y int
	 */
	public EnemigoBeta(Juego j,JLabel label,int lim_inf, int lim_sup, int pos_x, int pos_y) {
		juego = j;
		vida=150;
		danio_ataque=10;
		ent_graf = new EntidadGraficaEnemigo(label);
		rango = 15;
		direccion = 1;
		velocidad = 2;
		movimiento = new MovimientoVerticalEnemigo( this,direccion,velocidad,lim_inf,lim_sup);
		fabrica = new FabricaProyectilEnemigo();
		v = new VisitorEnemigo(this);
		
		delay =0;
		tiempo_pausa=0;
		activo=true;
	}
	
	@Override
	public void atacar() {
		ProyectilEnemigo proyectil = (ProyectilEnemigo) fabrica.crearProyectil(juego,this);
		juego.porAgregarEntidad(proyectil);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarEnemigoBeta(this);
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
		if(tiempo_pausa==0) {
			this.mover();
			
			if (++delay % 50 == 0) {
				this.atacar();
			}
		}else {
			--tiempo_pausa;
		}
		
	}
	
}
