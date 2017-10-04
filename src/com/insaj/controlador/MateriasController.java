
package com.insaj.controlador;

import com.insaj.entidades.Materias;
import com.insaj.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MateriasController {
    public void Insertar(Materias materia){
        try{
     SessionFactory sesion = HibernateUtil.getSessionFactory();
     Session session;
     session = sesion.openSession();
     Transaction tx = session.beginTransaction();
     session.save(materia);
     tx.commit();
     session.close();
        JOptionPane.showMessageDialog(null, "Insertado correctamente");
        }catch(HibernateException ex){
         JOptionPane.showMessageDialog(null, "Error al insertar registro: "+ex.getMessage());
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
            String hql = "delete from Materias where idMateria = "+id;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            rowCount = query.executeUpdate();
            //session.getTransaction().commit();//Realiza la transaccion
            JOptionPane.showMessageDialog(null, "Eliminado con Exito! Filas afectadas: "+rowCount);
            session.close();
         
        }catch(HibernateException he){
            JOptionPane.showMessageDialog(null, "Error al Eliminar Registro: "+he.getMessage());
           
        }
    }
    public Materias getMateriaByID(String id) {
        String hql = "from Materias where idMateria = "+id;
        Materias mates= new Materias();
        try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         mates = (Materias)session.get(Materias.class, Integer.valueOf(id)); 
        session.getTransaction().commit();
        return mates;
    } catch (HibernateException he) {
        he.printStackTrace();
        return null;
    }
    } 
     public void update(Materias mat ){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Materias mates = (Materias)session.get(Materias.class, mat.getIdMateria()); 
         mates.setNombre(mat.getNombre());
         mates.setTipo(mat.getTipo());
         session.update(mates); 
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
