package Controlador;


import javax.swing.JDialog;
import javax.swing.JFrame;

import Vista.Informaciones;

public class ControladorVentanaInformaciones {
	Informaciones ventana;
	
	public ControladorVentanaInformaciones(Informaciones ventana) {
		this.ventana = ventana;
	}
	
	public void inicializar() {
		ventana.setResizable(false);
		ventana.setSize(743, 500);
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
