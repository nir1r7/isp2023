import java.awt.*;

public class Level3 {

    int score = 0;
    int health = 3;
    Player p = new Player(750, 350);
    Obstacle o1 = new Obstacle(200, 200, 50, 50, true);
    FallingObstacle o2 = new FallingObstacle(600, 200, 50, 50, false);

    public void level3(Graphics g) {
        g.drawString("Score: " + score, 1000, 200);
        g.drawString("Health: " + health, 1000, 300);
        p.display(g);
        o1.display(g);
        o2.display(g);
        int collider1 = p.collided(o1);
        int collider2 = p.collided(o2);
        if (collider1 != 0) {
            if (collider1 > 0) score++;
            else health--;
        }
        if (collider2 != 0) {
            if (collider2 > 0) score++;
            else health--;
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
