package Controlador;

import java.io.IOException;

import Modelo.ComprobarArchivos;
import Vista.Carga;
import Vista.Principal;

public class Main {
	public static void main(String[] args){
		ComprobarArchivos directorios = new ComprobarArchivos();
		Carga ventanacarga = new Carga();
		ControladorVentanaCarga controladorventanacarga = new ControladorVentanaCarga(ventanacarga);
		controladorventanacarga.Inicializar();
		
		/*ComprobarArchivos directorios = new ComprobarArchivos();
		Principal ventana = new Principal();
		ControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal(ventana);
		controlador.Inicializar();*/
		
	}
}
