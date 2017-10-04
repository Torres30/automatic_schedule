/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.vista;

import com.insaj.controlador.AulasController;
import com.insaj.controlador.DialogosController;
import com.insaj.controlador.HorasController;
import com.insaj.entidades.Aulas;
import com.insaj.entidades.Horas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

/**
 *
 * @author Luis
 */
public class UIHoras extends javax.swing.JFrame {

        HorasController control = new HorasController();
    DialogosController dialogos = new DialogosController();
    public UIHoras() {
         {
        initComponents();
        MostrarDatos(control.executeHQLQuery("From Horas"));
        //A continuacion se le asigna un metodo a la caja de texto buscar.
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = txtBuscar.getText();
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                   
                }
                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    //JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla","Alerta",JOptionPane.WARNING_MESSAGE);
                    MostrarDatos(control.executeHQLQuery("From Horas where idHora where idHora like %"+txtBuscar.getText()+" or hora lik %'"+txtBuscar.getText()+"' or turno like %'"+txtBuscar.getText()+"'"));
   
                }
            }
        });
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHoras = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("HORAS A IMPRTIR PROFESORES - INSAJ");

        tablaHoras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaHoras);

        jLabel5.setText("Buscar:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(113, 113, 113))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(27, 27, 27)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tablaHoras.getSelectedRow()!=-1){//si hay un registro seleccionado pasa   
            DialogoHoras diag = new DialogoHoras();
            int row = tablaHoras.getSelectedRow();//captura la fila seleccionadad
            String tableID = (tablaHoras.getModel().getValueAt(row, 0)).toString();//guarda el id de la columna seleccionada
             try{
                 diag.txtIdHora.setText(tableID);//muestra el id en el textfield
                     Horas hora = control.getHorasByID(tableID);
                     //mostarando los datos en texfields
                      diag.txtHora.setText(hora.getHora());
                      diag.txtTurno.setText(hora.getTurno());
                      diag.addWindowListener(new WindowAdapter() {
                             @Override
                             public void windowClosed(WindowEvent e)  {
                                 // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                 MostrarDatos(control.executeHQLQuery("From Horas"));
                             }
                     });
                     dialogos.MostrarNuevoDialogo(diag, "Editar Horas");
                 
             }catch(HibernateException he){
                 //mostrar mensaje error
             }
    }else{
            JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla","Alerta",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla","Alerta",JOptionPane.WARNING_MESSAGE);
        MostrarDatos(control.executeHQLQuery("From Horas where idHora where idHora like %"+txtBuscar.getText()+" or hora lik %'"+txtBuscar.getText()+"' or turno like %'"+txtBuscar.getText()+"'"));
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        DialogoHoras dialogo =  new DialogoHoras();
        dialogo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e)  {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                MostrarDatos(control.executeHQLQuery("From Horas"));
            }
        });
        dialogos.MostrarNuevoDialogo(dialogo, "Nueva Hora");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            try {
                int row = tablaHoras.getSelectedRow();
                if(row==-1){
                   JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla","Alerta",JOptionPane.WARNING_MESSAGE);
                }else{
                    String tableClick = (tablaHoras.getModel().getValueAt(row, 0)).toString();
                    control.Borrar(tableClick);
                    MostrarDatos(control.executeHQLQuery("From Horas"));//actuliza la tabla
                }
             } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, ex);
             }
    }//GEN-LAST:event_btnEliminarActionPerformed

         private void MostrarDatos(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("ID");
        tableHeaders.add("DIA");
        tableHeaders.add("HORA");
        tableHeaders.add("TURNO");

        for (Object o : resultList) {
            Horas hora = (Horas) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(hora.getIdHora());
            oneRow.add(hora.toString());
            oneRow.add(hora.getHora());
            oneRow.add(hora.getTurno());
            tableData.add(oneRow);
        }
        tablaHoras.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIHoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIHoras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHoras;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
