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
@Table(name = "BACKPACKITEM")
@NamedQueries({
    @NamedQuery(name = "Backpackitem.findAll", query = "SELECT b FROM BackpackItem b"),
    @NamedQuery(name = "Backpackitem.findById", query = "SELECT b FROM BackpackItem b WHERE b.id = :id")})
public class BackpackItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "IDBACKPACK", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Backpack idbackpack;
    @JoinColumn(name = "IDITEM", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Item iditem;

    public BackpackItem() {
    }

    public BackpackItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Backpack getIdbackpack() {
        return idbackpack;
    }

    public void setIdbackpack(Backpack idbackpack) {
        this.idbackpack = idbackpack;
    }

    public Item getIditem() {
        return iditem;
    }

    public void setIditem(Item iditem) {
        this.iditem = iditem;
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
        if (!(object instanceof BackpackItem)) {
            return false;
        }
        BackpackItem other = (BackpackItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Backpackitem[ id=" + id + " ]";
    }
    
}
