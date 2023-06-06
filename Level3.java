import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.*;

public class Level3 {

    int score = 0;
    int health = 3;
    Player p = new Player(750, 350);
    
    ArrayList<Obstacle> obstacles = new ArrayList<>();

    public void level3(Graphics g) {
        g.drawString("Score: " + score, 1000, 200);
        g.drawString("Health: " + health, 1000, 300);
        p.display(g);
        for (int i = obstacles.size() - 1; i >= 0; i--) {
            obstacles.get(i).display(g);
            if (p.collided(obstacles.get(i)) != 0) {
                if (p.collided(obstacles.get(i)) > 0) score++;
                else health--;
                obstacles.remove(i);
            }
        }
    }

    public void load() {
        try {
            BufferedImage brawlStars = ImageIO.read(new File("./static/img/brawlstars.png"));
            obstacles.add(new FallingObstacle(Math.random() * 1400, -200, 25, 25, false, Math.random()/4 + 0.25, brawlStars));
        } catch (Exception e) {
            // TODO: handle exception
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
