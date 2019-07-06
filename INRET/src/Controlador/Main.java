package Controlador;

import java.io.File;

import Modelo.Almacenamiento;
import Modelo.Constantes;
import Vista.Carga;
import Vista.Principal;

public class Main {
	public static void main(String[] args){
		
		
		//1.- Comprobamos los directorios que utilizará el software
		Almacenamiento almacenamiento = new Almacenamiento();
		almacenamiento.ComprobarEstado();
		almacenamiento.CargarListaDocumentosAlmacenados(new File(Constantes.DirectorioDocumentos));
		almacenamiento.CargarListaDocumentosIndexados();
		
		//3.- Se indexan los documentos en la lista
		Carga ventanacarga = new Carga();
		ControladorVentanaCarga controladorventanacarga = new ControladorVentanaCarga(ventanacarga);
		controladorventanacarga.Inicializar();
		ventanacarga.dispose();
	
		//4.- Cierra la pantalla de carga y abre Principal
		Principal ventanaprincipal = new Principal();
		ControladorVentanaPrincipal controladorventanaprincipal = new ControladorVentanaPrincipal(ventanaprincipal);
		controladorventanaprincipal.Inicializar();
		
	
		
	}
}
