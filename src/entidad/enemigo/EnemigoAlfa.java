package entidad.enemigo;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad.proyectil.ProyectilEnemigo;
import entidad_grafica.EntidadGraficaEnemigo;
import fabrica.FabricaProyectilEnemigo;
import juego.Juego;
import movimiento.MovimientoVerticalEnemigo;
import visitor.*;

public class EnemigoAlfa extends Enemigo{
	private int delay,vida_inicial;
	private boolean velocidad_cambiada;
	
	/**
	 * Crea un nuevo EnemigoAlfa partiendo de ciertos parametros
	 * @param j Juego
	 * @param etiqueta JLabel
	 * @param lim_inf int
	 * @param lim_sup int
	 * @param pos_X int 
	 * @param pos_y int
	 */
	public EnemigoAlfa(Juego j, JLabel etiqueta,int lim_inf, int lim_sup, int pos_X, int pos_y) {
		juego = j;
		vida_inicial = 100;
		vida = vida_inicial;
		danio_ataque=5;
		ent_graf = new EntidadGraficaEnemigo(etiqueta);
		rango = 10;
		direccion = 1;
		velocidad = 2;
		movimiento = new MovimientoVerticalEnemigo(this,direccion,velocidad,lim_inf,lim_sup);
		fabrica = new FabricaProyectilEnemigo();
		v = new VisitorEnemigo(this);
		velocidad_cambiada = false;
		delay = 0;
		tiempo_pausa=0;
		activo=true;
	}
	
	@Override
	public void atacar() {
		ProyectilEnemigo p = (ProyectilEnemigo) fabrica.crearProyectil(juego,this);
		juego.porAgregarEntidad(p);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarEnemigoAlfa(this);
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
			
			if(!velocidad_cambiada && vida<=vida_inicial*0.2) {
				velocidad = velocidad*2;
				movimiento.setVelocidad(velocidad);
				velocidad_cambiada = true;
			}
		}else {
			--tiempo_pausa;
		}
	}	
	
}
