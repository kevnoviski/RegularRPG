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
	
    public void VerifyNCreate() {
        Crud crud = new Crud();

        DataTable res = crud.Select("select st.tablename  from sys.systables st "
                        + "LEFT OUTER join sys.sysschemas ss on "
                        + "(st.schemaid = ss.schemaid) where ss.schemaname ='APP'\r\n");

        if(res.getRowCount() == 0) {
            try {
                System.out.print("The required tables were not found, creating new ones..");
                String rootFolder=new File("").getAbsolutePath().toString();
                Path fileName = Path.of(rootFolder+"\\startupDB.sql");
                String newTables = Files.readString(fileName);
                crud.RunBatchCommand(newTables);
                System.out.print("done.");
            } catch (IOException ex) {
                Logger.getLogger(JumpStartDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	
}
