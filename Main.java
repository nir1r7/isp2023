import javax.swing.*;
import java.awt.*;

public class Level1 extends Main{
    
    public Level1(Graphics g){
        display(g);
    }

    public void display(Graphics g){
        Drawing1 draw = new Drawing1();
        draw.paint(g);
    } 

    class Drawing1{
        
        public Drawing1(){

        }

        public void paint(Graphics g){
            l1(g);
        }

        public void l1(Graphics g){
            g.drawRect(0, 0, 100, 100);
        }
    }
}
