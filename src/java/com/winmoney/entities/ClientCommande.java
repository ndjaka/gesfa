
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
 * ClientCommande generated by hbm2java
 */
@Entity
@Table(name="client_commande"
    ,schema="public"
)
public class ClientCommande  implements java.io.Serializable {


     private ClientCommandeId id;
     private Client client;
     private Commande commande;

    public ClientCommande() {
    }

    public ClientCommande(ClientCommandeId id, Client client, Commande commande) {
       this.id = id;
       this.client = client;
       this.commande = commande;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idclient", column=@Column(name="idclient", nullable=false) ), 
        @AttributeOverride(name="idcommande", column=@Column(name="idcommande", nullable=false) ) } )
    public ClientCommandeId getId() {
        return this.id;
    }
    
    public void setId(ClientCommandeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idclient", nullable=false, insertable=false, updatable=false)
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idcommande", nullable=false, insertable=false, updatable=false)
    public Commande getCommande() {
        return this.commande;
    }
    
    public void setCommande(Commande commande) {
        this.commande = commande;
    }




}

