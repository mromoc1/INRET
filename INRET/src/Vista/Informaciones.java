package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Color;

public class Informaciones extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Informaciones dialog = new Informaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Informaciones() {
		getContentPane().setBackground(new Color(255, 255, 255));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(249, 249, 249));
		tabbedPane.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Guía de Búsqueda", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setBackground(new Color(255, 255, 255));
		tabbedPane_1.setFont(new Font("Century Gothic", Font.ITALIC, 17));
		tabbedPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_2.add(tabbedPane_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane_1.addTab("Término/Frase", null, scrollPane_2, null);
		
		JTextArea txtrTrminoLuceneAsume = new JTextArea();
		txtrTrminoLuceneAsume.setLineWrap(true);
		txtrTrminoLuceneAsume.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrTrminoLuceneAsume.setEditable(false);
		txtrTrminoLuceneAsume.setText("T\u00E9rmino:  Lucene asume que el t\u00E9rmino introducido est\u00E1 escrito correctamente,\r\npor lo que, si el usuario introduce un error ortogr\u00E1fico, no obtendr\u00E1 un resulta- \r\ndo esperado.\r\nEjemplo: Lenguaje.\r\n\r\nFrase: En este caso, no solo son importantes los t\u00E9rminos individuales introduci-\r\ndos, sino tambi\u00E9n el orden en que aparecen.\r\nEjemplo: Lenguaje de programaci\u00F3n.");
		scrollPane_2.setViewportView(txtrTrminoLuceneAsume);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane_1.addTab(" ? , * ", null, scrollPane_3, null);
		
		JTextArea txtrComodinesLaBusqueda = new JTextArea();
		txtrComodinesLaBusqueda.setText("La b\u00FAsqueda permite utilizar comodines (?, *) que representan un \r\ncar\u00E1cter, permitiendo realizar una b\u00FAsqueda de un t\u00E9rmino que puede venir \r\nde diversas maneras, se debe tener en cuenta que el comod\u00EDn puede ir en \r\ncualquier posici\u00F3n menos al principio.\r\n\r\n[ ? ] : representa un car\u00E1cter.\r\nEjemplo: L?ngua?e (permitiendo buscar lenguaje y language por ejemplo)\r\n \r\n[ * ] : sustituye un n\u00FAmero infinito de caracteres, permite buscar otras formas de \r\nun t\u00E9rmino.\r\nEjemplo: Lenguaje* (permitiendo buscar otras formas, en este caso Lenguajes)\r\n");
		txtrComodinesLaBusqueda.setLineWrap(true);
		txtrComodinesLaBusqueda.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrComodinesLaBusqueda.setEditable(false);
		scrollPane_3.setViewportView(txtrComodinesLaBusqueda);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		tabbedPane_1.addTab("/[  ]/", null, scrollPane_4, null);
		
		JTextArea txtrConLasExpresiones = new JTextArea();
		txtrConLasExpresiones.setText("Con las expresiones regulares (/[ ]/) puedes buscar al mismo tiempo varios t\u00E9r-minos que comparten una serie de similitudes. A diferencia de los comodines, \r\ncon estos marcadores se definen exactamente las divergencias que hay tener \r\nen cuenta.\r\nEjemplo: /[mp]adre/.\r\n");
		txtrConLasExpresiones.setLineWrap(true);
		txtrConLasExpresiones.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrConLasExpresiones.setEditable(false);
		scrollPane_4.setViewportView(txtrConLasExpresiones);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		tabbedPane_1.addTab(" ~n ", null, scrollPane_5, null);
		
		JTextArea txtrEsteTipoDe = new JTextArea();
		txtrEsteTipoDe.setText("Este tipo de consulta se utiliza cuando se quiere tener tolerancia a errores. Se \r\nutiliza la distancia de Damerau-Levenshtein, f\u00F3rmula que eval\u00FAa las similitudes, para establecer c\u00F3mo de grande puede ser la desviaci\u00F3n.\r\n\r\n[ ~ ] : admite distancia de 0 a 2.\r\nEjemplo: Coche~1.\r\n\r\nTambi\u00E9n se utiliza cuando quieras permitir una aproximaci\u00F3n en las frases \r\n[ ~ ] : puedes especificar que deseas buscar dos t\u00E9rminos incluso si hay otras 5 palabras entre ellos. Ejemplo: \"Auto rojo\"~5.");
		txtrEsteTipoDe.setLineWrap(true);
		txtrEsteTipoDe.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrEsteTipoDe.setEditable(false);
		scrollPane_5.setViewportView(txtrEsteTipoDe);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		tabbedPane_1.addTab(" [ TO ] , { TO }", null, scrollPane_6, null);
		
		JTextArea txtrEnEsteTipo = new JTextArea();
		txtrEnEsteTipo.setText("En este tipo de consulta se busca entre dos t\u00E9rminos en un \u00E1rea concreta. Si \r\nbien esta b\u00FAsqueda no tiene mucho sentido para contenido general, puede \r\nser muy \u00FAtil para consultar ciertos campos, como los autores o los t\u00EDtulos. La cla-\r\nsificaci\u00F3n funciona de acuerdo con un orden lexicogr\u00E1fico. \r\n\r\n[ TO ] : para indicar un \u00E1rea de inclusi\u00F3n\r\n{ TO } : para indicar un \u00E1rea de exclusi\u00F3n \r\nEjemplo: [Allende TO Borges] o {Byron TO Shelley}\r\n");
		txtrEnEsteTipo.setLineWrap(true);
		txtrEnEsteTipo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrEnEsteTipo.setEditable(false);
		scrollPane_6.setViewportView(txtrEnEsteTipo);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		tabbedPane_1.addTab(" ^n ", null, scrollPane_7, null);
		
		JTextArea txtrLuceneBrindaLa = new JTextArea();
		txtrLuceneBrindaLa.setText("Permite dar m\u00E1s relevancia en la b\u00FAsqueda a determinados t\u00E9rminos o frases, \r\nlo que influye en la clasificaci\u00F3n de los resultados.\r\n\r\n[ ^n ]  : proporciona m\u00E1s relevancia de valor n.\r\nEjemplo: Coche^2 rojo.\r\n");
		txtrLuceneBrindaLa.setLineWrap(true);
		txtrLuceneBrindaLa.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrLuceneBrindaLa.setEditable(false);
		scrollPane_7.setViewportView(txtrLuceneBrindaLa);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		tabbedPane_1.addTab(" && , || , + , - ", null, scrollPane_8, null);
		
		JTextArea txtrLosOperadoresLgicos = new JTextArea();
		txtrLosOperadoresLgicos.setText("Los operadores l\u00F3gicos sirven para establecer conexiones entre t\u00E9rminos en \r\nuna consulta, han de estar siempre escritos en may\u00FAsculas para que Lucene no los considere t\u00E9rminos de b\u00FAsqueda normales.\r\n\r\n[ AND \u00F3 && ] : Ambos t\u00E9rminos deben estar presentes en el documento para \r\nque este se muestre como resultado.\r\nEjemplo: Coche && rojo.\r\n\r\n[ OR \u00F3 || ] : Indica que para que se muestre un documento como resultado al menos uno de los t\u00E9rminos indicados ha de aparecer en \u00E9l.\r\nEjemplo: Coche || rojo.\r\n\r\n[ + ] : Se utiliza para establecer un caso espec\u00EDfico de conector OR. Si colo-\r\ncas el s\u00EDmbolo directamente delante de una palabra, se establece que dicho t\u00E9rmino debe aparecer, mientras que el otro es opcional. \r\nEjemplo: +Auto rojo\r\n\r\n[ NOT \u00F3 - ] : Excluye ciertos t\u00E9rminos o frases de la b\u00FAsqueda. Tambi\u00E9n puedes \r\nrecurrir a un signo de exclamaci\u00F3n o emplazar un signo menos justo antes del\r\nt\u00E9rmino que desea excluir. No debes utilizar el operador NOT con un solo t\u00E9r-\r\nmino o frase. \r\nEjemplo: Auto rojo \u2013 azul");
		txtrLosOperadoresLgicos.setLineWrap(true);
		txtrLosOperadoresLgicos.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrLosOperadoresLgicos.setEditable(false);
		scrollPane_8.setViewportView(txtrLosOperadoresLgicos);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		tabbedPane_1.addTab(" ( ) ", null, scrollPane_9, null);
		
		JTextArea txtrSeUtilizaPara = new JTextArea();
		txtrSeUtilizaPara.setText("Se utiliza para agrupar t\u00E9rminos dentro de una consulta. Es de gran utilidad \r\npara crear entradas m\u00E1s complejas.\r\nEjemplo: Auto AND (rojo OR azul).");
		txtrSeUtilizaPara.setLineWrap(true);
		txtrSeUtilizaPara.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrSeUtilizaPara.setEditable(false);
		scrollPane_9.setViewportView(txtrSeUtilizaPara);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		tabbedPane_1.addTab(" \\ ", null, scrollPane_10, null);
		
		JTextArea txtrSirveParaUtilizar = new JTextArea();
		txtrSirveParaUtilizar.setText("Sirve para utilizar como t\u00E9rminos de b\u00FAsqueda aquellos caracteres que se \r\nemplean en la sintaxis de Lucene, comb\u00EDnalos mediante barra invertida. As\u00ED, \r\npuedes insertar, por ejemplo, un signo de interrogaci\u00F3n en una consulta de \r\nb\u00FAsqueda sin que el analizador lo interprete como un comod\u00EDn.\r\nEjemplo: \u00BFD\u00F3nde est\u00E1 mi coche\\?");
		txtrSirveParaUtilizar.setLineWrap(true);
		txtrSirveParaUtilizar.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		txtrSirveParaUtilizar.setEditable(false);
		scrollPane_10.setViewportView(txtrSirveParaUtilizar);
		
		JLabel lblSintaxisDe = new JLabel("Sintaxis para realizar B\u00FAsqueda");
		lblSintaxisDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSintaxisDe.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panel_2.add(lblSintaxisDe, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Acerca de", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(249, 249, 249));
		textArea_1.setEditable(false);
		textArea_1.setText("Software: INRET \n"
				+ "Versión: 3c \n"
				+ "Creado por: Marcelo Romo \n"
				+ "Asignatura: Laboratorio de Diseño y Analisis de Algoritmos \n"
				+ "Ingenieria en Computación \n"
				+ "Universidad de La Serena");
		textArea_1.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		scrollPane_1.setViewportView(textArea_1);
		
		
		
		
	}

}
