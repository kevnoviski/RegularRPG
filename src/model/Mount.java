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
@Table(name = "MOUNT")
@NamedQueries({
    @NamedQuery(name = "Mount.findAll", query = "SELECT m FROM Mount m"),
    @NamedQuery(name = "Mount.findById", query = "SELECT m FROM Mount m WHERE m.id = :id"),
    @NamedQuery(name = "Mount.findByNome", query = "SELECT m FROM Mount m WHERE m.nome = :nome"),
    @NamedQuery(name = "Mount.findByVelocidade", query = "SELECT m FROM Mount m WHERE m.velocidade = :velocidade"),
    @NamedQuery(name = "Mount.findByHealth", query = "SELECT m FROM Mount m WHERE m.health = :health"),
    @NamedQuery(name = "Mount.findByArmor", query = "SELECT m FROM Mount m WHERE m.armor = :armor"),
    @NamedQuery(name = "Mount.findByPrice", query = "SELECT m FROM Mount m WHERE m.price = :price")})
public class Mount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VELOCIDADE")
    private Double velocidade;
    @Column(name = "HEALTH")
    private Integer health;
    @Column(name = "ARMOR")
    private Integer armor;
    @Column(name = "PRICE")
    private Double price;
    @OneToMany(mappedBy = "idmount", fetch = FetchType.LAZY)
    private Collection<Item> itemCollection;
    @JoinColumn(name = "ID_CLASSEMOUNT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClasseMount idClassemount;
    @JoinColumn(name = "IDPICTURE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Picture idpicture;
    @JoinColumn(name = "IDTIER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tier idtier;
    @Column(name = "WEIGHT")
    private Double weight;

    public Mount() {
    }

    public Mount(Integer id) {
        this.id = id;
    }

    public Mount(String nome, Double velocidade, Integer health, Integer armor, Double price, ClasseMount idClassemount, Picture idpicture, Tier idtier, Double weight) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.health = health;
        this.armor = armor;
        this.price = price;
        this.idClassemount = idClassemount;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public ClasseMount getIdClassemount() {
        return idClassemount;
    }

    public void setIdClassemount(ClasseMount idClassemount) {
        this.idClassemount = idClassemount;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mount)) {
            return false;
        }
        Mount other = (Mount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mount[ id=" + id + " ]";
    }
    
}
