import java.awt.*;
import java.awt.event.KeyAdapter;

public class Level3 extends KeyAdapter {

    int x = 700;
    int y = 350;
    int score = 0;
    int health = 3;

    boolean left;
    boolean right;
    boolean up;
    boolean down;


    public void level3(Graphics g) {
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

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
