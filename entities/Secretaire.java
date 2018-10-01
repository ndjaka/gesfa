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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ndjaka
 */
@Entity
@Table(name = "secretaire")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Secretaire.findAll", query = "SELECT s FROM Secretaire s"),
//    @NamedQuery(name = "Secretaire.findByIduser", query = "SELECT s FROM Secretaire s WHERE s.iduser = :iduser")})
public class Secretaire extends Utilisateur implements Serializable {
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secretaire")
    private Collection<Commande> commandeCollection;

    public Secretaire() {
       
    }

    public Secretaire( String nom, String prenom, String adressemail, String telephone, String login, String motdepasse, Date datecreation, String profil, Boolean etat) {
        super(nom, prenom, adressemail, telephone, login, motdepasse, datecreation, profil, etat);
      
    }

    

    
}
