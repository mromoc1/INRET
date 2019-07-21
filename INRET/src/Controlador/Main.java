package Controlador;


import Modelo.Almacenamiento;
import Vista.Carga;
import Vista.Principal;

public class Main {
	/**
	 * 1.- Comprueba el estado de los directorios que el software requiere.
	 * (Indices, Documentos y el archivo que guarda los documentos indexados).
	 * 2.- Se cargan los documentos indexados y almacenados a una estructura.
	 * 3.- Realiza una busqueda de documentos duplicados, la cual preguntara
	 * al usuario si desea eliminar el documento o indexarlo igualmente.
	 * En caso de indexarlo no se volvera a consultar nuevamente si desea
	 * eliminarlo.
	 * 4.- En caso de que haya eliminado algun documento, se reescanea la
	 * el directorio de documentos y se carga nuevamente la estrcutra de 
	 * documentos almacenados.
	 * 5.- Se procede a Indexar aquellos documentos no indexados.
	 * 6.- Abre la ventana principal preparada para realizar busquedas.
	 * @param args
	 */
	public static void main(String[] args){
		Almacenamiento almacenamiento = new Almacenamiento();
		almacenamiento.ComprobarEstado();
		
		Carga ventanacarga = new Carga();
		ControladorVentanaCarga controladorventanacarga = new ControladorVentanaCarga(ventanacarga);
		controladorventanacarga.Inicializar();
		ventanacarga.dispose();
	
		Principal ventanaprincipal = new Principal();
		ControladorVentanaPrincipal controladorventanaprincipal = new ControladorVentanaPrincipal(ventanaprincipal);
		controladorventanaprincipal.Inicializar();
	}
}
