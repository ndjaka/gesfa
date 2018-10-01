package com.winmoney.entities;
// Generated 25 sept. 2018 22:38:54 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ouvrier generated by hbm2java
 */
@Entity
@Table(name="ouvrier"
    ,schema="public"
)
public class Ouvrier  implements java.io.Serializable {


     private int idouvrier;
     private String cniouvrier;
     private Date dateenregistrement;
     private String nomouvrier;
     private String prenomouvrier;
     private String telephone;
     private Set<ChefServiceOuvrier> chefServiceOuvriers = new HashSet<ChefServiceOuvrier>(0);

    public Ouvrier() {
    }

	
    public Ouvrier(int idouvrier) {
        this.idouvrier = idouvrier;
    }
    public Ouvrier(int idouvrier, String cniouvrier, Date dateenregistrement, String nomouvrier, String prenomouvrier, String telephone, Set<ChefServiceOuvrier> chefServiceOuvriers) {
       this.idouvrier = idouvrier;
       this.cniouvrier = cniouvrier;
       this.dateenregistrement = dateenregistrement;
       this.nomouvrier = nomouvrier;
       this.prenomouvrier = prenomouvrier;
       this.telephone = telephone;
       this.chefServiceOuvriers = chefServiceOuvriers;
    }
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idouvrier")
    public int getIdouvrier() {
        return this.idouvrier;
    }
    
    public void setIdouvrier(int idouvrier) {
        this.idouvrier = idouvrier;
    }

    
    @Column(name="cniouvrier", length=254)
    public String getCniouvrier() {
        return this.cniouvrier;
    }
    
    public void setCniouvrier(String cniouvrier) {
        this.cniouvrier = cniouvrier;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dateenregistrement", length=13)
    public Date getDateenregistrement() {
        return this.dateenregistrement;
    }
    
    public void setDateenregistrement(Date dateenregistrement) {
        this.dateenregistrement = dateenregistrement;
    }

    
    @Column(name="nomouvrier", length=254)
    public String getNomouvrier() {
        return this.nomouvrier;
    }
    
    public void setNomouvrier(String nomouvrier) {
        this.nomouvrier = nomouvrier;
    }

    
    @Column(name="prenomouvrier", length=254)
    public String getPrenomouvrier() {
        return this.prenomouvrier;
    }
    
    public void setPrenomouvrier(String prenomouvrier) {
        this.prenomouvrier = prenomouvrier;
    }

    
    @Column(name="telephone", length=254)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ouvrier")
    public Set<ChefServiceOuvrier> getChefServiceOuvriers() {
        return this.chefServiceOuvriers;
    }
    
    public void setChefServiceOuvriers(Set<ChefServiceOuvrier> chefServiceOuvriers) {
        this.chefServiceOuvriers = chefServiceOuvriers;
    }




}


