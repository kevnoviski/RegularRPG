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
@Table(name = "ARMOR")
@NamedQueries({
    @NamedQuery(name = "Armor.findAll", query = "SELECT a FROM Armor a"),
    @NamedQuery(name = "Armor.findById", query = "SELECT a FROM Armor a WHERE a.id = :id"),
    @NamedQuery(name = "Armor.findByDefesa", query = "SELECT a FROM Armor a WHERE a.defesa = :defesa"),
    @NamedQuery(name = "Armor.findByAtaque", query = "SELECT a FROM Armor a WHERE a.ataque = :ataque"),
    @NamedQuery(name = "Armor.findByPrice", query = "SELECT a FROM Armor a WHERE a.price = :price")})
public class Armor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DEFESA")
    private Double defesa;
    @Column(name = "ATAQUE")
    private Double ataque;
    @Column(name = "PRICE")
    private Double price;
    @OneToMany(mappedBy = "idarmor", fetch = FetchType.LAZY)
    private Collection<Personagem> personagemCollection;
    @JoinColumn(name = "ID_CLASSECOMBATE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClasseCombate idClassecombate;
    @JoinColumn(name = "IDPICTURE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Picture idpicture;
    @JoinColumn(name = "IDTIER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tier idtier;
    @OneToMany(mappedBy = "idarmor", fetch = FetchType.LAZY)
    private Collection<Item> itemCollection;
    @Column(name = "WEIGHT")
    private Double weight;
    
    public Armor() {
    }

    public Armor(Integer id) {
        this.id = id;
    }

    public Armor(Double defesa, Double ataque, Double price, ClasseCombate idClassecombate, Picture idpicture, Tier idtier, Double weight) {
        this.defesa = defesa;
        this.ataque = ataque;
        this.price = price;
        this.idClassecombate = idClassecombate;
        this.idpicture = idpicture;
        this.idtier = idtier;
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDefesa() {
        return defesa;
    }

    public void setDefesa(Double defesa) {
        this.defesa = defesa;
    }

    public Double getAtaque() {
        return ataque;
    }

    public void setAtaque(Double ataque) {
        this.ataque = ataque;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Collection<Personagem> getPersonagemCollection() {
        return personagemCollection;
    }

    public void setPersonagemCollection(Collection<Personagem> personagemCollection) {
        this.personagemCollection = personagemCollection;
    }

    public ClasseCombate getIdClassecombate() {
        return idClassecombate;
    }

    public void setIdClassecombate(ClasseCombate idClassecombate) {
        this.idClassecombate = idClassecombate;
    }

    public Picture getIdpicture() {
        return idpicture;
    }

    public void setIdpicture(Picture idpicture) {
        this.idpicture = idpicture;
    }

    public Tier getIdtier() {
        return idtier;
    }

    public void setIdtier(Tier idtier) {
        this.idtier = idtier;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
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
        if (!(object instanceof Armor)) {
            return false;
        }
        Armor other = (Armor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Armor[ id=" + id + " ]";
    }
    
}
