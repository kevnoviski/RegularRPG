package control;


    
import dao.Crud;
import dao.DataTable;
import dao.JumpStartDB;
import model.Tier;


public class Runner {

    public static void main(String[] args)  {
        JumpStartDB jps=  new JumpStartDB();
        jps.VerifyNCreate();
        /*Crud cd = new Crud();
        DataTable dttier = cd.Select("select * from APP.PICTURE");
        dttier.PrintTable();*/
    }

}
