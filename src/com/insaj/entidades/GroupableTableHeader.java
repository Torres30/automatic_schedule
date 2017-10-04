
package com.insaj.entidades;

import java.awt.Component;
import java.util.Enumeration;
import java.util.Vector;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class GroupableTableHeader extends JTableHeader {
  private static final String uiClassID = "GroupableTableHeaderUI";
  protected Vector columnGroups = null;
    
  public GroupableTableHeader(TableColumnModel model) {
    super(model);
    setUI(new GroupableTableHeaderUI());
    setReorderingAllowed(false);
  }

  public void updateUI(){
  // setUI(new GroupableTableHeaderUI());
 /*  TableCellRenderer renderer = getDefaultRenderer();
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
      if (renderer instanceof Component) {
          SwingUtilities.updateComponentTreeUI((Component)renderer);
      }*/
 
    TableCellRenderer staticDefaultRenderer
        = new DefaultHeaderRenderer();
   TableCellRenderer defaultRenderer
        = staticDefaultRenderer;
  LookAndFeel.installColorsAndFont
            (this, "TableHeader.background", "TableHeader.foreground",
            "TableHeader.font");

        LookAndFeel.installBorder(this, "TableHeader.border");

        if (defaultRenderer instanceof JComponent)
            ((JComponent)defaultRenderer).updateUI();

        revalidate(); repaint();
  }
  
 
  public void setReorderingAllowed(boolean b) {
    reorderingAllowed = false;
  }
    
  public void addColumnGroup(ColumnGroup g) {
    if (columnGroups == null) {
      columnGroups = new Vector();
    }
    columnGroups.addElement(g);
  }

  public Enumeration getColumnGroups(TableColumn col) {
    if (columnGroups == null) return null;
    Enumeration e = columnGroups.elements();
    while (e.hasMoreElements()) {
      ColumnGroup cGroup = (ColumnGroup)e.nextElement();
      Vector v_ret = (Vector)cGroup.getColumnGroups(col,new Vector());
      if (v_ret != null) { 
  return v_ret.elements();
      }
    }
    return null;
  }
  
  public void setColumnMargin() {
    if (columnGroups == null) return;
    int columnMargin = getColumnModel().getColumnMargin();
    Enumeration e = columnGroups.elements();
    while (e.hasMoreElements()) {
      ColumnGroup cGroup = (ColumnGroup)e.nextElement();
      cGroup.setColumnMargin(columnMargin);
    }
  }
  
}
