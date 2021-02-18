package control;

import model.Armor;
import model.ClasseCombate;
import model.Personagem;
import model.Weapon;

public class Runner {

	public static void main(String[] args)  {
		Personagem soldado = new Personagem(1,"Kevin",1000,'M',new Armor(new ClasseCombate("Assassin"), 30, 60), new Weapon("Machadao", new ClasseCombate("Hunter"), 100, 150, 100, 50, false));
	     System.out.println( 
	         "You entered : " + soldado.toString()); 
		}

}
