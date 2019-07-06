package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Principal extends JFrame {
	private Font Titulof = new Font("Century Gothic", Font.PLAIN, 35);
	private Font Busquedaf = new Font("Century Gothic", Font.PLAIN, 18);
	private Font Subtitulof = new Font("Century Gothic", Font.PLAIN, 20);
	private Font Listaf = new Font("Century Gothic", Font.PLAIN, 14);
	
	public JTextField campoBuscar;
	public JLabel iconocarpeta,iconoinformacion;
	public JTable tablaAlmacenamiento,tablaEncontrados;
	
	public Principal() {
		setBounds(100, 100, 1000, 600);
		getContentPane().add(PanelNorte() , BorderLayout.NORTH);
		getContentPane().add(PanelCentral() , BorderLayout.CENTER);
		
	}
	
	public JPanel PanelNorte() {
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(0, 0));;
		
		//Panel TITULO
		
		JPanel panel_1 = new JPanel();
		JLabel titulo = new JLabel("  INRET  ");
		titulo.setFont(Titulof);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\M\\git\\INRET\\INRET\\src\\Imagenes\\Logo app\\hexagon_eye_center_server_networking_icon-icons.com_59973 (1).png"));
		panel_1.add(lblNewLabel_2);
		panel_1.add(titulo);
		
		//FIN PANEL TITULO
		//---------------------------------------------------------
		//Panel Buscador
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		
		campoBuscar = new JTextField();
		campoBuscar.setBounds(10, 28, 539, 35);
		campoBuscar.setBorder(new LineBorder(new Color(105, 105, 105)));
		campoBuscar.setFont(Busquedaf);
		campoBuscar.setColumns(30);
		
		panel_2.add(campoBuscar);
		
		//FIN PANEL BUSCADOR
		//---------------------------------------------------------
		//Panel Iconos
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		iconoinformacion = new JLabel("");
		panel_3.add(iconoinformacion);
		iconoinformacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/info (7).png")));
		iconocarpeta = new JLabel("");
		panel_3.add(iconocarpeta);
		iconocarpeta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/folder (2).png")));
		//FIN PANEL ICONOS
		panel.add(panel_1, BorderLayout.WEST);
		panel.add(panel_2, BorderLayout.CENTER);
		panel.add(panel_3, BorderLayout.EAST);
		return panel;
	}
	
	public JPanel PanelCentral() {
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(new JPanel(), BorderLayout.SOUTH);
		panel.add(new JPanel(), BorderLayout.WEST);
		panel.add(new JPanel(), BorderLayout.EAST);
		panel.add(new JPanel(), BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(new JPanel(),BorderLayout.EAST);
		JLabel label = new JLabel("Documentos Almacenados");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(Subtitulof);
		panel_2.add(label,BorderLayout.NORTH);
		panel_2.add(panelDocumentosAlmacenados(),BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(new JPanel(),BorderLayout.WEST);
		panel_3.add(panelDocumentosEncontrados(),BorderLayout.CENTER);
		
		JLabel label2 = new JLabel("Documentos Encontrados");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(Subtitulof);
		panel_3.add(label2,BorderLayout.NORTH);
		
		
		panel_1.add(panel_2);
		panel_1.add(panel_3);
		
		panel.add(panel_1, BorderLayout.CENTER);
		return panel;
	}
	
	public JPanel panelDocumentosAlmacenados() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();
		tablaAlmacenamiento = new JTable();
		tablaAlmacenamiento.setFont(Listaf);
		scrollPane.setViewportView(tablaAlmacenamiento);
		panel.add(scrollPane);
		
		return panel;
	}
	
	public JPanel panelDocumentosEncontrados() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();
		tablaEncontrados = new JTable();
		tablaEncontrados.setFont(Listaf);
		scrollPane.setViewportView(tablaEncontrados);
		panel.add(scrollPane);
		
		return panel;
	}
}
