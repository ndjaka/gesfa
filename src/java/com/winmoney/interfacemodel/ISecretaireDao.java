package com.winmoney.interfacemodel;



import com.winmoney.entities.Client;
import com.winmoney.entities.Commande;
import com.winmoney.entities.Produit;
import java.util.Set;
import java.util.Vector;

public interface ISecretaireDao {
    
    String enregistrerCommande(int idsecretaire , Commande commande,Client client,String designation,int Quantite);
     Client UpdateClient(Client client);
    Set<Commande> listerCommande();
    Commande findCommandeByNameClient(String nomclient);
    void notifierDg(String numerophone);
     Vector<Object> ConsulterStocks();
    
}
