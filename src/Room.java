import java.awt.*;
import java.util.ArrayList;

// This will load our rooms and what-not
// We can edit our levels from files!
public class Room
{
    
    public Background background;
    public ArrayList<Character> character = new ArrayList<Character>();
    public ArrayList<Integer> indexes = new ArrayList<Integer>(); // cos i can't figure anything out atm
    
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
        
    }
}
