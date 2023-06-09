import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Obstacle class for Finals Frenzy, creates obstacles used throughout the game
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Obstacle{
    double x;
    double y;
    int w;
    int h;
    boolean good;
    BufferedImage img;

    Button y0;
    Button n0;
    Button y1;
    Button n1;
    Button y2;
    Button n2;

    Button y3;
    Button n3;

    Button y4;
    Button n4;
    Button y5;
    Button n5;
    Button y6;
    Button n6;
    
    Button y7;
    Button n7;

    public Obstacle(double x, double y, int w, int h, boolean good, BufferedImage img) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
        this.good = good;

        this.img = img;
    }
    
    public Obstacle(double x, double y, int w, int h, boolean good) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
        this.good = good;
    }

    public Obstacle(double x, double y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public void display(Graphics g){

        try{
            g.drawImage(img, (int)x, (int)y, w, h, null);
        } catch (Exception e){
            g.setColor(Color.BLACK);
            g.drawRect((int)x, (int)y, w, h);
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }

    public void setX(double n){
        x = n;
    }

    public void setY(double n) {
        y = n;
    }

    public void message(Graphics g, int i){
        switch(i){
            case 0:
                Slide s1 = new Slide(1, true,  "Testing 0");
                s1.display(g);

                y0 = new Button("Yes 0", 950, 200, 300, 50);
                n0 = new Button("No 0", 950, 350, 300, 50);

                y0.display(g);
                n0.display(g);

                break;
            case 1:
                Slide s2 = new Slide(1, true,  "Testing 1");
                s2.display(g);

                y1 = new Button("Yes 1", 950, 200, 300, 50);
                n1 = new Button("No 1", 950, 350, 300, 50);

                y1.display(g);
                n1.display(g);

                break;
            case 2:
                Slide s3 = new Slide(1, true,  "Testing 2");
                s3.display(g);

                y2 = new Button("Yes 2", 950, 200, 300, 50);
                n2 = new Button("No 2", 950, 350, 300, 50);

                y2.display(g);
                n2.display(g);
                
                break;
            case 3:
                Slide s4 = new Slide(-1, true,  "Testing 3");
                s4.display(g);

                y3 = new Button("Yes 3", 950, 200, 300, 50);
                n3 = new Button("No 3", 950, 350, 300, 50);

                y3.display(g);
                n3.display(g);
                
                break;
            case 4:
                Slide s5 = new Slide(-1, true,  "Testing 4");
                s5.display(g);

                y4 = new Button("Yes 4", 950, 200, 300, 50);
                n4 = new Button("No 4", 950, 350, 300, 50);

                y4.display(g);
                n4.display(g);
                
                break;
            case 5:
                Slide s6 = new Slide(-1, true,  "Testing 5");
                s6.display(g);

                y5 = new Button("Yes 5", 950, 200, 300, 50);
                n5 = new Button("No 5", 950, 350, 300, 50);

                y5.display(g);
                n5.display(g);
                
                break;
        }
    }
}
