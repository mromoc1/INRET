package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class BuscarEnDocumento {
	
    public ArrayList<Integer> ObtenerDatos(String cadena,String rutadocumento) throws IOException {
    	ArrayList<Integer> paginas = new ArrayList<Integer>();
    	PDDocument documento = PDDocument.load(new File("Documentos/"+rutadocumento));

    	StringTokenizer st =new StringTokenizer(cadena);
    	while (st.hasMoreElements()) {
    		String token = st.nextElement().toString();
    		for(int i=1; i < documento.getNumberOfPages(); i++) {
        		PDFTextStripper s = new PDFTextStripper();
        		s.setStartPage(i);
                s.setEndPage(i);
                String contenido = s.getText(documento);
                if(contenido.contains(token) || contenido.contains(Character.toUpperCase(token.charAt(0)) + token.substring(1, token.length()).toLowerCase())) {
        	    	paginas.add(i);
        	    }
        	}
    		paginas.add(0);
    	}
    	documento.close();
        return paginas;
    }
    
}
