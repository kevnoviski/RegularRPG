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
@Table(name = "ITEM")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "IDARMOR", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Armor idarmor;
    @JoinColumn(name = "IDBACKPACK", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Backpack idbackpack;
    @JoinColumn(name = "IDMOUNT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mount idmount;
    @JoinColumn(name = "IDWEAPON", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Weapon idweapon;
    @OneToMany(mappedBy = "iditem", fetch = FetchType.LAZY)
    private Collection<BackpackItem> backpackitemCollection;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Mount getIdmount() {
        return idmount;
    }

    public void setIdmount(Mount idmount) {
        this.idmount = idmount;
    }

    public Weapon getIdweapon() {
        return idweapon;
    }

    public void setIdweapon(Weapon idweapon) {
        this.idweapon = idweapon;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Item[ id=" + id + " ]";
    }
    
}
