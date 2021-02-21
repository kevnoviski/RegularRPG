package control;



import dao.JumpStartDB;

public class Runner {

	public static void main(String[] args)  {
		JumpStartDB jps=  new JumpStartDB();
		jps.VerifyNCreate();
		/*Personagem soldado = new Personagem(1,"Kevin",1000,'M',new Armor(new ClasseCombate("Assassin"), 30, 60), new Weapon("Machadao", new ClasseCombate("Hunter"), 100, 150, 100, 50, false));
	     System.out.println( 
	         "You entered : " + soldado.toString());*/ 
		}

}
