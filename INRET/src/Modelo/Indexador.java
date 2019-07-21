package Modelo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * Clase que permite realizar la indexacion de los documentos.
 * @author M
 *
 */
public class Indexador {
	private IndexWriter indice;
	
	/**
	 * Inicializa
	 * @throws IOException
	 */
	public Indexador() throws IOException {
		Directory directorio = FSDirectory.open(Paths.get(Constantes.DirectorioIndice)); //Directorio donde se guardara lo indexado
		StandardAnalyzer analizador = new StandardAnalyzer(); //"descompone" se podria decir el documento
		//Analyzer analizador; //Para testear
		IndexWriterConfig iwc = new IndexWriterConfig(analizador);
		indice = new IndexWriter(directorio, iwc);
	}
	
	public void Cerrar() throws IOException {
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
		Document documento;
		documento = obtenerDocumento(archivo);
		indice.addDocument(documento);
	}
	
	/**
	 * A medida que indexa la barra se irá rellenando
	 * @param barra
	 * @throws IOException
	 */
	public void crearIndice(JProgressBar barra, JLabel indexando) throws IOException{
		double porcentaje;	
		for(int i = 0; i < Constantes.ListaDocumentosAlmacenados.size() ; i++) {
			if(!FueIndexado(Constantes.ListaDocumentosAlmacenados.get(i).getName())) { //Comprueba si el documento ya fue indexado.	
				
				indexando.setText("Indexando: "+Constantes.ListaDocumentosAlmacenados.get(i).getName());
				indexarArchivo(Constantes.ListaDocumentosAlmacenados.get(i));
				
				File f = new File(Constantes.ArchivosIndexados);
				FileWriter fw = new FileWriter(f,true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(Constantes.ListaDocumentosAlmacenados.get(i).getName());
				pw.close();
		
				porcentaje= ((double)(i+1)/((double)Constantes.ListaDocumentosAlmacenados.size()-(double)Constantes.ListaDocumentosIndexados.size())*100);
				barra.setValue((int)porcentaje);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {e.printStackTrace();}
				
			}
		}
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
