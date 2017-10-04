
package com.insaj.vista;


import com.insaj.controlador.AulasController;
import com.insaj.controlador.ClasesController;
import com.insaj.controlador.DocentesController;
import com.insaj.controlador.HorariosController;
import com.insaj.controlador.HorasController;
import com.insaj.controlador.MateriasController;
import com.insaj.controlador.SeccionesController;
import com.insaj.entidades.Aulas;
import com.insaj.entidades.Celdas;
import com.insaj.entidades.Clases;
import com.insaj.entidades.ColumnGroup;
import com.insaj.entidades.TableHeader;
import com.insaj.entidades.Docentes;
import com.insaj.entidades.GroupableTableHeader;
import com.insaj.entidades.Horarios;
import com.insaj.entidades.Horas;
import com.insaj.entidades.Materias;
import com.insaj.entidades.MyRenderer;
import com.insaj.entidades.Secciones;
import com.insaj.entidades.Usuarios;
import com.insaj.generador.Data;
import com.insaj.generador.GeneticAlgorithm;
import com.insaj.generador.Population;
import com.insaj.generador.Schedule;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.time.DayOfWeek;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import static java.util.stream.Collectors.toList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.quinto.swing.table.model.IModelFieldGroup;
import org.quinto.swing.table.model.ModelData;
import org.quinto.swing.table.model.ModelField;
import org.quinto.swing.table.model.ModelFieldGroup;
import org.quinto.swing.table.model.ModelRow;
import org.quinto.swing.table.view.CustomTableHeaderRenderer;
import org.quinto.swing.table.view.JBroTable;


