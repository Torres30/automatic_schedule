/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import com.insaj.entidades.Aulas;
import com.insaj.entidades.Materias;
import com.insaj.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AulasController {
    public void Insertar(Aulas aulas){
        try{
     SessionFactory sesion = HibernateUtil.getSessionFactory();
     Session session;
     session = sesion.openSession();
     Transaction tx = session.beginTransaction();
     session.save(aulas);
     tx.commit();
     session.close();
        JOptionPane.showMessageDialog(null, "Insertado correctamente");
        }catch(HibernateException ex){
         JOptionPane.showMessageDialog(null, "Error al insertar registro");
        }
    }
    public List executeHQLQuery(String hql) {
         List resultList= null;
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         //JOptionPane.showMessageDialog(null,session.createQuery(hql),"Alerta",JOptionPane.WARNING_MESSAGE);
        Query q = session.createQuery(hql);
        resultList = q.list();
        session.getTransaction().commit();
        return resultList;
    } catch (HibernateException he) {
        he.printStackTrace();
        return resultList;
    }
    }
    public void Borrar(String id){
        int rowCount = 0;
        try{
            String hql = "delete from Aulas where idAula = "+id;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            rowCount = query.executeUpdate();
            //session.getTransaction().commit();//Realiza la transaccion
            JOptionPane.showMessageDialog(null, "Eliminado con Exito! Filas afectadas: "+rowCount);
            session.close();
         
        }catch(HibernateException he){
            JOptionPane.showMessageDialog(null, "Error al Eliminar Registro");
           
        }
    }
    public Aulas getAulasByID(String id) {
        String hql = "from Aulas where idAula = "+id;
        Aulas aulas= new Aulas();
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         aulas = (Aulas)session.get(Aulas.class, Integer.valueOf(id)); 
        session.getTransaction().commit();
        return aulas;
    } catch (HibernateException he) {
        he.printStackTrace();
        return null;
    }
    } 
     public void update(Aulas au ){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Aulas aulas = (Aulas)session.get(Aulas.class, au.getIdAula()); 
         aulas.setNumero(au.getNumero());
         aulas.setCapacidad(au.getCapacidad());
         session.update(aulas); 
         tx.commit();
         JOptionPane.showMessageDialog(null, "Actualizado correctamente");
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
    
}
