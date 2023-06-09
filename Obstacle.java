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

    /** Whether the obstacle gives points or takes health */
    boolean good;

    /** Image of the obstacle */
    BufferedImage img;

    /**
     * Obstacle constructor
     * @param x x value
     * @param y y value
     * @param w width
     * @param h height
     * @param good good or bad
     * @param img image for the obstalce
     */
    public Obstacle(double x, double y, int w, int h, boolean good, BufferedImage img) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
        this.good = good;

        this.img = img;
    }
    
    /**
     * Obstacle constructor
     * @param x x value
     * @param y y value
     * @param w width
     * @param h height
     * @param good good or bad
     */
    public Obstacle(double x, double y, int w, int h, boolean good) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
        this.good = good;
    }

    /**
     * Obstacle constructor
     * @param x x value
     * @param y y value
     * @param w width
     * @param h height
     */
    public Obstacle(double x, double y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    /**
     * Displays the obstacle
     * @param g graphics
     */
    public void display(Graphics g){

        try{
            g.drawImage(img, (int)x, (int)y, w, h, null);
        } catch (Exception e){
            g.setColor(Color.BLACK);
            g.drawRect((int)x, (int)y, w, h);
        }
    }

    /**
     * Gets the x value
     * @return x value
     */
    public double getX(){
        return x;
    }

    /**
     * Gets the y value
     * @return y value
     */
    public double getY(){
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
     * @param n x value
     */
    public void setX(double n){
        x = n;
    }

    /**
     * Sets the y value
     * @param n y value
     */
    public void setY(double n) {
        y = n;
    }
}
