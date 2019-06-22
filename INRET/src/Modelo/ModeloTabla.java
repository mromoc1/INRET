package Modelo;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {
	public boolean isCellEditable (int row, int column){
	       return false;
	   }
}
