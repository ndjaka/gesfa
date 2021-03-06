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
 * Fournisseur generated by hbm2java
 */
@Entity
@Table(name="fournisseur"
    ,schema="public"
)
public class Fournisseur  implements java.io.Serializable {


     private int idfournisseur;
     private Dg dg;
     private String adressemail;
     private String nomsociete;
     private String telephone;
     private Set<Matierepremiere> matierepremieres = new HashSet<Matierepremiere>(0);

    public Fournisseur() {
    }

	
    public Fournisseur(int idfournisseur, Dg dg) {
        this.idfournisseur = idfournisseur;
        this.dg = dg;
    }
    public Fournisseur(int idfournisseur, Dg dg, String adressemail, String nomsociete, String telephone, Set<Matierepremiere> matierepremieres) {
       this.idfournisseur = idfournisseur;
       this.dg = dg;
       this.adressemail = adressemail;
       this.nomsociete = nomsociete;
       this.telephone = telephone;
       this.matierepremieres = matierepremieres;
    }
   
     @Id 

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idfournisseur")
    public int getIdfournisseur() {
        return this.idfournisseur;
    }
    
    public void setIdfournisseur(int idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dg_id", nullable=false)
    public Dg getDg() {
        return this.dg;
    }
    
    public void setDg(Dg dg) {
        this.dg = dg;
    }

    
    @Column(name="adressemail",unique = true, length=254)
    public String getAdressemail() {
        return this.adressemail;
    }
    
    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    
    @Column(name="nomsociete", length=254)
    public String getNomsociete() {
        return this.nomsociete;
    }
    
    public void setNomsociete(String nomsociete) {
        this.nomsociete = nomsociete;
    }

    
    @Column(name="telephone", length=254)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="fournisseur")
    public Set<Matierepremiere> getMatierepremieres() {
        return this.matierepremieres;
    }
    
    public void setMatierepremieres(Set<Matierepremiere> matierepremieres) {
        this.matierepremieres = matierepremieres;
    }




}


