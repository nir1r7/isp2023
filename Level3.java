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
    
    Button y;
    Button n;

    public void level3(Graphics g) {
        switch(slideNum) {
            case 0:
                slide0(g);
                break;
            case 1:
                slide1(g);
                break;
            case 2:
                game(g);
                break;
            case 3:
                victory(g);
                break;
            case 4:
                defeat(g);
                break;
        }
    }

    public void load() {
        health = 3;
        score = 0;
        score = 0;
        health = 3;
        obstacles.clear();
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

    public void slide0(Graphics g) {
        Slide s = new Slide(bg, 0, "Exam season is coming up and you are on your computer, trying to focus. Can you stay focused and avoid all of the distractions focus on your assignments?", false);
        s.display(g);
    }

    public void slide1(Graphics g) {
        Slide s = new Slide(bg, 0, "Control your mouse pointer by using your arrow keys to move around the screen. Collect study and assignment related apps to earn points, while avoiding distractions. Score 20 points to win without losing all of your health!", false);
        s.display(g);
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
                o.setX(Math.random() * 1400);
                o.setY((Math.random() * 200 + 200) * -1);
            }
        }
        if (score >= goal) slideNum = 3;
        if (health <= 0) slideNum = 4;
    }

    public void victory(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        Slide s = new Slide(bg, 1, "Great job! You managed to stay focued and had a lot of success in this stressful time. Congratulations on the great work!", false);
        s.display(g);
    } 

    public void defeat(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        Slide s = new Slide(bg, -1, "Unfortunately, you fell down a rabbit hole of distractions and forgot to study. Do you want to try again?", true);
        s.display(g);
        y = new Button("Yes", 950, 200, 300, 50);
        n = new Button("No", 950, 350, 300, 50);
        y.display(g);
        n.display(g);
    }

    public void setScore(int n) {
        score = n;
    }

    public void setHealth(int n) {
        health = n;
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

    public void setSlide(int n) {
        slideNum = n;
    }

    public int getSlideNum() {
        return slideNum;
    }
}
