import java.awt.*;
import java.awt.image.BufferedImage;

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

        if (left) updateX(-1);
        if (right) updateX(1);
        if (up) updateY(-1);
        if (down) updateY(1);
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
        if (x + w >= wall.getX() && x + w <= wall.getX() + 25 && y + h >= wall.getY() && y <= wall.getY() + wall.getH()){
            return 1;
        }
        else if (x <= wall.getX() + wall.getW() && x >= wall.getX() + wall.getW() - 25 && y + h >= wall.getY() && y <= wall.getY() + wall.getH()){
            return 3;
        }
        else if (y + h >= wall.getY() && y + h <= wall.getY() + 25 && x + w  >= wall.getX() && x <= wall.getX() + wall.getW()){
            return 2;
        }
        else if (y <= wall.getY() + wall.getH() && y >= wall.getY() + wall.getH() - 25 && x + w  >= wall.getX() && x <= wall.getX() + wall.getW()){
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
        if (this.y + h + dy <= 665 && this.y + dy >= 0) {
            this.y += dy;
        }
    }
}
