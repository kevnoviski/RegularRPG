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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Oem
 */
@Entity
@Table(name = "TIER")
@NamedQueries({
    @NamedQuery(name = "Tier.findAll", query = "SELECT t FROM Tier t"),
    @NamedQuery(name = "Tier.findById", query = "SELECT t FROM Tier t WHERE t.id = :id"),
    @NamedQuery(name = "Tier.findByTiernumber", query = "SELECT t FROM Tier t WHERE t.tiernumber = :tiernumber"),
    @NamedQuery(name = "Tier.findByRequiredexp", query = "SELECT t FROM Tier t WHERE t.requiredexp = :requiredexp")})
public class Tier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TIERNUMBER")
    private Integer tiernumber;
    @Column(name = "REQUIREDEXP")
    private Integer requiredexp;
    @OneToMany(mappedBy = "idtier", fetch = FetchType.LAZY)
    private Collection<Armor> armorCollection;
    @OneToMany(mappedBy = "idtier", fetch = FetchType.LAZY)
    private Collection<Mount> mountCollection;
    @OneToMany(mappedBy = "idtier", fetch = FetchType.LAZY)
    private Collection<Weapon> weaponCollection;
    @OneToMany(mappedBy = "idtier", fetch = FetchType.LAZY)
    private Collection<Backpack> backpackCollection;

    public Tier() {
    }

    public Tier(Integer id) {
        this.id = id;
    }

    public Tier(Integer tiernumber, Integer requiredexp) {
        this.tiernumber = tiernumber;
        this.requiredexp = requiredexp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTiernumber() {
        return tiernumber;
    }

    public void setTiernumber(Integer tiernumber) {
        this.tiernumber = tiernumber;
    }

    public Integer getRequiredexp() {
        return requiredexp;
    }

    public void setRequiredexp(Integer requiredexp) {
        this.requiredexp = requiredexp;
    }

    public Collection<Armor> getArmorCollection() {
        return armorCollection;
    }

    public void setArmorCollection(Collection<Armor> armorCollection) {
        this.armorCollection = armorCollection;
    }

    public Collection<Mount> getMountCollection() {
        return mountCollection;
    }

    public void setMountCollection(Collection<Mount> mountCollection) {
        this.mountCollection = mountCollection;
    }

    public Collection<Weapon> getWeaponCollection() {
        return weaponCollection;
    }

    public void setWeaponCollection(Collection<Weapon> weaponCollection) {
        this.weaponCollection = weaponCollection;
    }

    public Collection<Backpack> getBackpackCollection() {
        return backpackCollection;
    }

    public void setBackpackCollection(Collection<Backpack> backpackCollection) {
        this.backpackCollection = backpackCollection;
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
        if (!(object instanceof Tier)) {
            return false;
        }
        Tier other = (Tier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tier[ id=" + id + " ]";
    }
    
}
