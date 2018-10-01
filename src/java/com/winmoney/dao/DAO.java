/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winmoney.dao;




import com.winmoney.hibernate.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ndjaka
 */
public class DAO<T,U> implements IDAO<T, U>{
    
    public static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   
         
    protected Logger logger = LoggerFactory.getLogger(DAO.class);
    private Class<T> type;
    
    public DAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
 

    @Override
    public T save(T obj) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            logger.info("............succes de l'operation ...........");

        } catch (Exception e) {
            e.printStackTrace();
            if (null != session.getTransaction()) {
                session.getTransaction().rollback();
                logger.info("............erreur avortement de la transaction...........");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return obj;
    }

    @Override
    public T findById(U id) {
        Session session = sessionFactory.openSession();
        T t = null;
       
        try {
            session.beginTransaction();
            t = (T) session.load(type.getTypeName(), (Serializable) id);
               
            logger.info("l'objet  est " + t.toString());
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                logger.info(t.getClass().getSimpleName() +"n'existe pas ");
                session.getTransaction().rollback();
            }
            return t;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Collection<T> getAll() {
        Session session = sessionFactory.openSession();
        List<T> tList;
//         Query  query = session.createQuery("FROM Promoteur ");
//         query.list();
        Criteria criteria = session.createCriteria(type.getTypeName());
         logger.info(".............la liste est " + criteria.list().toString());
        tList =  criteria.list();
        logger.info(".............la liste est " + tList.toString());
        return tList;
    }

    @Override
    public void delete(U id) {
        Session session = sessionFactory.openSession();
        T t;
        try {
            session.beginTransaction();
            t = (T) session.get(type.getTypeName(), (Serializable) id);
            session.delete(t);
            session.getTransaction().commit();
            logger.info(".............le produit n " + id + " a bien ete supprimer.................. ");

        } catch (Exception e) {
            e.printStackTrace();
            if (null != session.getTransaction()) {
                logger.info(".............avortement de la transaction");
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) session.close();

        }
    }

    @Override
    public T update(T t) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            logger.info("............succes de l'operation ...........");

        } catch (Exception e) {
            e.printStackTrace();
            if (null != session.getTransaction()) {
                        session.getTransaction().rollback();
                logger.info("............erreur avortement de la transaction...........");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }

    
}
