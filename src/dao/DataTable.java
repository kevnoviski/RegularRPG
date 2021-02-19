package dao;

import java.util.ArrayList;

public class DataTable {
	private String[] columnNames ;
    private ArrayList<Object> rowData;

    public int getColumnCount()
    {
        return columnNames.length;
    }

    public int getRowCount()
    {
        return rowData.size();
    }

    public String getColumnName(int col)
    {
        return columnNames[col];
    }
    
    public Boolean AddRow(Object[] row) {
    	try {
    		rowData.add(row);	
    		return true;
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		return false;
		}
    }
    
    public ArrayList<Object> Where(String filter){
    	
    	return null;
    }

	public DataTable(String[] columnNames) {
		super();
		this.columnNames = columnNames;
	}
    

    
    
}
