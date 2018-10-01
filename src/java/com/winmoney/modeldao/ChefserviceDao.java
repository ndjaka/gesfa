package com.winmoney.modeldao;

import com.winmoney.dao.DAO;
import com.winmoney.entities.Chefservice;
import com.winmoney.entities.Client;
import com.winmoney.entities.Commande;

public class ChefserviceDao extends DAO<Chefservice,Integer> implements IChefserviceDao {

    @Override
    public Commande ConsulterCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
