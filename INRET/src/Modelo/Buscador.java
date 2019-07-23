package Modelo;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Buscador {
	IndexSearcher indicebuscador;
	QueryParser analizarconsulta;
	Query consulta;
	
	public Buscador() throws IOException {
		Directory directorioindice = FSDirectory.open(Paths.get(Constantes.DirectorioIndice));
		IndexReader lector = DirectoryReader.open(directorioindice);
		indicebuscador = new IndexSearcher(lector);
		analizarconsulta = new QueryParser(Constantes.ContenidoArchivo, new StandardAnalyzer());
		
	}
	

	public TopDocs buscar(String contenido) throws ParseException, IOException {
		consulta = analizarconsulta.parse(contenido);
		return indicebuscador.search(consulta,30);
	}
	
	public Document obtenerDocumento(ScoreDoc sd) throws IOException {
		return indicebuscador.doc(sd.doc);
	}
	/**
	 * Metodo principal de la clase, realiza la busqueda en los indices.
	 * 
	 * 1.- realiza la busqueda rapidamente con el metodo buscar que retorna los documentos en los que hay hit.
	 * 2.- Se vacia la estructura de documentos buscados.
	 * 3.- Por cada hit encontrado, se consuta si el documento no ha sido borra.
	 * 4.- Si no ha sido borrado se ingresa a la lista de documentos recomendados.
	 * 
	 * @param contenidoabuscar
	 * @throws ParseException
	 * @throws IOException
	 */
	public void RealizarBusqueda(String contenidoabuscar) throws ParseException, IOException {
		//1
		TopDocs hits = buscar(contenidoabuscar);
		//2
		Constantes.ListaDocumentosBuscados.clear();
		//3
		for(ScoreDoc sd : hits.scoreDocs) {
			Document doc = obtenerDocumento(sd);
			if(EstaAlmacenado(doc.get(Constantes.NombreArchivo))) {
				//4
				Constantes.ListaDocumentosBuscados.add(doc.get(Constantes.NombreArchivo));
			}
		}
	}
	
	public Boolean EstaAlmacenado(String nombredocumento) {
		for(int i=0; i < Constantes.ListaDocumentosAlmacenados.size(); i++) {
			if(Constantes.ListaDocumentosAlmacenados.get(i).getName().equals(nombredocumento)) {
				return true;
			}
		}
		return false;
	}
}
