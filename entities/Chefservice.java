/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "chefservice")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Chefservice.findAll", query = "SELECT c FROM Chefservice c"),
//    @NamedQuery(name = "Chefservice.findByIduser", query = "SELECT c FROM Chefservice c WHERE c.iduser = :iduser"),
//    @NamedQuery(name = "Chefservice.findByProduit", query = "SELECT c FROM Chefservice c WHERE c.produit = :produit")})
public class Chefservice extends Utilisateur implements Serializable {
   
    @Size(max = 254)
    @Column(name = "produit")
    private String produit;
    @JoinTable(name = "chef_service_ouvrier", joinColumns = {
        @JoinColumn(name = "idchefservice")}, inverseJoinColumns = {
        @JoinColumn(name = "idouvrier")})
    @ManyToMany
    private Collection<Ouvrier> ouvrierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chefservice")
    private Collection<Produit> produitCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chefservice")
    private Collection<Service> serviceCollection;

    public Chefservice(String produit) {
        this.produit = produit;
    }

    public Chefservice(String produit, String nom, String prenom, String adressemail, String telephone, String login, String motdepasse, Date datecreation, String profil, Boolean etat) {
        super(nom, prenom, adressemail, telephone, login, motdepasse, datecreation, profil, etat);
        this.produit = produit;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Collection<Ouvrier> getOuvrierCollection() {
        return ouvrierCollection;
    }

    public void setOuvrierCollection(Collection<Ouvrier> ouvrierCollection) {
        this.ouvrierCollection = ouvrierCollection;
    }

    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

}
