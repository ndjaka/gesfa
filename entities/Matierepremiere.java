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
import javax.persistence.JoinTable;
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
@Table(name = "matierepremiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matierepremiere.findAll", query = "SELECT m FROM Matierepremiere m"),
    @NamedQuery(name = "Matierepremiere.findByIdmatierepremiere", query = "SELECT m FROM Matierepremiere m WHERE m.idmatierepremiere = :idmatierepremiere"),
    @NamedQuery(name = "Matierepremiere.findByNom", query = "SELECT m FROM Matierepremiere m WHERE m.nom = :nom"),
    @NamedQuery(name = "Matierepremiere.findByQuantite", query = "SELECT m FROM Matierepremiere m WHERE m.quantite = :quantite"),
    @NamedQuery(name = "Matierepremiere.findByDatelivraison", query = "SELECT m FROM Matierepremiere m WHERE m.datelivraison = :datelivraison"),
    @NamedQuery(name = "Matierepremiere.findByDescription", query = "SELECT m FROM Matierepremiere m WHERE m.description = :description")})
public class Matierepremiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmatierepremiere")
    private Integer idmatierepremiere;
    @Column(name = "nom")
    private Integer nom;
    @Column(name = "quantite")
    private Integer quantite;
    @Column(name = "datelivraison")
    private Integer datelivraison;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "matiere_premiere_produit", joinColumns = {
        @JoinColumn(name = "idmatierepremiere")}, inverseJoinColumns = {
        @JoinColumn(name = "idproduit")})
    @ManyToMany
    private Collection<Produit> produitCollection;
    @JoinColumn(name = "dg_id")
    @ManyToOne() 
    private Dg dg;
    @JoinColumn(name = "idfournisseur", referencedColumnName = "idfournisseur")
    @ManyToOne()
    private Fournisseur idfournisseur;

    public Matierepremiere() {
    }

    public Matierepremiere(Integer idmatierepremiere) {
        this.idmatierepremiere = idmatierepremiere;
    }

    public Integer getIdmatierepremiere() {
        return idmatierepremiere;
    }

    public void setIdmatierepremiere(Integer idmatierepremiere) {
        this.idmatierepremiere = idmatierepremiere;
    }

    public Integer getNom() {
        return nom;
    }

    public void setNom(Integer nom) {
        this.nom = nom;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getDatelivraison() {
        return datelivraison;
    }

    public void setDatelivraison(Integer datelivraison) {
        this.datelivraison = datelivraison;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    public Fournisseur getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Fournisseur idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatierepremiere != null ? idmatierepremiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matierepremiere)) {
            return false;
        }
        Matierepremiere other = (Matierepremiere) object;
        if ((this.idmatierepremiere == null && other.idmatierepremiere != null) || (this.idmatierepremiere != null && !this.idmatierepremiere.equals(other.idmatierepremiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Matierepremiere[ idmatierepremiere=" + idmatierepremiere + " ]";
    }
    
}
