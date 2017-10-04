/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import com.insaj.entidades.Clases;
import com.insaj.entidades.Horarios;
import com.insaj.entidades.Materias;
import com.insaj.util.HibernateUtil;
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
public class HorariosController {
    public void Insertar(Horarios horar, List<Clases> clases){
        try{
     SessionFactory sesion = HibernateUtil.getSessionFactory();
     Session session;
     session = sesion.openSession();
     Transaction tx = session.beginTransaction();
     Set<Clases> setclases = new HashSet<Clases>();
      clases.forEach((k)->{
               setclases.add(k);
            });
      horar.setClaseses(setclases);
     session.merge(horar);
     tx.commit();
     session.close();
        JOptionPane.showMessageDialog(null, "Insertado correctamente");
        }catch(HibernateException ex){
         JOptionPane.showMessageDialog(null, "Error al insertar registro:"+ex.getMessage());
        }
    }
    public List executeHQLQuery(String hql) {
         List resultList= null;
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // JOptionPane.showMessageDialog(null,session.createQuery(hql),"Alerta",JOptionPane.WARNING_MESSAGE);
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
            String hql = "delete from Horarios  where idHorario = "+id;
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
    public Horarios getHorariosByID(String id) {
        String hql = "from Horarios where idHorario = "+id;
        Horarios horar= new Horarios();
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         horar = (Horarios)session.get(Horarios.class, Integer.valueOf(id)); 
        session.getTransaction().commit();
        return horar;
    } catch (HibernateException he) {
        he.printStackTrace();
        return null;
    }
    } 
     public void update(Horarios hor ){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Horarios horar = (Horarios)session.get(Horarios.class, hor.getIdHorario()); 
         horar.setUsuarios(hor.getUsuarios());
         horar.setAnio(hor.getAnio());
         session.update(horar); 
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
