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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Armor;
import model.Backpack;
import model.ClasseCombate;
import model.ClasseMount;
import model.Mount;
import model.Picture;
import model.Tier;
import model.Weapon;

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
                System.out.println("done.");
                System.out.println("Inserting default content..");
                InsertEntities();
                System.out.println("done..");
            } catch (IOException ex) {
                Logger.getLogger(JumpStartDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private void InsertEntities(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("RegularRPGPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
        Tier t1 = new Tier(1,0);
        Tier t2 = new Tier(2,500);
        Tier t3 = new Tier(3,1000);
        Tier t4 = new Tier(4,3000);
        
        ClasseCombate cc_Assassin = new ClasseCombate("Assassin", 20, 50, 35);
        ClasseCombate cc_Mage = new ClasseCombate("Mage", 50, 60, 20);
        ClasseCombate cc_Soldier = new ClasseCombate("Soldier", 30, 35, 50);
        ClasseCombate cc_Hunter = new ClasseCombate("Hunter", 60, 55, 15);
        
        ClasseMount cm_regular = new ClasseMount("Regular");
        
        Picture sword_pc = new Picture( "sword", "\\Resources\\sword.png");
        Picture staff_pc = new Picture("staff","\\Resources\\staff.png");
        Picture crossbow_pc = new Picture("crossbow","\\Resources\\crossbow.png");
        Picture dagger_pc = new Picture("dagger","\\Resources\\dagger.png");
        Picture mount_t1_pc = new Picture("mount_t1","\\Resources\\mount_t1.png");
        Picture mount_t2_pc = new Picture("mount_t2","\\Resources\\mount_t2.png");
        Picture mount_t3_pc = new Picture("mount_t3","\\Resources\\mount_t3.png");
        Picture mount_t4_pc = new Picture("mount_t4","\\Resources\\mount_t4.png");
        Picture AssassinArmor_pc = new Picture("AssassinArmor","\\Resources\\AssassinArmor.png");
        Picture HunterArmor_pc = new Picture("HunterArmor","\\Resources\\HunterArmor.png");
        Picture MageArmor_pc = new Picture("MageArmor","\\Resources\\MageArmor.png");
        Picture SoldierArmor_pc = new Picture("SoldierArmor","\\Resources\\SoldierArmor.png");
        Picture Backpack_pc = new Picture("SoldierArmor","\\Backpack\\Backpack.png");
        Picture death_pc = new Picture("death","\\Backpack\\death.png");
        
        em.persist(t1);
        em.persist(t2);
        em.persist(t3);
        em.persist(t4);
        em.persist(cc_Assassin);
        em.persist(cc_Mage);
        em.persist(cc_Soldier);
        em.persist(cc_Hunter);
        em.persist(cm_regular);
        em.persist(sword_pc);
        em.persist(staff_pc);
        em.persist(crossbow_pc);
        em.persist(dagger_pc);
        em.persist(AssassinArmor_pc);
        em.persist(HunterArmor_pc);
        em.persist(MageArmor_pc);
        em.persist(SoldierArmor_pc);
        em.persist(Backpack_pc);
        em.persist(death_pc);
        em.persist(mount_t1_pc);
        em.persist(mount_t2_pc);
        em.persist(mount_t3_pc);
        em.persist(mount_t4_pc);
        
        
        
        em.getTransaction().commit();
        
        em.getTransaction().begin();        
        //(Double defesa, Double ataque, Double price, ClasseCombate idClassecombate, Picture idpicture, Tier idtier)
        Armor Armort1_ccSol = new Armor(60.0,10.0, 100.0, cc_Soldier, SoldierArmor_pc, t1,5.0);
        Armor Armort2_ccSol = new Armor(70.0,20.0, 200.0, cc_Soldier, SoldierArmor_pc, t2,5.1);
        Armor Armort3_ccSol = new Armor(80.0,30.0, 500.0, cc_Soldier, SoldierArmor_pc, t3,5.2);
        Armor Armort4_ccSol = new Armor(90.0,40.0, 1000.0, cc_Soldier, SoldierArmor_pc, t4,5.3);
        
        Armor Armort1_ccMag = new Armor(30.0,60.0, 100.0, cc_Mage, MageArmor_pc, t1,3.0);
        Armor Armort2_ccMag = new Armor(40.0,70.0, 200.0, cc_Mage, MageArmor_pc, t2,3.1);
        Armor Armort3_ccMag = new Armor(50.0,80.0, 500.0, cc_Mage, MageArmor_pc, t3,3.2);
        Armor Armort4_ccMag = new Armor(60.0,90.0, 1000.0, cc_Mage, MageArmor_pc, t4,3.3);
        
        Armor Armort1_ccHun = new Armor(30.0,60.0, 100.0, cc_Hunter, HunterArmor_pc, t1,2.5);
        Armor Armort2_ccHun = new Armor(40.0,70.0, 200.0, cc_Hunter, HunterArmor_pc, t2,2.6);
        Armor Armort3_ccHun = new Armor(50.0,70.0, 500.0, cc_Hunter, HunterArmor_pc, t3,2.7);
        Armor Armort4_ccHun = new Armor(60.0,70.0, 1000.0, cc_Hunter, HunterArmor_pc, t4,2.8);
        
        Armor Armort1_ccAss = new Armor(50.0,30.0, 100.0, cc_Assassin, AssassinArmor_pc, t1,1.0);
        Armor Armort2_ccAss = new Armor(60.0,40.0, 200.0, cc_Assassin, AssassinArmor_pc, t2,1.1);
        Armor Armort3_ccAss = new Armor(70.0,50.0, 500.0, cc_Assassin, AssassinArmor_pc, t3,1.2);
        Armor Armort4_ccAss = new Armor(80.0,60.0, 1000.0, cc_Assassin, AssassinArmor_pc, t4,1.3);
        
        //(String nome, Double dano, Double dps, Double durabilidade, Integer alcance, Boolean quebrada, Double price, ClasseCombate idClassecombate, Picture idpicture, Tier idtier) {
        Weapon Swordt1 = new Weapon("Sword I", 100.0, 1.0,  100.0, 10, false, 100.0, cc_Soldier, sword_pc, t1,5.0);
        Weapon Swordt2 = new Weapon("Sword II", 250.0, 1.5,  100.0, 11, false, 500.0, cc_Soldier, sword_pc, t2,5.1);
        Weapon Swordt3 = new Weapon("Sword III", 350.0, 2.0,  100.0, 12, false, 1000.0, cc_Soldier, sword_pc, t3,5.2);
        Weapon Swordt4 = new Weapon("Sword IIII", 550.0, 2.5,  100.0, 13, false, 5000.0, cc_Soldier, sword_pc, t4,5.3);
        
        Weapon Stafft1 = new Weapon("Staff I", 120.0, 1.5, 100.0, 40, false, 100.0, cc_Mage, staff_pc, t1,3.0);
        Weapon Stafft2 = new Weapon("Staff II", 150.0, 2.5, 100.0, 42, false, 500.0, cc_Mage, staff_pc, t2,3.1);
        Weapon Stafft3 = new Weapon("Staff III", 200.0, 3.5, 100.0, 43, false, 1000.0, cc_Mage, staff_pc, t3,3.2);
        Weapon Stafft4 = new Weapon("Staff IIII", 500.0, 4.5, 100.0, 44, false, 5000.0, cc_Mage, staff_pc, t4,3.3);
        
        Weapon CrossBow1 = new Weapon("CrossBow I", 200.0, 1.0, 100.0, 50, false, 100.0, cc_Hunter, crossbow_pc, t1,7.0);
        Weapon CrossBow2 = new Weapon("CrossBow II", 350.0, 1.3, 100.0, 51, false, 500.0, cc_Hunter, crossbow_pc, t2,7.5);
        Weapon CrossBow3 = new Weapon("CrossBow III", 450.0, 1.5, 100.0, 52, false, 1000.0, cc_Hunter, crossbow_pc, t3,7.8);
        Weapon CrossBow4 = new Weapon("CrossBow IIII", 650.0, 1.9, 100.0, 53, false, 5000.0, cc_Hunter, crossbow_pc, t4,8.0);
        
        Weapon Dagger1 = new Weapon("Dagger I", 150.0, 2.5, 100.0, 5, false, 100.0, cc_Assassin, dagger_pc, t1,1.0);
        Weapon Dagger2 = new Weapon("Dagger II", 300.0, 3.5, 100.0, 6, false, 500.0, cc_Assassin, dagger_pc, t2,1.5);
        Weapon Dagger3 = new Weapon("Dagger III", 350.0, 4.5, 100.0, 7, false, 1000.0, cc_Assassin, dagger_pc, t3,1.8);
        Weapon Dagger4 = new Weapon("Dagger IIII", 550.0, 5.5, 100.0, 8, false, 5000.0, cc_Assassin, dagger_pc, t4,2.0);
        
        Mount Mount_t1 = new Mount("Slow Joe", 90.0, 75, 10, 200.0, cm_regular, mount_t1_pc, t1,50.0);
        Mount Mount_t2 = new Mount("Hork", 110.0, 90, 50, 3000.0, cm_regular, mount_t2_pc, t2,60.0);
        Mount Mount_t3 = new Mount("Ghost", 120.0, 100, 70, 5000.0, cm_regular, mount_t3_pc, t3,80.0);
        Mount Mount_t4 = new Mount("Eternal Fire", 135.0, 110, 90, 10000.0, cm_regular,mount_t4_pc, t4,100.0);
        
        Backpack bcp_t1 = new Backpack(100.0, 0.0, 50.0, Backpack_pc, t1,0.5);
        Backpack bcp_t2 = new Backpack(250.0, 0.0, 150.0, Backpack_pc, t2,1.0);
        Backpack bcp_t3 = new Backpack(350.0, 0.0, 250.0, Backpack_pc, t3,1.5);
        Backpack bcp_t4 = new Backpack(500.0, 0.0, 1000.0, Backpack_pc, t4,2.0);
        
        em.persist(Armort1_ccSol);
        em.persist(Armort2_ccSol);
        em.persist(Armort3_ccSol);
        em.persist(Armort4_ccSol);
        
        em.persist(Armort1_ccMag);
        em.persist(Armort2_ccMag);
        em.persist(Armort3_ccMag);
        em.persist(Armort4_ccMag);
        
        em.persist(Armort1_ccHun);
        em.persist(Armort2_ccHun);
        em.persist(Armort3_ccHun);
        em.persist(Armort4_ccHun);
        
        em.persist(Armort1_ccAss);
        em.persist(Armort2_ccAss);
        em.persist(Armort3_ccAss);
        em.persist(Armort4_ccAss);
        
        em.persist(Swordt1);
        em.persist(Swordt2);
        em.persist(Swordt3);
        em.persist(Swordt4);
        
        em.persist(Stafft1);
        em.persist(Stafft2);
        em.persist(Stafft3);
        em.persist(Stafft4);
        
        em.persist(CrossBow1);
        em.persist(CrossBow2);
        em.persist(CrossBow3);
        em.persist(CrossBow4);
        
        em.persist(Dagger1);
        em.persist(Dagger2);
        em.persist(Dagger3);
        em.persist(Dagger4);
        
        em.persist(Mount_t1);
        em.persist(Mount_t2);
        em.persist(Mount_t3);
        em.persist(Mount_t4);
        
        em.persist(bcp_t1);
        em.persist(bcp_t2);
        em.persist(bcp_t3);
        em.persist(bcp_t4);
        
        em.getTransaction().commit();
        em.close();
    }
	
}
