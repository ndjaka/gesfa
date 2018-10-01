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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdcommande", query = "SELECT c FROM Commande c WHERE c.idcommande = :idcommande"),
    @NamedQuery(name = "Commande.findByDatelivraison", query = "SELECT c FROM Commande c WHERE c.datelivraison = :datelivraison"),
    @NamedQuery(name = "Commande.findByDatecommande", query = "SELECT c FROM Commande c WHERE c.datecommande = :datecommande")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcommande")
    private Integer idcommande;
    @Column(name = "datelivraison")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelivraison;
    @Column(name = "datecommande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecommande;
    
    @ManyToMany(mappedBy = "commandeCollection")
    private Collection<Client> clientCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<Commandeproduit> commandeproduitCollection;
    
    @JoinColumn(name = "secretaire_id")
    @ManyToOne()
    private Secretaire secretaire;

    public Commande() {
    }

    public Commande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Commande(Date datelivraison, Date datecommande) {
        this.datelivraison = datelivraison;
        this.datecommande = datecommande;
    }

    public Integer getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    public Date getDatelivraison() {
        return datelivraison;
    }

    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    public Collection<Commandeproduit> getCommandeproduitCollection() {
        return commandeproduitCollection;
    }

    public void setCommandeproduitCollection(Collection<Commandeproduit> commandeproduitCollection) {
        this.commandeproduitCollection = commandeproduitCollection;
    }

    public Secretaire getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(Secretaire secretaire) {
        this.secretaire = secretaire;
    }

    @Override
    public String toString() {
        return "Commande{" + "idcommande=" + idcommande + ", datelivraison=" + datelivraison + ", datecommande=" + datecommande + ", clientCollection=" + clientCollection + ", commandeproduitCollection=" + commandeproduitCollection + ", secretaire=" + secretaire + '}';
    }

   
    
}
