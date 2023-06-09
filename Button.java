import java.awt.*;

/**
 * Button class for Finals Frenzy, creates buttons that are used in the game
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Button{
    /** Parameters for button */
    String txt;
    int x;
    int y;
    int w;
    int h;
    
    /**
     * Button contructor
     * @param text
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Button(String text, int x, int y, int w, int h){
        txt = text;

        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public void display(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, w, h, 10, 10);

        x += 10;
        y += 35;

        String[] words = txt.split(" ");
        String[] lines = {"", "", "", ""};

        int charCount = 0;
        int index = 0;

        g.setColor(Color.BLACK);
        g.setFont(Main.font);
        for (int i = 0; i < words.length; i++){
            if (charCount + words[i].length() > w/10){

                g.setColor(Color.WHITE);
                g.fillRect(x - 10, y - 35, w, h);
                g.setColor(Color.BLACK);

                g.drawString(lines[index], x, y);

                y += 35;
                h += 40;
                index++;
                charCount = 0;
            }

            lines[index] += words[i] + " ";
            charCount += words[i].length() + 1;
        }

        g.setColor(Color.WHITE);
        if (index == 0){
            g.fillRect(x - 10, y - 35, w, h);
        } else{
            g.fillRect(x - 10, y - (index)*30, w, h - (index)*40);
        }
        g.setColor(Color.BLACK);

        g.drawString(lines[index], x, y);

        x -= 10;
        y -= (index + 1)*35;
    }

    public boolean isClicked(int xCoord, int yCoord){
        if (xCoord >= x && xCoord <= x + w && yCoord >= y && yCoord <= y + h){
            return true;
        }
        return false;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }

    public void setX(int n){
        x = n;
    }

    public void setY(int n){
        y = n;
    }

}
