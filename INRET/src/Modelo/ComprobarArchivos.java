package Modelo;

import java.io.File;

import javax.swing.JOptionPane;

/**
 * Clase utilizada para comprobar si los directorios o carpetas necesarias existen,
 * en caso de no existir, las crea.
 * @author M
 *
 */
public class ComprobarArchivos {
	
	public ComprobarArchivos() {
		DirectorioIndice();
		DirectorioDocumentos();
	}

	public void DirectorioIndice() {
		File c = new File(Constantes.DirectorioIndices);
		if(!c.exists()) {
			JOptionPane.showMessageDialog(null, "CREADO");
			c.mkdirs();
		}
	}
	
	public void DirectorioDocumentos() {
		File c = new File(Constantes.DirectorioDocumentos);
		if(!c.exists()) {
			JOptionPane.showMessageDialog(null, "CREADO");
			c.mkdirs();
		}
	}
	
}
