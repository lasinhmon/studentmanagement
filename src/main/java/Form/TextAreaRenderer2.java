/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author lasin
 */
public class TextAreaRenderer2 extends JTextArea implements TableCellRenderer {

    public TextAreaRenderer2() {
        Font font = new Font("Aparajita",0 , 12);
         setLineWrap(true);
         setWrapStyleWord(true);
         setBorder(BorderFactory.createEmptyBorder());
         setForeground(Color.BLUE);
         setFont(font);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable,
          Object obj, boolean isSelected, boolean hasFocus, int row,
          int column) {

         setText((String)obj);
         setBackground(Color.WHITE);


         return this;
     }
}
