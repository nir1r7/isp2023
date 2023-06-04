import java.awt.*;

public class Level3 {

    int score = 0;
    int health = 3;
    Player p = new Player(750, 350);
    Obstacle o1 = new Obstacle(200, 200, 50, 50);

    public void level3(Graphics g) {
        p.display(g);
        o1.display(g);
        if (p.collided(o1)) {
            g.drawString("Collision", 400, 350);
        }
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
