/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Oem
 */
@Entity
@Table(name = "CLASSECOMBATE")
@NamedQueries({
    @NamedQuery(name = "Classecombate.findAll", query = "SELECT c FROM ClasseCombate c"),
    @NamedQuery(name = "Classecombate.findById", query = "SELECT c FROM ClasseCombate c WHERE c.id = :id"),
    @NamedQuery(name = "Classecombate.findByNome", query = "SELECT c FROM ClasseCombate c WHERE c.nome = :nome"),
    @NamedQuery(name = "Classecombate.findByAlcance", query = "SELECT c FROM ClasseCombate c WHERE c.alcance = :alcance"),
    @NamedQuery(name = "Classecombate.findByAtaque", query = "SELECT c FROM ClasseCombate c WHERE c.ataque = :ataque"),
    @NamedQuery(name = "Classecombate.findByDefesa", query = "SELECT c FROM ClasseCombate c WHERE c.defesa = :defesa")})
public class ClasseCombate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "ALCANCE")
    private Integer alcance;
    @Column(name = "ATAQUE")
    private Integer ataque;
    @Column(name = "DEFESA")
    private Integer defesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClassecombate", fetch = FetchType.LAZY)
    private Collection<Armor> armorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClassecombate", fetch = FetchType.LAZY)
    private Collection<Weapon> weaponCollection;

    public ClasseCombate() {
    }

    public ClasseCombate(Integer id) {
        this.id = id;
    }

    public ClasseCombate(String nome, Integer alcance, Integer ataque, Integer defesa) {
        this.nome = nome;
        this.alcance = alcance;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAlcance() {
        return alcance;
    }

    public void setAlcance(Integer alcance) {
        this.alcance = alcance;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Collection<Armor> getArmorCollection() {
        return armorCollection;
    }

    public void setArmorCollection(Collection<Armor> armorCollection) {
        this.armorCollection = armorCollection;
    }

    public Collection<Weapon> getWeaponCollection() {
        return weaponCollection;
    }

    public void setWeaponCollection(Collection<Weapon> weaponCollection) {
        this.weaponCollection = weaponCollection;
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
        if (!(object instanceof ClasseCombate)) {
            return false;
        }
        ClasseCombate other = (ClasseCombate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Classecombate[ id=" + id + " ]";
    }
    
}
