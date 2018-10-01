/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
//    @NamedQuery(name = "Utilisateur.findByIduser", query = "SELECT u FROM Utilisateur u WHERE u.iduser = :iduser"),
//    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
//    @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
//    @NamedQuery(name = "Utilisateur.findByAdressemail", query = "SELECT u FROM Utilisateur u WHERE u.adressemail = :adressemail"),
//    @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone"),
//    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
//    @NamedQuery(name = "Utilisateur.findByMotdepasse", query = "SELECT u FROM Utilisateur u WHERE u.motdepasse = :motdepasse"),
//    @NamedQuery(name = "Utilisateur.findByDatecreation", query = "SELECT u FROM Utilisateur u WHERE u.datecreation = :datecreation"),
//    @NamedQuery(name = "Utilisateur.findByProfil", query = "SELECT u FROM Utilisateur u WHERE u.profil = :profil"),
//    @NamedQuery(name = "Utilisateur.findByEtat", query = "SELECT u FROM Utilisateur u WHERE u.etat = :etat")})
public abstract class Utilisateur implements Serializable {
    protected static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    protected Integer iduser;
    @Size(max = 254)
    @Column(name = "nom")
    protected String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    protected String prenom;
    @Size(max = 254)
    @Column(name = "adressemail")
    protected String adressemail;
    @Size(max = 254)
    @Column(name = "telephone")
    protected String telephone;
    @Size(max = 254)
    @Column(name = "login")
    protected String login;
    @Size(max = 254)
    @Column(name = "motdepasse")
    protected String motdepasse;
    @Column(name = "datecreation")
    @Temporal(TemporalType.DATE)
    protected Date datecreation;
    @Size(max = 254)
    @Column(name = "profil")
    protected String profil;
    @Column(name = "etat")
    protected Boolean etat;
    
    @JoinColumn(name = "idpromoteur")
    @ManyToOne()
    protected Promoteur idpromoteur;

    public Utilisateur() {
    }

    public Utilisateur(Integer iduser) {
        this.iduser = iduser;
    }

    public Utilisateur(String nom, String prenom, String adressemail, String telephone, String login, String motdepasse, Date datecreation, String profil, Boolean etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.adressemail = adressemail;
        this.telephone = telephone;
        this.login = login;
        this.motdepasse = motdepasse;
        this.datecreation = datecreation;
        this.profil = profil;
        this.etat = etat;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Promoteur getIdpromoteur() {
        return idpromoteur;
    }

    public void setIdpromoteur(Promoteur idpromoteur) {
        this.idpromoteur = idpromoteur;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.iduser);
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.prenom);
        hash = 97 * hash + Objects.hashCode(this.adressemail);
        hash = 97 * hash + Objects.hashCode(this.telephone);
        hash = 97 * hash + Objects.hashCode(this.login);
        hash = 97 * hash + Objects.hashCode(this.motdepasse);
        hash = 97 * hash + Objects.hashCode(this.datecreation);
        hash = 97 * hash + Objects.hashCode(this.profil);
        hash = 97 * hash + Objects.hashCode(this.etat);
        hash = 97 * hash + Objects.hashCode(this.idpromoteur);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.adressemail, other.adressemail)) {
            return false;
        }
        if (!Objects.equals(this.telephone, other.telephone)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.motdepasse, other.motdepasse)) {
            return false;
        }
        if (!Objects.equals(this.datecreation, other.datecreation)) {
            return false;
        }
        if (!Objects.equals(this.profil, other.profil)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.idpromoteur, other.idpromoteur)) {
            return false;
        }
        return true;
    }
    
    
     
     @Override
    public String toString() {
        return "Utilisateur{" + "iduser=" + iduser + ", nom=" + nom + ", prenom=" + prenom + ", adressemail=" + adressemail + ", telephone=" + telephone + ", login=" + login + ", motdepasse=" + motdepasse + ", datecreation=" + datecreation + ", profil=" + profil + ", etat=" + etat + '}';
    }

    
}
