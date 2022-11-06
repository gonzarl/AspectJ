package juego;

import java.util.Random;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import fabrica.*;

public class Horda {
	private Juego juego;
	private Enemigo[] horda;
	private int enemigos_restantes;
	
	/**
	 * Crea una nueva Horda partiendo de ciertos parametros
	 * @param j Juego
	 * @param dificultad int
	 */
	public Horda(Juego j, int dificultad) {
		this.juego = j;
		switch (dificultad) {
			case 1: crearHorda(4,5); break;
			case 2: crearHorda(8,4); break;
			case 3: crearHorda(12,3); break;
			case 4: crearHorda(16,2); break;
		}
		
	}

	/**
	 * Establece la horda
	 * @param horda Enemigo[]
	 */
	public void setHorda(Enemigo[] horda) {
		this.horda = horda;
	}
	
	/**
	 * Establece los enemigos restantes
	 * @param enemigos_restantes int
	 */
	public void setEnemigosRestantes(int enemigos_restantes) {
		this.enemigos_restantes = enemigos_restantes;
	}
	
	/**
	 * Consulta la horda
	 * @return horda
	 */
	public Enemigo[] getHorda() {
		return horda;
	}

	/**
	 * Consulta los enemigos restantes
	 * @return cantidad de enemigos
	 */
	public int getEnemigosRestantes() {
		return enemigos_restantes;
	}

	/**
	 * Crea una horda con determinada cantidad de enemigos y una probabilidad de obtener enemigos mas fuertes
	 * @param cant_enemigos int
	 * @param probabilidad int
	 */
	private void crearHorda(int cant_enemigos, int probabilidad) {
		int randInt,posx,posy=-80;
		JLabel etiquetaEnemigo;
		FabricaEnemigo fabricaBase, fabricaMejorado;
		Enemigo enemigo;
		
		Random rand = new Random();
		
		horda = new Enemigo[cant_enemigos];
		enemigos_restantes=cant_enemigos;
		int cantLineas = cant_enemigos / 4;
		int contEnemigos=0;
		
		fabricaBase = new FabricaEnemigoAlfa();
		fabricaMejorado = new FabricaEnemigoBeta();
		
		posx=0;
		for(int l=0;l<cantLineas;l++) {
			for(int i=0;i<4;i++) {
				posx += 100;
				etiquetaEnemigo = new JLabel();
				etiquetaEnemigo.setBounds(posx, posy, 45, 50);
				//creo enemigo con una probabilidad determinada de que sea un enemigo mejorado y lo agrego a la horda.
				randInt = rand.nextInt(probabilidad);
				if(randInt==0) {
					enemigo = fabricaMejorado.crearEnemigo(juego, etiquetaEnemigo, posx, posy);
				}else {
					enemigo = fabricaBase.crearEnemigo(juego, etiquetaEnemigo, posx, posy);
				}
				horda[contEnemigos++] = enemigo;
				juego.porAgregarEntidad(enemigo);
				
			}
			posx=0;
			posy+=60;
		}
	}
	
	public boolean termino() {
		return (enemigos_restantes==0);
	}
	
	public void enemigoAbatido() {
		enemigos_restantes--;
		}
}
