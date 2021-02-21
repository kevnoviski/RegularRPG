package dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
				+ "(st.schemaid = ss.schemaid) where ss.schemaname ='REGRPG'\r\n");
                res.PrintTable();
		if(res.getRowCount() == 0) {
                    try {
                        String rootFolder=new File("").getAbsolutePath().toString();
                        Path fileName = Path.of(rootFolder+"\\startupDB.sql");
                        String newTables = Files.readString(fileName);
                        crud.RunBatchCommand(newTables);
                    } catch (IOException ex) {
                        Logger.getLogger(JumpStartDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
                System.out.print("----");
		res = crud.Select("select st.tablename  from sys.systables st "
				+ "LEFT OUTER join sys.sysschemas ss on "
				+ "(st.schemaid = ss.schemaid) where ss.schemaname ='REGRPG'\r\n");
                res.PrintTable();
		/*select st.tablename  from sys.systables st LEFT OUTER join sys.sysschemas ss on (st.schemaid = ss.schemaid) where ss.schemaname ='APP'
*/
		
	}
	
}
