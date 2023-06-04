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


    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }
}
