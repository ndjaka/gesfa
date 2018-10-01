/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.modeldao;

import com.winmoney.dao.DAO;
import com.winmoney.entities.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ndjaka
 */
public class PromoteurDao extends DAO<Promoteur, Integer> implements com.winmoney.modeldao.IPromoteurDao {
    protected Logger logger = LoggerFactory.getLogger(PromoteurDao.class);

     DgDao dgDao = new com.winmoney.modeldao.DgDao();
     SecretaireDao secretaireDao = new SecretaireDao();
     ChefserviceDao chefserviceDao = new ChefserviceDao();

    // manipulation du directeur general
    @Override
    public Dg addDg(Dg dg, int idPromoteur) {
        dg.setPromoteur(new Promoteur(idPromoteur));
        dg.setEtat(Boolean.TRUE);
        dg.setDatecreation(new Date());
       return  dgDao.save(dg);
   }

    @Override
    public void DeleteDg(int id) {
     
       dgDao.deleteDg(id);
    }

    @Override
    public Dg updateDg(Dg dg) {
       Dg  dg1 = dgDao.findById(dg.getIduser());
            dg1 .setAdressemail( dg .getAdressemail());
            dg1.setPrenom( dg .getPrenom());
            dg1 .setNom( dg .getNom());
            dg1 .setLogin( dg .getLogin());
            dg1 .setMotdepasse( dg .getMotdepasse());
            dg1 .setDatecreation(new Date());
            dg1 .setTelephone( dg .getTelephone());
      return dgDao.update(dg1);
      }

    @Override
    public Dg findDg(int id) {

        return dgDao.findById(id);
    }

    @Override
    public List<Dg> findAllDg() {
       Session session = sessionFactory.openSession();
       Query query = session.createQuery("SELECT dg FROM Dg dg WHERE dg.etat = TRUE");
       
       
        return query.list();
          }


    // manipulation de la secretaire
    @Override
    public Secretaire addSecreatire(Secretaire secretaire, int idPromoteur) {

        secretaire.setPromoteur(new Promoteur(idPromoteur));
        secretaire.setEtat(true);
        secretaire.setDatecreation(new Date());
        return secretaireDao.save(secretaire);
    }

    @Override
    public void DeleteSecretaire(int id) {
           Secretaire secretaire = secretaireDao.findById(id);
           secretaire.setEtat(false);
           secretaireDao.update(secretaire);
    }

    @Override
    public Secretaire updateSecretaire(Secretaire secretaire) {
       Secretaire secretaire1 = secretaireDao.findById(secretaire.getIduser());
        secretaire1.setAdressemail(secretaire.getAdressemail());
        secretaire1.setPrenom(secretaire.getPrenom());
        secretaire1.setNom(secretaire.getNom());
        secretaire1.setLogin(secretaire.getLogin());
        secretaire1.setMotdepasse(secretaire.getMotdepasse());
        secretaire1.setDatecreation(new Date());
        secretaire1.setTelephone(secretaire.getTelephone());

        return secretaireDao.update(secretaire1);
    }

    @Override
    public Secretaire findSecretaire(int id) {
        Session session = sessionFactory.openSession();
         Secretaire secretaire = secretaireDao.findById(id);
         Query query = session.createQuery("FROM Commande c WHERE c.secretaireId = :id");
         query.setParameter("id",id);
         Set<Commande> commandes =(Set<Commande>) query.list();
         secretaire.setCommandes(commandes);
        return secretaire;
    }

    ///manipulation du secretaire
    @Override
    public Chefservice addChefService(Chefservice chefservice, int idPromoteur) {
                 chefservice.setPromoteur(new Promoteur(idPromoteur));
                 chefservice.setEtat(true);
                 chefservice.setDatecreation(new Date());
                 return chefserviceDao.save(chefservice);
    }

    @Override
    public void DeleteChefService(int id) {
        Chefservice chefservice = chefserviceDao.findById(id);
        chefservice.setEtat(false);
        chefserviceDao.update(chefservice);
    }

    @Override
    public Chefservice updateChefService(Chefservice chefservice) {
       Chefservice chefservice1 = chefserviceDao.findById(chefservice.getIduser());
        chefservice1.setAdressemail( chefservice.getAdressemail());
        chefservice1.setPrenom(chefservice.getPrenom());
        chefservice1.setNom( chefservice.getNom());
        chefservice1.setLogin( chefservice.getLogin());
        chefservice1.setMotdepasse( chefservice.getMotdepasse());
        chefservice1.setDatecreation(new Date());
        chefservice1.setTelephone( chefservice.getTelephone());
        return chefserviceDao.update(chefservice1);
    }

    @Override
    public Chefservice findChefService(int id) {
        Session session = sessionFactory.openSession();
        Chefservice chefservice = chefserviceDao.findById(1);
        
        Query query = session.createQuery("FROM Service s WHERE s.chefserviceId =:id");
        query.setParameter("id", id);
        Set<Service> services = (Set<Service>) query.list();
        chefservice.setServices(services);
         
//        Query query1 = session.createQuery("SELECT o FROM Ouvrier o WHERE o.chefserviceCollection.iduser=:id");
//        query1.setParameter("id", id);
//        chefservice.setOuvrierCollection(query1.list());
//   
        Query query2 = session.createQuery("SELECT p From Produit p WHERE p.chefserviceId=:id");
        query2.setParameter("id", id);
        Set<Produit> produits = ( Set<Produit>)query2.list();
        chefservice.setProduits(produits);
        
        return chefservice;
    }

    @Override
    public List<Chefservice> findAllChefService() {
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery("SELECT c FROM Chefservice c WHERE c.etat = TRUE");
       
        return query.list();
    }


    
       
        
    
    
    
}
