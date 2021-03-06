package com.winmoney.entities;
// Generated 25 sept. 2018 22:38:54 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Produit generated by hbm2java
 */
@Entity
@Table(name="produit"
    ,schema="public"
)
public class Produit  implements java.io.Serializable {


     private int idproduit;
     private Chefservice chefservice;
     private String description;
     private String designation;
     private Integer nombreactuel;
     private Float prixunitaire;
     private Integer quantite;
     private Set<Commandeproduit> commandeproduits = new HashSet<Commandeproduit>(0);
     private Set<ProduitService> produitServices = new HashSet<ProduitService>(0);
     private Set<MatierePremiereProduit> matierePremiereProduits = new HashSet<MatierePremiereProduit>(0);
     private Set<Caracteristique> caracteristiques = new HashSet<Caracteristique>(0);

    public Produit() {
    }

	
    public Produit(int idproduit, Chefservice chefservice) {
        this.idproduit = idproduit;
        this.chefservice = chefservice;
    }
    public Produit(int idproduit, Chefservice chefservice, String description, String designation, Integer nombreactuel, Float prixunitaire, Integer quantite, Set<Commandeproduit> commandeproduits, Set<ProduitService> produitServices, Set<MatierePremiereProduit> matierePremiereProduits, Set<Caracteristique> caracteristiques) {
       this.idproduit = idproduit;
       this.chefservice = chefservice;
       this.description = description;
       this.designation = designation;
       this.nombreactuel = nombreactuel;
       this.prixunitaire = prixunitaire;
       this.quantite = quantite;
       this.commandeproduits = commandeproduits;
       this.produitServices = produitServices;
       this.matierePremiereProduits = matierePremiereProduits;
       this.caracteristiques = caracteristiques;
    }
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idproduit")
    public int getIdproduit() {
        return this.idproduit;
    }
    
    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="chefservice_id", nullable=false)
    public Chefservice getChefservice() {
        return this.chefservice;
    }
    
    public void setChefservice(Chefservice chefservice) {
        this.chefservice = chefservice;
    }

    
    @Column(name="description", length=254)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="designation", length=254)
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    
    @Column(name="nombreactuel")
    public Integer getNombreactuel() {
        return this.nombreactuel;
    }
    
    public void setNombreactuel(Integer nombreactuel) {
        this.nombreactuel = nombreactuel;
    }

    
    @Column(name="prixunitaire", precision=8, scale=8)
    public Float getPrixunitaire() {
        return this.prixunitaire;
    }
    
    public void setPrixunitaire(Float prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    
    @Column(name="quantite")
    public Integer getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public Set<Commandeproduit> getCommandeproduits() {
        return this.commandeproduits;
    }
    
    public void setCommandeproduits(Set<Commandeproduit> commandeproduits) {
        this.commandeproduits = commandeproduits;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public Set<ProduitService> getProduitServices() {
        return this.produitServices;
    }
    
    public void setProduitServices(Set<ProduitService> produitServices) {
        this.produitServices = produitServices;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public Set<MatierePremiereProduit> getMatierePremiereProduits() {
        return this.matierePremiereProduits;
    }
    
    public void setMatierePremiereProduits(Set<MatierePremiereProduit> matierePremiereProduits) {
        this.matierePremiereProduits = matierePremiereProduits;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produit")
    public Set<Caracteristique> getCaracteristiques() {
        return this.caracteristiques;
    }
    
    public void setCaracteristiques(Set<Caracteristique> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }




}


