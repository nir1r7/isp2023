import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Player class for Finals Frenzy, creates a user-controlled player for the game
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Player2 extends Player {

    BufferedImage frontSprite;
    BufferedImage backSprite;
    BufferedImage leftSprite;
    BufferedImage rightSprite;

    public Player2(double x, double y) {
        super(x, y);
    }

    public Player2(double x, double y, int w, int h) {
        super(x, y, w, h);
        try {
            frontSprite = ImageIO.read(new File("./static/img/front.png"));
            backSprite = ImageIO.read(new File("./static/img/back.png"));
            leftSprite = ImageIO.read(new File("./static/img/left.png"));
            rightSprite = ImageIO.read(new File("./static/img/right.png"));

            background = frontSprite;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public Player2(double x, double y, BufferedImage background) {
        super(x, y, background);
    }

    public void display(Graphics g) {
        if (background != null) {
            g.drawImage(background, (int)x, (int)y, w, h, null);
        } else {
            g.fillRect((int)x, (int)y, w, h);
        }

        if (left) {
            updateX(-1);
            background = leftSprite;
        }
        if (right) {
            updateX(1);
            background = rightSprite;
        }
        if (up) {
            updateY(-1);
            background = backSprite;
        }
        if (down) {
            updateY(1);
            background = frontSprite;
        }
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

    public void setMoving(boolean m){
        moving = m;
    }

    public boolean isMoving(){
        return moving;
    }
}
