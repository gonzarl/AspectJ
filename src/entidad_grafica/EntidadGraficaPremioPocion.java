package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGraficaPremioPocion extends EntidadGraficaPremio {
	
	/**
	 * Crea una EntidadGraficaPremioPocion nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaPremioPocion(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/PremioPocion.png";
		this.etiqueta.setIcon(grafica);
	}
	
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
}
