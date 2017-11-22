import java.awt.*;
import java.util.ArrayList;

// This will load our rooms and what-not
// We can edit our levels from files!
public class Room
{
    
    public Background background;
    public ArrayList<Character> character = new ArrayList<Character>();
    
    public String text = "";
    public String speaker = "";
    
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
        
        try {
            background.draw(g);
        } catch (Exception e) {
            // not sure if this is safe
            System.out.println("Erroro drawing background with ID " + background.id);
            e.printStackTrace();
            System.exit(-3);
        }
        
        for(int i = 0; i < character.size(); ++i) {
            try {
                character.get(i).draw(g);
            } catch (Exception e) {
                // not sure if this is safe
                System.out.println("Error drawing character with ID " + character.get(i).id);
                e.printStackTrace();
                System.exit(-4);
            }
        }
        
        g.setColor(new Color(255, 255, 255, 200));
        g.fillRect(0, Screen.myHeight - 200, Screen.myWidth, 200);
        

        g.setColor(new Color(0, 0, 0, 255)); 
        g.setFont(new Font("CALIBRE", Font.PLAIN, 25));
        g.drawString(speaker, 75, Screen.myHeight - 150);
        
        // TODO: Typewriter effect
        g.setColor(new Color(0, 0, 0, 255)); 
        g.setFont(new Font("CALIBRE", Font.PLAIN, 25));
        g.drawString(text, 100, Screen.myHeight - 100);
    }
}
