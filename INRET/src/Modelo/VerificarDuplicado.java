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
	 * Metodo Principal de la clase.
	 * 1.- Para cada documento se obtienene el MD5
	 * 2.- Consulta si la estructura hashmap contiene la key del archivo que esta ingresando.
	 * Tambien consulta si fue indxado (si fue indexado no pregunta para eliminarlo).
	 * 3.- Si es un duplicado y se requiere eliminar, se elimina y se da a conocer que se debe reescanear la carpeta de documentos.
	 * 4.- Si no es un duplicado se guarda en la estructura hashmap y continua con el proximo documento.
	 * @param ListaDocumentos
	 * @return
	 */
	public Boolean BuscarDuplicados(ArrayList<File> ListaDocumentos) {
		Boolean requierecambio = false;
		HashMap<String, String> hashmap = new HashMap<String, String>();
		for (int i = 0; i < ListaDocumentos.size(); i++) {
			try {
				//1
				String md5 = getMD5(ListaDocumentos.get(i).getPath());
				//2
				if (hashmap.containsKey(md5) && !Constantes.ListaDocumentosIndexados.contains(ListaDocumentos.get(i).getName())/*!FueIndexado( ListaDocumentos.get(i).getName())*/) {
					//3
					int r = JOptionPane.showConfirmDialog(null,"  Tiene un archivo duplicado \n  " + ListaDocumentos.get(i).getName()+ "  \n  ¿Desea Eliminarlo?  ","Problema Encontrado", JOptionPane.WARNING_MESSAGE);
					if (r == JOptionPane.YES_OPTION) {
						File duplicado = new File(ListaDocumentos.get(i).getPath());
						duplicado.delete();
						requierecambio = true;
					}
				} else {
					//4
					hashmap.put(md5, ListaDocumentos.get(i).getPath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return requierecambio;
	}
}
