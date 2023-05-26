import java.awt.Font;
import java.awt.Graphics;

public class Slide {
    String txt;
    
    public Slide(String text){
        txt = text;
    }

    public void display(Graphics g){
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        int y = 250;

        for (int i = 0; i < txt.length(); i++){
            if (i % 80 == 0){
                y += 30;
            }
            g.drawString(txt.substring(i,i+1), 350, y);
        }


    }
}
