import java.awt.*;

public class Button{
    String txt;
    int x;
    int y;
    int w;
    int h;
    
    public Button(String text, int x, int y, int w, int h){
        txt = text;

        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public void display(Graphics g){
        x += 10;
        y += 35;

        String[] words = txt.split(" ");
        String[] lines = {"", "", "", ""};

        int charCount = 0;
        int index = 0;

        for (int i = 0; i < words.length; i++){
            if (charCount + words[i].length() > w/10){
                g.drawString(lines[index], x, y);

                y += 35;
                h += 40;
                index++;
                charCount = 0;
            }

            lines[index] += words[i] + " ";
            charCount += words[i].length() + 1;
        }
        g.drawString(lines[index], x, y);

        x -= 10;
        y -= (index + 1)*35;
        g.drawRect(x, y, w, h);
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
