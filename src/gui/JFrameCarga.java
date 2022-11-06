package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import audio.AudioPlayer;
import img.ImagenFondo;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JFrameCarga extends JFrame {

	private AudioPlayer ap;
	private Thread audio;
	
	//Metodo principal
	public static void main(String[] args) {
		JFrameCarga frame_carga = new JFrameCarga();
		frame_carga.setVisible(true);
	}
	
	/**
	 * Metodo creo frame carga
	 */
	public JFrameCarga() {
		
		//Creo el panel
		this.setIconImage(new ImageIcon(this.getClass().getResource("/img/iconoFrame.png")).getImage());
		ImagenFondo imagen_Fondo = new ImagenFondo(new ImageIcon(this.getClass().getResource("/img/fondoFrame.jpg")).getImage());
		setContentPane(imagen_Fondo);
		setTitle("Las aventuras del gordo Potter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//Creo el audio
		initAudio();
		
		//Creo el panel contenedor del boton para inciar el juego
		JPanel panel_carga = new JPanel();
		getContentPane().add(panel_carga, BorderLayout.SOUTH);
		panel_carga.setLayout(new BorderLayout(0, 0));
		
		//Creo el boton para jugar
		JButton boton_inicio = new JButton("Jugar");
		boton_inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameJuego frameJuego = new JFrameJuego();
				frameJuego.setVisible(true);
				audioOff();
				dispose();
			}
		});
		boton_inicio.setHorizontalAlignment(SwingConstants.CENTER);
		boton_inicio.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		panel_carga.add(boton_inicio);
		
	}
	
	/**
	 * Metodo iniciar audio
	 */
	private void initAudio() {
		ap = new AudioPlayer("audio/musica_espera.mp3");
		audio = new Thread(ap);
		audio.start();
	}

	private void audioOff() {
		ap = null;
		audio.stop();
		audio = null;
	}

}
