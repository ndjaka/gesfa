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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ouvrier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ouvrier.findAll", query = "SELECT o FROM Ouvrier o"),
    @NamedQuery(name = "Ouvrier.findByIdouvrier", query = "SELECT o FROM Ouvrier o WHERE o.idouvrier = :idouvrier"),
    @NamedQuery(name = "Ouvrier.findByNomouvrier", query = "SELECT o FROM Ouvrier o WHERE o.nomouvrier = :nomouvrier"),
    @NamedQuery(name = "Ouvrier.findByPrenomouvrier", query = "SELECT o FROM Ouvrier o WHERE o.prenomouvrier = :prenomouvrier"),
    @NamedQuery(name = "Ouvrier.findByCniouvrier", query = "SELECT o FROM Ouvrier o WHERE o.cniouvrier = :cniouvrier"),
    @NamedQuery(name = "Ouvrier.findByTelephone", query = "SELECT o FROM Ouvrier o WHERE o.telephone = :telephone"),
    @NamedQuery(name = "Ouvrier.findByDateenregistrement", query = "SELECT o FROM Ouvrier o WHERE o.dateenregistrement = :dateenregistrement")})
public class Ouvrier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idouvrier")
    private Integer idouvrier;
    @Size(max = 254)
    @Column(name = "nomouvrier")
    private String nomouvrier;
    @Size(max = 254)
    @Column(name = "prenomouvrier")
    private String prenomouvrier;
    @Size(max = 254)
    @Column(name = "cniouvrier")
    private String cniouvrier;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "dateenregistrement")
    @Temporal(TemporalType.DATE)
    private Date dateenregistrement;
    @ManyToMany(mappedBy = "ouvrierCollection")
    private Collection<Chefservice> chefserviceCollection;

    public Ouvrier() {
    }

    public Ouvrier(Integer idouvrier) {
        this.idouvrier = idouvrier;
    }

    public Integer getIdouvrier() {
        return idouvrier;
    }

    public void setIdouvrier(Integer idouvrier) {
        this.idouvrier = idouvrier;
    }

    public String getNomouvrier() {
        return nomouvrier;
    }

    public void setNomouvrier(String nomouvrier) {
        this.nomouvrier = nomouvrier;
    }

    public String getPrenomouvrier() {
        return prenomouvrier;
    }

    public void setPrenomouvrier(String prenomouvrier) {
        this.prenomouvrier = prenomouvrier;
    }

    public String getCniouvrier() {
        return cniouvrier;
    }

    public void setCniouvrier(String cniouvrier) {
        this.cniouvrier = cniouvrier;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateenregistrement() {
        return dateenregistrement;
    }

    public void setDateenregistrement(Date dateenregistrement) {
        this.dateenregistrement = dateenregistrement;
    }

    @XmlTransient
    public Collection<Chefservice> getChefserviceCollection() {
        return chefserviceCollection;
    }

    public void setChefserviceCollection(Collection<Chefservice> chefserviceCollection) {
        this.chefserviceCollection = chefserviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idouvrier != null ? idouvrier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ouvrier)) {
            return false;
        }
        Ouvrier other = (Ouvrier) object;
        if ((this.idouvrier == null && other.idouvrier != null) || (this.idouvrier != null && !this.idouvrier.equals(other.idouvrier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.winmoney.entities.Ouvrier[ idouvrier=" + idouvrier + " ]";
    }
    
}
