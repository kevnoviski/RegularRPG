package control;


    
import dao.Crud;
import dao.DataTable;
import dao.JumpStartDB;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Tier;


public class Runner {

	public static void main(String[] args)  {
		JumpStartDB jps=  new JumpStartDB();
                jps.VerifyNCreate();
                Crud cd = new Crud();
                DataTable ss = cd.Select("select * from APP.TIER");
                ss.PrintTable();
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("RegularRPGPU");
                EntityManager em = factory.createEntityManager();
                              
                /*
                Query q = em.createQuery("select t from Tier t");
                List<Tier> todoList = q.getResultList();
                for (Tier todo : todoList) {
                    System.out.println(todo);
                }*/
                
                
                
                em.getTransaction().begin();
                Tier tier = new Tier();
                tier.setRequiredexp(3000);
                tier.setTiernumber(4);
                em.persist(tier);
                em.getTransaction().commit();
                em.close();
                /*
                q = em.createQuery("select t from Tier t");
                todoList = q.getResultList();
                for (Tier todo : todoList) {
                    System.out.println(todo);
                }*/
                //
                
                ss = cd.Select("select * from APP.TIER");
                ss.PrintTable();
		//jps.VerifyNCreate();
		/*Personagem soldado = new Personagem(1,"Kevin",1000,'M',new Armor(new ClasseCombate("Assassin"), 30, 60), new Weapon("Machadao", new ClasseCombate("Hunter"), 100, 150, 100, 50, false));
	     System.out.println( 
	         "You entered : " + soldado.toString());*/ 
		}

}
