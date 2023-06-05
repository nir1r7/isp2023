import java.awt.*;

public class Level3 {

    int score = 0;
    int health = 3;
    Player p = new Player(750, 350);
    Obstacle[] obstacles = {
        new Obstacle(200, 200, 50, 50, true),
        new FallingObstacle(600, 0, 50, 50, false, 0.25, -200),
        new FallingObstacle(600, 0, 50, 50, false, 0.25, -200),
        new FallingObstacle(800, 0, 50, 50, false, 0.25, -200),
        new FallingObstacle(1000, 0, 50, 50, false, 0.25, -200),
        new FallingObstacle(1200, 0, 50, 50, false, 0.25, -200)
    };

    public void level3(Graphics g) {
        g.drawString("Score: " + score, 1000, 200);
        g.drawString("Health: " + health, 1000, 300);
        p.display(g);
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i] != null) {
                obstacles[i].display(g);
                if (p.collided(obstacles[i]) != 0) {
                    if (p.collided(obstacles[i]) > 0) score++;
                    else health--;
                    obstacles[i] = null;
                }
            }
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
