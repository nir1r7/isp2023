import java.awt.*;

/**
 * Wall class for Finals Frenzy, creates walls used in level 2
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Wall extends Obstacle{
    
    public Wall(int x, int y, int w, int h){
        super(x, y, w, h);
    }

    public void display(Graphics g){
        g.setColor(Color.GRAY);

        g.fillRect((int) getX(), (int) getY(), getW(), getH());
    }
}
