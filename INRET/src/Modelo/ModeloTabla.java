package Modelo;

import javax.swing.table.DefaultTableModel;

/**
 * Modelo para las tablas utilizadas.
 * Permite la accion de abrir al doble click.
 * @author M
 *
 */
public class ModeloTabla extends DefaultTableModel {
	public boolean isCellEditable (int row, int column){
	       return false;
	   }
}
