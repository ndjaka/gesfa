/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "caracteristique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristique.findAll", query = "SELECT c FROM Caracteristique c"),
    @NamedQuery(name = "Caracteristique.findByIdcaracteristique", query = "SELECT c FROM Caracteristique c WHERE c.idcaracteristique = :idcaracteristique"),
    @NamedQuery(name = "Caracteristique.findByNomcaract", query = "SELECT c FROM Caracteristique c WHERE c.nomcaract = :nomcaract"),
    @NamedQuery(name = "Caracteristique.findByImage", query = "SELECT c FROM Caracteristique c WHERE c.image = :image"),
    @NamedQuery(name = "Caracteristique.findByDimension", query = "SELECT c FROM Caracteristique c WHERE c.dimension = :dimension"),
    @NamedQuery(name = "Caracteristique.findByParticularite", query = "SELECT c FROM Caracteristique c WHERE c.particularite = :particularite")})
public class Caracteristique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcaracteristique")
    private Integer idcaracteristique;
    @Size(max = 254)
    @Column(name = "nomcaract")
    private String nomcaract;
    @Size(max = 254)
    @Column(name = "image")
    private String image;
    @Size(max = 254)
    @Column(name = "dimension")
    private String dimension;
    @Size(max = 254)
    @Column(name = "particularite")
    private String particularite;
    @JoinColumn(name = "idproduit")
    @ManyToOne()
    private Produit idproduit;

    public Caracteristique() {
    }

    public Caracteristique(Integer idcaracteristique) {
        this.idcaracteristique = idcaracteristique;
    }

    public Integer getIdcaracteristique() {
        return idcaracteristique;
    }

    public void setIdcaracteristique(Integer idcaracteristique) {
        this.idcaracteristique = idcaracteristique;
    }

    public String getNomcaract() {
        return nomcaract;
    }

    public void setNomcaract(String nomcaract) {
        this.nomcaract = nomcaract;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getParticularite() {
        return particularite;
    }

    public void setParticularite(String particularite) {
        this.particularite = particularite;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaracteristique != null ? idcaracteristique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristique)) {
            return false;
        }
        Caracteristique other = (Caracteristique) object;
        if ((this.idcaracteristique == null && other.idcaracteristique != null) || (this.idcaracteristique != null && !this.idcaracteristique.equals(other.idcaracteristique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Caracteristique[ idcaracteristique=" + idcaracteristique + " ]";
    }
    
}
