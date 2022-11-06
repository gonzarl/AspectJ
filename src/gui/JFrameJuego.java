package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;

import audio.AudioPlayer;
import img.ImagenFondo;

import juego.Juego;
import juego.TecladoJugador;

import java.awt.Color;
import java.awt.Font;

public class JFrameJuego extends JFrame {
	private Juego juego;
	private JPanel jPanelNivel;
	private JLabel jLabelVida,jLabelNivel,JLabelPausa,JLabelMejora;
	private JLabel lbl_jugador;
	private AudioPlayer ap;
	private Thread audio;
	private Thread t;
	
	/**
	 * Metodo creo el frame del juego
	 */
	public JFrameJuego() {
		
		//Creo el panel
		this.setIconImage(new ImageIcon(this.getClass().getResource("/img/iconoFrame.png")).getImage());
		ImagenFondo imagen_Fondo = new ImagenFondo(new ImageIcon(this.getClass().getResource("/img/fondoNuevo.jpg")).getImage());
		setContentPane(imagen_Fondo);
		setTitle("Las aventuras del gordo Potter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		jPanelNivel = new JPanel();
		
		//Comienza el juego
		initJuego();
		initGUI();
		initAudio();
		
	}
	
	/**
	 * Metodo inicio el juego
	 */
	private void initJuego(){
		juego = new Juego(this);
		juego.iniciar();
		t = new Thread(juego);
		t.start();
	}
	
	/**
	 * Metodo inicio la gui
	 */
	private void initGUI() {
		try {
			
			this.setLocationByPlatform(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			
			//Panel nivel
			getContentPane().add(jPanelNivel, BorderLayout.CENTER);
			jPanelNivel.setLayout(null);
			jPanelNivel.setOpaque(false);
				
			//Jugador
			lbl_jugador = new JLabel();
			lbl_jugador.setIcon(juego.getJugador().getEntidadGrafica().getGrafica());
			lbl_jugador.setBounds(200, 500, 50, 100);
			juego.getJugador().getEntidadGrafica().setEtiqueta(lbl_jugador);
			juego.getJugador().mover();
			jPanelNivel.add(lbl_jugador);
			addKeyListener(new TecladoJugador(juego.getJugador(),0,540));
				
			
			//Contador vida
			int cantVida = 100 - juego.getJugador().getDanioRecibido();
			jLabelVida = new JLabel("Vida: "+cantVida+ " %");
			jLabelVida.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelVida.setForeground(Color.WHITE);
			jLabelVida.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
			jLabelVida.setBounds(10, 10, 109, 29);
			jPanelNivel.add(jLabelVida);

			//Contador de nivel
			jLabelNivel = new JLabel("Nivel: 1");
			jLabelNivel.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelNivel.setForeground(Color.WHITE);
			jLabelNivel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
			jLabelNivel.setBounds(480, 10, 80, 30);
			jPanelNivel.add(jLabelNivel);
			
			//tiempo de hechizo mejorado
			JLabelMejora = new JLabel();
			JLabelMejora.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabelMejora.setForeground(Color.WHITE);
			JLabelMejora.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
			JLabelMejora.setBounds(380, 50, 200, 30);
			jPanelNivel.add(JLabelMejora);
			
			//tiempo de pausa
			JLabelPausa = new JLabel();
			JLabelPausa.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabelPausa.setForeground(Color.WHITE);
			JLabelPausa.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
			JLabelPausa.setBounds(10, 50, 100, 30);
			jPanelNivel.add(JLabelPausa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo cierro la ventana
	 * @param evt WindowEvent
	 */
	private void thisWindowClosing(WindowEvent evt) {
		cerrarJuego();
	}
	
	/**
	 * Metodo cerrar juego
	 */
	private void cerrarJuego() {
		this.dispose();
		System.exit(0);
	}
	
	public JPanel getPanel() {
		return jPanelNivel;
	}
	
	public void actualizarVida() {
		jLabelVida.setText("Vida:"+(100-juego.getJugador().getDanioRecibido())+"%");
	}
	public void actualizarNivel() {
		int horda_act = juego.getHordaActual();
		int niv_act;
		if (horda_act%2==0) {
			niv_act=horda_act/2;
		}else {
			niv_act =(horda_act/2)+1;
		}
		jLabelNivel.setText("Nivel:"+niv_act);
	}

	private void initAudio() {
		ap = new AudioPlayer("audio/musica_peleando.mp3");
		audio = new Thread(ap);
		audio.start();
	}
	
	public void audioOff() {
		ap=null;
		audio.stop();
		audio=null;
	}
	
	public void audioMurio() {
		audio.stop();
		ap = new AudioPlayer("audio/harry_muere.mp3");
		audio = new Thread(ap);
		audio.start();
	}
	
	public void audioGano() {
		audio.stop();
		ap = new AudioPlayer("audio/harry_gano.mp3");
		audio = new Thread(ap);
		audio.start();
	}
	
	public void mostrarMejora() {
		JLabelMejora.setVisible(true);
		int segs = juego.getJugador().getTiempoMejora()/10;
		JLabelMejora.setText("Tiempo de mejora: "+segs);
	}
	public void ocultarMejora() {
		JLabelMejora.setVisible(false);
	}
	
	public void mostrarPausa() {
		JLabelPausa.setVisible(true);
		int segs = juego.getTiempoPausa();
		JLabelPausa.setText("Pausa:"+segs);
	}
	
	public void ocultarPausa() {
		if(JLabelPausa!=null)
			JLabelPausa.setVisible(false);
	}
	
}
