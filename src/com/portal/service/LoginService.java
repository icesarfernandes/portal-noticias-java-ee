package com.portal.service;

/**
 * Created by italo on 15/05/17.
 */
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.portal.hibernate.util.HibernateUtil;
import com.portal.model.UsersEntity;

import javax.persistence.TypedQuery;

public class LoginService {

    public boolean authenticateUser(String usuario, String senha) {
        UsersEntity user = getUserByUserId(usuario);
        if(user!=null && user.getUsuario().equals(usuario) && user.getSenha().equals(senha)){
            return true;
        }else{
            return false;
        }
    }

    public UsersEntity getUserByUserId(String username) {
        Session session = HibernateUtil.openSession();
        List<UsersEntity> result = new ArrayList<>();
        try {
            TypedQuery<UsersEntity> query = session.createQuery("FROM UsersEntity WHERE usuario = " + username);
            result = query.getResultList();
            session.close();
            return result.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result.get(0);
    }

    public List<UsersEntity> getListOfUsers(){
        List<UsersEntity> list = new ArrayList<UsersEntity>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from UsersEntity").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}