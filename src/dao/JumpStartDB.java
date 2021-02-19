package dao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JumpStartDB {
	
	public void Create() {
		Crud crud = new Crud();
		ResultSet res = crud.Select("select st.*  from sys.systables st "
				/*+ "LEFT OUTER join sys.sysschemas ss on (st.schemaid = ss.schemaid) where ss.schemaname ='APP'\r\n"*/,0);
		try {
			while(res.next()) {
				int teste=1;
				System.out.println(res.getString("tablename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
