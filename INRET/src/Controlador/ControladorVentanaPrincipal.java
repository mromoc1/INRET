package Controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.lucene.queryparser.classic.ParseException;

import Modelo.Almacenamiento;
import Modelo.Buscador;
import Modelo.Constantes;
import Modelo.ModeloTabla;
import Vista.Principal;

public class ControladorVentanaPrincipal implements ActionListener,KeyListener,MouseListener {
	Principal ventana;
	Almacenamiento almacenamiento = new Almacenamiento();
	
	public ControladorVentanaPrincipal(Principal ventana) {
		this.ventana = ventana;

		this.ventana.iconocarpeta.addMouseListener(this);
		this.ventana.tablaAlmacenamiento.addMouseListener(this);
		this.ventana.tablaEncontrados.addMouseListener(this);
		this.ventana.campoBuscar.addKeyListener(this);
		
		this.ventana.boton1.addActionListener(this);
		this.ventana.boton2.addActionListener(this);
		this.ventana.boton3.addActionListener(this);
		this.ventana.boton4.addActionListener(this);
		this.ventana.boton5.addActionListener(this);
		this.ventana.boton6.addActionListener(this);
		this.ventana.boton7.addActionListener(this);
		this.ventana.boton8.addActionListener(this);
		this.ventana.boton9.addActionListener(this);
		this.ventana.boton10.addActionListener(this);
		this.ventana.boton11.addActionListener(this);
		this.ventana.boton12.addActionListener(this);
		
		
	}
	
	public void Inicializar(){
		
		ModeloTabla modelo = new ModeloTabla();
		modelo.addColumn("Documentos Almacenados: "+Constantes.ListaDocumentosAlmacenados.size());
		String[] test = new String[1];
		
		for(int i = 0; i< Constantes.ListaDocumentosAlmacenados.size();i++) {
			test[0] = Constantes.ListaDocumentosAlmacenados.get(i).getName();
			modelo.addRow(test);
		}
		
		ventana.tablaAlmacenamiento.setModel(modelo);
		

		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setSize(1000, 650);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == ventana.iconocarpeta) {
			try {
				Desktop.getDesktop().open(new File(Constantes.DirectorioDocumentos));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == ventana.tablaAlmacenamiento) {
			if(e.getClickCount() == 1) {}
			if(e.getClickCount() == 2) {
				almacenamiento.AbrirDocumento(Constantes.ListaDocumentosAlmacenados.get(ventana.tablaAlmacenamiento.getSelectedRow()).getName(), new File(Constantes.DirectorioDocumentos));
				
			}
		}
		if(e.getSource() == ventana.tablaEncontrados) {
			if(e.getClickCount() == 1) {}
			if(e.getClickCount() == 2) {
				almacenamiento.AbrirDocumento(Constantes.ListaDocumentosBuscados.get(ventana.tablaEncontrados.getSelectedRow()), new File(Constantes.DirectorioDocumentos));
				
			}
		}
		
	}
	public void keyPressed(KeyEvent e) {
		 if(e.getKeyCode()==KeyEvent.VK_ENTER){
			 Buscador buscador;
			try {
				buscador = new Buscador();
				try {
					buscador.RealizarBusqueda(this.ventana.campoBuscar.getText());
					
					ModeloTabla modelo = new ModeloTabla();
					modelo.addColumn("Documentos Recomendados: "+Constantes.ListaDocumentosBuscados.size());
					String[] test = new String[1];
					
					for(int i = 0; i< Constantes.ListaDocumentosBuscados.size();i++) {
						test[0] = Constantes.ListaDocumentosBuscados.get(i);
						modelo.addRow(test);
					}
					this.ventana.tablaEncontrados.setModel(modelo);
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			 
         }
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventana.boton1) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"?");
		}if(e.getSource() == ventana.boton2) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"*");
		}if(e.getSource() == ventana.boton3) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"[ ]");
		}if(e.getSource() == ventana.boton4) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"~");
		}if(e.getSource() == ventana.boton5) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"[ to ]");
		}if(e.getSource() == ventana.boton6) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"^2");
		}if(e.getSource() == ventana.boton7) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"&&");
		}if(e.getSource() == ventana.boton8) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"||");
		}if(e.getSource() == ventana.boton9) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"+");
		}if(e.getSource() == ventana.boton10) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"-");
		}if(e.getSource() == ventana.boton11) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"( )");
		}if(e.getSource() == ventana.boton12) {
			String contenido = ventana.campoBuscar.getText();
			ventana.campoBuscar.setText(contenido+"\\");
		}
	}
	
	
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
