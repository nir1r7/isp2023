import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Player class for Finals Frenzy, creates a user-controlled player for the game
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Player {

    private double x;
    private double y;
    private int w = 20;
    private int h = 20;

    /** Background image of the player */
    private BufferedImage background = null;

    /** Boolean variables which control player movement */
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    /**
     * Player constructor
     * @param x x value
     * @param y y value
     */
    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Player constructor with width and height
     * @param x x value
     * @param y y value
     * @param w width
     * @param h height
     */
    public Player(double x, double y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    /**
     * Player constructor with background
     * @param x x value
     * @param y y value
     * @param background background image
     */
    public Player(double x, double y, BufferedImage background) {
        this.x = x;
        this.y = y;
        this.background = background;
    }

    /**
     * Displays the player
     * @param g graphics
     */
    public void display(Graphics g) {
        /** Draws the background depending if the player has a background */
        if (background != null) {
            g.drawImage(background, (int)x, (int)y, w, h, null);
        } else {
            g.fillRect((int)x, (int)y, w, h);
        }

        /** Updates the player position based off of booleans */
        if (left) updateX(-1);
        if (right) updateX(1);
        if (up) updateY(-1);
        if (down) updateY(1);
    }

    /**
     * Checks if the player is colliding with an obstacle
     * @param o the obstacle
     * @return 1: collided and the obstacle gives points, 2: collided and the obstalce removes points, 0: no collision
     */
    public int collided(Obstacle o){
        if (x + w >= o.getX() && x <= o.getX() + o.getW() && y + h >= o.getY() && y <= o.getY() + o.getH()){
            if (o.getGood()) {
                return 1; 
            } else {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Adds a certain value to the current x value
     * @param dx the change in x
     */
    public void updateX(double dx) {
        if (this.x + w + dx <= 1385 && this.x + dx >= 0) {
            this.x += dx;
        }
    }

    /**
     * Adds a certain value to the current y value
     * @param dy the change in y
     */
    public void updateY(double dy) {
        if (this.y + h + dy <= 665 && this.y + dy >= 0) {
            this.y += dy;
        }
    }

    /**
     * Sets the x value to a certain value
     * @param n x value
     */
    public void setX(int n){
        x = n;
    }

    /**
     * Sets the y value to a certain value
     * @param n y value
     */
    public void setY(int n){
        y = n;
    }

    /**
     * Returns the x coordinate of the player
     * @return x
     */ 
    public double getX(){
        return x;
    }

    /**
     * Returns the y coordinate of the player
     * @return y
     */
    public double getY(){
        return y;
    }

    /**
     * returns the width of the player
     * @return w
     */
    public int getW(){
        return w;
    }

    /**
     * returns the height of the player
     * @return h
     */
    public int getH(){
        return h;
    }

    /**
     * checks if the player is going facing left
     * @return left
     */
    public boolean isLeft(){
        return left;
    }

    /**
     * checks if the player facing right
     * @return right
     */
    public boolean isRight(){
        return right;
    }

    /**
     * checks if the player is facing up
     * @return up
     */
    public boolean isUp(){
        return up;
    }

    /**
     * checks if the player is facing down
     * @return down
     */
    public boolean isDown(){
        return down;
    }

    /**
     * sets the left variable to b
     * @param b
     */
    public void setLeft(boolean b){
        left = b;
    }

    /**
     * sets the right variable to b
     * @param b
     */
    public void setRight(boolean b){
        right = b;
    }

    /**
     * sets the up variable to b
     * @param b
     */
    public void setUp(boolean b){
        up = b;
    }

    /**
     * sets the down variable to b
     * @param b
     */
    public void setDown(boolean b){
        down = b;
    }

    /**
     * Sets the background iamge of the player
     * @param icon
     */
    public void setBg(BufferedImage icon){
        background = icon;
    }

    /**
     * Gets the background image of the player
     * @return background
     */
    public BufferedImage getBg(){
        return background;
    }
}
