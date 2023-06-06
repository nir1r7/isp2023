import java.awt.*;

public class FallingObstacle extends Obstacle {
    double respawn;
    double dy;
    double rand = 50;

    public FallingObstacle(double x, double y, int w, int h, boolean good, double dy, double respawn) {
        super(x, y, w, h, good);
        this.dy = dy;
        this.respawn = respawn;
    }

    public void fall(double dy) {
        this.y += dy;
        if (this.y >= 700) {
            this.y = respawn + (rand - (Math.random() * 2 * rand));
            System.out.println(respawn + (rand - (Math.random() * 2 * rand)));
        }
    }

    public void display(Graphics g) {
        g.setColor(Color.BLACK);

        g.drawRect((int)x, (int)y, w, h);

        fall(dy);
    }
}
