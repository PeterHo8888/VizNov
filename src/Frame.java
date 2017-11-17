import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame
{
    private static final long serialVersionUID = 2601549676963257235L;
    
    // TODO: Read title from file
    public static String title = "VizNov";
    public static Dimension size = new Dimension (1280,720);

    public Frame()
    {
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    public void init()
    {
        setLayout(new GridLayout(1, 1, 0, 0));
        
        Screen screen = new Screen();
        add(screen);
        
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Frame();
    }
}
