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
 * MatierePremiereProduit generated by hbm2java
 */
@Entity
@Table(name="matiere_premiere_produit"
    ,schema="public"
)
public class MatierePremiereProduit  implements java.io.Serializable {


     private MatierePremiereProduitId id;
     private Matierepremiere matierepremiere;
     private Produit produit;

    public MatierePremiereProduit() {
    }

    public MatierePremiereProduit(MatierePremiereProduitId id, Matierepremiere matierepremiere, Produit produit) {
       this.id = id;
       this.matierepremiere = matierepremiere;
       this.produit = produit;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idproduit", column=@Column(name="idproduit", nullable=false) ), 
        @AttributeOverride(name="idmatierepremiere", column=@Column(name="idmatierepremiere", nullable=false) ) } )
    public MatierePremiereProduitId getId() {
        return this.id;
    }
    
    public void setId(MatierePremiereProduitId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idmatierepremiere", nullable=false, insertable=false, updatable=false)
    public Matierepremiere getMatierepremiere() {
        return this.matierepremiere;
    }
    
    public void setMatierepremiere(Matierepremiere matierepremiere) {
        this.matierepremiere = matierepremiere;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idproduit", nullable=false, insertable=false, updatable=false)
    public Produit getProduit() {
        return this.produit;
    }
    
    public void setProduit(Produit produit) {
        this.produit = produit;
    }




}

