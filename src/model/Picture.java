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
@Table(name = "PICTURE")
@NamedQueries({
    @NamedQuery(name = "Picture.findAll", query = "SELECT p FROM Picture p"),
    @NamedQuery(name = "Picture.findById", query = "SELECT p FROM Picture p WHERE p.id = :id"),
    @NamedQuery(name = "Picture.findByName", query = "SELECT p FROM Picture p WHERE p.name = :name"),
    @NamedQuery(name = "Picture.findByPath", query = "SELECT p FROM Picture p WHERE p.path = :path")})
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PATH")
    private String path;
    @OneToMany(mappedBy = "idpicture", fetch = FetchType.LAZY)
    private Collection<Personagem> personagemCollection;
    @OneToMany(mappedBy = "idpicture", fetch = FetchType.LAZY)
    private Collection<Armor> armorCollection;
    @OneToMany(mappedBy = "idpicture", fetch = FetchType.LAZY)
    private Collection<Mount> mountCollection;
    @OneToMany(mappedBy = "idpicture", fetch = FetchType.LAZY)
    private Collection<Weapon> weaponCollection;
    @OneToMany(mappedBy = "idpicture", fetch = FetchType.LAZY)
    private Collection<Backpack> backpackCollection;

    public Picture() {
    }

    public Picture(Integer id) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Collection<Personagem> getPersonagemCollection() {
        return personagemCollection;
    }

    public void setPersonagemCollection(Collection<Personagem> personagemCollection) {
        this.personagemCollection = personagemCollection;
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
        if (!(object instanceof Picture)) {
            return false;
        }
        Picture other = (Picture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Picture[ id=" + id + " ]";
    }
    
}
