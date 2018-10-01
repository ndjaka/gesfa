package com.winmoney.modeldao;

import com.winmoney.dao.DAO;
import com.winmoney.entities.Client;
import com.winmoney.entities.ClientCommande;
import com.winmoney.entities.ClientCommandeId;
import com.winmoney.entities.Commande;
import com.winmoney.entities.Commandeproduit;
import com.winmoney.entities.CommandeproduitId;

import com.winmoney.entities.Produit;
import com.winmoney.entities.Secretaire;
import com.winmoney.interfacemodel.ISecretaireDao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.Session;

public class SecretaireDao extends DAO<Secretaire, Integer> implements ISecretaireDao {

    @Override
    public String enregistrerCommande(int idsecretaire, Commande commande, Client client, String designation, int Quantite) {

        CommandeDao commandeDao = new CommandeDao();
        ClientDao clientDao = new ClientDao();
        ProduitDao dao = new ProduitDao();

        CommandeProduitDao commandeProduitDao = new CommandeProduitDao();
        Commandeproduit commandeProduit = new Commandeproduit();
        ClientCommande clientCommande = new ClientCommande();

        /**
         * ******** enregistrement du client et de sa commande ************
         */
        ClientCommandeDao clientCommandeDao = new ClientCommandeDao();
        Client client_existant = findClientByLogin(client.getAdressemail());

        logger.info("client dans la bd" + client.toString());
        
        if (!client_existant.equals(client)) {

            Client client1 = clientDao.save(client);// enregistremet client

            commande.setDatecommande(new Date());

            Commande commande1 = commandeDao.save(commande);//enregistremet commande

            clientCommande.setId(new ClientCommandeId(client1.getIdclient(), commande1.getIdcommande()));

            clientCommandeDao.save(clientCommande); //enregistremet client et sa commande

            Produit produit = findProduitByDesignation(designation);

            BigDecimal prixTotal = BigDecimal.valueOf(Quantite * produit.getPrixunitaire());

            commandeProduit.setPrixtotal(prixTotal);
            commandeProduit.setQuantitecommande(Quantite);
            commandeProduit.setId(new CommandeproduitId(commande.getIdcommande(), produit.getIdproduit()));

            commandeProduitDao.save(commandeProduit);// /enregistremet de la commande et le produit

            //traitement de la quantite en stock
            int etatQuantiteStock = enregistrerQuantite(produit, Quantite);

            if (etatQuantiteStock == 0) {
                return "pas pres";
            }
            if (etatQuantiteStock == 1) {
                produit.setQuantite(Quantite - produit.getQuantite());

                 //a ajouter message de notification vers le chef service pour la fabrication d'un nouveau produit
                dao.update(produit);
                return "incomplet";
            }

            if (etatQuantiteStock == 2) {
                produit.setQuantite(produit.getQuantite() - Quantite);
                dao.update(produit);
                return "complet";
            }
        }

        return null;
    }

    Produit findProduitByDesignation(String designation) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT p FROM Produit p WHERE p.designation = :designation");
        query.setParameter("designation", designation);
        Produit produit = (Produit) query.uniqueResult();
        session.close();
        return produit;
    }

    public int enregistrerQuantite(Produit produit, int qte) {

        if (produit.getQuantite() == 0 || produit.getQuantite() < 0) {

            return 0;
        } else if (produit.getQuantite() < qte && produit.getQuantite() != 0) {
            return 1;

        } else if (produit.getQuantite() > qte && produit.getQuantite() != 0) {
            return 2;
        }
        return -1;
    }

    @Override
    public Set<Commande> listerCommande() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT c FROM Commandeproduit cp INNER JOIN cp.commande ");
        return null;
    }

    @Override
    public Commande findCommandeByNameClient(String nomclient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifierDg(String numerophone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Object> ConsulterStocks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client UpdateClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Client findClientByLogin(String adressemail) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT c FROM Client c WHERE c.adressemail=:X");
        query.setParameter("X", adressemail);
        
        System.err.println("client"+query.uniqueResult().toString());
        
        Client client = (Client) query.uniqueResult();
        
        session.close();
        return client;
    }
}
