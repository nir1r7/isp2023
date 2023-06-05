import java.awt.*;

public class Player {
    
    double x;
    double y;
    int w = 20;
    int h = 20;

    boolean left;
    boolean right;
    boolean up;
    boolean down;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void display(Graphics g) {
        if (left) updateX(-0.5);
        if (right) updateX(0.5);
        if (up) updateY(-0.5);
        if (down) updateY(0.5);
        g.fillRect((int)x, (int)y, w, h);
    }

    public boolean collided(Obstacle o){
        if (x + w >= o.getX() && x <= o.getX() + o.getW() && y + h >= o.getY() && y <= o.getY() + o.getH()){
            return true;
        }
        return false;
    }


    public void updateX(double dx) {
        if (this.x + w + dx <= 1400 && this.x + dx >= 0) {
            this.x += dx;
        }
    }

    public void updateY(double dy) {
        if (this.y + h + dy <= 700 && this.y + dy >= 0) {
            this.y += dy;
        }
    }
}
