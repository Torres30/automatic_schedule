
package com.insaj.entidades;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class MyRenderer extends DefaultTableCellRenderer {
    List<Celdas> celdas;
    List<Celdas> celds;

    public MyRenderer(List<Celdas> celdas) {
        this.celdas = celdas;
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
{ 
    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    
    if (! table.isRowSelected(row))
    { 

            //boolean finder = celdas.stream().allMatch(t -> t.getColumna()== column && t.getFila() == row);
            celds = 
    celdas.stream()
                .filter(t -> t.getColumna()== column && t.getFila() == row)
                .collect(Collectors.toList());
           
           if(celds.size()>0){
            c.setBackground(celds.get(0).getDocente().getColor());
            c.setForeground(Color.white);
           } 
           else{
            c.setBackground(table.getBackground()); 
            c.setForeground(Color.black);
           }
            // row == Celda.getFila() && column == Celda.getColumna()
            //c.setBackground(new java.awt.Color(0, 0, 255));
    }
    return c; 
} 

}
