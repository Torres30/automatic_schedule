/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import com.insaj.entidades.Horas;
import com.insaj.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Luis
 */
public class HorasController {
    
    public void Insertar(Horas hora){
        try{
     SessionFactory sesion = HibernateUtil.getSessionFactory();
     Session session;
     session = sesion.openSession();
     Transaction tx = session.beginTransaction();
     session.save(hora);
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
            String hql = "delete from Horas where idHora = "+id;
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
    public Horas getHorasByID(String id) {
        String hql = "from Horas where idHora = "+id;
        Horas hora= new Horas();
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        hora = (Horas)session.get(Horas.class, Integer.valueOf(id)); 
        session.getTransaction().commit();
        return hora;
    } catch (HibernateException he) {
        he.printStackTrace();
        return null;
    }
    } 
    public void update(Horas hor ){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Horas hora = (Horas)session.get(Horas.class, hor.getIdHora()); 
         hora.setHora(hor.getHora());
         hora.setTurno(hor.getTurno());
         session.update(hora); 
         tx.commit();
         JOptionPane.showMessageDialog(null, "Actualizado correctamente");
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
    public Horas getPro(int dia, String hora){
         String hql = "from Horas where dias = "+dia + " and hora = '"+hora+"'";
         System.out.println(hql);
         Session session=null;
        try {
            Horas hor = null;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            if(q.list().size()>0){
             hor = (Horas)q.list().get(0);
            }
            session.getTransaction().commit();
            return hor;
        } catch (HibernateException he) {
            he.printStackTrace();
            return null;
        }finally{
         session.close();
        }
        
    }
}
