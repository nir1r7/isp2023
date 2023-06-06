import java.awt.*;

public class Wall extends Obstacle{
    
    public Wall(int x, int y, int w, int h){
        super(x, y, w, h);
    }

    public void display(Graphics g){
        g.setColor(Color.GRAY);

        g.fillRect((int) getX(), (int) getY(), getW(), getH());
    }
}
