/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Oem
 */
public class JogadorPersonagem {
    private int id;
    private int idJogador;
    private int idPersonagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public int getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(int idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public JogadorPersonagem() {
    }

    public JogadorPersonagem(int id, int idJogador, int idPersonagem) {
        this.id = id;
        this.idJogador = idJogador;
        this.idPersonagem = idPersonagem;
    }
    
    
}
