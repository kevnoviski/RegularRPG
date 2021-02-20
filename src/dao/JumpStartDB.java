package dao;

import java.util.ArrayList;
import java.util.List;

public class JumpStartDB {
	
	public void Create() {
		Crud crud = new Crud();
		//crud.Create("create table central.teste (id int)");
		
		/*
		List<String> parms = new ArrayList<String>();
		parms.add("1");
		
		crud.Insert("insert into central.teste values(?)",parms );
		
		crud.DeleteFrom("central.teste", "id=?", parms);
		*/
		DataTable res = crud.Select("select st.tablename  from sys.systables st "
				+ "LEFT OUTER join sys.sysschemas ss on "
				+ "(st.schemaid = ss.schemaid) where ss.schemaname ='CENTRAL'\r\n");
		if(res.getRowCount() == 0) {
			/*crud.Command("create schema central");
			crud.Command("create table central.");*/
		}
		
		/*select st.tablename  from sys.systables st LEFT OUTER join sys.sysschemas ss on (st.schemaid = ss.schemaid) where ss.schemaname ='APP'
*/
		
	}
	
}
