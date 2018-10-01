/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByIdservice", query = "SELECT s FROM Service s WHERE s.idservice = :idservice"),
    @NamedQuery(name = "Service.findByNomservice", query = "SELECT s FROM Service s WHERE s.nomservice = :nomservice")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservice")
    private Integer idservice;
    @Size(max = 254)
    @Column(name = "nomservice")
    private String nomservice;
    @ManyToMany(mappedBy = "serviceCollection")
    private Collection<Produit> produitCollection;
    @JoinColumn(name = "chefservice_id")
    @ManyToOne(optional = false)
    private Chefservice chefservice;

    public Service() {
    }

    public Service(Integer idservice) {
        this.idservice = idservice;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public String getNomservice() {
        return nomservice;
    }

    public void setNomservice(String nomservice) {
        this.nomservice = nomservice;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    public Chefservice getChefservice() {
        return chefservice;
    }

    public void setChefservice(Chefservice chefservice) {
        this.chefservice = chefservice;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservice != null ? idservice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.idservice == null && other.idservice != null) || (this.idservice != null && !this.idservice.equals(other.idservice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Service[ idservice=" + idservice + " ]";
    }
    
}
