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
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Cursor;

public class Principal extends JFrame {
	private Font Titulof = new Font("Century Gothic", Font.PLAIN, 35);
	private Font Busquedaf = new Font("Century Gothic", Font.PLAIN, 18);
	private Font Subtitulof = new Font("Century Gothic", Font.PLAIN, 20);
	private Font Listaf = new Font("Century Gothic", Font.PLAIN, 14);
	
	public JTextField campoBuscar;
	public JLabel iconocarpeta,iconoinformacion;
	public JTable tablaAlmacenamiento,tablaEncontrados;
	
	public JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton10, boton11, boton12, boton13;
	
	public Principal() {
		getContentPane().add(PanelNorte() , BorderLayout.NORTH);
		getContentPane().add(PanelCentral() , BorderLayout.CENTER);
		
	}
	
	public JPanel PanelNorte() {
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(0, 0));;
		
		//Panel TITULO
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 249, 249));
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("INRET   ");
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(Titulof);
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Logo app/hexagon_eye_center_server_networking_icon-icons.com_59973 (1).png")));
		panel_1.add(lblNewLabel_2);
		
		//FIN PANEL TITULO
		//---------------------------------------------------------
		//Panel Buscador
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(249, 249, 249));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		campoBuscar = new JTextField();
		campoBuscar.setBorder(new LineBorder(new Color(130, 135, 144)));
		campoBuscar.setFont(Busquedaf);
		campoBuscar.setColumns(30);
		
		panel_2.add(campoBuscar, BorderLayout.SOUTH);
		//FIN PANEL ICONOS
		panel.add(panel_1, BorderLayout.WEST);
		panel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblRealizarBsqueda = new JLabel("Realizar B\u00FAsqueda:");
		lblRealizarBsqueda.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRealizarBsqueda.setFont(Busquedaf);
		panel_2.add(lblRealizarBsqueda, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(249, 249, 249));
		panel_2.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(249, 249, 249));
		panel.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		//FIN PANEL BUSCADOR
		//---------------------------------------------------------
		//Panel Iconos
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(249, 249, 249));
		panel_4.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		iconocarpeta = new JLabel("");
		iconocarpeta.setVerticalAlignment(SwingConstants.BOTTOM);
		iconocarpeta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(iconocarpeta);
		iconocarpeta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Logo carpeta/icons8-carpeta-48.png")));
		iconoinformacion = new JLabel("");
		iconoinformacion.setHorizontalAlignment(SwingConstants.CENTER);
		iconoinformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(iconoinformacion);
		iconoinformacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/info (7).png")));
		return panel;
	}
	
	public JPanel PanelCentral() {
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(249, 249, 249));
		panel.add(panel_5, BorderLayout.SOUTH);
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(249, 249, 249));
		panel.add(panel_4, BorderLayout.WEST);
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(249, 249, 249));
		panel.add(panel_6, BorderLayout.EAST);
		panel.add(panelBotones(), BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(new BorderLayout(0, 0));
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(249, 249, 249));
		panel_2.add(panel_8,BorderLayout.EAST);
		panel_2.add(panelDocumentosAlmacenados(),BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(new BorderLayout(0, 0));
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(249, 249, 249));
		panel_3.add(panel_7,BorderLayout.WEST);
		panel_3.add(panelDocumentosEncontrados(),BorderLayout.CENTER);
		
		panel_1.add(panel_2);
		panel_1.add(panel_3);
		
		panel.add(panel_1, BorderLayout.CENTER);
		return panel;
	}
	
	public JPanel panelDocumentosAlmacenados() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(249, 249, 249));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaAlmacenamiento = new JTable();
		tablaAlmacenamiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaAlmacenamiento.setShowVerticalLines(false);
		tablaAlmacenamiento.setSelectionBackground(new Color(153, 204, 255));
		tablaAlmacenamiento.setRowHeight(25);
		tablaAlmacenamiento.setIntercellSpacing(new Dimension(0, 0));
		tablaAlmacenamiento.setFocusable(false);
		tablaAlmacenamiento.setFont(Listaf);
		
		tablaAlmacenamiento.getTableHeader().setFont(Subtitulof);
		tablaAlmacenamiento.getTableHeader().setOpaque(false);
		tablaAlmacenamiento.getTableHeader().setBackground(new Color(32, 136, 203));
		tablaAlmacenamiento.getTableHeader().setForeground(new Color(255,255,255));
		
		scrollPane.setViewportView(tablaAlmacenamiento);
		panel.add(scrollPane);
		
		return panel;
	}
	
	public JPanel panelDocumentosEncontrados() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(30, 144, 255));
		tablaEncontrados = new JTable();
		tablaEncontrados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaEncontrados.setShowVerticalLines(false);
		tablaEncontrados.setSelectionBackground(new Color(153, 204, 255));
		tablaEncontrados.setRowHeight(25);
		tablaEncontrados.setIntercellSpacing(new Dimension(0, 0));
		tablaEncontrados.setFocusable(false);
		tablaEncontrados.setFont(Listaf);
		
		tablaEncontrados.getTableHeader().setFont(Subtitulof);
		tablaEncontrados.getTableHeader().setOpaque(false);
		tablaEncontrados.getTableHeader().setBackground(new Color(32, 136, 203));
		tablaEncontrados.getTableHeader().setForeground(new Color(255,255,255));
		
		scrollPane.setViewportView(tablaEncontrados);
		panel.add(scrollPane);
		
		return panel;
	}
	
	public JPanel panelBotones() {
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(new Color(249, 249, 249));
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(249, 249, 249));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		boton1 = new JButton(" ? ");
		panel_1.add(boton1);
		boton1.setBorderPainted(false);
		boton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton1.setBackground(new Color(192, 192, 192));
		boton1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton2 = new JButton(" * ");
		panel_1.add(boton2);
		boton2.setBorderPainted(false);
		boton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton2.setBackground(new Color(192, 192, 192));
		boton2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton3 = new JButton(" /[ ]/ ");
		panel_1.add(boton3);
		boton3.setBorderPainted(false);
		boton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton3.setBackground(new Color(192, 192, 192));
		boton3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton4 = new JButton(" ~n ");
		panel_1.add(boton4);
		boton4.setBorderPainted(false);
		boton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton4.setBackground(new Color(192, 192, 192));
		boton4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton5 = new JButton(" [ TO ] ");
		panel_1.add(boton5);
		boton5.setBorderPainted(false);
		boton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton5.setBackground(new Color(192, 192, 192));
		boton5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton13 = new JButton(" { TO } ");
		boton13.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		boton13.setBorderPainted(false);
		boton13.setBackground(Color.LIGHT_GRAY);
		panel_1.add(boton13);
		
		boton6 = new JButton(" ^n ");
		panel_1.add(boton6);
		boton6.setBorderPainted(false);
		boton6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton6.setBackground(new Color(192, 192, 192));
		boton6.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton7 = new JButton(" AND/&& ");
		panel_1.add(boton7);
		boton7.setBorderPainted(false);
		boton7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton7.setBackground(new Color(192, 192, 192));
		boton7.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton8 = new JButton(" OR/|| ");
		panel_1.add(boton8);
		boton8.setBorderPainted(false);
		boton8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton8.setBackground(new Color(192, 192, 192));
		boton8.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton9 = new JButton(" + ");
		panel_1.add(boton9);
		boton9.setBorderPainted(false);
		boton9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton9.setBackground(new Color(192, 192, 192));
		boton9.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton10 = new JButton(" - ");
		panel_1.add(boton10);
		boton10.setBorderPainted(false);
		boton10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton10.setBackground(new Color(192, 192, 192));
		boton10.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton11 = new JButton(" ( ) ");
		panel_1.add(boton11);
		boton11.setBorderPainted(false);
		boton11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton11.setBackground(new Color(192, 192, 192));
		boton11.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		boton12 = new JButton(" \\ ");
		panel_1.add(boton12);
		boton12.setBorderPainted(false);
		boton12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton12.setBackground(new Color(192, 192, 192));
		boton12.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(249, 249, 249));
		panel.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(249, 249, 249));
		panel.add(panel_3, BorderLayout.SOUTH);
		
		return panel;
	}
	
	
}
