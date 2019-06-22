package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.Documentos;
import Vista.Principal;

public class ControladorVentanaPrincipal implements ActionListener,KeyListener,MouseListener {
	Principal ventana;
	Documentos doc = new Documentos();
	
	public ControladorVentanaPrincipal(Principal ventana) {
		this.ventana = ventana;

		this.ventana.iconocarpeta.addMouseListener(this);
	}
	
	public void Inicializar(){
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
			JFileChooser jf = new JFileChooser();
			jf.setDialogTitle("Seleccione Archivo");
			jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jf.showOpenDialog(null);
			doc.Cargar(jf.getSelectedFile());
			
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
