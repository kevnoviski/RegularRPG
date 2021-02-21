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
@Table(name = "BACKPACK")
@NamedQueries({
    @NamedQuery(name = "Backpack.findAll", query = "SELECT b FROM Backpack b"),
    @NamedQuery(name = "Backpack.findById", query = "SELECT b FROM Backpack b WHERE b.id = :id"),
    @NamedQuery(name = "Backpack.findByWeightlimit", query = "SELECT b FROM Backpack b WHERE b.weightlimit = :weightlimit"),
    @NamedQuery(name = "Backpack.findByCurrentweight", query = "SELECT b FROM Backpack b WHERE b.currentweight = :currentweight"),
    @NamedQuery(name = "Backpack.findByPrice", query = "SELECT b FROM Backpack b WHERE b.price = :price")})
public class Backpack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "WEIGHTLIMIT")
    private Double weightlimit;
    @Column(name = "CURRENTWEIGHT")
    private Double currentweight;
    @Column(name = "PRICE")
    private Double price;
    @OneToMany(mappedBy = "idbackpack", fetch = FetchType.LAZY)
    private Collection<Personagem> personagemCollection;
    @OneToMany(mappedBy = "idbackpack", fetch = FetchType.LAZY)
    private Collection<Item> itemCollection;
    @JoinColumn(name = "IDPICTURE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Picture idpicture;
    @JoinColumn(name = "IDTIER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tier idtier;
    @OneToMany(mappedBy = "idbackpack", fetch = FetchType.LAZY)
    private Collection<BackpackItem> backpackitemCollection;

    public Backpack() {
    }

    public Backpack(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWeightlimit() {
        return weightlimit;
    }

    public void setWeightlimit(Double weightlimit) {
        this.weightlimit = weightlimit;
    }

    public Double getCurrentweight() {
        return currentweight;
    }

    public void setCurrentweight(Double currentweight) {
        this.currentweight = currentweight;
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

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
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

    public Collection<BackpackItem> getBackpackitemCollection() {
        return backpackitemCollection;
    }

    public void setBackpackitemCollection(Collection<BackpackItem> backpackitemCollection) {
        this.backpackitemCollection = backpackitemCollection;
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
        if (!(object instanceof Backpack)) {
            return false;
        }
        Backpack other = (Backpack) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Backpack[ id=" + id + " ]";
    }
    
}
