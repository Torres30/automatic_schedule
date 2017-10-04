/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import com.insaj.entidades.Materias;
import com.insaj.entidades.Secciones;
import com.insaj.util.HibernateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class SeccionesController {
    public int Insertar(Secciones secci, List<Materias> materias){
       try{
     SessionFactory sesion = HibernateUtil.getSessionFactory();
     Session session;
     session = sesion.openSession();
     Transaction tx = session.beginTransaction();
    //  Set<Materias> setmat = new HashSet<Materias>();
      List<Materias> setmat = new ArrayList<Materias>();
       materias.forEach((k)->{
               setmat.add(k);
            });
     secci.setMateriases(setmat);
     session.merge(secci);
     tx.commit();
        session.close();
        return 1;
        }catch(HibernateException ex){
            return 0;
         
        }
    }
    public List executeHQLQuery(String hql) {
         List resultList= null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
        // JOptionPane.showMessageDialog(null,session.createQuery(hql),"Alerta",JOptionPane.WARNING_MESSAGE);
        Query q = session.createQuery(hql);
        resultList = q.list();
        session.getTransaction().commit();
        return resultList;
    } catch (HibernateException he) {
        he.printStackTrace();
        return resultList;
    }finally{
         session.close(); 
        }
        
    }
    public void Borrar(String id){
        int rowCount = 0;
        try{
            String hql = "delete from Secciones where idSeccion = "+id;
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
    public Secciones getSeccionesByID(String id) {
        Secciones secci= new Secciones();
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         secci = (Secciones)session.get(Secciones.class, Integer.valueOf(id)); 
        session.getTransaction().commit();
        return secci;
    } catch (HibernateException he) {
        he.printStackTrace();
        return null;
    }
    } 
     public void update(Secciones sec ,List<Materias> materias){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Secciones secci = (Secciones)session.get(Secciones.class, sec.getIdSeccion()); 
         secci.setEspecialidad(sec.getEspecialidad());
         secci.setAnio(sec.getAnio());
         secci.setSeccion(sec.getSeccion());
         //Set<Materias> setmat = new HashSet<Materias>();
         List<Materias> setmat = new ArrayList<Materias>();
         materias.forEach((k)->{
                     setmat.add(k);
            });
         secci.setMateriases(setmat);
         session.merge(secci);
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
