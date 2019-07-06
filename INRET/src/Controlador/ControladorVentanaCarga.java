package Controlador;

import java.io.IOException;

import javax.swing.JFrame;

import Modelo.Indexador;
import Vista.Carga;

public class ControladorVentanaCarga {
	Carga ventana ;
	Indexador indexador;
	
	public ControladorVentanaCarga(Carga ventana) {
		this.ventana = ventana;
		ventana.progressBar.setValue(0);
	}
	
	/**
	 * Metodo que inicializa la ventana de carga e indexacion
	 */
	public void Inicializar() {
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(497, 193);
		ventana.setUndecorated(true);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		try {
			indexador = new Indexador();
			indexador.crearIndice(ventana.progressBar);
			indexador.cerrar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
