package model;

public interface Combate {
	public int CausarDano(int dano, int health);
	public int ReceberDano(int dano, int health);
	public int Defender(int dano);
}
