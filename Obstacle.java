import java.awt.*;

public class Obstacle{
    int x;
    int y;
    int w;
    int h;
    
    public Obstacle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public void display(Graphics g){

        g.setColor(Color.BLACK);

        g.drawRect(x, y, w, h);
    }

    public boolean collided(int xCoord, int yCoord, int width, int height){
        if (xCoord >= x && xCoord <= x + w && yCoord >= y && yCoord <= y + h){
            return true;
        }
        return false;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }

    public void setX(int n){
        x = n;
    }

    public void setY(int n){
        y = n;
    }

}
