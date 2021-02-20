package model;


public class ClasseCombate {
    private int id;
    private String nome;
    private int alcance;
    private int ataque;
    private int defesa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean ForaDeAlcance(int distancia) {
            return getAlcance()  > distancia;
    }

    public int getAlcance() {
            return this.alcance;
    }
    public int getAtaque() {
            return this.ataque;
    }
    public int getDefesa() {
            return this.defesa;
    }

    public String getNome() {
            return nome;
    }

    public ClasseCombate() {

    }

    public ClasseCombate(int id, String nome, int alcance, int ataque, int defesa) {
        this.id = id;
        this.nome = nome;
        this.alcance = alcance;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    @Override
    public String toString() {
        return "ClasseCombate{ nome=" + nome + ", alcance=" + alcance + ", ataque=" + ataque + ", defesa=" + defesa + '}';
    }

	
}
