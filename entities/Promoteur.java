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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "promoteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promoteur.findAll", query = "SELECT p FROM Promoteur p"),
    @NamedQuery(name = "Promoteur.findByIdpromoteur", query = "SELECT p FROM Promoteur p WHERE p.idpromoteur = :idpromoteur"),
    @NamedQuery(name = "Promoteur.findByNom", query = "SELECT p FROM Promoteur p WHERE p.nom = :nom"),
    @NamedQuery(name = "Promoteur.findByPrenom", query = "SELECT p FROM Promoteur p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Promoteur.findByTelephone", query = "SELECT p FROM Promoteur p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Promoteur.findByDatecreationcompte", query = "SELECT p FROM Promoteur p WHERE p.datecreationcompte = :datecreationcompte"),
    @NamedQuery(name = "Promoteur.findByLogin", query = "SELECT p FROM Promoteur p WHERE p.login = :login"),
    @NamedQuery(name = "Promoteur.findByMdp", query = "SELECT p FROM Promoteur p WHERE p.mdp = :mdp")})
public class Promoteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpromoteur")
    private Integer idpromoteur;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "datecreationcompte")
    @Temporal(TemporalType.DATE)
    private Date datecreationcompte;
    @Size(max = 254)
    @Column(name = "login")
    private String login;
    @Size(max = 254)
    @Column(name = "mdp")
    private String mdp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpromoteur")
    private Collection<Utilisateur> utilisateurCollection;

    public Promoteur() {
    }

    public Promoteur(Integer idpromoteur) {
        this.idpromoteur = idpromoteur;
    }

    public Integer getIdpromoteur() {
        return idpromoteur;
    }

    public void setIdpromoteur(Integer idpromoteur) {
        this.idpromoteur = idpromoteur;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDatecreationcompte() {
        return datecreationcompte;
    }

    public void setDatecreationcompte(Date datecreationcompte) {
        this.datecreationcompte = datecreationcompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromoteur != null ? idpromoteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promoteur)) {
            return false;
        }
        Promoteur other = (Promoteur) object;
        if ((this.idpromoteur == null && other.idpromoteur != null) || (this.idpromoteur != null && !this.idpromoteur.equals(other.idpromoteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Promoteur[ idpromoteur=" + idpromoteur + " ]";
    }
    
}
