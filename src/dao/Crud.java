package dao;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Crud {
    private Connection Connect()  {
        Connection con= null;
        try {
                con =  DriverManager.getConnection("jdbc:derby:" + new File("").getAbsolutePath().toString()+"\\DB; create=true");
                //con =  DriverManager.getConnection("jdbc:derby://localhost:1527/sample; create=true");
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return con;
    }

    public DataTable Select(String query) {
        try {
                Connection con = Connect();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();
                int totalColumn = metaData.getColumnCount();
                String[] columns = new String[totalColumn];
                for(int j=0; j<totalColumn;j++) {
                        columns[j]=metaData.getColumnName(j+1);
                }
                DataTable ret = new DataTable(columns);
                while(rs.next()) {
                        Object[] row = new Object[totalColumn];
                        for(int j=0; j<totalColumn;j++) {
                                row[j]=rs.getString(j+1);
                        }
                        ret.addRow(row);
                }
                //https://stackoverflow.com/questions/20142624/how-to-describe-and-show-table-in-derby-db
                con.close();
                return ret;
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
        }
    }

    public int Update(String sql, List<String> parametros) {
        try {
                Connection con = Connect();
                PreparedStatement ps = con.prepareStatement(sql);
                int i=1;
                for(String par : parametros) {
                        ps.setString(i, par);
                        i++;
                }
                ps.executeUpdate();
                con.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return 0;
    }

    public int DeleteFrom(String table/*table name*/, String where/* field =? and field1 = ?*/, List<String> parametros/*string only*/) {
        try {
                Connection con = Connect();
                String sql  = "Delete from "+ table +" where "+ where;
                PreparedStatement ps = con.prepareStatement(sql);
                int i=1;
                for(String par : parametros) {
                        ps.setString(i, par);
                        i++;
                }
                ps.executeUpdate();
                con.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return 0;
    }

    public int Insert(String sql, List<String> parametros) {
        try {
                Connection con = Connect();
                PreparedStatement ps = con.prepareStatement(sql);
                int i=1;
                for(String par : parametros) {
                        ps.setString(i, par);
                        i++;
                }
                ps.execute();
                con.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return 0;
    }

    public void Command(String command) {
        try {
                Connection con = Connect();
                PreparedStatement ps = con.prepareStatement(command);
                ps.execute();
                con.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    public void RunBatchCommand(String in) {
        try {
                Connection con = Connect();
                Statement s = con.createStatement(); 
                //String prep =in.replace("\r\n", "");             
                String[] commands = in.replace("\r\n", "").split(";");
                for(String command: commands){
                    if(command.length() > 5){
                        s.addBatch(command);    
                    }
                }
                s.executeLargeBatch();
                //s.executeBatch(); 
                con.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
	
}
