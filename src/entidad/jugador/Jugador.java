package entidad.jugador;

import java.util.*;
import javax.swing.JLabel;
import entidad.*;
import entidad.proyectil.*;
import entidad_grafica.*;
import fabrica.*;
import juego.Juego;
import visitor.*;

public class Jugador extends Entidad{
	
	private int danio_recibido,pos_x,pos_y,tiempo_mejora;
	private FabricaProyectil fabrica_base, fabrica_mejorado;
	private String proyectil_actual;
	private List<Proyectil> en_espera;
	
	/**
	 * Crea un nuevo Jugador partiendo de un determinado juego
	 * @param juego Juego
	 */
	public Jugador(Juego juego) {
		this.juego = juego;
		this.danio_recibido=0;
		ent_graf = new EntidadGraficaJugador();
		pos_x=300;
		pos_y=460;
		fabrica_base = new FabricaProyectilBase();
		fabrica_mejorado = new FabricaProyectilMejorado();
		v = new VisitorJugador(this);
		proyectil_actual = "Base";
		tiempo_mejora = 0;
		
		en_espera = new ArrayList<Proyectil>();
	}
	
	public void atacar() {
		if(proyectil_actual=="Base" || tiempo_mejora==0) {
			atacarBase();
		}else {
			atacarMejorado();
		}
	}
	
	/**
	 * Ataque base
	 */
	public void atacarBase() {
		ProyectilBase p = (ProyectilBase) fabrica_base.crearProyectil(juego,this);
		en_espera.add(p);
	}

	/**
	 * Ataque mejorado
	 */
	public void atacarMejorado() {
		ProyectilMejorado p = (ProyectilMejorado) fabrica_mejorado.crearProyectil(juego,this);
		en_espera.add(p);
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visitarJugador(this);
	}

	@Override
	public void mover() {
		ent_graf.moverEtiqueta(pos_x, pos_y);
	}
	
	/**
	 * Metodo jugar
	 */
	public void curar() {
		this.danio_recibido=0;
	}
	
	/**
	 * Establece el danio recibido
	 * @param danio
	 */
	public void recibirDanio(int danio) {
		this.danio_recibido += danio;
		
		if(this.danio_recibido >= 100) {
			ent_graf.muerte();
		}else {
			ent_graf.daniar();
		}
		
	}
	
	@Override
	public void accionar() {
		for (Proyectil p : en_espera) {
			juego.porAgregarEntidad(p);
		}
		
		en_espera = new ArrayList<Proyectil>();
		
		Iterable<Entidad> colisiones = this.detectarColisiones();
		
		for (Entidad e:colisiones)
			e.aceptar(this.v);

	}
	
	/**
	 * Establece la posicion respecto x
	 * @param posx int
	 */
	public void setPosX(int posX) {
		this.pos_x = posX;
	}
	
	/**
	 * Establece la posicion respecto y
	 * @param posy int
	 */
	public void setPosY(int posY) {
		this.pos_y = posY;
	}
	
	/**
	 * Establece las posiciones respecto x e y
	 * @param x int
	 * @param y int
	 */
	public void setPos(int x, int y) {
		pos_x = x;
		pos_y = y;
	}

	public void setProyectilActual(String proyectil) {
		this.proyectil_actual = proyectil;
	}
	
	public void setTiempoMejora(int tiempo) {
		tiempo_mejora=tiempo;
	}
	
	public int getTiempoMejora() {
		return tiempo_mejora;
	}
	
	/**
	 * Consulta el danio recibido
	 * @return danio
	 */
	public int getDanioRecibido() {
		return danio_recibido;
	}
	
	/**
	 * Contulta la posicion respecto x
	 *  @param posicion respecto x
	 */
	public int getPosX() {
		return pos_x;
	}

	/**
	 * Consulta la posicion respecto y
	 * @return posicion respecto y
	 */
	public int getPosY() {
		return pos_y;
	}
	
	public String getProyectilActual() {
		return proyectil_actual;
	}

	
	
	
	
}
