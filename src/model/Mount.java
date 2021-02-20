package model;

public class Mount {
	private String name;
	private ClasseMount tipo;
	private double velocidade;
	private int health;
	private int armor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ClasseMount getTipo() {
		return tipo;
	}
	public void setTipo(ClasseMount tipo) {
		this.tipo = tipo;
	}
	public double getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public Mount() {
		
	}
	
	public Mount(String name, ClasseMount tipo, double velocidade, int health, int armor) {
		
		this.name = name;
		this.tipo = tipo;
		this.velocidade = velocidade;
		this.health = health;
		this.armor = armor;
	}
	@Override
	public String toString() {
		return "Mount [name=" + getName() + ", tipo=" + tipo.toString() + ", velocidade=" + getVelocidade() + ", health=" + getHealth()
				+ ", armor=" + getArmor() + "]";
	}
	
	
	
}
