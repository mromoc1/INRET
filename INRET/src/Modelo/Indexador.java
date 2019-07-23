package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Indexador {
	private IndexWriter indice;
	
	public Indexador() throws IOException {
		Directory directorio = FSDirectory.open(Paths.get(Constantes.DirectorioIndice));
		StandardAnalyzer analizador = new StandardAnalyzer(); 
		IndexWriterConfig iwc = new IndexWriterConfig(analizador);
		indice = new IndexWriter(directorio, iwc);
	}
	
	public void Cerrar() throws IOException {
		indice.close();
	}
	
	public void indexarArchivo(File archivo) throws IOException{
		Document documento = new Document();
		documento.add(new TextField(Constantes.NombreArchivo, archivo.getName(), Field.Store.YES));
		documento.add(new TextField(Constantes.ContenidoArchivo,ObtenerContenido(archivo),Field.Store.YES));
		indice.addDocument(documento);
	}
	
	public String ObtenerContenido(File documento) {
		String contenido = "";
		PDDocument doc = null;
		try {
		    doc = PDDocument.load(documento);
		    PDFTextStripper s = new PDFTextStripper();

		    s.setLineSeparator("\n");
		    s.setStartPage(1);
		    s.setEndPage(doc.getNumberOfPages());
		    contenido = s.getText(doc);
		    
		    doc.close();
		} catch(Exception e){e.printStackTrace();}
		return contenido;
	}
	
	/**
	 * Metodo principal de la clase lleva a cabo la indexacion de cada documento almacenado.
	 * 1.- Recorre la lista de documentos almacenados preguntanto si han sido indexados.
	 * 2.- Si fueron indexados se continua con el siguiente.
	 * 3.- Si no se ha indexado, se indexa llamando al metodo "indexarArchivo"
	 * 4.- se abre el archivo de documentos indexados y se guarda el nombre.
	 * 5.- a medida que se indexen se ira cargando la barra de la ventana de carga.
	 * @param barra
	 * @param indexando
	 * @throws IOException
	 */
	public void crearIndice(JProgressBar barra, JLabel indexando) throws IOException{
		double porcentaje;
		for(int i = 0; i < Constantes.ListaDocumentosAlmacenados.size() ; i++) {
			//1
			//2
			if(!Constantes.ListaDocumentosIndexados.contains( Constantes.ListaDocumentosAlmacenados.get(i).getName())) { //Comprueba si el documento ya fue indexado.	
				//3
				indexando.setText("Indexando: "+Constantes.ListaDocumentosAlmacenados.get(i).getName());
				indexarArchivo(Constantes.ListaDocumentosAlmacenados.get(i));
				//4
				File f = new File(Constantes.ArchivosIndexados);
				FileWriter fw = new FileWriter(f,true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(Constantes.ListaDocumentosAlmacenados.get(i).getName());
				pw.close();
				//5
				porcentaje= ((double)(i+1)/((double)Constantes.ListaDocumentosAlmacenados.size()-(double)Constantes.ListaDocumentosIndexados.size())*100);
				barra.setValue((int)porcentaje);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {e.printStackTrace();}
				
			}
		}
	}
	
	
	
	
}
