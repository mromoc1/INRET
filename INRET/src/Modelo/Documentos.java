package Modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Documentos {
	public ArrayList<String> lista = new ArrayList<String>();
	
	public DefaultTableModel modeloTabla() {
		lista.clear();
		CargarLista(new File(Constantes.DirectorioDocumentos));
		
		ModeloTabla modelo = new ModeloTabla();
		
		modelo.addColumn("Total Documentos: "+lista.size());
		String[] test = new String[1];
		
		for(int i = 0; i< lista.size();i++) {
			test[0] = lista.get(i);
			modelo.addRow(test);
		}
		return modelo;
	}
	
	public void CargarLista(File archivo) {
		for (final File ficheroEntrada : archivo.listFiles()) {
			if (ficheroEntrada.isDirectory()) {
				CargarLista(ficheroEntrada);
	        }else{
	        	String nombre = ficheroEntrada.getName();
	        	if(nombre.endsWith(".pdf") || nombre.endsWith(".PDF") ) {
	        		lista.add(nombre);
	        	}
	        }
	    }
	}
	
	public void AbrirDocumento (String Documento,File archivo) {
		for (final File ficheroEntrada : archivo.listFiles()) {
			if (ficheroEntrada.isDirectory()) {
				AbrirDocumento(Documento,ficheroEntrada);
	        }else{
	        	String nombre = ficheroEntrada.getName();
	        	if(nombre.equals(Documento)) {
	        		try {
						Desktop.getDesktop().open(ficheroEntrada);
					} catch (IOException e) {
						e.printStackTrace();
					}
	        	}
	        }
	    }
	}
	
}
