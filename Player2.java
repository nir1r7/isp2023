import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Player class for Finals Frenzy, creates a user-controlled player for specifically level 2
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Player2 extends Player {

    /** Sprites for each of the walking directions */
    BufferedImage frontSprite;
    BufferedImage backSprite;
    BufferedImage leftSprite;
    BufferedImage rightSprite;

    /** Moving variable to restrict movement in slides */
    boolean moving = true;

    /**
     * Player2 Constructor
     * @param x x coordinate
     * @param y y coordinate
     */
    public Player2(double x, double y) {
        super(x, y);
        try {
            frontSprite = ImageIO.read(new File("./static/img/front.png"));
            backSprite = ImageIO.read(new File("./static/img/back.png"));
            leftSprite = ImageIO.read(new File("./static/img/left.png"));
            rightSprite = ImageIO.read(new File("./static/img/right.png"));

            background = frontSprite;
        } catch (Exception e) {}
    }

    /**
     * Player2 Constructor with width and height
     * @param x x coordinate
     * @param y y coordinate
     * @param w width
     * @param h height
     */
    public Player2(double x, double y, int w, int h) {
        super(x, y, w, h);
        try {
            frontSprite = ImageIO.read(new File("./static/img/front.png"));
            backSprite = ImageIO.read(new File("./static/img/back.png"));
            leftSprite = ImageIO.read(new File("./static/img/left.png"));
            rightSprite = ImageIO.read(new File("./static/img/right.png"));

            background = frontSprite;
        } catch (Exception e) {}
    }
    
    /**
     * Player2 Constructor with background
     * @param x x coordinate
     * @param y y coordinate
     * @param background background image
     */
    public Player2(double x, double y, BufferedImage background) {
        super(x, y, background);
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

        /** Changes sprites based on the direction the player is moving */
        if (left) {
            updateX(-1);
            background = leftSprite;
        }
        if (right) {
            updateX(1);
            background = rightSprite;
        }
        if (up) {
            updateY(-1);
            background = backSprite;
        }
        if (down) {
            updateY(1);
            background = frontSprite;
        }
    }

    /**
     * Adds a certain value to the current x value
     * @param dx the change in x
     */
    public void updateX(double dx) {
        /** Only moves if moving is true */
        if (this.x + w + dx <= 1385 && this.x + dx >= 0 && moving) {
            this.x += dx;
        }
    }

    /**
     * Adds a certain value to the current y value
     * @param dy the change in y
     */
    public void updateY(double dy) {
        /** Only moves if moving is true */
        if (this.y + h + dy <= 665 && this.y + dy >= 0 && moving) {
            this.y += dy;
        }
    }

    /**
     * Checks if the player is collided with a wall
     * @param wall the wall
     * @return the direction in which the wall is collided with or no collision at all
     */
    public int collided(Wall wall){
        if (x + w >= wall.getX() && x + w <= wall.getX() + 25 && y + h >= wall.getY() && y <= wall.getY() + wall.getH()){
            return 1;
        }
        else if (x <= wall.getX() + wall.getW() && x >= wall.getX() + wall.getW() - 25 && y + h >= wall.getY() && y <= wall.getY() + wall.getH()){
            return 3;
        }
        else if (y + h >= wall.getY() && y + h <= wall.getY() + 25 && x + w  >= wall.getX() && x <= wall.getX() + wall.getW()){
            return 2;
        }
        else if (y <= wall.getY() + wall.getH() && y >= wall.getY() + wall.getH() - 25 && x + w  >= wall.getX() && x <= wall.getX() + wall.getW()){
            return 4;
        }
        return 0;
    }

    /**
     * Sets moving to true or false
     * @param m moving or not
     */
    public void setMoving(boolean m){
        moving = m;
    }

    /**
     * Gets if moving is true or false
     * @return boolean of moving
     */
    public boolean isMoving(){
        return moving;
    }
}
