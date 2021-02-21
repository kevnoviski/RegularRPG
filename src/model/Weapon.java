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
@Table(name = "WEAPON")
@NamedQueries({
    @NamedQuery(name = "Weapon.findAll", query = "SELECT w FROM Weapon w"),
    @NamedQuery(name = "Weapon.findById", query = "SELECT w FROM Weapon w WHERE w.id = :id"),
    @NamedQuery(name = "Weapon.findByNome", query = "SELECT w FROM Weapon w WHERE w.nome = :nome"),
    @NamedQuery(name = "Weapon.findByDano", query = "SELECT w FROM Weapon w WHERE w.dano = :dano"),
    @NamedQuery(name = "Weapon.findByDps", query = "SELECT w FROM Weapon w WHERE w.dps = :dps"),
    @NamedQuery(name = "Weapon.findByDurabilidade", query = "SELECT w FROM Weapon w WHERE w.durabilidade = :durabilidade"),
    @NamedQuery(name = "Weapon.findByAlcance", query = "SELECT w FROM Weapon w WHERE w.alcance = :alcance"),
    @NamedQuery(name = "Weapon.findByQuebrada", query = "SELECT w FROM Weapon w WHERE w.quebrada = :quebrada"),
    @NamedQuery(name = "Weapon.findByPrice", query = "SELECT w FROM Weapon w WHERE w.price = :price")})
public class Weapon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DANO")
    private Double dano;
    @Column(name = "DPS")
    private Double dps;
    @Column(name = "DURABILIDADE")
    private Double durabilidade;
    @Column(name = "ALCANCE")
    private Integer alcance;
    @Column(name = "QUEBRADA")
    private Boolean quebrada;
    @Column(name = "PRICE")
    private Double price;
    @OneToMany(mappedBy = "idweapon", fetch = FetchType.LAZY)
    private Collection<Personagem> personagemCollection;
    @OneToMany(mappedBy = "idweapon", fetch = FetchType.LAZY)
    private Collection<Item> itemCollection;
    @JoinColumn(name = "ID_CLASSECOMBATE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClasseCombate idClassecombate;
    @JoinColumn(name = "IDPICTURE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Picture idpicture;
    @JoinColumn(name = "IDTIER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tier idtier;

    public Weapon() {
    }

    public Weapon(Integer id) {
        this.id = id;
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

    public Double getDano() {
        return dano;
    }

    public void setDano(Double dano) {
        this.dano = dano;
    }

    public Double getDps() {
        return dps;
    }

    public void setDps(Double dps) {
        this.dps = dps;
    }

    public Double getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(Double durabilidade) {
        this.durabilidade = durabilidade;
    }

    public Integer getAlcance() {
        return alcance;
    }

    public void setAlcance(Integer alcance) {
        this.alcance = alcance;
    }

    public Boolean getQuebrada() {
        return quebrada;
    }

    public void setQuebrada(Boolean quebrada) {
        this.quebrada = quebrada;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Weapon)) {
            return false;
        }
        Weapon other = (Weapon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Weapon[ id=" + id + " ]";
    }
    
}
