package model;

public class Mount {
    private int id;
    private String name;
    private ClasseMount tipo;
    private double velocidade;
    private int health;
    private int armor;
    private Picture picture;
    private Tier tier;

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
    

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Mount(int id, String name, ClasseMount tipo, double velocidade, int health, int armor, Picture picture, Tier tier) {
        this.id = id;
        this.name = name;
        this.tipo = tipo;
        this.velocidade = velocidade;
        this.health = health;
        this.armor = armor;
        this.picture = picture;
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Mount{" + "id=" + id + ", name=" + name + ", tipo=" + tipo + ", velocidade=" + velocidade + ", health=" + health + ", armor=" + armor + ", picture=" + picture + ", tier=" + tier + '}';
    }

}
