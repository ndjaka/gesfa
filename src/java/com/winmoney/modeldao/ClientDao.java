/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.modeldao;

import com.winmoney.hibernate.HibernateUtil;
import com.winmoney.dao.DAO;
import com.winmoney.entities.Client;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ndjaka
 */
public class ClientDao extends DAO<Client, Integer> implements com.winmoney.modeldao.IClientDao {
    private final SessionFactory  sessionFactory1 = HibernateUtil.getSessionFactory();
            private final Logger logger = LoggerFactory.getLogger(ClientDao.class);
   
    @Override
    public Client getClientByTelephone(String Phone) {
        Session session = sessionFactory1.openSession();
                
               
                Query query =  session.createQuery("FROM Client c WHERE c.telephone = :telephone");
                      query.setParameter("telephone", Phone.trim());
      
       return (Client)query.uniqueResult();
    }

    
}
