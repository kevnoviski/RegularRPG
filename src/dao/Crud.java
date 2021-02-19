package dao;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Crud {
	private Connection Connect()  {
		Connection con= null;
		try {
			con =  DriverManager.getConnection("jdbc:derby:" + new File("").getAbsolutePath().toString()+"\\DB; create=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public ResultSet Select(String query, int Nmcolumns) {
		try {
			Connection con = Connect();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int totalColumn = metaData.getColumnCount();
			
			//con.close();
			return rs;
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
	
	public void Create(String command) {
		try {
			Connection con = Connect();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
