import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.*;


public class Player {
    
    double x;
    double y;
    int w = 20;
    int h = 20;
    BufferedImage background = null;

    boolean left;
    boolean right;
    boolean up;
    boolean down;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Player(double x, double y, BufferedImage background) {
        this.x = x;
        this.y = y;
        this.background = background;
    }

    public void display(Graphics g) {
        if (background != null) {
            g.drawImage(background, (int)x, (int)y, w, h, null);
        } else {
            g.fillRect((int)x, (int)y, w, h);
        }
        if (left) updateX(-0.5);
        if (right) updateX(0.5);
        if (up) updateY(-0.5);
        if (down) updateY(0.5);
    }

    public int collided(Obstacle o){
        if (x + w >= o.getX() && x <= o.getX() + o.getW() && y + h >= o.getY() && y <= o.getY() + o.getH()){
            if (o.good) {
                return 1; 
            } else {
                return -1;
            }
        }
        return 0;
    }

    public int collided(Wall wall){
        if (x + w == wall.getX() && y + h >= wall.getY() && y <= wall.getY() + wall.getH()){
            return 1;
        }
        if (x == wall.getX() + wall.getW() && y + h >= wall.getY() && y <= wall.getY() + wall.getH()){
            return 3;
        }
        if (y + h == wall.getY() && x + w  >= wall.getX() && x <= wall.getX() + wall.getW()){
            return 2;
        }
        if (y == wall.getY() + wall.getH() && x + w  >= wall.getX() && x <= wall.getX() + wall.getW()){
            return 4;
        }
        return 0;
    }

    public void updateX(double dx) {
        if (this.x + w + dx <= 1400 && this.x + dx >= 0) {
            this.x += dx;
        }
    }

    public void updateY(double dy) {
        if (this.y + h + dy <= 700 && this.y + dy >= 0) {
            this.y += dy;
        }
    }
}
