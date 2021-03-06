package com.winmoney.entities;
// Generated 25 sept. 2018 22:38:54 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Promoteur generated by hbm2java
 */
@Entity
@Table(name="promoteur"
    ,schema="public"
)
public class Promoteur  implements java.io.Serializable {


     private int idpromoteur;
     private Date datecreationcompte;
     private String login;
     private String mdp;
     private String nom;
     private String prenom;
     private String telephone;
     private Set<Secretaire> secretaires = new HashSet<Secretaire>(0);
     private Set<Chefservice> chefservices = new HashSet<Chefservice>(0);
     private Set<Dg> dgs = new HashSet<Dg>(0);

    public Promoteur() {
    }

	
    public Promoteur(int idpromoteur) {
        this.idpromoteur = idpromoteur;
    }
    public Promoteur(int idpromoteur, Date datecreationcompte, String login, String mdp, String nom, String prenom, String telephone, Set<Secretaire> secretaires, Set<Chefservice> chefservices, Set<Dg> dgs) {
       this.idpromoteur = idpromoteur;
       this.datecreationcompte = datecreationcompte;
       this.login = login;
       this.mdp = mdp;
       this.nom = nom;
       this.prenom = prenom;
       this.telephone = telephone;
       this.secretaires = secretaires;
       this.chefservices = chefservices;
       this.dgs = dgs;
    }
   
     @Id 
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpromoteur")
    public int getIdpromoteur() {
        return this.idpromoteur;
    }
    
    public void setIdpromoteur(int idpromoteur) {
        this.idpromoteur = idpromoteur;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datecreationcompte", length=13)
    public Date getDatecreationcompte() {
        return this.datecreationcompte;
    }
    
    public void setDatecreationcompte(Date datecreationcompte) {
        this.datecreationcompte = datecreationcompte;
    }

    
    @Column(name="login", length=254)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="mdp", length=254)
    public String getMdp() {
        return this.mdp;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    @Column(name="nom", length=254)
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Column(name="prenom", length=254)
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    @Column(name="telephone", length=254)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="promoteur")
    public Set<Secretaire> getSecretaires() {
        return this.secretaires;
    }
    
    public void setSecretaires(Set<Secretaire> secretaires) {
        this.secretaires = secretaires;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="promoteur")
    public Set<Chefservice> getChefservices() {
        return this.chefservices;
    }
    
    public void setChefservices(Set<Chefservice> chefservices) {
        this.chefservices = chefservices;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="promoteur")
    public Set<Dg> getDgs() {
        return this.dgs;
    }
    
    public void setDgs(Set<Dg> dgs) {
        this.dgs = dgs;
    }




}


