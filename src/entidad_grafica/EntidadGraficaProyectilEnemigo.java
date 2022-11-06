package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGraficaProyectilEnemigo extends EntidadGraficaProyectil {
	
	/**
	 * Crea una EntidadGraficaProyectilEnemigo nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaProyectilEnemigo(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/AtaqueMalo.png";
		etiqueta.setIcon(grafica);
	}
	
	@Override
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
	
}
