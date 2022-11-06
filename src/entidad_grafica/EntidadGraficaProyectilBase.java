package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGraficaProyectilBase extends EntidadGraficaProyectil {
	
	/**
	 * Crea una EntidadGraficaProyectilBase nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaProyectilBase(JLabel etiqueta) {
		this.etiqueta = etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/HechizoBase.png";
		this.etiqueta.setIcon(grafica);
	}
	
}
