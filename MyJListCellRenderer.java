import java.awt.Color;  
import java.awt.Component;  
import javax.swing.DefaultListCellRenderer;  
import javax.swing.JList;  


class MyJListCellRenderer extends DefaultListCellRenderer {  
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {  
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );  
            if ( index % 2 == 0 ) {  
                c.setBackground( new Color(235,235,235) );  
}            else {  
                c.setBackground( new Color(204,204,204) );  
            }
            if (isSelected) {
             c.setBackground(new Color(7,66,60));
            }  
            return c;  
        }  
    }  

