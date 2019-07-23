package Modelo;

import java.io.File;
import java.util.ArrayList;

/**
 * Variables constantes utilizadas en las demas clases
 * 1.-  Archivo que guarda aquellos libros indexados para que no se indexen nuevamente.
 * 2.-  Ruta y nombre del directorio que almacena losdocumentos.
 * 3.- Ruta y nombre del directorio que almacena los indices.
 * 4.- Variable que hace referencia al contenido del archivo utilizado en la indexacion.
 * 5.- Variable que hace referencia al nombre del archivo utilizado en la indexacion.
 * 6.- Estructura que guarda los archivos almacenados en la carpeta documentos.
 * 7.- Estructura que guarda el nombre de los documentos coincidentes a la busqueda.
 * 8.- Estructura que guarda el nombre de los documentos que ya han sido indexados.
 * @author M
 *
 */
public class Constantes {
	
	//1
	public static final String ArchivosIndexados = "archivosindexados.txt";
	//2
	public static final String DirectorioDocumentos = "Documentos";
	//3
	public static final String DirectorioIndice = "Indice";
	//4
	public static final String ContenidoArchivo = "contenidoarchivo";
	//5
	public static final String NombreArchivo = "nombrearchivo";
	//6
	public static ArrayList<File> ListaDocumentosAlmacenados = new ArrayList<>();
	//7
	public static ArrayList<String> ListaDocumentosBuscados = new ArrayList<>();
	//8
	public static ArrayList<String> ListaDocumentosIndexados = new ArrayList<>();
	
	
}
