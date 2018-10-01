package com.winmoney.entities;
// Generated 25 sept. 2018 22:38:54 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Secretaire generated by hbm2java
 */
@Entity
@Table(name="secretaire"
    ,schema="public"
)
public class Secretaire  implements java.io.Serializable {


     private int iduser;
     private Promoteur promoteur;
     private String adressemail;
     private Date datecreation;
     private Boolean etat;
     private String login;
     private String motdepasse;
     private String nom;
     private String prenom;
     private String profil;
     private String telephone;
     private Set<Commande> commandes = new HashSet<Commande>(0);

    public Secretaire() {
    }

	
    public Secretaire(int iduser) {
        this.iduser = iduser;
    }
    public Secretaire(int iduser, Promoteur promoteur, String adressemail, Date datecreation, Boolean etat, String login, String motdepasse, String nom, String prenom, String profil, String telephone, Set<Commande> commandes) {
       this.iduser = iduser;
       this.promoteur = promoteur;
       this.adressemail = adressemail;
       this.datecreation = datecreation;
       this.etat = etat;
       this.login = login;
       this.motdepasse = motdepasse;
       this.nom = nom;
       this.prenom = prenom;
       this.profil = profil;
       this.telephone = telephone;
       this.commandes = commandes;
    }
   
     @Id 

    
    @Column(name="iduser", unique=true, nullable=false)
    public int getIduser() {
        return this.iduser;
    }
    
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idpromoteur")
    public Promoteur getPromoteur() {
        return this.promoteur;
    }
    
    public void setPromoteur(Promoteur promoteur) {
        this.promoteur = promoteur;
    }

    
    @Column(name="adressemail", length=254)
    public String getAdressemail() {
        return this.adressemail;
    }
    
    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datecreation", length=13)
    public Date getDatecreation() {
        return this.datecreation;
    }
    
    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    
    @Column(name="etat")
    public Boolean getEtat() {
        return this.etat;
    }
    
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    
    @Column(name="login", length=254)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="motdepasse", length=254)
    public String getMotdepasse() {
        return this.motdepasse;
    }
    
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
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

    
    @Column(name="profil", length=254)
    public String getProfil() {
        return this.profil;
    }
    
    public void setProfil(String profil) {
        this.profil = profil;
    }

    
    @Column(name="telephone", length=254)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="secretaire")
    public Set<Commande> getCommandes() {
        return this.commandes;
    }
    
    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }




}


