import java.awt.*;

public class FallingObstacle extends Obstacle {
    public FallingObstacle(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public void fall(int dy) {
        this.y += dy;
        if (this.y >= 700) {
            this.y = -100;
        }
    }

    public void display(Graphics g) {
        g.setColor(Color.BLACK);

        g.drawRect(x, y, w, h);

        fall(1);
    }
}
