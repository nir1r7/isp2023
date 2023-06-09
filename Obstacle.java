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
}
