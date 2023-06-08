import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.*;

public class Level3 {
    private int slideNum = 0;
    BufferedImage bg;
    int goal = 20;
    int good = 8;
    int bad = 60;

    int score = 0;
    int health = 3;
    Player p;
    
    
    ArrayList<Obstacle> obstacles = new ArrayList<>();

    public void level3(Graphics g) {
        switch(slideNum) {
            case 0:
                game(g);
                break;
            case 1:
                victory(g);
                break;
            case 2:
                defeat(g);
                break;
        }
    }

    public void load() {
        try {
            bg = ImageIO.read(new File("./static/img/phonebackground.png"));
            BufferedImage brawlstars = ImageIO.read(new File("./static/img/brawlstars.png"));
            BufferedImage instagram = ImageIO.read(new File("./static/img/instagram.png"));
            BufferedImage snapchat = ImageIO.read(new File("./static/img/snapchat.png"));
            BufferedImage twitter = ImageIO.read(new File("./static/img/twitter.png"));
            BufferedImage youtube = ImageIO.read(new File("./static/img/youtube.png"));

            BufferedImage github = ImageIO.read(new File("./static/img/github.png"));
            BufferedImage googledocs = ImageIO.read(new File("./static/img/googledocs.png"));
            BufferedImage googlesheets = ImageIO.read(new File("./static/img/googlesheets.png"));
            BufferedImage googleslides = ImageIO.read(new File("./static/img/googleslides.png"));

            BufferedImage pointer = ImageIO.read(new File("./static/img/pointer.png"));
            p = new Player(750, 350, pointer);

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
            p = new Player(750, 350);
        }
    }

    public void game(Graphics g) {
        g.drawImage(bg, 0, 0, 1400, 700, null);
        g.setFont(Main.font);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 1290, 50);
        g.drawString("Health: " + health, 1290, 100);
        p.display(g);
        for (Obstacle o : obstacles) {
            o.display(g);
            if (p.collided(o) != 0) {
                if (p.collided(o) > 0) score++;
                else health--;
                o.setY((Math.random() * 200 + 200) * -1);
            }
        }
        if (score == goal) slideNum = 1;
        if (health == 0) slideNum = 2;
    }

    public void victory(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        Slide s = new Slide(1, "Victory!");
        s.display(g);
    } 

    public void defeat(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        Slide s = new Slide(-1, "Defeat...");
        s.display(g);
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
