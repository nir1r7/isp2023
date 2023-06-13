import java.awt.*;

/**
 * Button class for Finals Frenzy, creates buttons that are used in the game
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Button{
    /** Parameters for button */
    private String txt;
    private int x;
    private int y;
    private int w;
    private int h;
    
    /**
     * Button contructor
     * @param text text of button
     * @param x x value of button
     * @param y y value of button
     * @param w width of button
     * @param h height of button
     */
    public Button(String text, int x, int y, int w, int h){
        txt = text;

        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    /**
     * Displays the button
     * @param g graphics
     */
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
        g.setFont(Main.getMainFont());
        /** Displays text in lines */
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

    /**
     * Checks if button is clicked
     * @param xCoord x coordinate of mouse
     * @param yCoord y coordinate of mouse
     * @return boolean whether the button was clicked or not
     */
    public boolean isClicked(int xCoord, int yCoord){
        if (xCoord >= x && xCoord <= x + w && yCoord >= y && yCoord <= y + h){
            return true;
        }
        return false;
    }

    /**
     * Gets the x value
     * @return x value
     */
    public int getX(){
        return x;
    }

    /**
     * Gets the y value
     * @return y value
     */
    public int getY(){
        return y;
    }

    /**
     * Gets the width
     * @return width
     */
    public int getW(){
        return w;
    }

    /**
     * Gets the height
     * @return height
     */
    public int getH(){
        return h;
    }
    
    /**
     * Sets the x value
     * @param n the value to set it to
     */
    public void setX(int n){
        x = n;
    }

    /**
     * Sets the y value
     * @param n the value to set it to
     */
    public void setY(int n){
        y = n;
    }

    /**
     * Sets the w of the button
     * @param n the value to set it to
     */
    public void setW(int n){
        w = n;
    }

    /**
     * Gets the text of the button
     * @return txt
     */
    public String getText(){
        return txt;
    }

}
