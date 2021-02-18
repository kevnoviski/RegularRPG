package model;

public class AtributoClasseCombate {
	private int alcance;
	private int ataque;
	private int defesa;
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
	public AtributoClasseCombate() {
		// TODO Auto-generated constructor stub
	}
	public AtributoClasseCombate(int alcance, int ataque, int defesa) {
		this.alcance = alcance;
		this.ataque = ataque;
		this.defesa = defesa;
	}
	@Override
	public String toString() {
		return "\nAtributoClasseCombate [alcance=" + alcance + ", ataque=" + ataque + ", defesa=" + defesa + "]";
	}
	
	
}
