package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica {
	protected JLabel etiqueta;
	protected ImageIcon grafica;
	
	/**
	 * Establece la grafica inicial
	 */
	public void iniciar() {}
	
	/**
	 *  Establece la grafica de libertad
	 */
	public void liberar() {}
	
	/**
	 *  Establece la grafica de disparo
	 */
	public void disparo() {}
	
	/**
	 *  Establece la grafica de daño
	 */
	public void daniar() {}
	
	/**
	 * Desaparece la grafica
	 */
	public void desaparecer() {
		this.etiqueta.setVisible(false);
	}
	
	/**
	 * Mueve la etiqueta segun las coordenadas x e y
	 * @param x int
	 * @param y int
	 */
	public void moverEtiqueta(int x, int y) {}
	
	/**
	 * Establece la grafica de muerto
	 */
	public void muerte() {}
	
	//Getters y setters
	
	/**
	 * Establece la etiqueta 
	 * @param etiqueta JLabel 
	 */
	public void setEtiqueta(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	/**
	 * Establece la grafica
	 * @param grafica ImageIcon
	 */
	public void setGrafica(ImageIcon grafica) {
		this.grafica = grafica;
	}
	
	/**
	 * Consulta la etiqueta 
	 * @return etiqueta
	 */
	public abstract JLabel getEtiqueta();
	
	/**
	 * Consulta la grafica
	 * @return grafica
	 */
	public ImageIcon getGrafica() {
		return grafica;
	}
}