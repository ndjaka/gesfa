/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "client")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
//    @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient"),
//    @NamedQuery(name = "Client.findByNomclient", query = "SELECT c FROM Client c WHERE c.nomclient = :nomclient"),
//    @NamedQuery(name = "Client.findByPrenomclient", query = "SELECT c FROM Client c WHERE c.prenomclient = :prenomclient"),
//    @NamedQuery(name = "Client.findBySexe", query = "SELECT c FROM Client c WHERE c.sexe = :sexe"),
//    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
//    @NamedQuery(name = "Client.findByAdressemail", query = "SELECT c FROM Client c WHERE c.adressemail = :adressemail"),
//    @NamedQuery(name = "Client.findByLieuderesidence", query = "SELECT c FROM Client c WHERE c.lieuderesidence = :lieuderesidence")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclient")
    private Integer idclient;
    @Size(max = 254)
    @Column(name = "nomclient")
    private String nomclient;
    @Size(max = 254)
    @Column(name = "prenomclient")
    private String prenomclient;
    @Size(max = 254)
    @Column(name = "sexe")
    private String sexe;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 254)
    @Column(name = "adressemail",unique=true)
    private String adressemail;
    @Size(max = 254)
    @Column(name = "lieuderesidence")
    private String lieuderesidence;
    @JoinTable(name = "client_commande", joinColumns = {
        @JoinColumn(name = "idclient", referencedColumnName = "idclient")}, inverseJoinColumns = {
        @JoinColumn(name = "idcommande", referencedColumnName = "idcommande")})
    @ManyToMany
    private Collection<Commande> commandeCollection;
    @JoinColumn(name = "dg_id")
    @ManyToOne()
    private Dg dg;

    public Client() {
    }

    public Client(Integer idclient) {
        this.idclient = idclient;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getPrenomclient() {
        return prenomclient;
    }

    public void setPrenomclient(String prenomclient) {
        this.prenomclient = prenomclient;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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

    public String getLieuderesidence() {
        return lieuderesidence;
    }

    public void setLieuderesidence(String lieuderesidence) {
        this.lieuderesidence = lieuderesidence;
    }

    public Dg getDg() {
        return dg;
    }

    public void setDg(Dg dg) {
        this.dg = dg;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Client[ idclient=" + idclient + " ]";
    }
    
}
