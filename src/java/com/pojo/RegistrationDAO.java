/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import com.util.NewHibernateUtil;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author MORAD HOSSAIN
 */
public class RegistrationDAO {

    public boolean doInsert(Registration reg) throws SQLException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Serializable ser = s.save(reg);
        s.getTransaction().commit();
        s.close();
        if (ser != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doLogin(String username, String password) throws SQLException {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Registration where username=:a and password=:b");
        q.setString("a", username);
        q.setString("b", password);
        List list = q.list();
        if (list.size() == 1) {
            return true;
        } else {
            return false;
        }

    }

    public List<Registration> showAllStudent() {
        List<Registration> li = new ArrayList<>();
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Registration");
        li = q.list();
        return li;
    }
}
