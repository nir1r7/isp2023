import java.awt.*;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level2 extends KeyAdapter {
    Player p;

    ArrayList<Wall> walls = new ArrayList<Wall>();
    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    int x = 700;
    int y = 350;
    private int slideNum = 0;

    public void level2(Graphics g) {
        switch(slideNum) {
            case 0:
                slide0(g);
                break;
            case 1:
                slide1(g);
                break;
            case 2:
                maze(g);
                break;
        }
    }

    public void load(){
        p = new Player(600, 300);
        obstacles.clear();
        walls.clear();

        Obstacle g1;
        Obstacle g2;
        Obstacle g3;

        Obstacle b1;
        Obstacle b2;
        Obstacle b3;

        try{
            g1 = new Obstacle(117, 17, 40, 40, true, ImageIO.read(new File("./static/img/twitter.png")));
            g2 = new Obstacle(517, 417, 40, 40, true, ImageIO.read(new File("./static/img/twitter.png")));
            g3 = new Obstacle(993, 517, 40, 40, true, ImageIO.read(new File("./static/img/twitter.png")));

            b1 = new Obstacle(117, 493, 40, 40, true, ImageIO.read(new File("./static/img/twitter.png")));
            b2 = new Obstacle(1193, 17, 40, 40, true, ImageIO.read(new File("./static/img/twitter.png")));
            b3 = new Obstacle(1303, 417, 40, 40, true, ImageIO.read(new File("./static/img/twitter.png")));
        } catch (Exception e){
            g1 = new Obstacle(117, 17, 40, 40, true);
            g2 = new Obstacle(517, 417, 40, 40, true);
            g3 = new Obstacle(1000, 517, 40, 40, true);

            b1 = new Obstacle(117, 493, 40, 40, true);
            b2 = new Obstacle(1193, 17, 40, 40, true);
            b3 = new Obstacle(1303, 417, 40, 40, true);
        }

        obstacles.add(g1);
        obstacles.add(g2);
        obstacles.add(g3);

        obstacles.add(b1);
        obstacles.add(b2);
        obstacles.add(b3);

        walls.add(new Wall(75, 0, 25, 275));
        walls.add(new Wall(175, 175, 1000, 25));
        walls.add(new Wall(75, 75, 1000, 25));
        walls.add(new Wall(1150, 0, 25, 200));
        walls.add(new Wall(75, 275, 600, 25));
        walls.add(new Wall(750, 275, 25, 100));
        walls.add(new Wall(500, 375, 275, 25));
        walls.add(new Wall(1262, 75, 25,225)); // INBETWEEN 25, @ 12
        walls.add(new Wall(850, 275, 412, 25)); // INBETWEEN 25, @ 12
        walls.add(new Wall(850, 275, 25, 300));
        walls.add(new Wall(950, 375, 450, 25));
        walls.add(new Wall(1262, 375, 25, 200)); // INBETWEEN 25, @ 12
        walls.add(new Wall(950, 500, 25, 175));
        walls.add(new Wall(950, 475, 225, 25));
        walls.add(new Wall(750, 475, 25, 200));
        walls.add(new Wall(375, 450, 100, 25));
        walls.add(new Wall(750, 275, 25, 100));
        walls.add(new Wall(225, 375, 175, 25));
        walls.add(new Wall(475, 375, 25, 200));
        walls.add(new Wall(375, 400, 25, 75));
        walls.add(new Wall(500, 550, 150, 25));
        walls.add(new Wall(75, 550, 325, 25));
        walls.add(new Wall(75, 375, 25, 175));
    }

    public void slide0(Graphics g) {
        Slide s = new Slide(0, "Exam season is coming up and you are on your computer, trying to focus. Can you stay focused and avoid all of the distractions focus on your assignments?");
        s.display(g);
    }

    public void slide1(Graphics g) {
        Slide s = new Slide(0, "Control your mouse pointer by using your arrow keys to move around the screen. Collect study and assignment related apps to earn points, while avoiding distractions. Score 20 points to win without losing all of your health!");
        s.display(g);
    }

    public void maze(Graphics g) {
        for (Wall w : walls){
            w.display(g);
            if (p.collided(w) != 0) {
                switch (p.collided(w)){
                    case 1:
                        p.updateX(-1);
                        break;
                    case 2:
                        p.updateY(-1);
                        break;
                    case 3:
                        p.updateX(1);
                        break;
                    case 4:
                        p.updateY(1);
                        break;
                }
            }
        }
        int temp = -1;
        for (int i = 0; i < obstacles.size(); i++){
            obstacles.get(i).display(g);
            if (p.collided(obstacles.get(i)) != 0){
                temp = i;
            }
        }
        if (temp != -1 ) obstacles.get(temp).message(g, temp);

        g.setColor(Color.BLACK);
        p.display(g);
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
