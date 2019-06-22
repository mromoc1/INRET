package Controlador;

import Vista.Principal;

public class Main {
	public static void main(String[] args) {
		Principal ventana = new Principal();
		ControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal(ventana);
		controlador.Inicializar();
	}
}
