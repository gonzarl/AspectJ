package movimiento;

import javax.swing.JLabel;
import entidad.premio.Premio;

public class MovimientoVerticalPremio extends MovimientoVertical{

	/**
	 * Crea un nuevo MovimientoVerticalPremio partiendo de ciertos parametros
	 * @param p Premio
	 * @param dir int
	 * @param vel int 
	 * @param lim_inf int
	 * @param lim_sup int
	 */
	public MovimientoVerticalPremio( Premio p, int dir, int vel, int lim_inf, int lim_sup) {
		direccion = dir;
		velocidad = vel;
		entidad = p;
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
