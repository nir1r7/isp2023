import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

public class Level2 extends KeyAdapter {
    Player p = new Player(600, 300);

    ArrayList<Wall> walls = new ArrayList<Wall>();

    int x = 700;
    int y = 350;
    int score = 0;

    //test
    public void level2(Graphics g) {
        g.drawString("This is level 2, click again to go to level 3", 200, 250);
        p.display(g);
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
    }

    public void load(){
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
