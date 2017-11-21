import java.awt.*;
import java.util.ArrayList;

// This will load our rooms and what-not
// We can edit our levels from files!
public class Room
{
    
    public Background background;
    public ArrayList<Character> character = new ArrayList<Character>();
    
    public String text = "";
    
    public Room()
    {
        define();
    }

    public void define()
    {

    }
    
    // will be called with Screen's Graphics object
    public void draw(Graphics g)
    {
        // draw the bg
        background.draw(g);
        
        // TODO: add loop for each character
        // for each character in room
        //   draw character[x]
        for(int i = 0; i < character.size(); ++i) {
            try {
                character.get(i).draw(g);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Value of i: " + i);
                System.exit(0);
            }
        }
        
        g.setColor(new Color(255, 255, 255, 200));
        g.fillRect(0, Screen.myHeight - 200, Screen.myWidth, 200);
        g.setColor(new Color(0, 0, 0, 255)); 
        g.setFont(new Font("CALIBRE", Font.BOLD, 25));
        g.drawString(text, 100, Screen.myHeight - 125);
    }
}
