package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGraficaProyectil extends EntidadGrafica{
	protected String imagen;
	
	@Override
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
	
	@Override
	public void disparo() {
		this.etiqueta.setIcon(new ImageIcon(this.getClass().getResource(imagen)));
	}
	
	@Override
	public void desaparecer() {
		this.etiqueta.setVisible(false);
	}
	
	/**
	 * Establece la imagen
	 * @param s ruta de la imagen
	 */
	public void setImagen(String s) {
		imagen = s;
	}

	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
	
	/**
	 * Consulta imagen
	 * @return imagen
	 */
	public String getImagen() {
		return this.imagen;
	}
}
