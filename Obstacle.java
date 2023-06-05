import java.awt.*;

public class Obstacle{
    double x;
    double y;
    int w;
    int h;
    
    public Obstacle(double x, double y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public void display(Graphics g){

        g.setColor(Color.BLACK);

        g.drawRect((int)x, (int)y, w, h);
    }

    public double getX(){
        return x;
    }

    public double getY(){
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
}
