package entidad_grafica;

import javax.swing.*;

public class EntidadGraficaJugador extends EntidadGrafica{
	private String harry = "/img/Harry.png", harry_daniado = "/img/HarryGolpeado.gif";
	private String harry_muerto = "/img/HarryMuerto.gif";
	
	/**
	 * Crea una EntidadGraficaJugador nueva
	 */
	public EntidadGraficaJugador() {
		etiqueta = new JLabel();
		grafica = new ImageIcon();
		ImageIcon imagen = new ImageIcon(this.getClass().getResource(harry));
		grafica.setImage(imagen.getImage());
	}
	
	@Override
	public void daniar() {
		ImageIcon imagen;
		imagen = new ImageIcon(this.getClass().getResource(harry_daniado));
		grafica.setImage(imagen.getImage());
	}
	
	@Override
	public void moverEtiqueta(int x, int y) {
		etiqueta.setLocation(x,y);
	}
	
	@Override
	public void muerte() {
		ImageIcon imagen;
		
		etiqueta.setBounds(etiqueta.getX(), etiqueta.getY(), etiqueta.getWidth()*2, etiqueta.getHeight());
		
		imagen = new ImageIcon(this.getClass().getResource(harry_muerto));
		grafica.setImage(imagen.getImage());
	}

	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
	
	
}












