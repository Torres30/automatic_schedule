/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.vista;

import com.insaj.controlador.ClasesController;
import com.insaj.controlador.HorasController;
import com.insaj.controlador.SeccionesController;
import com.insaj.entidades.Aulas;
import com.insaj.entidades.Celdas;
import com.insaj.entidades.Clases;
import com.insaj.entidades.Docentes;
import com.insaj.entidades.Horas;
import com.insaj.entidades.MyRenderer;
import com.insaj.entidades.Secciones;
import com.sun.org.apache.bcel.internal.Constants;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;


public class Calendar extends javax.swing.JFrame {

    List<Celdas> listaCeldas;
    Random r = new Random();
    public Calendar() {
        initComponents();
        listaCeldas = new ArrayList<>();
        //GridLayout layout = new GridLayout(20, 2);
        //SpringLayout lay = new SpringLayout();
        //jPanel1.setLayout(lay);
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(922, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        SeccionesController control = new SeccionesController();
        HorasController controlHoras = new HorasController();
        ClasesController controlClases = new ClasesController();
        List<Secciones> sec = control.executeHQLQuery("From Secciones");
        List<Horas> horas = controlHoras.executeHQLQuery("From Horas");
        List<Clases> clases = controlClases.executeHQLQuery("From Clases");
        for (int i = 0; i < clases.size(); i++) {
            if(clases.get(i).getDocentes().getColor()==null){
             clases.get(i).getDocentes().setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            }
        }
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("HORA");//AGREGA EL HEADER DE LAS HORAS
        for (int i = 0; i < sec.size(); i++) {
           tableHeaders.add(sec.get(i).toString());  
        }
        for (int i = 0; i < horas.size(); i++) {  // 20.NUMERO DE FILAS(SERA NUMERO DE HORAS)
             Vector<Object> oneRow = new Vector<Object>();
             oneRow.add(horas.get(i).getHora()); //AQUI VA IR LA HORA
             int z = i;
            
            for (int j = 0; j < sec.size(); j++) {//NUMERO DE SECCIONES
                int x = j;
                int aux = 0;
                for(int k = 0;k<clases.size();k++){
                     if(clases.get(k).getSecciones().toString().equals(sec.get(x).toString()) && clases.get(k).getHoras().getIdHora().equals(horas.get(z).getIdHora())){
                        oneRow.add(clases.get(k).getMaterias().getNombre());
                        
                       // int[] fiveRandomNumbers = r.ints(3, 0, 11).toArray();
                        int index = r.nextInt(255);
                        listaCeldas.add(new Celdas(i, j+1, clases.get(k).getMaterias().getNombre(), clases.get(k).getDocentes()));
                        aux++;
                     }
                }
               if(aux == 0){
                 oneRow.add(""); //SI NO HAY MATERIA, DEJAR EN BLANCO
               }
               
            }
            
            tableData.add(oneRow);
        }
       
        MyRenderer myRenderer = new MyRenderer(listaCeldas); 
        jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
        jTable1.setDefaultRenderer(Object.class, myRenderer);
        List<Docentes> docents = new ArrayList<>();
  //INICIA MOSTRAR COLORES DE DOCENTES       
        for (int i = 0; i < clases.size(); i++) {
            int check=0;
            if(docents.isEmpty()){
                docents.add(clases.get(i).getDocentes());
                jPanel1.add(new Label(clases.get(i).getDocentes().getNombres()));
                JPanel pn = new JPanel();
                pn.setBackground(clases.get(i).getDocentes().getColor());
                jPanel1.add(pn);
            }else{
            for(int e =0;e<docents.size();e++){
                if(docents.get(e).equals(clases.get(i).getDocentes())){
                    check++;
                }
            }
            if(check==0){
                //JOptionPane.showMessageDialog(null,clases.get(i).getDocentes().getColor() );
                docents.add(clases.get(i).getDocentes());
                jPanel1.add(new Label(clases.get(i).getDocentes().getNombres()));
                JPanel pn = new JPanel();
                pn.setSize(10, 10);
                pn.setBackground(clases.get(i).getDocentes().getColor());
                jPanel1.add(pn);
            }
           }
        }
//FIN IMPRIMIR LOS COLORES DE DOCENTES
        GridLayout lay = new GridLayout(docents.size(), 2, 5,5);
        jPanel1.setLayout(lay);
        
        this.pack();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
