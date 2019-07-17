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
	
	/**
	 * Metodo constructor inicializa las variables
	 * @throws IOException
	 */
	public Buscador() throws IOException {
		Directory directorioindice = FSDirectory.open(Paths.get(Constantes.DirectorioIndice));
		IndexReader lector = DirectoryReader.open(directorioindice);
		indicebuscador = new IndexSearcher(lector);
		analizarconsulta = new QueryParser(Constantes.ContenidoArchivo, new StandardAnalyzer());
	}
	

	public TopDocs buscar(String contenido) throws ParseException, IOException {
		consulta = analizarconsulta.parse(contenido);
		return indicebuscador.search(consulta,10);
	}
	
	public Document obtenerDocumento(ScoreDoc sd) throws IOException {
		return indicebuscador.doc(sd.doc);
	}
	
	/**
	 * Metodo con el que podemos buscar y que utiliza los demas metodos
	 * @param contenidoabuscar
	 * @throws ParseException
	 * @throws IOException
	 */
	public void RealizarBusqueda(String contenidoabuscar) throws ParseException, IOException {
		TopDocs hits = buscar(contenidoabuscar);
		Constantes.ListaDocumentosBuscados.clear();
		for(ScoreDoc sd : hits.scoreDocs) {
			Document doc = obtenerDocumento(sd);
			Constantes.ListaDocumentosBuscados.add(doc.get(Constantes.NombreArchivo));
		}
	}
	

}
