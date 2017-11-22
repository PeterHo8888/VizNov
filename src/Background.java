import java.awt.*;
import java.awt.image.BufferedImage;

public class Background
{
    public int id;

    BufferedImage image = null;

    public Background(int bgID)
    {
        this.id = bgID;
        define(bgID);
        System.out.println("Creating background with ID " + this.id);
    }

    public void define(int id)
    {
        try {
            image = Screen.backgrounds.get(id);
        } catch (Exception e) {
            System.out.println("Couldn't create background. Aborting");
            System.exit(0);
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, 0, 0, null);
    }

}
