/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import com.insaj.entidades.Usuarios;
import com.insaj.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class loginController {
    public Usuarios validarLogin(String user, String pass){
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sesion.createCriteria(Usuarios.class); 
        criteria.add(Restrictions.eq("usuario", user));
        Usuarios u = (Usuarios) criteria.uniqueResult(); 
        if(u!=null){
            if(u.getPassword().equals(pass)){
              return u;
            }else{
              return null;
            }   
        }else{
            return null;
        }
    }
}
