package Controlador;

import Modelo.ComprobarArchivos;
import Vista.Principal;

public class Main {
	public static void main(String[] args) {
		ComprobarArchivos directorios = new ComprobarArchivos();
		Principal ventana = new Principal();
		ControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal(ventana);
		controlador.Inicializar();
	}
}
