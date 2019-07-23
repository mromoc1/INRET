package Controlador;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import Vista.Informaciones;

public class ControladorVentanaInformaciones {
	Informaciones ventana;
	
	public ControladorVentanaInformaciones(Informaciones ventana) {
		this.ventana = ventana;
	}
	
	public void inicializar() {
		ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo app/hexagon_eye_center_server_networking_icon-icons.com_59973 (1).png"));
		Image imagen = icono.getImage();
		ventana.setIconImage(imagen);
		
		ventana.setTitle(".:: INFORMACIONES ::.");
		ventana.setResizable(false);
		ventana.setSize(743, 500);
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
