package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JTable;

public class Principal extends JFrame {
	private Font Titulof = new Font("Century Gothic", Font.PLAIN, 35);
	private Font Busquedaf = new Font("Century Gothic", Font.PLAIN, 18);
	
	public JTextField campoBuscar;
	public JLabel iconocarpeta,iconoinformacion,iconobuscar;
	
	public Principal() {
		setBounds(100, 100, 1000, 600);
		getContentPane().add(PanelNorte() , BorderLayout.NORTH);
		getContentPane().add(PanelCentral() , BorderLayout.CENTER);
		
	}
	
	public JPanel PanelNorte() {
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		/*----- PANEL 1 -----*/
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout(0, 0));
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 0));
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 0));
		
		/*sub paneles de 3*/
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 0));
		
		iconocarpeta = new JLabel("");
		iconocarpeta.setIcon(new ImageIcon("C:\\Users\\M\\eclipse-workspace\\INFRET\\Imagenes\\folder (2).png"));
		panel_4.add(iconocarpeta);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		panel_3.add(panel_4);
		/*FIN sub paneles de 3*/
		
		/*PANEL 1*/
		JLabel titulo = new JLabel("  INRET  ");
		titulo.setFont(Titulof);;
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(titulo);
		/*FIN PANEL 1*/
		
		/*PANEL 2*/
		campoBuscar = new JTextField();
		campoBuscar.setBorder(new LineBorder(new Color(105, 105, 105)));
		campoBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		campoBuscar.setFont(Busquedaf);
		campoBuscar.setColumns(30);
		
		iconobuscar = new JLabel("");
		iconobuscar.setIcon(new ImageIcon("C:\\Users\\M\\eclipse-workspace\\INFRET\\Imagenes\\search (4).png"));
		
		panel_2.add(campoBuscar);
		panel_2.add(iconobuscar);
		/*FIN PANEL2*/
		
		/*PANEL 1*/
		panel1.add(panel_1, BorderLayout.WEST);
		panel1.add(panel_2, BorderLayout.CENTER);
		panel1.add(panel_3, BorderLayout.EAST);
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 128, 0));
		
		iconoinformacion = new JLabel("");
		iconoinformacion.setIcon(new ImageIcon("C:\\Users\\M\\eclipse-workspace\\INFRET\\Imagenes\\info (7).png"));
		panel_5.add(iconoinformacion);
		
		panel_3.add(panel_5);
		/*----- FIN PANEL 1 -----*/

		
		panel.add(panel1, BorderLayout.CENTER);
		return panel;
	}
	
	public JPanel PanelCentral() {
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		return panel;
	}

}
