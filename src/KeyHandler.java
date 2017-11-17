import java.awt.event.*;

import javax.swing.JPanel;

public class KeyHandler extends Screen
{
    public KeyHandler() {
        addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent me) { 
              System.out.println(me); 
            } 
          });
    }
    
 

}
