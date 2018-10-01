package com.winmoney.entities;
// Generated 25 sept. 2018 22:38:54 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProduitService generated by hbm2java
 */
@Entity
@Table(name="produit_service"
    ,schema="public"
)
public class ProduitService  implements java.io.Serializable {


     private ProduitServiceId id;
     private Produit produit;
     private Service service;

    public ProduitService() {
    }

    public ProduitService(ProduitServiceId id, Produit produit, Service service) {
       this.id = id;
       this.produit = produit;
       this.service = service;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idservice", column=@Column(name="idservice", nullable=false) ), 
        @AttributeOverride(name="idproduit", column=@Column(name="idproduit", nullable=false) ) } )
    public ProduitServiceId getId() {
        return this.id;
    }
    
    public void setId(ProduitServiceId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idproduit", nullable=false, insertable=false, updatable=false)
    public Produit getProduit() {
        return this.produit;
    }
    
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idservice", nullable=false, insertable=false, updatable=false)
    public Service getService() {
        return this.service;
    }
    
    public void setService(Service service) {
        this.service = service;
    }




}


