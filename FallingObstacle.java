import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Falling obstacle class for Finals Frenzy, creates falling obstacles used in level 3
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class FallingObstacle extends Obstacle {
    double dy;
    double rand = 50;
    BufferedImage icon;

    public FallingObstacle(double x, double y, int w, int h, boolean good, double dy, BufferedImage icon) {
        super(x, y, w, h, good);
        this.dy = dy;
        this.icon = icon;
    }

    public void fall(double dy) {
        this.y += dy;
        if (this.y >= 700) {
            this.x = Math.random() * 1400;
            this.y = -200 + (rand - (Math.random() * 2 * rand));
        }
    }

    public void display(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(icon, (int)x, (int)y, w, h, null);
        fall(dy);
    }
}
