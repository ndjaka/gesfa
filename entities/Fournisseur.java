/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByIdfournisseur", query = "SELECT f FROM Fournisseur f WHERE f.idfournisseur = :idfournisseur"),
    @NamedQuery(name = "Fournisseur.findByNomsociete", query = "SELECT f FROM Fournisseur f WHERE f.nomsociete = :nomsociete"),
    @NamedQuery(name = "Fournisseur.findByTelephone", query = "SELECT f FROM Fournisseur f WHERE f.telephone = :telephone"),
    @NamedQuery(name = "Fournisseur.findByAdressemail", query = "SELECT f FROM Fournisseur f WHERE f.adressemail = :adressemail")})
public class Fournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfournisseur")
    private Integer idfournisseur;
    @Size(max = 254)
    @Column(name = "nomsociete")
    private String nomsociete;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 254)
    @Column(name = "adressemail",unique=true)
    private String adressemail;
    @JoinColumn(name = "dg_id")
    @ManyToOne(optional = false)
    private Dg dg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfournisseur")
    private Collection<Matierepremiere> matierepremiereCollection;

    public Fournisseur() {
    }

    public Fournisseur(Integer idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public Integer getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Integer idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public String getNomsociete() {
        return nomsociete;
    }

    public void setNomsociete(String nomsociete) {
        this.nomsociete = nomsociete;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public Dg getDg() {
        return dg;
    }

    public void setDg(Dg dg) {
        this.dg = dg;
    }

 

    @XmlTransient
    public Collection<Matierepremiere> getMatierepremiereCollection() {
        return matierepremiereCollection;
    }

    public void setMatierepremiereCollection(Collection<Matierepremiere> matierepremiereCollection) {
        this.matierepremiereCollection = matierepremiereCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfournisseur != null ? idfournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idfournisseur == null && other.idfournisseur != null) || (this.idfournisseur != null && !this.idfournisseur.equals(other.idfournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Fournisseur[ idfournisseur=" + idfournisseur + " ]";
    }
    
}
