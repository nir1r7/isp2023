import java.awt.*;

/**
 * Wall class for Finals Frenzy, creates walls used in level 2
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Wall extends Obstacle{
    
    /**
     * Wall constructor
     * @param x x value
     * @param y y value
     * @param w width
     * @param h height
     */
    public Wall(int x, int y, int w, int h){
        super(x, y, w, h);
    }

    /**
     * Displays the wall
     * @param g graphics
     */
    public void display(Graphics g){
        g.setColor(new Color(0, 163, 255));

        g.fillRect((int) getX(), (int) getY(), getW(), getH());
    }
}
