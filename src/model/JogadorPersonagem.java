/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Oem
 */
@Entity
@Table(name = "JOGADORPERSONAGEM")
@NamedQueries({
    @NamedQuery(name = "Jogadorpersonagem.findAll", query = "SELECT j FROM JogadorPersonagem j"),
    @NamedQuery(name = "Jogadorpersonagem.findById", query = "SELECT j FROM JogadorPersonagem j WHERE j.id = :id")})
public class JogadorPersonagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "IDJOGADOR", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jogador idjogador;
    @JoinColumn(name = "IDPERSONAGEM", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Personagem idpersonagem;

    public JogadorPersonagem() {
    }

    public JogadorPersonagem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jogador getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(Jogador idjogador) {
        this.idjogador = idjogador;
    }

    public Personagem getIdpersonagem() {
        return idpersonagem;
    }

    public void setIdpersonagem(Personagem idpersonagem) {
        this.idpersonagem = idpersonagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JogadorPersonagem)) {
            return false;
        }
        JogadorPersonagem other = (JogadorPersonagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Jogadorpersonagem[ id=" + id + " ]";
    }
    
}
