import java.awt.*;
import java.awt.image.BufferedImage;

public class Obstacle{
    double x;
    double y;
    int w;
    int h;
    boolean good;
    BufferedImage img;

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
                Slide s1 = new Slide("Testing 0");
                s1.display(g);
                break;
            case 1:
                Slide s2 = new Slide("Testing 1");
                s2.display(g);
                break;
            case 2:
                Slide s3 = new Slide("Testing 2");
                s3.display(g);
                break;
            case 3:
                Slide s4 = new Slide("Testing 3");
                s4.display(g);
                break;
            case 4:
                Slide s5 = new Slide("Testing 4");
                s5.display(g);
                break;
            case 5:
                Slide s6 = new Slide("Testing 5");
                s6.display(g);
                break;
        }
    }
}
