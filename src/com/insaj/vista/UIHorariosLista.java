
package com.insaj.vista;

import com.insaj.controlador.ClasesController;
import com.insaj.controlador.HorariosController;
import com.insaj.entidades.Clases;
import com.insaj.entidades.Docentes;
import com.insaj.entidades.Horarios;
import com.insaj.entidades.Roles;
import com.insaj.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;


public class UIHorariosLista extends javax.swing.JFrame {

    HorariosController control = new HorariosController();
      ClasesController clases= new ClasesController();
    public UIHorariosLista() {
        initComponents();
        llenarCbbDeparts();
        MostrarDatos(control.executeHQLQuery("from Horarios"));
    }

     private void MostrarDatos(List<Horarios> horari) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("ID");
        tableHeaders.add("AÑO");
        tableHeaders.add("CREADO POR");
        List<Horarios> list = new ArrayList<>(horari);
        for (Object o : list) {
            Horarios cla = (Horarios) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(cla.getIdHorario());
            oneRow.add(cla.getAnio());
            oneRow.add(cla.getUsuarios().getUsuario());
          
            tableData.add(oneRow);
        }
        tableHorarios.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableHorarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableHorarios);

        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnVer.setText("VER");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnVer))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       UIHorario horario = new UIHorario();
       horario.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
                int row = tableHorarios.getSelectedRow();
                if(row==-1){
                   JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla","Alerta",JOptionPane.WARNING_MESSAGE);
                }else{
                    String tableClick = (tableHorarios.getModel().getValueAt(row, 0)).toString();
                    control.Borrar(tableClick);
                    MostrarDatos(control.executeHQLQuery("From Horarios"));//actuliza la tabla
                }
             } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, ex);
             }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        try {
                int row = tableHorarios.getSelectedRow();
                if(row==-1){
                   JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla","Alerta",JOptionPane.WARNING_MESSAGE);
                }else{
                    String tableClick = (tableHorarios.getModel().getValueAt(row, 0)).toString();
                    UIHorarioMostrar mostrar = new UIHorarioMostrar();
                    Horarios ho = control.getHorariosByID(tableClick);
                    List<Clases> classDocente = new ArrayList<>();
                    List<Clases> clases = new ArrayList<>(ho.getClaseses());
                    Docentes docent = (Docentes)jComboBox1.getSelectedItem();
                    if(docent != null){
                        clases.forEach((k)->{

                          if(k.getDocentes().getIdDocente() == docent.getIdDocente()){
                           classDocente.add(k);
                          }
                    
                           });
                    }
                    if(classDocente.size()>0){
                         mostrar.MostrarDatos(classDocente);
                    }else{
                    mostrar.MostrarDatos(clases);
                    }
                    mostrar.setVisible(true);
                }
             } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, ex);
             }
    }//GEN-LAST:event_btnVerActionPerformed
public void llenarCbbDeparts(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Docentes> lista = (List<Docentes>)session.createQuery("from Docentes").list();
        try{
            jComboBox1.setModel(new DefaultComboBoxModel(lista.toArray()));
            jComboBox1.setSelectedIndex(-1);
        }catch(Exception ex){
        //error
        JOptionPane.showMessageDialog(null, "Error al cargar los Docentes");
        }
        
     }
    
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
            java.util.logging.Logger.getLogger(UIHorariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIHorariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIHorariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIHorariosLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIHorariosLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHorarios;
    // End of variables declaration//GEN-END:variables
}
