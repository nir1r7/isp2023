import java.awt.*;

public class FallingObstacle extends Obstacle {
    public FallingObstacle(double x, double y, int w, int h) {
        super(x, y, w, h);
    }

    public void fall(double dy) {
        this.y += dy;
        if (this.y >= 700) {
            this.y = -100;
        }
    }

    public void display(Graphics g) {
        g.setColor(Color.BLACK);

        g.drawRect((int)x, (int)y, w, h);

        fall(0.25);
    }
}
