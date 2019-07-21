 package Controlador;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import Modelo.Almacenamiento;
import Modelo.Constantes;
import Modelo.Indexador;
import Modelo.VerificarDuplicado;
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
			Almacenamiento almacenamiento = new Almacenamiento();
			almacenamiento.CargarListaDocumentosIndexados();
			almacenamiento.CargarListaDocumentosAlmacenados(new File(Constantes.DirectorioDocumentos));
			VerificarDuplicado verificar = new VerificarDuplicado();
			if(verificar.BuscarDuplicados(Constantes.ListaDocumentosAlmacenados)) {
				Constantes.ListaDocumentosAlmacenados.clear();
				almacenamiento.CargarListaDocumentosAlmacenados(new File(Constantes.DirectorioDocumentos));
			}
			indexador = new Indexador();
			indexador.crearIndice(ventana.progressBar, ventana.lblIndexando);
			indexador.Cerrar();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
