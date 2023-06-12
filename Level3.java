import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.text.Style;

import java.util.*;

/**
 * Level 3 class for Finals Frenzy, creates the third level
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Level3 {
    /** Slide number */
    private int slideNum = 0;

    /** Background image */
    BufferedImage bg;

    /** Level parameters */
    int goal = 20;
    int good = 8;
    int bad = 60;

    /** Starting score and health */
    int score = 0;
    int health = 3;
    Player p;
    
    /** ArrayList of obstacles */
    ArrayList<Obstacle> obstacles = new ArrayList<>();
    
    /** Buttons */
    Button y;
    Button n;

    /**
     * Displays level 3 from slide number
     * @param g graphics
     */
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

    /**
     * Preloads all info into the level
     * Resets all player stats and adds all obstacles into ArrayList
     */
    public void load() {
        health = 3;
        score = 0;
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

    /**
     * Displays slide 0
     * @param g graphics
     */
    public void slide0(Graphics g) {
        Slide s = new Slide(bg, 0, "Exam season is coming up and you are on your computer, trying to focus. Can you stay focused and avoid all of the distractions focus on your assignments?", false);
        s.display(g);
    }

    /**
     * Displays slide 1
     * @param g graphics
     */
    public void slide1(Graphics g) {
        Slide s = new Slide(bg, 0, "Control your mouse pointer by using your arrow keys to move around the screen. Collect study and assignment related apps to earn points, while avoiding distractions. Score 20 points to win without losing all of your health!", false);
        s.display(g);

        try{
            Font f = Font.createFont(Font.TRUETYPE_FONT, new File("./static/fonts/font.otf")).deriveFont(32f);
            g.setFont(f);


            BufferedImage brawlstars = ImageIO.read(new File("./static/img/brawlstars.png"));
            BufferedImage instagram = ImageIO.read(new File("./static/img/instagram.png"));
            BufferedImage snapchat = ImageIO.read(new File("./static/img/snapchat.png"));
            BufferedImage twitter = ImageIO.read(new File("./static/img/twitter.png"));
            BufferedImage youtube = ImageIO.read(new File("./static/img/youtube.png"));

            BufferedImage github = ImageIO.read(new File("./static/img/github.png"));
            BufferedImage googledocs = ImageIO.read(new File("./static/img/googledocs.png"));
            BufferedImage googlesheets = ImageIO.read(new File("./static/img/googlesheets.png"));
            BufferedImage googleslides = ImageIO.read(new File("./static/img/googleslides.png"));

            int w = 80;

            g.drawImage(brawlstars, 850, 150, w, w, null);
            g.drawImage(instagram, 950, 150, w, w, null);
            g.drawImage(snapchat, 850, 250, w, w, null);
            g.drawImage(twitter, 950, 250, w, w, null);
            g.drawImage(youtube, 900, 350, w, w, null);

            g.drawImage(github, 380, 150, w, w, null);
            g.drawImage(googledocs, 480, 150, w, w, null);
            g.drawImage(googlesheets, 380, 250, w, w, null);
            g.drawImage(googleslides, 480, 250, w, w, null);

        } catch (Exception e){}

        g.drawString("Study related apps", 310, 100);
        g.drawString("Distractions", 840, 100);
    }

    /**
     * Displays the game
     * @param g graphics
     */
    public void game(Graphics g) {
        /** Draws background */
        g.drawImage(bg, 0, 0, 1400, 700, null);
        g.setFont(Main.font);
        p.display(g);
        /** Loops through each obstacle, displaying it and checking for collisions */
        for (Obstacle o : obstacles) {
            o.display(g);
            if (p.collided(o) != 0) {
                if (p.collided(o) > 0) score++;
                else health--;
                o.setX(Math.random() * 1400);
                o.setY((Math.random() * 200 + 200) * -1);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 1290, 50);
        g.drawString("Health: " + health, 1290, 100);

        /** End game conditions */
        if (score >= goal) slideNum = 3;
        if (health <= 0) slideNum = 4;
    }

    /**
     * Displays victory screen
     * @param g graphics
     */
    public void victory(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        Slide s = new Slide(bg, 1, "Great job! You managed to stay focued and had a lot of success in this stressful time. Congratulations on the great work!", false);
        s.display(g);
    } 

    /**
     * Displays defeat screen
     * @param g graphics
     */
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

    /**
     * Sets the score
     * @param n the score
     */
    public void setScore(int n) {
        score = n;
    }

    /**
     * Sets the health
     * @param n the health
     */
    public void setHealth(int n) {
        health = n;
    }

    /**
     * Sets the player to moving left
     * @param left left
     */
    public void setLeft(boolean left) {
        p.left = left;
    }

    /**
     * Sets the player to moving right
     * @param right right
     */
    public void setRight(boolean right) {
        p.right = right;
    }

    /**
     * Sets the player to moving up
     * @param up up
     */
    public void setUp(boolean up) {
        p.up = up;
    }

    /**
     * Sets the player to moving down
     * @param down down
     */
    public void setDown(boolean down) {
        p.down = down;
    }

    /**
     * Sets the slide number
     * @param n the slide number
     */
    public void setSlide(int n) {
        slideNum = n;
    }

    /**
     * Gets the slide number
     * @return the slide number
     */
    public int getSlideNum() {
        return slideNum;
    }
}
