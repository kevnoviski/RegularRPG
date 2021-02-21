package model;

public class Armor {
    private int id;
    private ClasseCombate classe;
    private double defesa;
    private double ataque;
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

    public Armor(int id, ClasseCombate classe, double defesa, double ataque, Picture picture, Tier tier) {
        this.id = id;
        this.classe = classe;
        this.defesa = defesa;
        this.ataque = ataque;
        this.picture = picture;
        this.tier = tier;
    }

  

    public Armor() {
            super();
    }

    @Override
    public String toString() {
        return "Armor{" + "id=" + id + ", classe=" + classe.toString() + ", defesa=" + defesa + ", ataque=" + ataque + ", picture=" + picture.toString() + ", tier=" + tier.toString() + '}';
    }



   
	
	
}
