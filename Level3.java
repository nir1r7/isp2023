import java.awt.*;
import java.awt.event.KeyAdapter;

public class Level3 extends KeyAdapter {

    int score = 0;
    int health = 3;
    Player p = new Player(750, 350);

    public void level3(Graphics g) {
        p.display(g);
    }

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public void setLeft(boolean left) {
        p.left = left;
    }

    public void setRight(boolean right) {
        p.right = right;
    }

    public void setUp(boolean up) {
        p.up = up;
    }

    public void setDown(boolean down) {
        p.down = down;
    }
}
