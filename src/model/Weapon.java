package model;

public class Weapon {
    private int id;
    private String nome;
    private ClasseCombate classe;
    private double dano;
    private double dps;
    private double durabilidade;
    private int alcance;
    private Boolean quebrada;
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

    private void DanificarWeapon() {
            if(!this.quebrada) {
                    this.durabilidade = this.durabilidade - 0.03;
                    if(this.durabilidade <= 0) {
                            this.quebrada = true;
                    }	
            }
    }

    public int CausarDano(int healthAlvo, int distancia) {
            if(!this.quebrada) {
                    double danoCausado =((this.dano * this.durabilidade)/100) /* -*  distancia*/;
                    int resultadoAtaque = (int) (healthAlvo - danoCausado);
                    DanificarWeapon();
                    if (resultadoAtaque <= 0) {
                            return 0;
                    }
                    return resultadoAtaque;	
            }
            else {
                    return healthAlvo;
            }
    }



    public int getId() {
            return id;
    }


    public void setId(int id) {
            this.id = id;
    }


    public Boolean getQuebrada() {
            return quebrada;
    }


    public void setQuebrada(Boolean quebrada) {
            this.quebrada = quebrada;
    }


    public int getAlcance() {
            return alcance;
    }

    public void setAlcance(int alcance) {
            this.alcance = alcance;
    }

    public double getDps() {
            return dps;
    }

    public void setDps(double dps) {
            this.dps = dps;
    }

    public void setDurabilidade(double durabilidade) {
            this.durabilidade = durabilidade;
    }

    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }

    public ClasseCombate getClasse() {
            return classe;
    }
    public void setClasse(ClasseCombate classe) {
            this.classe = classe;
    }

    public double getDano() {
            return dano;
    }
    public void setDano(double dano) {
            this.dano = dano;
    }

    public double getDurabilidade() {
            return durabilidade;
    }
    public void setDurabilidade(int durabilidade) {
            this.durabilidade = durabilidade;
    }

    public Weapon() {

    }

    public Weapon(int id, String nome, ClasseCombate classe, double dano, double dps, double durabilidade, int alcance, Boolean quebrada, Picture picture, Tier tier) {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        this.dano = dano;
        this.dps = dps;
        this.durabilidade = durabilidade;
        this.alcance = alcance;
        this.quebrada = quebrada;
        this.picture = picture;
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Weapon{" + "id=" + id + ", nome=" + nome + ", classe=" + classe + ", dano=" + dano + ", dps=" + dps + ", durabilidade=" + durabilidade + ", alcance=" + alcance + ", quebrada=" + quebrada + ", picture=" + picture + ", tier=" + tier + '}';
    }

}
