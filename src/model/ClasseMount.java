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
@Table(name = "CLASSEMOUNT")
@NamedQueries({
    @NamedQuery(name = "Classemount.findAll", query = "SELECT c FROM ClasseMount c"),
    @NamedQuery(name = "Classemount.findById", query = "SELECT c FROM ClasseMount c WHERE c.id = :id"),
    @NamedQuery(name = "Classemount.findByClasse", query = "SELECT c FROM ClasseMount c WHERE c.classe = :classe")})
public class ClasseMount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CLASSE")
    private String classe;
    @OneToMany(mappedBy = "idClassemount", fetch = FetchType.LAZY)
    private Collection<Mount> mountCollection;

    public ClasseMount() {
    }

    public ClasseMount(Integer id) {
        this.id = id;
    }

    public ClasseMount(String classe) {
        this.classe = classe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Collection<Mount> getMountCollection() {
        return mountCollection;
    }

    public void setMountCollection(Collection<Mount> mountCollection) {
        this.mountCollection = mountCollection;
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
        if (!(object instanceof ClasseMount)) {
            return false;
        }
        ClasseMount other = (ClasseMount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Classemount[ id=" + id + " ]";
    }
    
}
