package com.portal.service;

/**
 * Created by italo on 15/05/17.
 */
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.portal.hibernate.util.HibernateUtil;
import com.portal.model.UsersEntity;

import javax.persistence.TypedQuery;

public class RegistroService {

    public boolean register(UsersEntity user){
        Session session = HibernateUtil.openSession();
        if(isUserExists(user)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public boolean isUserExists(UsersEntity user){
        Session session = HibernateUtil.openSession();
        boolean result = false;
        try{
            TypedQuery<UsersEntity> query = session.createQuery("FROM UsersEntity WHERE usuario = " + user.getUsuario());
            UsersEntity userResult = query.getSingleResult();
            if(userResult != null) result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return result;
    }
}