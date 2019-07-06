package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Carga extends JFrame {
	private Font Titulof = new Font("Century Gothic", Font.PLAIN, 35);
	private Font Subtitulof = new Font("Century Gothic", Font.PLAIN, 20);
	
	public JProgressBar progressBar;

	
	public Carga() {
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(439, 0, 58, 192);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 58, 192);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(58, 166, 381, 26);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(58, 29, 381, 98);
		getContentPane().add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		panel_3.add(label, BorderLayout.WEST);
		label.setIcon(new ImageIcon("C:\\Users\\M\\git\\INRET\\INRET\\src\\Imagenes\\Logo app\\hexagon_eye_center_server_networking_icon-icons.com_59973.png"));
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		panel_3.add(lblBienvenido, BorderLayout.CENTER);
		lblBienvenido.setFont(Titulof);
		
		JLabel lblPorfavorEspereMientras = new JLabel("Porfavor espere mientras se configura");
		lblPorfavorEspereMientras.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblPorfavorEspereMientras, BorderLayout.SOUTH);
		lblPorfavorEspereMientras.setFont(Subtitulof);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(58, 138, 381, 26);
		getContentPane().add(progressBar);
		
		
		
	}
}
