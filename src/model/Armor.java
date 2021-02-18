package model;

public class Armor {
	private ClasseCombate classe;
	private double defesa;
	private double ataque;
	
	public ClasseCombate getClasse() {
		return classe;
	}
	public void setClasse(ClasseCombate classe) {
		this.classe = classe;
	}
	public double getDefesa() {
		return defesa;
	}
	public void setDefesa(double defesa) {
		this.defesa = defesa;
	}
	public double getAtaque() {
		return ataque;
	}
	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}
	
	public Armor(ClasseCombate classe, double defesa, double ataque) {
		super();
		this.classe = classe;
		this.defesa = defesa + classe.getDefesa(classe.getNome());
		this.ataque = ataque + classe.getAtaque(classe.getNome());
	}
	
	public Armor() {
		super();
	}
	
	@Override
	public String toString() {
		return "\nArmor [classe=" + classe.toString() + ", defesa=" + defesa + ", ataque=" + ataque + "]";
	}
	
	
}
