
package com.insaj.entidades;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.Enumeration;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;



class DefaultHeaderRenderer
    extends DefaultTableCellRenderer
{
    {
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    }

    public void updateUI()
    {
        super.updateUI();

        setHorizontalAlignment(CENTER);

        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    }


    public Component getTableCellRendererComponent
        (JTable table, Object value, boolean selected, boolean focused,
        int row, int column)
    {
        TableHeader header;

        if (table != null && (header = (TableHeader)table.getClientProperty(TableHeader.KEY)) != null)
        {
            setForeground(header.getForeground());
            setBackground(header.getBackground());

            setFont(header.getFont());

            setComponentOrientation(header.getComponentOrientation());

            setEnabled(header.isEnabled());
        }
        else
        {
            setForeground(UIManager.getColor("TableHeader.foreground"));
            setBackground(UIManager.getColor("TableHeader.background"));

            setFont(UIManager.getFont("TableHeader.font"));

            setComponentOrientation(ComponentOrientation.UNKNOWN);

            setEnabled(true);
        }

        setText(value != null ? value.toString() : "");

        return this;
    }
}



public class TableHeader
    extends JComponent
{
    /** TableColumn that also has a headerSpan property. */
    public static class XTableColumn
        extends TableColumn
    {
        private int headerSpan;


        public XTableColumn()
        {
            headerSpan = 1;
        }

        /** number of columns that the header cell spans. */
        public final int headerSpan()
        {
            return headerSpan;
        }

        
        public void setHeaderSpan(int newHeaderSpan)
        {
            headerSpan = newHeaderSpan;   
        }
    }


    private static TableCellRenderer staticDefaultRenderer
        = new DefaultHeaderRenderer();

    /** Under this key, the table header is stored in the JTable, so that
        the renderer can access it. See demo renderer above.
    */
    public static Object KEY = TableHeader.class;

    private JTable table;

    private transient TableColumnModel columns;

    private TableCellRenderer defaultRenderer
        = staticDefaultRenderer;


    private transient Listener listener;


   public TableHeader(JTable table)
    {
        this.table = table;

        table.putClientProperty(KEY, this);

        this.columns = table.getColumnModel();

        this.listener = createListener();

        table.addPropertyChangeListener(listener);

        columns.addColumnModelListener(listener);

        add(new CellRendererPane());

        updateUI();
    }


    public void updateUI()
    {
        LookAndFeel.installColorsAndFont
            (this, "TableHeader.background", "TableHeader.foreground",
            "TableHeader.font");

        LookAndFeel.installBorder(this, "TableHeader.border");

        if (defaultRenderer instanceof JComponent)
            ((JComponent)defaultRenderer).updateUI();

        revalidate(); repaint();
    }


    public final JTable table()
    {
        return table;
    }

    public void setTable(JTable t)
    {
        JTable oldTable = table;
        TableColumnModel oldColumns = columns;

        table.putClientProperty(KEY, null);

        table.removePropertyChangeListener(listener);

        columns.removeColumnModelListener(listener);

        table = t;

        table.putClientProperty(KEY, this);

        columns = t.getColumnModel();

        table.addPropertyChangeListener(listener);

        columns.addColumnModelListener(listener);

        revalidate(); repaint();

        firePropertyChange("table", oldTable, table);
        firePropertyChange("columns", oldColumns, columns);
    }

    public final TableColumnModel columns()
    {
        return columns;
    }

    /** For serialization, the TableCellRenderer is needed to be serializable.
     */
    public void setDefaultRenderer(TableCellRenderer r)
    {
        TableCellRenderer oldRenderer = defaultRenderer;

        defaultRenderer = r;

        revalidate(); repaint();

        firePropertyChange("defaultRenderer", oldRenderer, defaultRenderer);
    }

    public final TableCellRenderer defaultRenderer()
    {
        return defaultRenderer;
    }


    private TableCellRenderer renderer(TableColumn c)
    {
        TableCellRenderer result = c.getHeaderRenderer();

        if (result != null)
            return result;

        return defaultRenderer;
    }


    private Component component(TableCellRenderer r, TableColumn c, int column)
    {
        return r.getTableCellRendererComponent
            (table, c.getHeaderValue(), false, false, -1, column);
    }


    private Dimension size(long innerWidth)
    {
        Insets i = getInsets();

        return new Dimension((int)Math.min(innerWidth + i.left + i.bottom, Integer.MAX_VALUE), innerHeight() + i.top + i.bottom);
    }


    /** Alas, this cannot be cached. */
    private int innerHeight()
    {
        int result = 0;

        int count = columns.getColumnCount();

        for (int j = 0; j < count; )
        {
            TableColumn c = columns.getColumn(j);

            int span;

            if (c instanceof XTableColumn)
                span = ((XTableColumn)c).headerSpan();
            else
                span = 1;

            Component d = component(renderer(c), c, j);

            result = Math.max(result, d.getPreferredSize().height);

            j += span;
        }

        return result;
    }



    public Dimension getMinimumSize()
    {
        if (isMinimumSizeSet())
            return super.getMinimumSize();

        return size(minWidth(columns));
    }

    public Dimension getPreferredSize()
    {
        if (isPreferredSizeSet())
            return super.getPreferredSize();

        return size(preferredWidth(columns));
    }

    public Dimension getMaximumSize()
    {
        if (isMaximumSizeSet())
            return super.getMaximumSize();

        return size(maxWidth(columns));
    }


    public void paintComponent(Graphics g)
    {
        Insets i = getInsets();

        Rectangle clip = g.getClipBounds();

        CellRendererPane pane = (CellRendererPane)getComponent(0);

        Rectangle r = new Rectangle();

        r.x = i.left;
        r.y = i.top;
        r.height = getHeight() - i.top - i.bottom;

        if (r.height <= 0)
            return;


        int count = columns.getColumnCount();

        for (int j = 0; j < count; )
        {
            TableColumn c = columns.getColumn(j);

            r.width = c.getWidth();

            int span;

            if (c instanceof XTableColumn)
            {
                span = ((XTableColumn)c).headerSpan();

                if (j + span > count)
                {
                    System.err.println("column: "+j+" span: "+span+" > "+count);
                    System.err.println("This state of TableColumnModel is forbidden!");
                    span = count - j;
                }

                for (int k = 1; k < span; k++)
                    r.width += columns.getColumn(j + k).getWidth();
            }
            else
            {
                span = 1;
            }

            Component d = component(renderer(c), c, j);

            pane.paintComponent(g, d, this, 
                r.x, r.y, r.width, r.height, true);

            r.x += r.width;

            j += span;
        }

        pane.removeAll();
    }


    private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();

        listener = createListener();

        table.addPropertyChangeListener(listener);

        columns = table.getColumnModel();

        columns.addColumnModelListener(listener);
    }


    protected Object clone()
        throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }


    private Listener createListener()
    {
        return new Listener();
    }


    private class Listener
        implements TableColumnModelListener, PropertyChangeListener
    {
        public void propertyChange(PropertyChangeEvent e)
        {
            if (e.getPropertyName().equals("columnModel"))
            {
                TableColumnModel oldColumns = columns;

                columns.removeColumnModelListener(this);

                columns = table.getColumnModel();

                columns.addColumnModelListener(this);

                revalidate(); repaint();

                firePropertyChange("columns", oldColumns, columns);
            }
        }


        public void columnAdded(TableColumnModelEvent e)
        {
            revalidate(); repaint();
        }

        public void columnRemoved(TableColumnModelEvent e)
        {
            revalidate(); repaint();
        }

        public void columnSelectionChanged(ListSelectionEvent e)
        {
        }

        public void columnMoved(TableColumnModelEvent e)
        {
            repaint();
        }

        public void columnMarginChanged(ChangeEvent e)
        {
            revalidate(); repaint();
        }
    }  

    /* Utility methods. Copied here from TableColumnModels. */

    public static long minWidth(TableColumnModel columns)
    {
        long result = 0;

        for (Enumeration e = columns.getColumns(); e.hasMoreElements();)
            result += ((TableColumn)e.nextElement()).getMinWidth();

        return result;
    }

    public static long preferredWidth(TableColumnModel columns)
    {
        long result = 0;

        for (Enumeration e = columns.getColumns(); e.hasMoreElements();)
            result += ((TableColumn)e.nextElement()).getPreferredWidth();

        return result;
    }

    public static long maxWidth(TableColumnModel columns)
    {
        long result = 0;

        for (Enumeration e = columns.getColumns(); e.hasMoreElements();)
            result += ((TableColumn)e.nextElement()).getMaxWidth();

        return result;
    }
}


