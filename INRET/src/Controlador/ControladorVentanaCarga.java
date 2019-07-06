package Controlador;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import Modelo.ComprobarArchivos;
import Modelo.Constantes;
import Modelo.Documentos;
import Modelo.Indexador;
import Vista.Carga;

public class ControladorVentanaCarga {
	Carga ventana ;
	Indexador indexador;
	
	public ControladorVentanaCarga(Carga ventana) {
		this.ventana = ventana;
	}
	
	public void Inicializar() {
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(100, 100, 497, 193);
		ventana.setUndecorated(true);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		try {
			CrearIndice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CrearIndice() throws IOException {
		indexador = new Indexador();
		indexador.crearIndice();
		indexador.cerrar();
	}

}
