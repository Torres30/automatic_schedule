/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import com.insaj.entidades.Docentes;
import com.insaj.entidades.Materias;
import com.insaj.util.HibernateUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DocentesController {
    
        public void Insertar(Docentes docen, List<Materias> materias){
        try{
           // Materias mat =  new Materias("nueva", "nueva");
     SessionFactory sesion = HibernateUtil.getSessionFactory();
     Session session;
     session = sesion.openSession();
     Transaction tx = session.beginTransaction();
     Set<Materias> setmat = new HashSet<Materias>();
      materias.forEach((k)->{
               setmat.add(k);
            });
    
     docen.setMaterias(setmat);
     session.merge(docen);
     tx.commit();
     session.close();
        JOptionPane.showMessageDialog(null, "Insertado correctamente");
        }catch(HibernateException ex){
         JOptionPane.showMessageDialog(null, "Error al insertar registro: "+ ex.getMessage());
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
            String hql = "delete from Docentes where idDocente = "+id;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            rowCount = query.executeUpdate();
            //session.getTransaction().commit();//Realiza la transaccion
            JOptionPane.showMessageDialog(null, "Eliminado con Exito! Filas afectadas: "+rowCount);
            session.close();
         
        }catch(HibernateException he){
            JOptionPane.showMessageDialog(null, "Error al Eliminar Registro:"+he.getMessage());
           
        }
    }
    public Docentes getDocentesByID(String id) {
        String hql = "from Docentes where idDocente = "+id;
        Docentes docen= new Docentes();
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         docen = (Docentes)session.get(Docentes.class, Integer.valueOf(id)); 
        session.getTransaction().commit();
        return docen;
    } catch (HibernateException he) {
        he.printStackTrace();
        return null;
    }
    } 
     public void update(Docentes doc ,  List<Materias> materias){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Docentes docen = (Docentes)session.get(Docentes.class, doc.getIdDocente()); 
         docen.setNombres(doc.getNombres());
         docen.setApellidos(doc.getApellidos());
         docen.setContrato(doc.getContrato());
         docen.setNumHorasPlanta(doc.getNumHorasPlanta());
         docen.setNumHorasClases(doc.getNumHorasClases());
         docen.setR(doc.getR());
         docen.setG(doc.getG());
         docen.setB(doc.getB());
         Set<Materias> setmat = new HashSet<Materias>();
      materias.forEach((k)->{
               setmat.add(k);
            });
         docen.setMaterias(setmat);
         session.merge(docen); 
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
