package Modelo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexador {
	private IndexWriter indice;
	
	public Indexador() throws IOException {
		Directory DirectorioIndice = FSDirectory.open(Paths.get(Constantes.DirectorioIndices));
		StandardAnalyzer analizador = new StandardAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analizador);
		indice = new IndexWriter(DirectorioIndice, iwc);
	}
	
	public void cerrar() throws IOException {
		indice.close();
	}

	/**
	 * Metodo que descompone el documento en indices y los retorna.
	 * @param archivo
	 * @return
	 * @throws IOException
	 */
	private Document obtenerDocumento(File archivo) throws IOException {
		Document documento = new Document();
		TextField contenidoArchivo =new TextField(Constantes.ContenidoArchivo, new FileReader(archivo));
		TextField nombreArchivo = new TextField(Constantes.NombreArchivo, archivo.getName(), TextField.Store.YES);
		TextField rutaArchivo = new TextField(Constantes.RutaArchivo, archivo.getCanonicalPath(), TextField.Store.YES);
		
		documento.add(contenidoArchivo);
		documento.add(nombreArchivo);
		documento.add(rutaArchivo);
		return documento;
	}
	
	/**
	 * Metodo que realiza la indexacion de los archivos contenidos
	 * en el directorio de almacenamiento.
	 * @param archivo
	 * @throws IOException
	 */
	public void indexarArchivo(File archivo) throws IOException{
		System.out.println(""+archivo.getName());
		Document documento;
		documento = obtenerDocumento(archivo);
		indice.addDocument(documento);
	}
	
	public void crearIndice() throws IOException{
		File[] archivos = new File(Constantes.DirectorioDocumentos).listFiles();
		for(File archivo : archivos) {
			if(!archivo.isDirectory() && !archivo.isHidden() && archivo.exists() && archivo.canRead()) {
				indexarArchivo(archivo);
			}
		}
	}
	
}
