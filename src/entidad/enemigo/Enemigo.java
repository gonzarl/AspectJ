package entidad.enemigo;

import java.util.Random;


import entidad.Entidad;
import entidad.premio.Premio;
import fabrica.FabricaPremio;
import fabrica.FabricaPremioEfectoArma;
import fabrica.FabricaPremioEfectoCuarentena;
import fabrica.FabricaPremioMejoraPocion;
import fabrica.FabricaProyectil;
import movimiento.Movimiento;

public abstract class Enemigo extends Entidad{
	protected int vida,danio_ataque,rango,direccion,velocidad,tiempo_pausa;
	protected FabricaProyectil fabrica;
	protected boolean activo;
	
	/**
	 * Metodo de ataque
	 */
	public abstract void atacar();

	/**
	 * Establece la vida
	 * @param vida int
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Establece el danio del ataque
	 * @param danio_ataque int
	 */
	public void setDanioAtaque(int danio_ataque) {
		this.danio_ataque = danio_ataque;
	}

	/**
	 * Establece la direccion
	 * @param direccion int
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Establece la velocidad
	 * @param velocidad int
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	 * Establece el rango afectado
	 * @param rango int
	 */
	public void setRango(int rango) {
		this.rango = rango;
	}
	
	/**
	 * Establece la fabrica
	 * @param fabrica FabricaProyectil
	 */
	public void setFabrica(FabricaProyectil fabrica) {
		this.fabrica = fabrica;
	}
	
	/**
	 * Establece el movimiento
	 * @param mov Movimiento
	 */
	public void setMovimiento(Movimiento mov) {
		this.movimiento=mov;
	}
	
	public void setPausa(int tiempo) {
		tiempo_pausa=tiempo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public int getPausa() {
		return tiempo_pausa;
	}
	
	/**
	 * Consulta la vida
	 * @return vida
	 */
	public int getVida() {
		return vida;
	}
	
	/**
	 * Consulta el danio del ataque
	 * @return danio
	 */
	public int getDanioAtaque() {
		return danio_ataque;
	}
	
	/**
	 * Consulta el rango afectado
	 * @return rango
	 */
	public int getRango() {
		return rango;
	}

	/**
	 * Consulta la direccion
	 * @return direccion
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * Consulta velocidad
	 * @return velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Consulta fabrica del proyectil
	 * @return fabrica
	 */
	public FabricaProyectil getFabrica() {
		return fabrica;
	}	
	
	/**
	 * Consulta el movimiento
	 * @return movimiento
	 */
	public Movimiento getMovimiento() {
		return this.movimiento;
	}
	
	public boolean getActivo() {
		return activo;
	}

	
	
	/**
	 * Establece el danio recibido
	 * @param danio int
	 */
	public void recibirDanio(int danio) {
		int rand_int,rand_premio, probabilidad = 4;
		Random rand;
		FabricaPremio fabrica_cuarentena = new FabricaPremioEfectoCuarentena();
		FabricaPremio fabrica_arma = new FabricaPremioEfectoArma();
		FabricaPremio fabrica_pocion = new FabricaPremioMejoraPocion();
		Premio premio;
		
		this.vida -= danio;
		
		if (activo) {
			if(this.vida <= 0) {
				this.juego.porEliminarEntidad(this);
				this.juego.descontarEnemigo();
				activo=false;
				
				//generacion de premios
				rand = new Random();
				rand_int = rand.nextInt(probabilidad);
				if(rand_int==0) {
					rand = new Random();
					//crear premio
					rand_premio= rand.nextInt(3);
					switch(rand_premio) {
						case 0: premio = fabrica_cuarentena.crearPremio(juego,this);break;
						case 1: premio = fabrica_arma.crearPremio(juego,this); break;
						default: premio = fabrica_pocion.crearPremio(juego,this); break;
					}
					juego.porAgregarEntidad(premio);
				}
			}else {
				ent_graf.daniar();
			}
		}
		
	}
	
	
	
	
}
