package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGraficaProyectilMejorado extends EntidadGraficaProyectil {
	
	/**
	 * Crea una EntidadGraficaProyectilMejorado nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaProyectilMejorado(JLabel etiqueta) {
		this.etiqueta = etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/HechizoMejorado.png";
		this.etiqueta.setIcon(grafica);
	}
	
}