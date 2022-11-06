package img;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLabel;

public class ImagenFondo extends JLabel{
	private Image imagen;
	
	public ImagenFondo(Image img) {
		imagen=img;
	}
	
	@Override
	public void paint(Graphics grafico) {
		grafico.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
		setOpaque(false);
		super.paint(grafico);
	}	
}
