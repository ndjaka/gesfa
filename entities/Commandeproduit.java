/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "commandeproduit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commandeproduit.findAll", query = "SELECT c FROM Commandeproduit c"),
    @NamedQuery(name = "Commandeproduit.findByIdcommande", query = "SELECT c FROM Commandeproduit c WHERE c.commandeproduitPK.idcommande = :idcommande"),
    @NamedQuery(name = "Commandeproduit.findByIdproduit", query = "SELECT c FROM Commandeproduit c WHERE c.commandeproduitPK.idproduit = :idproduit"),
    @NamedQuery(name = "Commandeproduit.findByQuantitecommande", query = "SELECT c FROM Commandeproduit c WHERE c.quantitecommande = :quantitecommande"),
    @NamedQuery(name = "Commandeproduit.findByPrixtotal", query = "SELECT c FROM Commandeproduit c WHERE c.prixtotal = :prixtotal")})
public class Commandeproduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommandeproduitPK commandeproduitPK;
    @Column(name = "quantitecommande")
    private Integer quantitecommande;
    @Column(name = "prixtotal")
    private BigInteger prixtotal;
    @JoinColumn(name = "idcommande", referencedColumnName = "idcommande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "idproduit", referencedColumnName = "idproduit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public Commandeproduit() {
    }

    public Commandeproduit(CommandeproduitPK commandeproduitPK) {
        this.commandeproduitPK = commandeproduitPK;
    }

    public Commandeproduit(int idcommande, int idproduit) {
        this.commandeproduitPK = new CommandeproduitPK(idcommande, idproduit);
    }

    public CommandeproduitPK getCommandeproduitPK() {
        return commandeproduitPK;
    }

    public void setCommandeproduitPK(CommandeproduitPK commandeproduitPK) {
        this.commandeproduitPK = commandeproduitPK;
    }

    public Integer getQuantitecommande() {
        return quantitecommande;
    }

    public void setQuantitecommande(Integer quantitecommande) {
        this.quantitecommande = quantitecommande;
    }

    public BigInteger getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(BigInteger prixtotal) {
        this.prixtotal = prixtotal;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandeproduitPK != null ? commandeproduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commandeproduit)) {
            return false;
        }
        Commandeproduit other = (Commandeproduit) object;
        if ((this.commandeproduitPK == null && other.commandeproduitPK != null) || (this.commandeproduitPK != null && !this.commandeproduitPK.equals(other.commandeproduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Commandeproduit[ commandeproduitPK=" + commandeproduitPK + " ]";
    }
    
}
