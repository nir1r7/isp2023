import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.*;

public class Level3 {
    int good = 8;
    int bad = 40;

    int score = 0;
    int health = 3;
    Player p = new Player(750, 350);
    
    ArrayList<Obstacle> obstacles = new ArrayList<>();

    public void level3(Graphics g) {
        g.drawString("Score: " + score, 1000, 200);
        g.drawString("Health: " + health, 1000, 300);
        p.display(g);
        for (Obstacle o : obstacles) {
            o.display(g);
            if (p.collided(o) != 0) {
                if (p.collided(o) > 0) score++;
                else health--;
                o.setY((Math.random() * 200 + 200) * -1);
            }
        }
    }

    public void load() {
        try {
            BufferedImage brawlstars = ImageIO.read(new File("./static/img/brawlstars.png"));
            BufferedImage instagram = ImageIO.read(new File("./static/img/instagram.png"));
            BufferedImage snapchat = ImageIO.read(new File("./static/img/snapchat.png"));
            BufferedImage twitter = ImageIO.read(new File("./static/img/twitter.png"));
            BufferedImage youtube = ImageIO.read(new File("./static/img/youtube.png"));

            BufferedImage github = ImageIO.read(new File("./static/img/github.png"));
            BufferedImage googledocs = ImageIO.read(new File("./static/img/googledocs.png"));
            BufferedImage googlesheets = ImageIO.read(new File("./static/img/googlesheets.png"));
            BufferedImage googleslides = ImageIO.read(new File("./static/img/googleslides.png"));

            for (int i = 0; i < bad; i++) {
                switch(i % 5) {
                    case 0:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, false, (Math.random() * 0.25 + 0.5), brawlstars));
                        break;
                    case 1:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, false, (Math.random() * 0.25 + 0.5), instagram));
                        break;
                    case 2:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, false, (Math.random() * 0.25 + 0.5), snapchat));
                        break;
                    case 3:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, false, (Math.random() * 0.25 + 0.5), twitter));
                        break;
                    case 4:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, false, (Math.random() * 0.25 + 0.5), youtube));
                        break;
                }
            }
            for (int i = 0; i < good; i++) {
                switch(i % 4) {
                    case 0:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, true, (Math.random() * 0.25 + 0.5), github));
                        break;
                    case 1:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, true, (Math.random() * 0.25 + 0.5), googledocs));
                        break;
                    case 2:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, true, (Math.random() * 0.25 + 0.5), googlesheets));
                        break;
                    case 3:
                        obstacles.add(new FallingObstacle(Math.random() * 1400, (Math.random() * 200 + 600) * -1, 25, 25, true, (Math.random() * 0.25 + 0.5), googleslides));
                        break;
                }
            }
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
