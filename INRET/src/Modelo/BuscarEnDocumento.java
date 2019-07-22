package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class BuscarEnDocumento {
	
    public ArrayList<Integer> ObtenerDatos(String cadena,String rutadocumento) throws IOException {
    	ArrayList<Integer> paginas = new ArrayList<Integer>();
    	PDDocument documento = PDDocument.load(new File("Documentos/"+rutadocumento));

    	for(int i=1; i < documento.getNumberOfPages(); i++) {
    		PDFTextStripper s = new PDFTextStripper();
    		s.setStartPage(i);
            s.setEndPage(i);
            String contenido = s.getText(documento);
            if(contenido.contains(cadena) || contenido.contains(Character.toUpperCase(cadena.charAt(0)) + cadena.substring(1, cadena.length()).toLowerCase())) {
    	    	paginas.add(i);
    	    }
    	}
    	documento.close();
        return paginas;
    }
    
}
