package model;


import java.util.HashMap;

public class ClasseCombate {
	private String nome;
	private HashMap<String, AtributoClasseCombate> abilidadesClasses;
	
	public Boolean ForaDeAlcance(int distancia) {
		if(getAlcance(this.nome)  > distancia) {
			return true;
		}
		return true;
	}
	
	public int getAlcance(String nome) {
		return abilidadesClasses.get(this.nome).getAlcance();
	}
	public int getAtaque(String nome) {
		return abilidadesClasses.get(this.nome).getAtaque();
	}
	public int getDefesa(String nome) {
		return abilidadesClasses.get(this.nome).getDefesa();
	}

	public String getNome() {
		return nome;
	}

	public ClasseCombate() {
		Inicializar();
	}


	public ClasseCombate(String nome) {
		this.nome = nome;
		Inicializar();		
	}
	
	private void Inicializar() {
		
		this.abilidadesClasses = new HashMap<String, AtributoClasseCombate>();
		
		abilidadesClasses.put("Assassin", new AtributoClasseCombate(10, 35, 20));
		
		abilidadesClasses.put("Soldier", new AtributoClasseCombate(25, 10, 50));
		
		abilidadesClasses.put("Mage", new AtributoClasseCombate(45, 30, 10));
		
		abilidadesClasses.put("Hunter", new AtributoClasseCombate(50, 25, 15));
	}


	@Override
	public String toString() {
		return "\nClasseCombate [nome=" + nome + "]" + abilidadesClasses.get(this.nome).toString();
	}
	
	
	
}
