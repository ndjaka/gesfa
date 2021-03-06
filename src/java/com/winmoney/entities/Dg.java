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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Dg generated by hbm2java
 */
@Entity
@Table(name="dg"
    ,schema="public"
)
public class Dg  implements java.io.Serializable {


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
     private Set<Fournisseur> fournisseurs = new HashSet<Fournisseur>(0);
     
     private Set<Matierepremiere> matierepremieres = new HashSet<Matierepremiere>(0);

    public Dg() {
    }

	
    public Dg(int iduser) {
        this.iduser = iduser;
    }
    public Dg(int iduser, Promoteur promoteur, String adressemail, Date datecreation, Boolean etat, String login, String motdepasse, String nom, String prenom, String profil, String telephone, Set<Fournisseur> fournisseurs, Set<Matierepremiere> matierepremieres) {
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
       this.fournisseurs = fournisseurs;
     
       this.matierepremieres = matierepremieres;
    }
   
     @Id 
     @NotNull
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="iduser")
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

    
    @Column(name="adressemail",unique = true, length=254)
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

    
    @Column(name="login",unique = true,length=254)
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="dg")
    public Set<Fournisseur> getFournisseurs() {
        return this.fournisseurs;
    }
    
    public void setFournisseurs(Set<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }



@OneToMany(fetch=FetchType.LAZY, mappedBy="dg")
    public Set<Matierepremiere> getMatierepremieres() {
        return this.matierepremieres;
    }
    
    public void setMatierepremieres(Set<Matierepremiere> matierepremieres) {
        this.matierepremieres = matierepremieres;
    }




}


