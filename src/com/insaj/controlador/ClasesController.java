/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import com.insaj.entidades.Clases;
import com.insaj.entidades.Horas;
import com.insaj.entidades.Materias;
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
public class ClasesController {
    public void Insertar(Clases clase){
        try{
     SessionFactory sesion = HibernateUtil.getSessionFactory();
     Session session;
     session = sesion.openSession();
     Transaction tx = session.beginTransaction();
     session.save(clase);
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
            String hql = "delete from Clases where idClase = "+id;
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
    public Clases getClasesByID(String id) {
        String hql = "from Clases where idClase = "+id;
        Clases clas= new Clases();
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         clas = (Clases)session.get(Clases.class, Integer.valueOf(id)); 
        session.getTransaction().commit();
        return clas;
    } catch (HibernateException he) {
        he.printStackTrace();
        return null;
    }
    } 
    public void update(Clases cla ){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Clases clas = (Clases)session.get(Clases.class, cla.getIdClase()); 
         clas.setAulas(cla.getAulas());
         clas.setDocentes(cla.getDocentes());
         clas.setHoras(cla.getHoras());
         clas.setSecciones(cla.getSecciones());
         session.update(clas); 
         tx.commit();
         JOptionPane.showMessageDialog(null, "Actualizado correctamente");
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
    public Clases getClasePro(int dia,String hora, int seccion){
   
    /* String hql = "from Clases where idHora = "+control.getPro(dia, hora).getIdHora()+
                  " and idSeccion = "+seccion;
        System.out.println(hql);
        Session session= null;
         try {
            Clases cla = null;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            if(q.list().size()>0){
             cla = (Clases)q.list().get(0);
            }
            session.getTransaction().commit();
            return cla;
        } catch (HibernateException he) {
            he.printStackTrace();
            return null;
        }finally{
         session.close();
         }*/
    return null;
    }
}
