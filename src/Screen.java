import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.image.*;
import javax.swing.*;

// JPanel can be attached to JFrame and you can draw on it
// or Window, w/e tf u want to call it
// Runnable makes class a thread
public class Screen extends JPanel implements Runnable
{
    private static final long serialVersionUID = -4957777078221266129L;

    // create new thread of ourselves
    public Thread thread = new Thread(this);

    public static ArrayList<BufferedImage> backgrounds = new ArrayList<BufferedImage>();
    public static ArrayList<BufferedImage> characters = new ArrayList<BufferedImage>();

    // Screen has its own size, JPanel doesn't include
    // borders or titlebar
    public static int myWidth, myHeight;

    public static boolean isFirst = true;

    public static Room room;

    public static Loader loader;

    public static File[] listBg;

    public static File[] listCh;

    public static Typewriter typewriter;

    public Screen()
    {
        setBackground(Color.PINK);
        thread.start();
    }

    public void define()
    {
        room = new Room();
        typewriter = new Typewriter();
        loader = new Loader(new File("res/game.scr"));

        // load bg
        System.out.print("Loading backgrounds...");
        File folderBg = new File("res/backgrounds/");
        listBg = folderBg.listFiles();
        for (int i = 0; i < listBg.length; ++i) {
            if (listBg[i].isFile()) {
                try {
                    backgrounds.add(ImageIO.read(listBg[i]));
                } catch (IOException e) {
                    System.out.println("Error loading backgrounds.");
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }
        System.out.println(listBg.length + " backgrounds loaded.");

        // load characters
        System.out.print("Loading characters...");
        File folderCh = new File("res/characters/");
        listCh = folderCh.listFiles();
        for (int i = 0; i < listCh.length; ++i) {
            if (listCh[i].isFile()) {
                try {
                    characters.add(ImageIO.read(listCh[i]));
                } catch (IOException e) {
                    System.out.println("Error loading characters.");
                    e.printStackTrace();
                    System.exit(-2);
                }
            }
        }
        System.out.println(listCh.length + " characters loaded.");

        loader.load("start");
        setMouseHandler();
    }

    public void setMouseHandler()
    {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me)
            {
                // REMINDER:
                // Must control if options available
                if (typewriter.isTyping()) {
                    System.out.println("Loading next.");
                    loader.load();
                }
                
                 else { typewriter.end(); }
                 

            }
        });
    }

    // this is where you draw all things
    // called by default by JPanel and repaint()
    public void paintComponent(Graphics g)
    {
        // define all our good stuff on init
        if (isFirst) {
            myWidth = getWidth();
            myHeight = getHeight();

            // create new room and stuff
            define();

            // done with init
            isFirst = false;
        }

        // draws blank space on screen
        // "clears" it
        // g.clearRect(0, 0, getWidth(), getHeight());
        room.draw(g);
    }

    // runs automatically when thread started
    public void run()
    {
        // gameloop
        // NEVER use paintComponent() for loop
        // ^Java rule
        while (true) {
            
            if(!isFirst) {
                typewriter.type(50);
            }
            repaint();
            
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                System.out.println("Couldn't sleep!");
            }

        }

    }

}
