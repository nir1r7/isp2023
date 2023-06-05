import java.awt.*;

public class Player {
    
    int x;
    int y;
    int w = 20;
    int h = 20;

    boolean left;
    boolean right;
    boolean up;
    boolean down;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display(Graphics g) {
        if (left) updateX(-1);
        if (right) updateX(1);
        if (up) updateY(-1);
        if (down) updateY(1);
        g.fillRect(x, y, w, h);
    }

    public boolean collided(Obstacle o){
        if (x + w >= o.getX() && x <= o.getX() + o.getW() && y + h >= o.getY() && y <= o.getY() + o.getH()){
            return true;
        }
        return false;
    }


    public void updateX(int dx) {
        if (this.x + w + dx <= 1400 && this.x + dx >= 0) {
            this.x += dx;
        }
    }

    public void updateY(int dy) {
        if (this.y + h + dy <= 700 && this.y + dy >= 0) {
            this.y += dy;
        }
    }
}
