
package com.insaj.vista;

import com.insaj.controlador.HorasController;
import com.insaj.controlador.SeccionesController;
import com.insaj.entidades.Celdas;
import com.insaj.entidades.Clases;
import com.insaj.entidades.Docentes;
import com.insaj.entidades.Horas;
import com.insaj.entidades.MyRenderer;
import com.insaj.entidades.Secciones;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import static java.util.stream.Collectors.toList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.quinto.swing.table.model.IModelFieldGroup;
import org.quinto.swing.table.model.ModelData;
import org.quinto.swing.table.model.ModelField;
import org.quinto.swing.table.model.ModelFieldGroup;
import org.quinto.swing.table.model.ModelRow;
import org.quinto.swing.table.view.CustomTableHeaderRenderer;
import org.quinto.swing.table.view.JBroTable;


public class UIHorarioMostrar extends javax.swing.JFrame {

    /**
     * Creates new form UIHorarioMostrar
     */
    List<Celdas> listaCeldas;
    public UIHorarioMostrar() {
        initComponents();
         listaCeldas = new ArrayList<>();  
    }
    public void MostrarDatos(List<Clases> clases) {
        /*Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("HORA");
        tableHeaders.add("SECCION");
        tableHeaders.add("DOCENTE");
        tableHeaders.add("AULA");
        List<Clases> list = new ArrayList<>(clases);
        for (Object o : list) {
            Clases cla = (Clases) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(cla.getHoras().getHora());
            oneRow.add(cla.getSecciones().toString());
            oneRow.add(cla.getDocentes().toString());
            oneRow.add(cla.getAulas().getNumero());
            tableData.add(oneRow);
        }
        tbleHorario.setModel(new DefaultTableModel(tableData, tableHeaders));*/
           //INICIA JBROTABLE
             SeccionesController control = new SeccionesController();
        HorasController controlHoras = new HorasController();
 //       ClasesController controlClases = new ClasesController();
        List<Secciones> sec = control.executeHQLQuery("From Secciones");
        List<Horas> horas = controlHoras.executeHQLQuery("From Horas h order by h.dias asc, h.idHora asc");
        List<String> dayofhours =horas.stream().map(Horas::toString).collect(toList());//captura todos los dias incluyendo repetidos
        List<String> dias = dayofhours.stream().distinct().collect(toList());//captura dias sin repetir
    List<Docentes> docents = new ArrayList<>();
   int Cabnum = 0;//numero secuencial de cabecera
   List<String> getHoras =horas.stream().map(Horas::getHoraTurno).collect(toList());//captura todos las horas en strings
   List<String> horas_no_re = getHoras.stream().distinct().collect(toList());//captura las horas anteriores sin repetir
   IModelFieldGroup groups2[] = new IModelFieldGroup[dias.size()+1]; 
    groups2[0]= new ModelField("hora","HORA");
     for (int y=0;y<dias.size();y++) {
        ModelFieldGroup dia = new ModelFieldGroup("abc"+y, dias.get(y).toUpperCase());
        
        for (int x = 0; x < sec.size(); x++) {
            dia.withChild(new ModelField(sec.get(x).getIdSeccion().toString()+Cabnum, sec.get(x).toString().toLowerCase()));
           // System.err.println("DAtos: "+sec.get(x).getIdSeccion().toString()+Cabnum+" "+sec.get(x).toString());
            Cabnum++;
        }
        groups2[y+1]= dia;
     }
 
       ModelField fields[] = ModelFieldGroup.getBottomFields( groups2 );
    
      ModelRow rows[] = new ModelRow[ horas_no_re.size() ];
      for ( int i = 0; i < rows.length; i++ )
      rows[ i ] = new ModelRow( fields.length );
    
      ModelData data2 = new ModelData( groups2 );
      data2.setRows(rows);
      
      //INSERTANDO LAS HORAS
         for (int i = 0; i < horas_no_re.size(); i++) {
             data2.setValue(i,0, horas_no_re.get(i));
         }
         getHoras =horas.stream().map(Horas::getHora).collect(toList());//captura todos las horas en strings
         horas_no_re = getHoras.stream().distinct().collect(toList());//captura las horas anteriores sin repetir
         
        List<Integer> dias_int =horas.stream().map(Horas::getDias).collect(toList());//captura todos los dias incluyendo repetidos
        List<Integer> dias_int_list = dias_int.stream().distinct().collect(toList());//captura dias sin repetir
        Cabnum = 0;
      
      for(int a =0;a<horas_no_re.size();a++){
          Cabnum=0;
         for (int b=0;b<dias_int_list.size();b++) {
             for(int c =0;c<sec.size();c++){
                 Cabnum++;//para llevar el control de las materias
                 for(int d=0;d<clases.size();d++){
                     // System.out.println("hora:"+a+" "+" dia: "+b+" seccion: "+c+ " clase:"+d + " ordinal de clase: "+Cabnum)
                     if(clases.get(d).getHoras().getHora().equals(horas_no_re.get(a)) && clases.get(d).getSecciones().getIdSeccion().equals(sec.get(c).getIdSeccion()) && clases.get(d).getHoras().getDias()== dias_int_list.get(b)){
                       data2.setValue(a,Cabnum, clases.get(d).getMaterias());
                      listaCeldas.add(new Celdas(a, Cabnum, clases.get(d).getMaterias().getNombre(), clases.get(d).getDocentes()));
                 }
                 }
             }
         }
      }
      
      JBroTable tableBRO = new JBroTable( data2 );
      tableBRO.getTableHeader().getUI().setCustomRenderer( new CustomTableHeaderRenderer() {
        @Override
        public Component getTableCellRendererComponent( Component originalComponent, JBroTable table, Object value, boolean isSelected, boolean hasFocus, boolean isDragged, int row, int viewColumn, int modelColumn, IModelFieldGroup dataField ) {
          if ( dataField == null || !( originalComponent instanceof JLabel ) )
            return originalComponent;
          JLabel ret = ( JLabel )originalComponent;
          ret.setHorizontalAlignment( "LAST_NAME".equals( dataField.getIdentifier() ) ? SwingConstants.CENTER : SwingConstants.CENTER );
          ret.setFont( ret.getFont().deriveFont( ("abc0").equals( dataField.getIdentifier())
                  || ("abc1").equals( dataField.getIdentifier()) 
                  || ("abc2").equals( dataField.getIdentifier()) 
                  || ("abc3").equals( dataField.getIdentifier()) 
                  || ("hora").equals( dataField.getIdentifier()) 
                  || ("abc4").equals( dataField.getIdentifier()) ? Font.BOLD : Font.PLAIN ) );

          return ret;
        }
      } );
      tableBRO.setRowHeight(25);
      tableBRO.setAutoResizeMode(AUTO_RESIZE_OFF);
       MyRenderer myRenderer = new MyRenderer(listaCeldas); //aqui se le pone el color a las celdas
      tableBRO.setDefaultRenderer(Object.class, myRenderer);
   //FINALIZA JBROTABE
        jScrollPane1.getViewport ().add (tableBRO);
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
                pn.setBackground(clases.get(i).getDocentes().getColor());
                jPanel1.add(pn);
            }
           }
        }
//FIN IMPRIMIR LOS COLORES DE DOCENTES
        GridLayout lay = new GridLayout(docents.size(), 2, 5,5);
        jPanel1.setLayout(lay);
        pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(UIHorarioMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIHorarioMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIHorarioMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIHorarioMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIHorarioMostrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
