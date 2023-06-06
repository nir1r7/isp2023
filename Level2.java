import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

public class Level2 extends KeyAdapter {
    Player p = new Player(600, 300);

    ArrayList<Wall> walls = new ArrayList<Wall>();

    int x = 700;
    int y = 350;
    int score = 0;

    public void level2(Graphics g) {
        g.drawString("This is level 2, click again to go to level 3", 200, 200);

        map(g);
        p.display(g);

        for (int i = 0; i < walls.size(); i++){
            switch (p.collided(walls.get(i))){
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

    public void map(Graphics g){
        Wall w1 = new Wall(50, 0, 25, 200);
        Wall w2 = new Wall(50, 200, 1000, 25);

        walls.add(w1);
        walls.add(w2);

        for (int i = 0; i < walls.size(); i++){
            walls.get(i).display(g);
        }
        
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
