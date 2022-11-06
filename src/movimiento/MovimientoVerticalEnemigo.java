package movimiento;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;

public class MovimientoVerticalEnemigo extends MovimientoVertical {
	
	/**
	 * Crea un nuevo MovimientoVerticalEnemigo partiendo de ciertos parametros
	 * @param e Enemigo
	 * @param dir int
	 * @param vel int 
	 * @param lim_inf int
	 * @param lim_sup int
	 */
	public MovimientoVerticalEnemigo( Enemigo e, int dir, int vel, int lim_inf, int lim_sup) {
		entidad = e;
		direccion = dir;
		velocidad = vel;
		lim_inferior = lim_inf;
		lim_superior = lim_sup;
	}
	
	@Override
	public void mover() {
		JLabel lbl;
		int pos_y;
		
		lbl = entidad.getEntidadGrafica().getEtiqueta();
		pos_y = lbl.getY() + direccion * velocidad;
		
		//si llega al final del mapa, aparece arriba
		if (pos_y >= this.lim_inferior) {
			lbl.setLocation(lbl.getX(), this.lim_superior);
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
		
		entidad.setPosY(pos_y);
	}
	
	public void moverArriba() {
		JLabel lbl;
		int pos_y;
		
		lbl = entidad.getEntidadGrafica().getEtiqueta();
		pos_y = lbl.getY() + direccion * velocidad;
		
		lbl.setLocation(lbl.getX(), this.lim_superior);
		
		entidad.setPosY(pos_y);
	}
	
}
