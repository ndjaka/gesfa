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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "dg")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Dg.findAll", query = "SELECT d FROM Dg d"),
//    @NamedQuery(name = "Dg.findByIduser", query = "SELECT d FROM Dg d WHERE d.iduser = :iduser")})
public class Dg extends Utilisateur implements Serializable {
 
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dg")
    private Collection<Fournisseur> fournisseurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dg")
    private Collection<Client> clientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dg")
    private Collection<Matierepremiere> matierepremiereCollection;

    public Dg(String nom, String prenom, String adressemail, String telephone, String login, String motdepasse, Date datecreation, String profil, Boolean etat) {
        super(nom, prenom, adressemail, telephone, login, motdepasse, datecreation, profil, etat);
    }

    public Dg() {
    }

    public Collection<Fournisseur> getFournisseurCollection() {
        return fournisseurCollection;
    }

    public void setFournisseurCollection(Collection<Fournisseur> fournisseurCollection) {
        this.fournisseurCollection = fournisseurCollection;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    public Collection<Matierepremiere> getMatierepremiereCollection() {
        return matierepremiereCollection;
    }

    public void setMatierepremiereCollection(Collection<Matierepremiere> matierepremiereCollection) {
        this.matierepremiereCollection = matierepremiereCollection;
    }

    
}
