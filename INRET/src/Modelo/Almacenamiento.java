package Modelo;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Almacenamiento {

	/**
	 * Comprueba si los directorios y archivo estan creados
	 * Directorio Indice
	 * Directorio Documentos
	 * Archivo texto listado de archivos indexados
	 */
	
	public void ComprobarEstado() {
		File f = new File(Constantes.DirectorioIndices);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		File f2 = new File(Constantes.DirectorioDocumentos);
		if(!f2.exists()) {
			f2.mkdirs();
		}
		
        File f3 = new File(Constantes.ArchivosIndexados);
        if(!f3.exists()) {
        	try {
				f3.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	/**
	 * Llena la lista de documentos almacenados
	 * @param archivo
	 */
	public void CargarListaDocumentosAlmacenados(File archivo) {
		for (final File ficheroEntrada : archivo.listFiles()) {
			if (ficheroEntrada.isDirectory()) {
				CargarListaDocumentosAlmacenados(ficheroEntrada);
	        }else{
	        	String nombre = ficheroEntrada.getName();
	        	if(nombre.endsWith(".pdf") || nombre.endsWith(".PDF") ) {
	        		Constantes.ListaDocumentosAlmacenados.add(ficheroEntrada);
	        	}
	        }
	    }
	}
	
	/**
	 * Llena la lista de documentos indexados
	 */
	public void CargarListaDocumentosIndexados() {
		FileReader fr;
		BufferedReader br;
		
		try {
	         File f = new File (Constantes.ArchivosIndexados);
	         fr = new FileReader (f);
	         br = new BufferedReader(fr);
	         String linea;
	         while((linea = br.readLine())!=null) {
	            Constantes.ListaDocumentosIndexados.add(linea);
	         }
	         fr.close();
	         br.close();
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	}
	
	/**
	 * Permite abrir el documento desde la tabla.
	 * @param Documento
	 * @param archivo
	 */
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



















































