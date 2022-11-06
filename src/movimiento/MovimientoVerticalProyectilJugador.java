package movimiento;

import javax.swing.JLabel;
import entidad.proyectil.*;

public class MovimientoVerticalProyectilJugador extends MovimientoVertical{
	
	/**
	 * Crea un nuevo MovimientoVerticalProyectilJugador partiendo de ciertos parametros
	 * @param p Proyectil
	 * @param dir int
	 * @param vel int 
	 * @param lim_inf int
	 * @param lim_sup int
	 */
	public MovimientoVerticalProyectilJugador( Proyectil p, int dir, int vel,int lim) {
		entidad = p;
		direccion = dir;
		velocidad = vel;
		lim_superior = lim;
	}
	
	
	@Override
	public void mover() {
		JLabel lbl = entidad.getEntidadGrafica().getEtiqueta();
		int pos_y = lbl.getY() + direccion * velocidad;
		
		//si se pasa del rango desaparece
		if (pos_y <= this.lim_superior) {
			entidad.desactivar();
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
		
		entidad.setPosY(pos_y);
	}

}
