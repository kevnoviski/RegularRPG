package dao;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    public Boolean addRow(Object[] row) {
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
    
    public int indexOf(String column) {
    	return Arrays.asList(columnNames).indexOf(column);
    }
    
    public ArrayList<Object> Where(String filter){
    	//String[] args = filter.split(" ");
    	
    	return null;
    	/*
    	    public List<T> filter(Predicate<T> criteria, List<T> list) {
        		return list.stream().filter(criteria).collect(Collectors.<T>toList());
 			}
    		list = new Test().filter(x -> x > 2, list);
    	 */
    }

	public DataTable(String[] columnNames) {
		super();
		this.columnNames = columnNames;
		this.rowData = new ArrayList<Object>();
	}

	public void PrintTable() {
		System.out.print("|");
		for(String col : this.columnNames) {
			System.out.print(col + "|");
		}
		System.out.println("");
		for(Object obj : rowData) {
			Object[] rowContent = (Object[])obj;
			System.out.print("|");
			for(int i=0; i< this.getColumnCount();i++) {
				System.out.print(rowContent[i] + " | ");
			}
			System.out.println("");
		}
	}
    


    
    
}
