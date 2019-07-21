package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import javax.swing.JOptionPane;

public class VerificarDuplicado {
	
	public byte[] createChecksum(String documento) {
		byte[] buffer = new byte[1024];
		int numRead;
		MessageDigest complete=null;
		try {
			InputStream is = new FileInputStream(documento);
			complete = MessageDigest.getInstance("MD5");
			
			do {
				numRead = is.read(buffer);
				if (numRead > 0) {
					complete.update(buffer, 0, numRead);
				}
			} while (numRead != -1);
			is.close();		
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();}
		return complete.digest();	
	}
	
	
	/**
	 * Metodo que retorna el MD5 correspondiente a un documento. Cada archivo posee
	 * una MD5 diferente, por lo que si 2 archivos son identicos en su contenido
	 * poseeran un mismo MD5.
	 * 
	 * @param documento
	 * @return
	 */
	public String getMD5(String documento) {
		byte b[] = createChecksum(documento);
		String md5="";
		for (int i = 0; i < b.length; i++) {
			md5 += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return md5;
	}

	/**
	 * Metodo principal que nos permite identificar si hay documentos duplicados.
	 * 
	 * @param ListaDocumentos
	 * @return
	 */
	public Boolean BuscarDuplicados(ArrayList<File> ListaDocumentos) {
		// nos indica si requiere o no comprobar nuevamente los archivos almacenados, ya
		// que es probable que este metodo elimine algunos.
		Boolean requierecambio = false;
		// Estructura que nos permite identificar aquellosdocumentos con un MD5 similar
		HashMap<String, String> hashmap = new HashMap<String, String>();

		for (int i = 0; i < ListaDocumentos.size(); i++) {
			try {
				// Obtiene el MD5de cada documento
				String md5 = getMD5(ListaDocumentos.get(i).getPath());
				// Comprueba que el documento no haya sido agregado
				if (hashmap.containsKey(md5) && !FueIndexado( ListaDocumentos.get(i).getName())) {
					// Si ya ha sido agregado nos consulta si queremos eliminarlo porque es un
					// duplicado.
					int r = JOptionPane.showConfirmDialog(null,"  Tiene un archivo duplicado \n  " + ListaDocumentos.get(i).getName()+ "  \n  ¿Desea Eliminarlo?  ","Problema Encontrado", JOptionPane.WARNING_MESSAGE);
					if (r == JOptionPane.YES_OPTION) {
						File duplicado = new File(ListaDocumentos.get(i).getPath());
						duplicado.delete();
						requierecambio = true;
					}
				} else {
					hashmap.put(md5, ListaDocumentos.get(i).getPath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return requierecambio;
	}
	
	public Boolean FueIndexado(String nombredocumento) {
		for(int i=0; i < Constantes.ListaDocumentosIndexados.size(); i++) {
			if(Constantes.ListaDocumentosIndexados.get(i).equals(nombredocumento)) {
				return true;
			}
		}
		return false;
	}
}
