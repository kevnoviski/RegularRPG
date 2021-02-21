package model;

public class Personagem {

    private int id;
    private String name;
    private int health;
    private int exp;
    private int gold;
    private char sexo;
    private Armor armadura;
    private Weapon arma;
    private Backpack backpack ;
    private Picture picture;

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }


    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }


    public int getGold() {
            return gold;
    }
    public void setGold(int gold) {
            this.gold = gold;
    }
    public int getExp() {
            return exp;
    }
    public void setExp(int exp) {
            this.exp = exp;
    }
    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public int getHealth() {
            return health + (int)this.armadura.getDefesa();
    }
    public void setHealth(int health) {
            this.health = health;
    }

    public Armor getArmadura() {
            return armadura;
    }
    public void setArmadura(Armor armadura) {
            this.armadura = armadura;
    }
    public Weapon getArma() {
            return arma;
    }
    public void setArma(Weapon arma) {
            this.arma = arma;
    }
    public char getSexo() {
            return sexo;
    }
    public void setSexo(char sexo) {
            this.sexo = sexo;
    }


    public Personagem() {

    }

    public Personagem(int id, String name, int health, int exp, int gold, char sexo, Armor armadura, Weapon arma, Backpack backpack, Picture picture) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.exp = exp;
        this.gold = gold;
        this.sexo = sexo;
        this.armadura = armadura;
        this.arma = arma;
        this.backpack = backpack;
        this.picture = picture;
    }

    

    
    public int CausarDano(int dano, int health) {
            // TODO Auto-generated method stub
            return 0;
    }
    
    public int ReceberDano(int dano, int health) {
            // TODO Auto-generated method stub
            return 0;
    }
    
    public int Defender(int dano) {
            // TODO Auto-generated method stub
            return 0;
    }
    
    public String toString() {
            return "Personagem [id=" + id + ", name=" + name + ", health=" + getHealth() + ", sexo=" + sexo + ", armadura="
                            + armadura.toString() + ", arma=" + arma.toString() +", picture = " +picture.toString()+ "]";
    }
    
    public int Refletir(int dano) {
            // TODO Auto-generated method stub
            //inclusao teste.
            return 0;
    }
	
}
