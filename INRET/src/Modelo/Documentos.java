package Modelo;

import java.io.File;
import java.util.ArrayList;

public class Documentos {
	public String url;
	public ArrayList<File> listadocumentos;
	
	public ArrayList<File> Cargar(File archivo) {
		listadocumentos = new ArrayList<File>();
		url = archivo.getAbsolutePath();
		
		
		for (final File ficheroEntrada : archivo.listFiles()) {
	        if (ficheroEntrada.isDirectory()) {
	            Cargar(ficheroEntrada);
	        } else {
	        	String nombre = ficheroEntrada.getName();
	        	if(nombre.endsWith(".pdf") || nombre.endsWith(".PDF") ) {
	        		listadocumentos.add(ficheroEntrada);
	        	}
	        }
	    }
		return listadocumentos;
	}
	
}
