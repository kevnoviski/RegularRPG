package model;

import java.util.ArrayList;

public class Jogador {
    private int id;
    private String nome;
    private ArrayList<Personagem> personagem ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public ArrayList<Personagem> getPersonagem() {
            return personagem;
    }

    public void setPersonagem(ArrayList<Personagem> personagem) {
            this.personagem = personagem;
    }


    public Jogador(String nome, ArrayList<Personagem> personagem) {
            super();
            this.nome = nome;
            this.personagem = personagem;
    }

    public Jogador() {

    }
	
	
}