class TableHeaderExample
{
    public static void main(String[] args)
    {
        DefaultTableModel data = new DefaultTableModel(10, 0);

        data.addColumn("ABC");
        data.addColumn("DEF");
        data.addColumn("GHI");
        data.addColumn("JKL");
        data.addColumn("MNO");
        data.addColumn("PQR");

        TableColumnModel columns = new DefaultTableColumnModel();

        TableHeader.XTableColumn abc = new TableHeader.XTableColumn();
        abc.setHeaderValue("ABC");
        abc.setHeaderSpan(2);

        TableColumn ghi = new TableColumn(2);
        ghi.setHeaderValue("GHI");

        TableHeader.XTableColumn jkl = new TableHeader.XTableColumn();
        jkl.setHeaderValue("JKL");
        jkl.setHeaderSpan(3);
        jkl.setModelIndex(3);

        columns.addColumn(abc);
        columns.addColumn(new TableColumn(1));
        columns.addColumn(ghi);
        columns.addColumn(jkl);
        columns.addColumn(new TableColumn(4));
        columns.addColumn(new TableColumn(5));

        JTable table = new JTable(data, columns)
        {
            protected void configureEnclosingScrollPane()
            {
            }
        };

        table.setTableHeader(null);

        TableHeader header = new TableHeader(table);

        header.setForeground(Color.blue);
        header.setFont(header.getFont().deriveFont(18.0f));

        JScrollPane pane = new JScrollPane(table);

        pane.setColumnHeaderView(header);

        JFrame f = new JFrame();

        f.setContentPane(pane);

        f.pack();

        f.setVisible(true);
    }
}