public class UIHorario extends javax.swing.JFrame {
    MateriasController matcontrol = new MateriasController();
    AulasController aucontrol = new AulasController();
    DocentesController docencontrol = new DocentesController();
    HorariosController horControl = new HorariosController();
    HorasController horascontroles = new HorasController();
    SeccionesController seccionesControler = new SeccionesController();
    ClasesController claseControler = new ClasesController();
    Usuarios user = new Usuarios();
    List<Clases> clases =  new ArrayList<>();
    public static final int POPULATION_SIZE = 9; 
    public static final double  MUTATION_RATE = 0.1;//0.1
    public static final double CROSSOVER_RATE = 0.9;//0.9
    public static final int TOURNAMENT_SELECTION_SIZE = 3;//3
    public static final int NUMB_OF_ELITE_SCHEDULES = 1;
    private Data data;
    private int classNumb= 1;
    private int scheduleNumb=0;
    List<Celdas> listaCeldas;
    Random r = new Random();
    DefaultTableModel dm = new DefaultTableModel();
    public UIHorario() {
        initComponents();
        List<Materias> listMat = matcontrol.executeHQLQuery("from Materias");
        List<Aulas> listAula = aucontrol.executeHQLQuery("from Aulas");
        List<Docentes> listaDocen = docencontrol.executeHQLQuery("from Docentes");
        List<Horas> listaHoras = horControl.executeHQLQuery("from Horas h order by h.turno desc");
        List<Secciones> listaSecciones = seccionesControler.executeHQLQuery("from Secciones");
        data = new Data(listAula, listaDocen, listMat, listaSecciones, listaHoras); 
        listaCeldas = new ArrayList<>();  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbleHorario = new javax.swing.JTable();
        btnGenerarHorarios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        btnVerDatos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtAnio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        tbleHorario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbleHorario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGenerarHorarios.setText("Generar Horario");
        btnGenerarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarHorariosActionPerformed(evt);
            }
        });

        btnVerDatos.setText("VER DATOS");
        btnVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDatosActionPerformed(evt);
            }
        });

        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Año:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGenerarHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addGap(13, 13, 13)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarHorariosActionPerformed
        
        try{
        int generatioNumber = 0; 
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(this.data);
        Population population = new Population(this.POPULATION_SIZE, this.data).sortByFitness();
        this.classNumb = 1;
         
         
          while (population.getSchedules().get(0).getFitness() !=1.0) { //antes 1.0
         // while (population.getSchedules().get(0).getNumbOfConflicts() !=1.0) { //antes 1.0
             
            System.out.println(">Generation # "+ ++generatioNumber);
            System.out.print(" Schedule  #  |                                          ");
            System.out.print(" Classes [dep,class,room,instructor,meeting-time]        ");
            System.out.println("                                  | Fitness | conflicts");
            System.out.print("---------------------------------------------------astable-------------------");
            System.out.println("--------------------------------------------------asctable--------------------");
            
           population = geneticAlgorithm.evolve(population).sortByFitness();
          
            this.scheduleNumb = 0;
           population.getSchedules().forEach(schedule -> 
                    System.out.println("          "+this.scheduleNumb++ +
                                                                             "   | "+
                                                                             String.format("%.5f", schedule.getFitness())+
                                                                             " | " + schedule.getNumbOfConflicts()));
           this.printScheduleAsTable(population.getSchedules().get(0), generatioNumber);
            
            this.classNumb = 1;
            if(generatioNumber==6000){
              break;
              }
            
        }
          if(generatioNumber==6000){
           JOptionPane.showMessageDialog(null, "Error, Los datos no son factibles");
          }else{
            setClases(population.getSchedules().get(0).getClasses());
            MostrarDatos(population.getSchedules().get(0).getClasses());
          }
         //this.printScheduleAsTable(population.getSchedules().get(0), generatioNumber);
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"No fue posible generar el horario. "+ ex.getMessage());
        }
    }//GEN-LAST:event_btnGenerarHorariosActionPerformed

    private void btnVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDatosActionPerformed
        DialogoData data = new DialogoData();
        data.setVisible(true);
    }//GEN-LAST:event_btnVerDatosActionPerformed

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public List<Clases> getClases() {
        return clases;
    }

    public void setClases(List<Clases> clases) {
        this.clases = clases;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtAnio.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Campos vacios. llena los campos");
        }else{
        HorariosController control = new HorariosController();
        Horarios horar = new Horarios(getUser(),txtAnio.getText());
        control.Insertar(horar,getClases());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void printScheduleAsTable(Schedule schedule, int generation){
      /*  ArrayList<Clases> classes = schedule.getClasses();
        System.out.print("\n                         ");
        System.out.println("Class #  | Dept  | Course (Number, max # of students) | RoomCap  | Instructor | Meetingtime ");
        System.out.print("                       ");
        System.out.print("------------------------------------");
        System.out.println("----------------------------------------");
        classes.forEach(x->{
        int majorIndex = data.getDepts().indexOf(x.getSecciones());
        int coursesIndex = data.getCourses().indexOf(x.getMaterias());
        int roomindex = data.getRooms().indexOf(x.getAulas());
        int instrctorIndex = data.getInstructors().indexOf(x.getDocentes());
        int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getHoras());
            System.out.print("                        ");
            System.out.print(String.format(" %1$02d ", classNumb)+ "   |   ");
            System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getSeccion())+" | ");
            JOptionPane.showMessageDialog(null,"clase size: "+ classes.size()+" Class materias:"+x.getMaterias()+" Data materias:"+data.getCourses().get(0)+" " +data.getCourses().get(1)+" "+data.getCourses().get(2)+" " +data.getCourses().get(3)  );
            System.out.print(String.format("%1$21s", data.getCourses().get(0).getNombre())+
                    " ( "+data.getCourses().get(0).getIdMateria()+ ", "+
                    x.getMaterias().getTipo()+")     | ");
            System.out.print(String.format("%1$10s", data.getRooms().get(roomindex).getNumero()+
                    " ("+x.getAulas().getCapacidad())+ ")   | ");
            System.out.print(String.format("%1$15s", data.getInstructors().get(0).toString()+
                    " ("+data.getInstructors().get(0).getIdDocente()+ ")")+ " | ");
            System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getHora()+
                    " ("+data.getMeetingTimes().get(meetingTimeIndex).getIdHora()+")");
            
            classNumb++;
        });*/
    }
     private void MostrarDatos(List<Clases> clases) {        
        SeccionesController control = new SeccionesController();
        HorasController controlHoras = new HorasController();
 //       ClasesController controlClases = new ClasesController();
        List<Secciones> sec = control.executeHQLQuery("From Secciones");
        List<Horas> horas = controlHoras.executeHQLQuery("From Horas h order by h.dias asc, h.idHora asc");
      //  List<Clases> clases = controlClases.executeHQLQuery("From Clases");
        for (int i = 0; i < clases.size(); i++) {
            if(clases.get(i).getDocentes().getColor()==null){
             clases.get(i).getDocentes().setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            } 
        }
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("HORA");//AGREGA EL HEADER DE LAS HORAS
        
        //CAPURANDO LOS DIAS
        List<String> dayofhours =horas.stream().map(Horas::toString).collect(toList());//captura todos los dias incluyendo repetidos
        List<String> dias = dayofhours.stream().distinct().collect(toList());//captura dias sin repetir
        
    /*     for (String dia : dias) {
           //  JOptionPane.showMessageDialog(null, dia);
           //captura la cabecera de secciones por dia
                for (int i = 0; i < sec.size(); i++) {
                   tableHeaders.add(sec.get(i).toString());  
                }
                
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
                       // listaCeldas.add(new Celdas(i, j+1, clases.get(k).getMaterias().getNombre(), clases.get(k).getDocentes()));
                        aux++;
                     }
                }
               if(aux == 0){
                 oneRow.add(""); //SI NO HAY MATERIA, DEJAR EN BLANCO
               }
               
            }
            
            tableData.add(oneRow);
        }
        
       // MyRenderer myRenderer = new MyRenderer(listaCeldas); //aqui se le pone el color a las celdas
        dm = new DefaultTableModel(tableData,tableHeaders);//tableHeaders 
        
        //CODIGO PRUEBAS
        JTable table = new JTable( dm ) {
            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
          };
        //termina codigo nuevo
        tbleHorario.setModel(dm);
       // tbleHorario.setDefaultRenderer(Object.class, myRenderer);
        List<Docentes> docents = new ArrayList<>();
        //MODIFICANDO LOS HEADER
       TableColumnModel cm = table.getColumnModel();
        ColumnGroup g_name = new ColumnGroup("LUNES");
        g_name.add(cm.getColumn(1));
        g_name.add(cm.getColumn(2));
        g_name.add(cm.getColumn(3));
        ColumnGroup g_lang = new ColumnGroup("MARTES");
        g_lang.add(cm.getColumn(4));
        g_lang.add(cm.getColumn(5));
        g_lang.add(cm.getColumn(6));
        ColumnGroup g_other = new ColumnGroup("MIERCOLES");
        g_other.add(cm.getColumn(7));
        g_other.add(cm.getColumn(8));
        g_other.add(cm.getColumn(9));
        ColumnGroup g_jueve = new ColumnGroup("JUEVES");
        g_jueve.add(cm.getColumn(10));
        g_jueve.add(cm.getColumn(11));
        g_jueve.add(cm.getColumn(12));
        ColumnGroup g_vier = new ColumnGroup("VIERNES");
        g_vier.add(cm.getColumn(13));
        g_vier.add(cm.getColumn(14));
        g_vier.add(cm.getColumn(15));
        GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
        header.addColumnGroup(g_name);
        header.addColumnGroup(g_lang);
        header.addColumnGroup(g_other);
        header.addColumnGroup(g_jueve);
        header.addColumnGroup(g_vier);
        pack();*/
   //INICIA JBROTABLE
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
            java.util.logging.Logger.getLogger(UIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIHorario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarHorarios;
    private javax.swing.JButton btnVerDatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbleHorario;
    private javax.swing.JTextField txtAnio;
    // End of variables declaration//GEN-END:variables
}
