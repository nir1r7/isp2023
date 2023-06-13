import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Falling obstacle class for Finals Frenzy, creates falling obstacles used in level 3
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class FallingObstacle extends Obstacle {
    /** This distance of the y value */
    private double dy;
    /** The maximum random number */
    private double rand = 50;
    /** The icon of the falling obstacle */
    private BufferedImage icon;

    /**
     * Falling obstacle constructor
     * @param x x value
     * @param y y value
     * @param w width
     * @param h height
     * @param good good or bad (points or deduction)
     * @param dy distance of y change
     * @param icon icon displayed
     */
    public FallingObstacle(double x, double y, int w, int h, boolean good, double dy, BufferedImage icon) {
        super(x, y, w, h, good);
        this.dy = dy;
        this.icon = icon;
    }

    /**
     * Gets the object to fall
     * @param dy distance of y changed
     */
    public void fall(double dy) {
        setY(getY() + dy);
        /** If the object goes below the screen it respawns at a random position in a range */
        if (getY() >= 700) {
            setX(Math.random() * 1400);
            setY(-200 + (rand - (Math.random() * 2 * rand)));
        }
    }

    /**
     * Displays the falling obstacle
     * @param g graphics
     */
    public void display(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(icon, (int)getX(), (int)getY(), getW(), getH(), null);
        fall(dy);
    }
}
