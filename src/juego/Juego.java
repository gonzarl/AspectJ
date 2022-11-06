package juego;

import entidad.jugador.Jugador;

import gui.JFrameJuego;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidad.*;

public class Juego implements Runnable{
	private Jugador harry;
	private Horda horda;
	private Mapa mapa;
	private JFrameJuego gui;
	private boolean activo,gano,pausa,disparo;
	private int horda_actual,tiempo_pausa;
	private List<Entidad> por_eliminar;
	private List<Entidad> por_agregar;
	
	public Juego(JFrameJuego gui) {
		this.gui = gui;
	}
    
    /**
     * Establece el jugador 
     * @param harry Jugador
     */
    public void setJugador(Jugador harry) {
		this.harry = harry;
	}
    
    /**
     * Establece la horda 
     * @param horda Horda
     */
    public void setHordas(Horda hordas) {
		this.horda = hordas;
	}
    
    /**
     * Establece el mapa
     * @param mapa Mapa
     */
    public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
    
    public void setGui(JFrameJuego gui) {
    	this.gui=gui;
    }
    
    public void setActivo(boolean activo) {
    	this.activo=activo;
    }
    
    public void setGano(boolean gano) {
    	this.gano=gano;
    }
    
    public void setPausa(boolean pausa) {
    	this.pausa=pausa;
    }
    
    public void setDisparo(boolean disparo) {
    	this.disparo=disparo;
    }
    
    public void setHordaActual(int horda) {
    	horda_actual=horda;
    }
    
    public void setTiempoPausa(int tiempo) {
    	tiempo_pausa=tiempo;
    }
    
    /**
     * Consulta el jugador
     * @return jugador
     */
    public Jugador getJugador() {
        return harry;
    }
	
    /**
     * Consulta la horda
     * @return horda
     */
	public Horda getHordas() {
		return horda;
	}
	
	/**
	 * Consulta el mapa
	 * @return mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}
	
	public JFrameJuego getGui() {
    	return gui;
    }
    
    public boolean getActivo() {
    	return activo;
    }
    
    public boolean getGano() {
    	return gano;
    }
    
    public boolean getPausa() {
    	return pausa;
    }
    
    public boolean getDisparo() {
    	return disparo;
    }
	
	public int getHordaActual() {
		return horda_actual;
	}
	
	public int getTiempoPausa() {
	   	return tiempo_pausa/10;
	}
	
	public void porAgregarEntidad(Entidad e){
    	por_agregar.add(e);
    }
    
    public void porEliminarEntidad(Entidad e) {
    	por_eliminar.add(e);
    }
	
	/**
	 * Metodo iniciar juego
	 */
    public void iniciar() {
    	por_eliminar = new ArrayList<Entidad>();
    	por_agregar = new ArrayList<Entidad>();
    	activo=true;
    	mapa = new Mapa();
    	harry = new Jugador(this);
    	gano=false;
    	horda_actual=1;
    	horda = new Horda(this,horda_actual);
    	
    	tiempo_pausa=0;
    	pausa=false;
    	disparo=false;
    }
    
	/**
     * Metodo ganar juego
     */
    public void ganar() {
    	activo=false;
    }
    
    /**
     * Metodo perder juego
     */
    public void perder() {
    	activo=false;
    }
    
    /**
     * Metodo pausar juego
     */
    public void pausar() {
    	tiempo_pausa=100;
    	pausa=true;
    	for (Entidad e : mapa.getEntidadesActivas()) {
    		e.setPausa(tiempo_pausa);
    	}
    }
    
    /**
     * Metodo mejorar hechizos
     */
    public void mejorarHechizos() {
    	harry.setProyectilActual("Mejorado");
    	harry.setTiempoMejora(300);
    	disparo=true;
    }
    
	public void descontarEnemigo() {
		this.horda.enemigoAbatido();
	}

	public void accionar() {
		if(horda.termino() && horda_actual<4) {
			horda = new Horda(this,++horda_actual);
		}else if(horda.termino() && horda_actual==4) {
			gano=true;
			activo=false;
		}
		
		if(harry.getDanioRecibido()>=100) {
			activo=false;
		}
		
		for (Entidad e: mapa.getEntidadesActivas()) {
			e.accionar();
		}
	}
	
	@Override
	public void run() {		
		this.porAgregarEntidad(harry);
		
		while(activo) {
			accionar();
			int tiempo_disp = harry.getTiempoMejora();
			
			if (tiempo_disp>0) {
				harry.setTiempoMejora(--tiempo_disp);
			}else {
				harry.setProyectilActual("Base");
				disparo=false;
			}
			
			for(Entidad e: por_agregar) {
				mapa.agregarEntidadActiva(e);
				e.getEntidadGrafica().iniciar();
				gui.getPanel().add(e.getEntidadGrafica().getEtiqueta());
			}
			
			//reseteo la lista por_agregar
			por_agregar = new ArrayList<Entidad>();
			
			for(Entidad e: por_eliminar) {
				mapa.eliminarEntidadActiva(e);
				e.getEntidadGrafica().desaparecer();
			}
			
			//reseteo la lista por_agregar
			por_eliminar = new ArrayList<Entidad>();
			
			
			//actualizaciones graficas
			
			gui.getPanel().repaint();
			gui.actualizarVida();
			gui.actualizarNivel();
			
			if(disparo) {
				gui.mostrarMejora();
			}else {
				gui.ocultarMejora();
			}
			
			if (pausa) {
				gui.mostrarPausa();
				--tiempo_pausa;
				if(tiempo_pausa==0)
					pausa=false;
			}else {
				gui.ocultarPausa();
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		if(gano) {
			gui.audioGano();
			JOptionPane.showMessageDialog(null, "Ganaste. Todos los elfos han sido liberados.");
			System.exit(0);
		}else {
			gui.audioMurio();
			JOptionPane.showMessageDialog(null, "Perdiste. Los elfos de Voldemort te han derrotado.");
			System.exit(0);
		}
		
	}
	
    
}
