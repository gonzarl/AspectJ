package movimiento;

import javax.swing.JLabel;

import entidad.proyectil.ProyectilEnemigo;

public class MovimientoVerticalProyectilEnemigo extends MovimientoVertical{

	/**
	 * Crea un nuevo MovimientoVerticalProyectilEnemigo partiendo de ciertos parametros
	 * @param p ProyectilEnemigo
	 * @param dir int
	 * @param vel int 
	 * @param lim_inf int
	 * @param lim_sup int
	 */
	public MovimientoVerticalProyectilEnemigo( ProyectilEnemigo p, int dir, int vel, int lim_inf, int lim_sup) {
		entidad = p;
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
		
		//si se pasa del rango desaparece
		if (pos_y >= this.lim_inferior) {
			entidad.desactivar();
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
		
		entidad.setPosY(pos_y);
	}
	
}
