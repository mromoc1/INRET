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
	 * 1.- Inicializa la ventana de carga.
	 * 2.- Carga las estructuras Lista de Documentos Indexados y Documentos Almacenados.
	 * 3.- Verifica la duplicidad de los archivos Almacenados.
	 * 4.- Si hay duplicidad y se eliminar algun archivo, nuevamente se carga la Lista de Almacenados.
	 * 5.- Llama a la clase indexador para comenzar a indexar los documentos no indexados.
	 */
	public void Inicializar() {
		/**
		 * 1
		 */
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(497, 193);
		ventana.setUndecorated(true);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		/**
		 * FIN 1
		 */
		
		try {
			/**
			 * 2
			 */
			Almacenamiento almacenamiento = new Almacenamiento();
			almacenamiento.CargarListaDocumentosIndexados();
			almacenamiento.CargarListaDocumentosAlmacenados(new File(Constantes.DirectorioDocumentos));
			/**
			 *FIN 2
			 *
			 * 3
			 */
			VerificarDuplicado verificar = new VerificarDuplicado();
			if(verificar.BuscarDuplicados(Constantes.ListaDocumentosAlmacenados)) {
			/**
			 * FIN 3
			 *
			 * 4
			 */
				Constantes.ListaDocumentosAlmacenados.clear();
				almacenamiento.CargarListaDocumentosAlmacenados(new File(Constantes.DirectorioDocumentos));
			}
			/**
			 * FIN 4
			 **
			 * 5 
			 */
			indexador = new Indexador();
			indexador.crearIndice(ventana.progressBar, ventana.lblIndexando);
			indexador.Cerrar();
			/**
			 * FIN 5
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
