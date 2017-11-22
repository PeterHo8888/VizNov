import java.awt.*;
import java.awt.image.BufferedImage;

public class Character
{
    public int id;
    public int x, y;

    BufferedImage image = null;

    public Character(int chID, int x, int y)
    {
        this.id = chID;
        define(id);
        this.x = x;
        this.y = y;
        System.out.println("Creating character with ID " + this.id + " @ (" + this.x + ", " + this.y + ")");
    }

    public Character(int chID, String pos)
    {
        this.id = chID;
        define(id);
        switch (pos) {
            case "middle":
                try {
                    this.x = Screen.myWidth / 2 - image.getWidth() / 2;
                    this.y = Screen.myHeight - image.getHeight();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            case "left":
                try {
                    this.x = 25;
                    this.y = Screen.myHeight - image.getHeight();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            case "right":
                try {
                    this.x = Screen.myWidth - image.getWidth() - 25;
                    this.y = Screen.myHeight - image.getHeight();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
        }
        System.out.println("Creating character with ID " + this.id + " @ (" + this.x + ", " + this.y + ")");
    }

    public void define(int id)
    {
        try {
            image = Screen.characters.get(id);
        } catch (Exception e) {
            System.out.println("Couldn't create character. Aborting");
            System.exit(0);
        }
    }

    // Draw character
    // One object per character
    public void draw(Graphics g)
    {
        g.drawImage(image, x, y, null);
    }
}
