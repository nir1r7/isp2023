import java.awt.*;

public class CenteredButton extends Button{
    String txt;
    int x;
    int y;
    int w;
    int h;
    
    public CenteredButton(String text, int x, int y, int w, int h){
        super(text, x, y, w, h);
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
}