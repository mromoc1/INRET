package Controlador;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Vista.Matches;

public class ControladorVentanaMatches implements ActionListener{

	Matches ventana;
	
	public ControladorVentanaMatches(Matches ventana) {
		this.ventana = ventana;
		this.ventana.setResizable(false);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.botonok.addActionListener(this);
	}
	
	public void Inicializar(ArrayList<Integer> paginas, String documento, String consulta) {
		ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/Logo app/hexagon_eye_center_server_networking_icon-icons.com_59973 (1).png"));
		Image imagen = icono.getImage();
		ventana.setIconImage(imagen);

		ventana.setTitle(".:: DETALLES DE LA BÚSQUEDA ::.");
		this.ventana.textArea.setText("[DOCUMENTO:] \n"
				
				+ documento + "\n"
				+ "[BÚSQUEDA:] \n"+ consulta
				+ "\nSe recomienda revisar las páginas: \n");
		for(int i=0; i < paginas.size() ; i++) {
			this.ventana.textArea.append("" + paginas.get(i) + "\n");
		}
		this.ventana.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ventana.botonok) {
			this.ventana.dispose();
		}
	}

	
	
	
}
