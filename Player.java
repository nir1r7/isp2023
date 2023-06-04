import java.awt.*;

public class Player {
    
    int x;
    int y;

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
        g.fillRect(x, y, 20, 20);
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }
}
