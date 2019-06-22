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

import Modelo.Constantes;
import Modelo.Documentos;
import Vista.Principal;

public class ControladorVentanaPrincipal implements ActionListener,KeyListener,MouseListener {
	Principal ventana;
	Documentos doc = new Documentos();
	
	public ControladorVentanaPrincipal(Principal ventana) {
		this.ventana = ventana;

		this.ventana.iconocarpeta.addMouseListener(this);
		this.ventana.tablaDocumentosDisponibles.addMouseListener(this);
	}
	
	public void Inicializar(){
		ventana.tablaDocumentosDisponibles.setModel(doc.modeloTabla());

		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setBounds(100, 100, 1000, 650);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

	public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == ventana.iconocarpeta) {
			try {
				Desktop.getDesktop().open(new File(Constantes.DirectorioDocumentos));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == ventana.tablaDocumentosDisponibles) {
			if(e.getClickCount() == 1) {}
			if(e.getClickCount() == 2) {
				doc.AbrirDocumento(doc.lista.get(ventana.tablaDocumentosDisponibles.getSelectedRow()), new File(Constantes.DirectorioDocumentos));
				
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}
	
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
