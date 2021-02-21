/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Oem
 */
@Entity
@Table(name = "PERSONAGEM")
@NamedQueries({
    @NamedQuery(name = "Personagem.findAll", query = "SELECT p FROM Personagem p"),
    @NamedQuery(name = "Personagem.findById", query = "SELECT p FROM Personagem p WHERE p.id = :id"),
    @NamedQuery(name = "Personagem.findByName", query = "SELECT p FROM Personagem p WHERE p.name = :name"),
    @NamedQuery(name = "Personagem.findByHealth", query = "SELECT p FROM Personagem p WHERE p.health = :health"),
    @NamedQuery(name = "Personagem.findByExp", query = "SELECT p FROM Personagem p WHERE p.exp = :exp"),
    @NamedQuery(name = "Personagem.findByGold", query = "SELECT p FROM Personagem p WHERE p.gold = :gold"),
    @NamedQuery(name = "Personagem.findBySexo", query = "SELECT p FROM Personagem p WHERE p.sexo = :sexo")})
public class Personagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "HEALTH")
    private Integer health;
    @Column(name = "EXP")
    private Integer exp;
    @Column(name = "GOLD")
    private Integer gold;
    @Column(name = "SEXO")
    private String sexo;
    @JoinColumn(name = "IDARMOR", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Armor idarmor;
    @JoinColumn(name = "IDBACKPACK", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Backpack idbackpack;
    @JoinColumn(name = "IDPICTURE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Picture idpicture;
    @JoinColumn(name = "IDWEAPON", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Weapon idweapon;
    @OneToMany(mappedBy = "idpersonagem", fetch = FetchType.LAZY)
    private Collection<JogadorPersonagem> jogadorpersonagemCollection;

    public Personagem() {
    }

    public Personagem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Armor getIdarmor() {
        return idarmor;
    }

    public void setIdarmor(Armor idarmor) {
        this.idarmor = idarmor;
    }

    public Backpack getIdbackpack() {
        return idbackpack;
    }

    public void setIdbackpack(Backpack idbackpack) {
        this.idbackpack = idbackpack;
    }

    public Picture getIdpicture() {
        return idpicture;
    }

    public void setIdpicture(Picture idpicture) {
        this.idpicture = idpicture;
    }

    public Weapon getIdweapon() {
        return idweapon;
    }

    public void setIdweapon(Weapon idweapon) {
        this.idweapon = idweapon;
    }

    public Collection<JogadorPersonagem> getJogadorpersonagemCollection() {
        return jogadorpersonagemCollection;
    }

    public void setJogadorpersonagemCollection(Collection<JogadorPersonagem> jogadorpersonagemCollection) {
        this.jogadorpersonagemCollection = jogadorpersonagemCollection;
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
        if (!(object instanceof Personagem)) {
            return false;
        }
        Personagem other = (Personagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Personagem[ id=" + id + " ]";
    }
    
}
