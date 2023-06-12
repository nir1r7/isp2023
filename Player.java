import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Player class for Finals Frenzy, creates a user-controlled player for the game
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
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

    boolean moving = true;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Player(double x, double y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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

    public void updateX(double dx) {
        if (this.x + w + dx <= 1385 && this.x + dx >= 0 && moving) {
            this.x += dx;
        }
    }

    public void updateY(double dy) {
        if (this.y + h + dy <= 665 && this.y + dy >= 0 && moving) {
            this.y += dy;
        }
    }

    public void setX(int n){
        x = n;
    }

    public void setY(int n){
        y = n;
    }

    public void setMoving(boolean m){
        moving = m;
    }

    public boolean isMoving(){
        return moving;
    }
}
