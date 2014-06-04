package gui;

import javax.swing.table.DefaultTableModel;

public class FundDataTableModel extends DefaultTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7253708129477072682L;

	public FundDataTableModel(Object cellData[][], Object[] headerData){
		super(cellData, headerData);
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	
}
