/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIdproduit", query = "SELECT p FROM Produit p WHERE p.idproduit = :idproduit"),
    @NamedQuery(name = "Produit.findByDesignation", query = "SELECT p FROM Produit p WHERE p.designation = :designation"),
    @NamedQuery(name = "Produit.findByPrixunitaire", query = "SELECT p FROM Produit p WHERE p.prixunitaire = :prixunitaire"),
    @NamedQuery(name = "Produit.findByQuantite", query = "SELECT p FROM Produit p WHERE p.quantite = :quantite"),
    @NamedQuery(name = "Produit.findByDescription", query = "SELECT p FROM Produit p WHERE p.description = :description"),
    @NamedQuery(name = "Produit.findByNombreactuel", query = "SELECT p FROM Produit p WHERE p.nombreactuel = :nombreactuel")})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduit")
    private Integer idproduit;
    @Size(max = 254)
    @Column(name = "designation")
    private String designation;
    @Column(name = "prixunitaire")
    private Float prixunitaire;
    @Column(name = "quantite")
    private Integer quantite;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Column(name = "nombreactuel")
    private Integer nombreactuel;
    @ManyToMany(mappedBy = "produitCollection")
    private Collection<Matierepremiere> matierepremiereCollection;
    @JoinTable(name = "produit_service", joinColumns = {
        @JoinColumn(name = "idproduit", referencedColumnName = "idproduit")}, inverseJoinColumns = {
        @JoinColumn(name = "idservice", referencedColumnName = "idservice")})
    @ManyToMany
    private Collection<Service> serviceCollection;
    @JoinColumn(name = "chefservice_id")
    @ManyToOne(optional = false)
    private Chefservice chefservice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Commandeproduit> commandeproduitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduit")
    private Collection<Caracteristique> caracteristiqueCollection;

    public Produit() {
    }

    public Produit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

 
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNombreactuel() {
        return nombreactuel;
    }

    public void setNombreactuel(Integer nombreactuel) {
        this.nombreactuel = nombreactuel;
    }

    @XmlTransient
    public Collection<Matierepremiere> getMatierepremiereCollection() {
        return matierepremiereCollection;
    }

    public void setMatierepremiereCollection(Collection<Matierepremiere> matierepremiereCollection) {
        this.matierepremiereCollection = matierepremiereCollection;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

 

    @XmlTransient
    public Collection<Commandeproduit> getCommandeproduitCollection() {
        return commandeproduitCollection;
    }

    public void setCommandeproduitCollection(Collection<Commandeproduit> commandeproduitCollection) {
        this.commandeproduitCollection = commandeproduitCollection;
    }

    @XmlTransient
    public Collection<Caracteristique> getCaracteristiqueCollection() {
        return caracteristiqueCollection;
    }

    public void setCaracteristiqueCollection(Collection<Caracteristique> caracteristiqueCollection) {
        this.caracteristiqueCollection = caracteristiqueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduit != null ? idproduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idproduit == null && other.idproduit != null) || (this.idproduit != null && !this.idproduit.equals(other.idproduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Produit[ idproduit=" + idproduit + " ]";
    }
    
}
