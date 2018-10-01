package com.winmoney.entities;
// Generated 25 sept. 2018 22:38:54 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Service generated by hbm2java
 */
@Entity
@Table(name="service"
    ,schema="public"
)
public class Service  implements java.io.Serializable {


     private int idservice;
     private Chefservice chefservice;
     private String nomservice;
     private Set<ProduitService> produitServices = new HashSet<ProduitService>(0);

    public Service() {
    }

	
    public Service(int idservice, Chefservice chefservice) {
        this.idservice = idservice;
        this.chefservice = chefservice;
    }
    public Service(int idservice, Chefservice chefservice, String nomservice, Set<ProduitService> produitServices) {
       this.idservice = idservice;
       this.chefservice = chefservice;
       this.nomservice = nomservice;
       this.produitServices = produitServices;
    }
   
    @Id 
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idservice")
    public int getIdservice() {
        return this.idservice;
    }
    
    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="chefservice_id", nullable=false)
    public Chefservice getChefservice() {
        return this.chefservice;
    }
    
    public void setChefservice(Chefservice chefservice) {
        this.chefservice = chefservice;
    }

    
    @Column(name="nomservice", length=254)
    public String getNomservice() {
        return this.nomservice;
    }
    
    public void setNomservice(String nomservice) {
        this.nomservice = nomservice;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="service")
    public Set<ProduitService> getProduitServices() {
        return this.produitServices;
    }
    
    public void setProduitServices(Set<ProduitService> produitServices) {
        this.produitServices = produitServices;
    }




}

