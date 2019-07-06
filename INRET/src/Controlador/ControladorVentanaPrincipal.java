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

import Modelo.Almacenamiento;
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
		this.ventana.tablaAlmacenamiento.addMouseListener(this);
	}
	
	public void Inicializar(){
		
		ModeloTabla modelo = new ModeloTabla();
		modelo.addColumn("Total Documentos: "+Constantes.ListaDocumentosAlmacenados.size());
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
				almacenamiento.AbrirDocumento(Constantes.ListaDocumentosAlmacenados.get(ventana.tablaEncontrados.getSelectedRow()).getName(), new File(Constantes.DirectorioDocumentos));
				
			}
		}
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void actionPerformed(ActionEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
