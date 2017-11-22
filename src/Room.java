import java.awt.*;
import java.util.ArrayList;

// This will load our rooms and what-not
// We can edit our levels from files!
public class Room
{

    public Background background;
    public ArrayList<Character> character = new ArrayList<Character>();

    public String text = "";
    public char[] dialog;
    public String speaker = "";

    public boolean done = true;
    public boolean first = true;

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
        done = false;
        if (first) {
            System.out.print("Drawing entities...");
            try {
                background.draw(g);
            } catch (Exception e) {
                // not sure if this is safe
                System.out.println("Error drawing background with ID " + background.id);
                e.printStackTrace();
                System.exit(-3);
            }

            for (int i = 0; i < character.size(); ++i) {
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
            System.out.println("Done.");
        }

        g.setColor(new Color(0, 0, 0, 255));
        g.setFont(new Font("CALIBRE", Font.PLAIN, 25));
        /*
         * if (isTyping) { ++textPos; // g.drawString(text.substring(0, textPos), 100,
         * Screen.myHeight - 100); g.drawChars(dialog, 0, textPos - 1, 100,
         * Screen.myHeight - 100); } if (textPos > text.length()) { isTyping = false;
         * done = true; return; }
         */

        g.drawString(text, 100, Screen.myHeight - 100);

        done = true;

    }
}
