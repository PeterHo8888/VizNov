
public class Typewriter
{
    private int x = 0;
    
    private String text;
    
    public boolean isTyping = true;

    public Typewriter() {
        this.x = 0;
        isTyping = false;
    }
    
    public void type(int speed) {
        if(x < text.length() * speed) {
            ++x;
            isTyping = false;
        } else {
            isTyping = true;
        }
        Screen.room.text = text.substring(0, x / speed);
    }
    
    public void set(String text) {
        this.text = text;
        this.x = 0;
    }

}
