import java.io.*;
import java.util.*;

/*
 * Bg code (-1 for no change)
 * Ch code (-1 for now change)
 * Dialog w/ logic
 */

/*
 * TODO: Change loader to read by line number
 * 
 * Loader takes in filepath and line number.
 * 
 * First run: Create 2d array associating to each label a unique line number in the file
 * 
 * On mouseclick, decide what to do.
 * 
 */

// TODO: Resolve background and characters by file name

public class Loader
{
    File file = null;
    Scanner scan = null;
    int line = 0;

    ArrayList<String> script = new ArrayList<String>();
    Hashtable<String, Integer> labels = new Hashtable<String, Integer>();

    public Loader(File loadPath)
    {
        try {
            scan = new Scanner(loadPath);
            while (scan.hasNext()) {
                script.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File %s not found.\n", loadPath.toString());
            e.printStackTrace();
        }

        scan.close();

        scanLabels();

        line = 0;
    }

    public void scanLabels()
    {
        for (int i = 0; i < script.size(); ++i) {
            String temp = script.get(i);
            if (temp.charAt(temp.length() - 1) == ':' && !temp.contains(" ")) {
                labels.put(temp.substring(0, temp.length() - 1), line);
            }
        }
    }

    public void jumpLabel(String label)
    {
        line = labels.get(label);
    }

    public void drawBackground(String background)
    {
        for (int i = 0; i < Screen.listBg.length; ++i) {
            if (Screen.listBg[i].getName().equalsIgnoreCase(background + ".png")
                    || Screen.listBg[i].getName().equalsIgnoreCase(background + ".jpg")) {
                Screen.room.background = new Background(i);
            }
        }
    }

    public void drawCharacter(String character)
    {
        String[] temp = character.split(" ");
        String chName = "";
        // number position
        if (temp[temp.length - 1].matches("[-+]?\\d*\\.?\\d+") && temp[temp.length - 2].matches("[-+]?\\d*\\.?\\d+")) {

            for (int i = 0; i < temp.length - 2; ++i) {
                chName += temp[i] + " ";
            }
            chName = chName.trim();

            for (int i = 0; i < Screen.listCh.length; ++i) {
                if (Screen.listCh[i].getName().equalsIgnoreCase(chName + ".png")) {
                    Screen.room.character.add(new Character(i, Integer.parseInt(temp[temp.length - 1]),
                            Integer.parseInt(temp[temp.length - 2])));
                }
            }
        } else {
            for (int i = 0; i < temp.length - 1; ++i) {
                chName += temp[i] + " ";
            }
            chName = chName.trim();
            for (int i = 0; i < Screen.listCh.length; ++i) {
                if (Screen.listCh[i].getName().equalsIgnoreCase(chName + ".png")) {
                    Screen.room.character.add(new Character(i, temp[temp.length - 1]));
                }
            }
        }
    }
    
    public void hideCharacter(String character)
    {        
        for (int i = 0; i < Screen.listCh.length; ++i) {
            if (Screen.listCh[i].getName().equalsIgnoreCase(character + ".png")) {
                for(int j = 0; j < Screen.room.character.size(); ++j) {
                    if(Screen.room.character.get(j).id == i) {
                        Screen.room.character.remove(j);
                        i--;
                        break;
                    }
                }
            }
        }
    }

    public void load()
    {
        if (script.size() == line) {
            System.out.println("Game over.");
            return;
        }
        String temp = script.get(line);
        String[] parts = temp.split(" ");
        String args = temp.substring(temp.indexOf(" ") + 1, temp.length());
        if (temp.charAt(0) == '\"') {
            //System.out.println(temp); // replace with call to dialog()
            Screen.room.text = temp;
            ++line;
            return;
        }
        switch (parts[0]) {
            case "draw":
                drawCharacter(args);
                break;
            case "hide":
                hideCharacter(args);
                break;
            case "bg":
                drawBackground(args);
                break;
            case "jmp":
                jumpLabel(args);
                break;

        }
        ++line;
        load();
    }

    public void load(String label)
    {
        jumpLabel(label);
        ++line;
        load();
    }

    public void error(String msg)
    {
        System.err.printf("%s:%d error: %s.\n", file.getName(), line, msg);
    }
}
