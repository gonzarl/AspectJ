package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import entidad.jugador.Jugador;

public class TecladoJugador implements KeyListener{
	private Jugador j;
	private int limite_izq, limite_der;
	
	/**
	 * Crea un nuevo TecladoJugador partiendo de ciertos parametros
	 * @param juego Juego
	 * @param j Jugador
	 * @param lim_izq int
	 * @param lim_der int
	 */
	public TecladoJugador(Jugador j, int lim_izq, int lim_der) {
		this.j = j;
		limite_izq = lim_izq;
		limite_der = lim_der;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int pos_x = j.getPosX();
		int factor_movimiento = 8;
		
		switch(e.getKeyCode()){
			
			//movimiento a izquierda
			case KeyEvent.VK_Q: {
				pos_x = pos_x - factor_movimiento;
				
				if(pos_x<limite_izq)
					pos_x=limite_izq;
				
				j.setPosX(pos_x);
				j.mover();
				break;
			}
			//movimiento a derecha
			case KeyEvent.VK_W: {
				pos_x = pos_x + factor_movimiento;
				
				if(pos_x>limite_der)
					pos_x=limite_der;
				
				j.setPosX(pos_x);
				j.mover();
				break;
			}
			
			case KeyEvent.VK_SPACE: {
				j.atacar();
				break;
			}
			
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	
}
