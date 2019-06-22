package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Principal extends JFrame {
	private Font Titulof = new Font("Century Gothic", Font.PLAIN, 35);
	private Font Busquedaf = new Font("Century Gothic", Font.PLAIN, 18);
	private Font Subtitulof = new Font("Century Gothic", Font.PLAIN, 20);
	private Font Listaf = new Font("Century Gothic", Font.PLAIN, 14);
	
	public JTextField campoBuscar;
	public JLabel iconocarpeta,iconoinformacion,iconobuscar;
	public JTable tablaDocumentosDisponibles;
	
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
		iconocarpeta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/folder (2).png")));
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
		campoBuscar.setFont(Busquedaf);
		campoBuscar.setColumns(30);
		
		iconobuscar = new JLabel("");
		iconobuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/search (4).png")));
		
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
		iconoinformacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/info (7).png")));
		panel_5.add(iconoinformacion);
		
		panel_3.add(panel_5);
		/*----- FIN PANEL 1 -----*/

		
		panel.add(panel1, BorderLayout.CENTER);
		return panel;
	}
	
	public JPanel PanelCentral() {
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Documentos Disponibles");
		lblNewLabel.setFont(Subtitulof);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Documentos Buscados");
		lblNewLabel_1.setFont(Subtitulof);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane);
		
		tablaDocumentosDisponibles = new JTable();
		tablaDocumentosDisponibles.setFont(Listaf);
		scrollPane.setViewportView(tablaDocumentosDisponibles);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		return panel;
	}
	
	

}
