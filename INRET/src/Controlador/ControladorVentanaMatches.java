package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import Modelo.BuscarEnDocumento;
import Modelo.Constantes;
import Vista.Matches;

public class ControladorVentanaMatches implements ActionListener{

	Matches ventana;
	
	public ControladorVentanaMatches(Matches ventana) {
		this.ventana = ventana;
		this.ventana.setResizable(false);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.botonok.addActionListener(this);
	}
	
	public void Inicializar(ArrayList<Integer> paginas) {
		this.ventana.setVisible(true);
		this.ventana.textArea.setText("Se recomienda Buscar en las paginas: \n");
		for(int i=0; i < paginas.size() ; i++) {
			this.ventana.textArea.append("" + paginas.get(i) + "\n");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ventana.botonok) {
			this.ventana.dispose();
		}
	}

	
	
	
}
