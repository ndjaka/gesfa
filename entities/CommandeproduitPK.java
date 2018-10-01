/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ndjaka
 */
@Embeddable
public class CommandeproduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcommande")
    private int idcommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduit")
    private int idproduit;

    public CommandeproduitPK() {
    }

    public CommandeproduitPK(int idcommande, int idproduit) {
        this.idcommande = idcommande;
        this.idproduit = idproduit;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcommande;
        hash += (int) idproduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeproduitPK)) {
            return false;
        }
        CommandeproduitPK other = (CommandeproduitPK) object;
        if (this.idcommande != other.idcommande) {
            return false;
        }
        if (this.idproduit != other.idproduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.CommandeproduitPK[ idcommande=" + idcommande + ", idproduit=" + idproduit + " ]";
    }
    
}
